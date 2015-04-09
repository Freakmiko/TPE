package com.tpe.gruppenummer.uebung01;

public class Node {

    private Node parent;
    private Node[] subNodes;
    private Integer[] keys;

    Node(int order) {
        this(order, null);
    }

    Node(int order, Node parent) {
        this.setKeys(new Integer[order * 2 + 1]);
        this.setSubNodes(new Node[order * 2 + 2]);
        this.setParent(parent);
    }

    boolean insert(int index, Integer o) {
        if(getKeys()[index] == null) {
            getKeys()[index] = o;

            if(getKeys()[getKeys().length - 1] != null)
                return true;
            return false;
        } else  {
            for (int i = getKeys().length - 1; i > index; i--) {
                getKeys()[i] = getKeys()[i - 1];
                getSubNodes()[i] = getSubNodes()[i - 1];
            }
            getKeys()[index] = o;

            if(getKeys()[getKeys().length - 1] != null)
                return true;
            return false;
        }
    }

    int size() {
        int count = 0;
        for (int i = 0; i < getKeys().length; i++) {
            count += getKeys()[i] == null ? 0 : 1;
        }
        return count;
    }


    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public Node[] getSubNodes() {
        return subNodes;
    }

    public void setSubNodes(Node[] subNodes) {
        this.subNodes = subNodes;
    }

    public Integer[] getKeys() {
        return keys;
    }

    public void setKeys(Integer[] keys) {
        this.keys = keys;
    }
}
