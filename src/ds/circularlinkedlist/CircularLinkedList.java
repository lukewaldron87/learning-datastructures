package ds.circularlinkedlist;

import ds.singlylinkedlist.Node;

public class CircularLinkedList {

	private Node first;
	private Node last;
	
	public CircularLinkedList() {
		first =null;
		last = null;
	}
	
	public boolean isEmpty() {
		return (first == null);
	}
	
	public void insertFirst(int data) {
		
		Node newNode = new Node();
		newNode.data = data;
		
		if(isEmpty()) {
			last = newNode;
		}
		
		// newNode --> old first
		newNode.next = first;
		// first place
		first = newNode;
	}
	
	public void insertLast(int data) {
		
		Node newNode = new Node();
		newNode.data = data;
		
		if(isEmpty()) {
			first = newNode;
		} else {
			// the next value of the last node will point to the new node
			last.next = newNode;
			// we make the new node we created be the last one in the list
			last = newNode;
		}
	}
	
	public int deleteFirst() {
		int temp = first.data;
		
		if(first.next == null) {
			last = null;
		}
		
		// first will point ot old's next value
		first = first.next;
		return temp;
	}
	
	public void displayList() {
		System.out.println("List (first --> last");
		Node currentNode = first;
		while(currentNode != null) {
			currentNode.displayNode();
			currentNode = currentNode.next;
		}
	}
}
