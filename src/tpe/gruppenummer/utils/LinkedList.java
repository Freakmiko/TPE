package tpe.gruppenummer.utils;

import tpe.gruppenummer.uebung01.Node;

public interface LinkedList {

	void addLast(Node number);

	Node removeFirst();

	Node getFirst();

	boolean isEmpty();

	String toString();

}
