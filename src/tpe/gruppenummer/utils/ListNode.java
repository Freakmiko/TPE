package tpe.gruppenummer.utils;


import tpe.gruppenummer.uebung01.Node;

/**
 * The class ListNode is a helper class for every kind of LinkedLists
 * 
 * @author Wolfgang Schramm
 */
public class ListNode {

	private Node element;
	private ListNode next;

	/**
	 * @return the value of the current node
	 */
	public Node getElement() {
		return element;
	}

	/**
	 * @param value
	 *            the new value of the current node
	 */
	public void setElement(Node value) {
		this.element = value;
	}

	/**
	 * @return the next element
	 */
	public ListNode getNext() {
		return next;
	}

	/**
	 * 
	 * @param next
	 *            the new next element
	 */
	public void setNext(ListNode next) {
		this.next = next;
	}
}

