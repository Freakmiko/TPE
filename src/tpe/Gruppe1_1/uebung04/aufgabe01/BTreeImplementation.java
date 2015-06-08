package tpe.Gruppe1_1.uebung04.aufgabe01;

import gdi.MakeItSimple;
import tpe.Gruppe1_1.uebung01.BTree;
import tpe.Gruppe1_1.uebung01.Node;
import tpe.Gruppe1_1.utils.Queue;
import tpe.Gruppe1_1.utils.QueueImpl;

import java.io.*;

import static gdi.MakeItSimple.*;

public class BTreeImplementation implements BTree, Serializable {

    Node root;
    int order;

    /**
     * Creates the BTree with the given order
     * @param order the order of the tree (can't be <= 0)
     */
    public BTreeImplementation(int order) {
        if(order <= 0)
            order = 1;

        this.order = order;
        root = new Node(order);
    }

    public static BTree cloneDeep(BTree otherTree) {
        String tree = otherTree.getElements();

        Object file = openOutputFile("the.tree");

        print(file, tree);

        closeOutputFile(file);

        BTree baum = new BTreeImplementation(otherTree.getOrder());
        baum.insert("the.tree");

        return baum;
    }

    @Override
    public boolean insert(Comparable o) {
        if (root.getKeys()[0] == null)
            return insert(root, 0, o);

        return root.getKeys()[0].getClass().getSuperclass() == o.getClass().getSuperclass() && insert(root, 0, o);
    }

    private boolean insert(Node node,int keyIndex, Comparable o) {
        // If our current element is null and it doesn't have children
        // we can insert the integer at the current index.
        // Otherwise the node has children and we try to insert it in the left child
        // of the current element.
        if(node.getKeys()[keyIndex] == null && node.getChildren()[keyIndex] == null) {
            // If our node is full and the new element is inserted we have to balance the tree
            if(node.insert(keyIndex, o))
                balance(node);
            return true;
        } else if(node.getKeys()[keyIndex] == null) {
            return insert(node.getChildren()[keyIndex], 0, o);
        }

        // Should the element already be in the node we return false to indicate that
        if(node.getKeys()[keyIndex].compareTo(o) == 0)
            return false;

        // If our current element is greater than the integer we want to insert
        // and it doesn't have children, we insert it at the current index and rebalance if needed
        // if it has children we recursively call insert on that child
        if(node.getKeys()[keyIndex].compareTo(o)>= 1) {
            if(node.getChildren()[keyIndex] == null) {
                if(node.insert(keyIndex, o))
                    balance(node);
                return true;
            } else {
                return insert(node.getChildren()[keyIndex], 0, o);
            }
        } else {
            // If the current element is less than the integer we want to insert
            // we recursively call insert on the current node with a higher index (+1)
            return insert(node, keyIndex + 1, o);
        }
    }

