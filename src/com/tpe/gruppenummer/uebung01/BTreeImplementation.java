package com.tpe.gruppenummer.uebung01;

import com.tpe.gruppenummer.utils.QueueImpl;
import com.tpe.gruppenummer.utils.Queue;

import static gdi.MakeItSimple.*;

public class BTreeImplementation implements BTree {

    Node root;
    int order;

    BTreeImplementation(int order) {
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
    public boolean insert(Integer o) {
        return insert(root, 0, o);
    }

    private boolean insert(Node node,int keyIndex, Integer o) {
        // If our current element is null and it doesn't have children
        // we can insert the integer at the current index.
        // Otherwise the node has children and we try to insert it in the left child
        // of the current element.
        if(node.getKeys()[keyIndex] == null && node.getSubNodes()[keyIndex] == null) {
            // If our node is full and the a new element is inserted we have to balance the tree
            if(node.insert(keyIndex, o))
                balance(node);
            return true;
        } else if(node.getKeys()[keyIndex] == null) {
            return insert(node.getSubNodes()[keyIndex], 0, o);
        }

        // Should the element already be in the node we return false to indicate that
        if(node.getKeys()[keyIndex].intValue() == o.intValue())
            return false;

        // If our current element is greater than the integer we want to insert
        // and it doesn't have children we insert it at the current index and rebalance if needed
        // should it have children we recursively call insert on that child
        if(node.getKeys()[keyIndex] > o) {
            if(node.getSubNodes()[keyIndex] == null) {
                if(node.insert(keyIndex, o))
                    balance(node);
                return true;
            } else {
                return insert(node.getSubNodes()[keyIndex], 0, o);
            }
        } else {
            // If the current element is less than the integer we want to insert
            // we recursively call insert on the current node with a higher index (+1)
            return insert(node, keyIndex + 1, o);
        }
    }

    private void balance(Node node) {
        Integer median = node.getKeys()[order];
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

            // Here look for the largest element that is still
            // smaller than our median in the parent,
            // that way we can insert the median at the right position
            for(int i = 0; i < order * 2; i++)
                if (curParent.getKeys()[i] != null && curParent.getKeys()[i] < median)
                    maxIndex = i;

            // Should the current maximum Index still be larger than our median
            // we insert the median BEFORE that index
            // otherwise we insert it AFTER the maximum Index
            if(curParent.getKeys()[maxIndex] > median) {
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
        newParent.getSubNodes()[indexOfInserted] = childLeft;
        for (int i = 0; i < order; i++) {
            childLeft.insert(i, node.getKeys()[i]);
            // if the elements have children we need to reconnect them too
            childLeft.getSubNodes()[i] = node.getSubNodes()[i];
            // and also reparent them
            if(childLeft.getSubNodes()[i] != null)
                childLeft.getSubNodes()[i].setParent(childLeft);

            // if we're on the last index before the median we need
            // to reconnect the child of our median too
            if(i == order - 1) {
                childLeft.getSubNodes()[i + 1] = node.getSubNodes()[i + 1];
                if(childLeft.getSubNodes()[i] != null)
                    childLeft.getSubNodes()[i + 1].setParent(childLeft);
            }
        }

        // and the right child has all the values larger than our median
        Node childRight = new Node(order, newParent);
        newParent.getSubNodes()[indexOfInserted + 1] = childRight;
        for (int i = order + 1; i < node.getKeys().length; i++) {
            // tempIndex is just there to shorten the other lines
            int tempIndex = i - (order + 1);
            // if the elements have children we need to reconnect them too
            childRight.insert(tempIndex, node.getKeys()[i]);
            childRight.getSubNodes()[tempIndex] = node.getSubNodes()[i];

            if(childRight.getSubNodes()[tempIndex] != null)
                childRight.getSubNodes()[tempIndex].setParent(childRight);

            // if we're on the last index we need
            // to reconnect the child of our median too
            if(i == node.getKeys().length - 1) {
                childRight.getSubNodes()[tempIndex + 1] = node.getSubNodes()[i + 1];
                if(childRight.getSubNodes()[tempIndex] != null)
                    childRight.getSubNodes()[tempIndex + 1].setParent(childRight);
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
    public boolean contains(Integer o) {
        return contains(root, 0, o);
    }

    private boolean contains(Node node, int keyIndex, Integer o) {
        if(node.getKeys()[keyIndex] == null)
            return node.getSubNodes()[keyIndex] != null && contains(node.getSubNodes()[keyIndex], 0, o);

        if(node.getKeys()[keyIndex].intValue() == o.intValue())
            return true;

        if(node.getKeys()[keyIndex] > o)
            return node.getSubNodes()[keyIndex] != null && contains(node.getSubNodes()[keyIndex], 0, o);
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
                if(n.getSubNodes()[i] != null)
                    queue.enter(n.getSubNodes()[i]);
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
        if(node.getSubNodes()[0] == null)
            return count;
        else
            count += height(node.getSubNodes()[0]);
        return count;
    }

    @Override
    public Integer getMax() {
        return getMax(root);
    }

    private Integer getMax(Node node) {
        int currMax = 0;
        int currMaxIndex = 0;
        for(int i = 0; i < order * 2; i++) {
            if(node.getKeys()[0] == null) {
                return -1;
            }
            if(node.getKeys()[i] != null) {
                currMax = node.getKeys()[i];
                currMaxIndex = i;
            }
        }

        if(node.getSubNodes()[currMaxIndex + 1] != null) {
            return getMax(node.getSubNodes()[currMaxIndex + 1]);
        } else {
            return currMax;
        }
    }

    @Override
    public Integer getMin() {
        return getMin(root);
    }

    private Integer getMin(Node node) {
        if(node.getSubNodes()[0] == null)
            return node.getKeys()[0] == null ? -1 : node.getKeys()[0];
        else
            return getMin(node.getSubNodes()[0]);
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
        if(node.getSubNodes()[0] == null) {
            output += "<";
            for(int i = 0; i < order * 2; i++) {
                output += node.getKeys()[i] == null ? "" : node.getKeys()[i] + " ";
            }
            output += ">";
            return output;
        } else {
            output += "[";
            for (int i = 0; i < order * 2 + 1; i++) {
                output += printInorder(node.getSubNodes()[i]);
                output += node.getKeys()[i] == null ? "" : node.getKeys()[i] + " ";
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
        if(node.getSubNodes()[0] == null) {
            for(int i = 0; i < order * 2; i++) {
                output += node.getKeys()[i] == null ? "" : node.getKeys()[i] + " ";
            }
            return output;
        } else {
            for (int i = 0; i < order * 2 + 1; i++) {
                output += printPostorder(node.getSubNodes()[i]);
            }
            for(int i = 0; i < order * 2; i++) {
                output += node.getKeys()[i] == null ? "" : node.getKeys()[i] + " ";
            }
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
        if(node.getSubNodes()[0] == null) {
            for(int i = 0; i < order * 2; i++) {
                output += node.getKeys()[i] == null ? "" : node.getKeys()[i] + " ";
            }
            return output;
        } else {
            for(int i = 0; i < order * 2; i++) {
                output += node.getKeys()[i] == null ? "" : node.getKeys()[i] + " ";
            }
            for (int i = 0; i < order * 2 + 1; i++) {
                output += printPreorder(node.getSubNodes()[i]);
            }
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
            for(int i = 0; i < order * 2; i++) {
                output += n.getKeys()[i] == null ? "" : n.getKeys()[i] + " ";
            }
            for(int i = 0; i < order * 2 + 1; i++) {
                if(n.getSubNodes()[i] != null)
                    queue.enter(n.getSubNodes()[i]);
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
            for(int i = 0; i < order * 2; i++) {
                output += n.getKeys()[i] == null ? "" : " " + n.getKeys()[i] ;
            }
            for(int i = 0; i < order * 2 + 1; i++) {
                if(n.getSubNodes()[i] != null)
                    queue.enter(n.getSubNodes()[i]);
            }
        }

        return output;
    }
}
