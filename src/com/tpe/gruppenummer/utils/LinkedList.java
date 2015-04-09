package com.tpe.gruppenummer.utils;

import com.tpe.gruppenummer.uebung01.Node;

public interface LinkedList {

	public void addLast(Node number);

	public Node removeFirst();

	public Node getFirst();

	public boolean isEmpty();

	public String toString();

}