    private void balance(Node node) {
        Comparable median = node.getKeys()[order];
        int indexOfInserted = 0;
        Node newParent;
        boolean needsRebalancing = false;

        // If our current node is the root of the Tree
        // we create a new root and insert the median
        if(node == root) {
            Node newRoot = new Node(order);
            newRoot.insert(0, median);
            newParent = newRoot;
            root = newRoot;
        } else {
            Node curParent = node.getParent();
            int maxIndex = 0;

            // Here we look for the largest element that is still
            // smaller than our median in the parent,
            // that way we can insert the median at the right position
            for(int i = 0; i < order * 2; i++)
                if (curParent.getKeys()[i] != null && curParent.getKeys()[i].compareTo(median)<= -1)
                    maxIndex = i;

            // Should the current maximum Index still be larger than our median
            // we insert the median BEFORE that index
            // otherwise we insert it AFTER the maximum Index
            if(curParent.getKeys()[maxIndex].compareTo(median)>= 1) {
                needsRebalancing = curParent.insert(maxIndex, median);
                indexOfInserted = maxIndex;
            } else {
                needsRebalancing = curParent.insert(maxIndex + 1, median);
                indexOfInserted = maxIndex + 1;
            }

            newParent = node.getParent();
        }

        // Here we create the new children of the new balanced node
        // the left child has all the values smaller than our median
        Node childLeft = new Node(order, newParent);
        newParent.getChildren()[indexOfInserted] = childLeft;
        for (int i = 0; i < order; i++) {
            childLeft.insert(i, node.getKeys()[i]);
            // if the elements have children we need to reconnect them too
            childLeft.getChildren()[i] = node.getChildren()[i];
            // and also reparent them
            if(childLeft.getChildren()[i] != null)
                childLeft.getChildren()[i].setParent(childLeft);

            // if we're on the last index before the median we need
            // to reconnect the child of our median too
            if(i == order - 1) {
                childLeft.getChildren()[i + 1] = node.getChildren()[i + 1];
                if(childLeft.getChildren()[i] != null)
                    childLeft.getChildren()[i + 1].setParent(childLeft);
            }
        }

        // and the right child has all the values larger than our median
        Node childRight = new Node(order, newParent);
        newParent.getChildren()[indexOfInserted + 1] = childRight;
        for (int i = order + 1; i < node.getKeys().length; i++) {
            // tempIndex is just there to shorten the other lines
            int tempIndex = i - (order + 1);
            // if the elements have children we need to reconnect them too
            childRight.insert(tempIndex, node.getKeys()[i]);
            childRight.getChildren()[tempIndex] = node.getChildren()[i];

            if(childRight.getChildren()[tempIndex] != null)
                childRight.getChildren()[tempIndex].setParent(childRight);

            // if we're on the last index we need
            // to reconnect the child last too
            if(i == node.getKeys().length - 1) {
                childRight.getChildren()[tempIndex + 1] = node.getChildren()[i + 1];
                if(childRight.getChildren()[tempIndex] != null)
                    childRight.getChildren()[tempIndex + 1].setParent(childRight);
            }
        }

        if(needsRebalancing)
            balance(newParent);
    }

    @Override
    public boolean insert(String filename) {
        if(!isFilePresent(filename))
            return false;

        Object file = openInputFile(filename);

        // We loop through each number in the file and see if
        // it already is in the tree, if it's not already there we insert it
        while(!isEndOfInputFile(file)) {
            int currentNumber = readInt(file);
            if(!contains(currentNumber)) {
                insert(currentNumber);
            } else {
                closeInputFile(file);
                return false;
            }
        }

        closeInputFile(file);
        return true;
    }

    @Override
    public boolean contains(Comparable o) {
        if(root.getKeys()[0] == null)
            return false;
        else if(root.getKeys()[0].getClass().getSuperclass() != o.getClass().getSuperclass())
            return false;
        return contains(root, 0, o);
    }

    private boolean contains(Node node, int keyIndex, Comparable o) {
        if(node.getKeys()[keyIndex] == null)
            return node.getChildren()[keyIndex] != null && contains(node.getChildren()[keyIndex], 0, o);

        if(node.getKeys()[keyIndex].compareTo(o) == 0)
            return true;

        if(node.getKeys()[keyIndex].compareTo(o)>= 1)
            return node.getChildren()[keyIndex] != null && contains(node.getChildren()[keyIndex], 0, o);
//        else if (node.getKeys()[keyIndex].compareTo(o) <= -1 && node.getChildren()[keyIndex] != null)
//            return  contains(node.getChildren()[keyIndex], 0, o);
        else
            return contains(node, keyIndex + 1, o);
    }

    @Override
    public int size() {
        int size = 0;
        Queue queue = new QueueImpl();
        queue.enter(root);

        while(!queue.isEmpty()) {
            Node n = queue.leave();
            size += n.size();
            for(int i = 0; i < order * 2 + 1; i++) {
                if(n.getChildren()[i] != null)
                    queue.enter(n.getChildren()[i]);
            }
        }

        return size;
    }

