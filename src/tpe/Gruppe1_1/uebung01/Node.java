package tpe.Gruppe1_1.uebung01;

public class Node {

    private Node parent;
    private Node[] children;
    private Comparable[] keys;

    public Node(int order) {
        this(order, null);
    }

    public Node(int order, Node parent) {
        this.setKeys(new Comparable[order * 2 + 1]);
        this.setChildren(new Node[order * 2 + 2]);
        this.setParent(parent);
    }

    /**
     * Inserts the integer at the index into the node
     * if the node exceeds its limit of elements it returns true
     * @param index The position where the integer is inserted
     * @param o The integer to be inserted
     * @return returns true if the node has more elements than it can hold and false if everything's fine
     */
    public boolean insert(int index, Comparable o) {
        if(index < 0 || index >= getKeys().length)
            return false;

        if(getKeys()[index] == null) {
            getKeys()[index] = o;

            return getKeys()[getKeys().length - 1] != null;
        } else  {
            // We shift every element (and it's children) to the right as long
            // as we're in front of the insert position
            for (int i = getKeys().length - 1; i > index; i--) {
                getKeys()[i] = getKeys()[i - 1];
                getChildren()[i] = getChildren()[i - 1];
            }
            getKeys()[index] = o;

            return getKeys()[getKeys().length - 1] != null;
        }
    }

    /**
     * Removes the Integer from the Node.
     * @param o The integer to remove.
     */
    public void remove(Comparable o) {
        int nodeToRemove = -1;

        for(int i = 0; i < getKeys().length; i++) {
            if(getKeys()[i] != null && getKeys()[i].compareTo(o) == 0)
                nodeToRemove = i;
        }

        if(nodeToRemove == -1)
            return;


        for(int i = nodeToRemove; i < getKeys().length - 1; i++) {
            getKeys()[i] = getKeys()[i + 1];
            getChildren()[i] = getChildren()[i + 1];
            getKeys()[i+1] = null;
            getChildren()[i+1] = null;
        }
    }

    /**
     * Counts the elements in the node
     * @return the number of elements
     */
    public int size() {
        int count = 0;
        for (int i = 0; i < getKeys().length; i++) {
            count += getKeys()[i] == null ? 0 : 1;
        }
        return count;
    }


    /**
     * Returns the parent
     * @return the parent
     */
    public Node getParent() {
        return parent;
    }

    /**
     * Sets the parent
     * @param parent the new parent
     */
    public void setParent(Node parent) {
        this.parent = parent;
    }

    /**
     * Returns an array of nodes of the children
     * @return the array of children
     */
    public Node[] getChildren() {
        return children;
    }

    /**
     * Sets the children
     * @param children the new children
     */
    public void setChildren(Node[] children) {
        this.children = children;
    }

    /**
     * Returns the keys of the node
     * @return the keys of the node
     */
    public Comparable[] getKeys() {
        return keys;
    }

    /**
     * Sets the keys of the node
     * @param keys the new keys
     */
    public void setKeys(Comparable[] keys) {
        this.keys = keys;
    }
}
