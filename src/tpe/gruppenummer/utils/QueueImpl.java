package tpe.gruppenummer.utils;

import tpe.gruppenummer.uebung01.Node;

public class QueueImpl implements Queue {

    LinkedList internalList;

    public QueueImpl() {
        internalList = new LinkedListImpl();
    }

    @Override
    public void enter(Node value) {
        internalList.addLast(value);
    }

    @Override
    public Node leave() {
        return internalList.removeFirst();
    }

    @Override
    public Node front() {
        return internalList.getFirst();
    }

    @Override
    public boolean isEmpty() {
        return internalList.isEmpty();
    }

    @Override
    public String toString() {
        return internalList.toString();
    }
}