    @Override
    public int height() {
        return isEmpty() ? 0 : height(root);
    }

    private int height(Node node) {
        int count = 1;
        if(node.getChildren()[0] == null)
            return count;
        else
            count += height(node.getChildren()[0]);
        return count;
    }

    @Override
    public Comparable getMax() {
        Node maxNode = getMax(root);

        if(maxNode == null)
            return -1;
        else
            return maxNode.getKeys()[maxNode.size() - 1];
    }

    private Node getMax(Node node) {
        if(node.getChildren()[node.size()] != null)
            return getMax(node.getChildren()[node.size()]);
        else
            return node.getKeys()[0] == null ? null : node;
    }

    @Override
    public Comparable getMin() {
        Node minNode = getMin(root);

        if(minNode == null)
            return -1;
        else
            return minNode.getKeys()[0];
    }

    private Node getMin(Node node) {
        // For the smallest element we only need to look through
        // the left children of our nodes and the leftmost element in a node
        if(node.getChildren()[0] == null)
            return node.getKeys()[0] == null ? null : node;
        else
            return getMin(node.getChildren()[0]);
    }

    @Override
    public boolean isEmpty() {
        return (root == null || root.size() == 0);
    }

    @Override
    public void addAll(BTree otherTree) {
        String tree = otherTree.getElements();

        Object file = openOutputFile("the.tree");

        print(file, tree);

        closeOutputFile(file);

        insert("the.tree");

    }

    public int getOrder() {
        return order;
    }

    @Override
    public void printInorder() {
        println(printInorder(root));
    }

    private String printInorder(Node node) {
        String output = "";
        if(node == null)
            return output;
        if(node.getChildren()[0] == null) {
            output += "<";
            for(int i = 0; i < order * 2; i++)
                output += node.getKeys()[i] == null ? "" : " " + node.getKeys()[i] + " ";
            output += ">";
            return output;
        } else {
            output += "[";
            for (int i = 0; i < order * 2 + 1; i++) {
                output += printInorder(node.getChildren()[i]);
                output += node.getKeys()[i] == null ? "" :" " +  node.getKeys()[i] + " ";
            }
            output += "]";
            return output;
        }
    }

    @Override
    public void printPostorder() {
        println(printPostorder(root));
    }

    private String printPostorder(Node node) {
        String output = "";
        if(node == null)
            return output;
        if(node.getChildren()[0] == null) {
            for(int i = 0; i < order * 2; i++)
                output += node.getKeys()[i] == null ? "" : node.getKeys()[i] + " ";
            return output;
        } else {
            for (int i = 0; i < order * 2 + 1; i++)
                output += printPostorder(node.getChildren()[i]);
            for(int i = 0; i < order * 2; i++)
                output += node.getKeys()[i] == null ? "" : node.getKeys()[i] + " ";
            return output;
        }
    }

    @Override
    public void printPreorder() {
        println(printPreorder(root));
    }

    private String printPreorder(Node node) {
        String output = "";
        if(node == null)
            return output;
        if(node.getChildren()[0] == null) {
            for(int i = 0; i < order * 2; i++)
                output += node.getKeys()[i] == null ? "" : node.getKeys()[i] + " ";
            return output;
        } else {
            for(int i = 0; i < order * 2; i++)
                output += node.getKeys()[i] == null ? "" : node.getKeys()[i] + " ";
            for (int i = 0; i < order * 2 + 1; i++)
                output += printPreorder(node.getChildren()[i]);
            return output;
        }
    }

    @Override
    public void printLevelorder() {
        String output = "";
        Queue queue = new QueueImpl();
        queue.enter(root);

        while(!queue.isEmpty()) {
            Node n = queue.leave();
            for(int i = 0; i < order * 2; i++)
                output += n.getKeys()[i] == null ? "" : n.getKeys()[i] + " ";

            for(int i = 0; i < order * 2 + 1; i++) {
                if(n.getChildren()[i] != null)
                    queue.enter(n.getChildren()[i]);
            }
        }

        println(output);

    }

