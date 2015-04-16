package tpe.GruppeXY.utils;

import tpe.GruppeXY.uebung01.Node;
import gdi.MakeItSimple.*;

public class LinkedListImpl implements LinkedList {

	private ListNode head;

	@Override
	public void addLast(Node number) {

		ListNode newNode = new ListNode();
		newNode.setElement(number);

		if(isEmpty()) {
			head = newNode;
		} else {
			ListNode currNode = head;

			while (currNode.getNext() != null)
				currNode = currNode.getNext();

			currNode.setNext(newNode);
		}
	}

	@Override
	public Node removeFirst() {
		if(isEmpty())
			throw new GDIException("Can't remove from empty list");
		Node value = head.getElement();
		head = head.getNext();
		return value;
	}

	@Override
	public Node getFirst() {
		if(head == null)
			throw new GDIException("No first Element");

		return head.getElement();
	}


	@Override
	public boolean isEmpty() {
		return head == null;
	}

	public static LinkedList empty() {
		return new LinkedListImpl();
	}

	@Override
	public String toString() {
		String returnString = "";
		ListNode currNode = head;

		while(currNode != null) {
			returnString += currNode.getElement() + " ";
			currNode = currNode.getNext();
		}

		return returnString;
	}

}