    public String getElements() {
        String output = "";
        Queue queue = new QueueImpl();
        queue.enter(root);

        while(!queue.isEmpty()) {
            Node n = queue.leave();
            for(int i = 0; i < order * 2; i++)
                output += n.getKeys()[i] == null ? "" : " " + n.getKeys()[i];

            for(int i = 0; i < order * 2 + 1; i++) {
                if(n.getChildren()[i] != null)
                    queue.enter(n.getChildren()[i]);
            }
        }

        return output;
    }

    private Node findObject(Node node, Comparable o) {
        if(node.getChildren()[0] == null) {
            for(int i = 0; i < node.size(); i++) {
                if(node.getKeys()[i].compareTo(o) == 0)
                    return node;
            }
            return null;
        }

        for(int i = 0; i < node.size(); i++) {
            if(node.getKeys()[i].compareTo(o) == 0)
                return node;
            if(node.getKeys()[i].compareTo(o) >= 1)
                return findObject(node.getChildren()[i], o);
            if(i == node.size() - 1)
                return findObject(node.getChildren()[i+1], o);
        }

        return null;
    }

    @Override
    public boolean remove(Comparable o) {
        // First we want to know if the object is in the tree (with contains(o))
        // then we find the node that contains that object and remove the object
        return contains(o) && remove(findObject(root, o), 0, o);
    }

    private boolean remove(Node node, int index, Comparable o) {
        // if our node is a leaf we can just remove the object
        // from the node and rebalance it if needed
        if(node.getChildren()[0] == null) {
            node.remove(o);
            if(node.size() < order)
                rebalance(node);
        } else {
            // in this case our node is not a leaf

            int seperatorIndex = 0;
            // first we find the index of our object that we want to remove
            for(int i = 0; i < node.size(); i++)
                if(node.getKeys()[i].compareTo(o) == 0)
                    seperatorIndex = i;

            // then we get the biggest element from the left subtree of our object
            Node maxNode = getMax(node.getChildren()[seperatorIndex]);
            // we replace our element with the biggest element from the left subtree
            node.getKeys()[seperatorIndex] = maxNode.getKeys()[maxNode.size() - 1];
            // and then we remove that element from the subtree
            maxNode.remove(maxNode.getKeys()[maxNode.size() - 1]);

            // in case our maxNode is now deficient we need to rebalance it
            if(maxNode.size() < order)
                rebalance(maxNode);
        }
        return true;
    }

    private void rebalance(Node node) {
        int rightParentIndex = 0;
        Node rightSibling = null, leftSibling = null;

        if(node.getParent() == null)
        	return;

        // first we get the index of the parent element (right from our node)
        for(int i = 0; i < node.getParent().size() + 1; i++) {
            if(node.getParent().getChildren()[i] == node ) {
                rightParentIndex = i;
            }
        }

        // here we get the siblings
        if(rightParentIndex < order + 1)
            rightSibling = node.getParent().getChildren()[rightParentIndex + 1];
        if(rightParentIndex > 0)
            leftSibling = node.getParent().getChildren()[rightParentIndex - 1];

        // should our node have a right sibling that we can remove one element from
        // we rotate the tree
        if(rightSibling != null && rightSibling.size() - 1 >= order) {
            rotate(node, rightSibling, rightParentIndex, 0, order - 1);
        }
        // same with our left sibling
        else if (leftSibling != null && leftSibling.size() - 1 >= order) {
            rotate(node, leftSibling, rightParentIndex - 1, leftSibling.size() - 1, 0);
        } else {
            // if we're not able to remove one element from one of the siblings
            // we have to merge with one of them
            if(leftSibling != null) {
                // we get the seperator and insert it into the left sibling
                Comparable seperator = node.getParent().getKeys()[rightParentIndex - 1];
                leftSibling.insert(order, seperator);

                // then we fill that left sibling with all the elements
                // that are still in our deficient node
                for(int i = 0; i < node.size(); i++)
                    leftSibling.insert(order + 1 + i, node.getKeys()[i]);

                // here we set the right child of our seperator
                // to the left child because after removing one element from
                // the node, all the children get shifted to the left, thus losing one element
                node.getParent().getChildren()[rightParentIndex] = leftSibling;
                node.getParent().remove(seperator);


                // should our parent be the root and not have any elements, our new root
                // is now  the left sibling
                if(node.getParent() == root && node.getParent().getKeys()[0] == null) {
                    if(node.getChildren()[0] != null)
                        leftSibling.getChildren()[leftSibling.size()] = node.getChildren()[0];
                    root = leftSibling;
                    leftSibling.setParent(null);
                } else if (node.getParent().size() < order) {
                    rebalance(node.getParent());
                }

            } else if (rightSibling != null) {
                // here we do the same as with the left sibling
                Comparable seperator = node.getParent().getKeys()[rightParentIndex];
                node.insert(order - 1, seperator);

                for(int i = 0; i < rightSibling.size(); i++)
                    node.insert(order + i, rightSibling.getKeys()[i]);

                node.getParent().getChildren()[rightParentIndex + 1] = node;
                node.getParent().remove(seperator);
                if(node.getParent() == root && node.getParent().getKeys()[0] == null) {
                    if (rightSibling.getChildren()[0] != null) {
                        node.getChildren()[node.size()] = rightSibling.getChildren()[0];
                    }
                    root = node;
                    node.setParent(null);
                } else if (node.getParent().size() < order) {
                    rebalance(node.getParent());
                }

            }
        }
    }


    private void rotate(Node deficientNode, Node nodeWithEnoughElements, int parentIndex, int keyIndexToTakeOut, int insertPosInDeficentNode) {
        deficientNode.insert(insertPosInDeficentNode, deficientNode.getParent().getKeys()[parentIndex]);
        deficientNode.getParent().getKeys()[parentIndex] = nodeWithEnoughElements.getKeys()[keyIndexToTakeOut];

        if(nodeWithEnoughElements.getChildren()[keyIndexToTakeOut] != null) {
        	if(deficientNode.getChildren()[insertPosInDeficentNode+1] == null) {
        		deficientNode.getChildren()[insertPosInDeficentNode+1] = new Node(order);
        		deficientNode.getChildren()[insertPosInDeficentNode+1].setParent(deficientNode);
        	}
        	for(int i = 0; i < nodeWithEnoughElements.getChildren()[keyIndexToTakeOut].size(); i++) {
        		deficientNode.getChildren()[insertPosInDeficentNode+1].insert(deficientNode.getChildren()[insertPosInDeficentNode+1].size(),
        				nodeWithEnoughElements.getChildren()[keyIndexToTakeOut].getKeys()[i]);
        	}
        }

        nodeWithEnoughElements.remove(nodeWithEnoughElements.getKeys()[keyIndexToTakeOut]);
    }

    /**
     * This method saves the tree to a file
     *
     * @param path The path (including filename) the tree will be saved to
     */
    public void saveTree(String path) {
        ObjectOutputStream stream = null;
        try {
            stream = new ObjectOutputStream(new FileOutputStream(path));
            stream.writeObject(this);
            stream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method loads a tree from a file
     * and returns that tree.
     * @param path The path to the file that contains the tree;
     * @return Returns the tree from the file
     * @throws FileNotFoundException
     */
    public static BTreeImplementation loadTree(String path) throws FileNotFoundException {
        ObjectInputStream stream = null;
        BTreeImplementation newTree = null;

        if (!MakeItSimple.isFilePresent(path))
            throw new FileNotFoundException(path + " could not be found!");

        try {
            stream = new ObjectInputStream(new FileInputStream(path));
            newTree = (BTreeImplementation) stream.readObject();
            stream.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return newTree;
    }
}
