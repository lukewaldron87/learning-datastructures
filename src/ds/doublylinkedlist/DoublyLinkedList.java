package ds.doublylinkedlist;

public class DoublyLinkedList {

	private Node first;
	private Node last;
	
	public DoublyLinkedList() {
		this.first = null;
		this.last = null;
	}
	
	public boolean isEmpty() {
		return first == null;
	}
	
	public void insertFirst(int data) {
		
		Node newNode = new Node();
		newNode.data = data;
		
		if(isEmpty()) {
			
			// if empty, last will refer to the new Node being created
			last = newNode;
		} else {
			
			first.previous = newNode;
		}
		
		// the new node's next field will point to the old first
		newNode.next = first;
		first = newNode;
		
	}
	
	public void insertLast(int data) {
		
		Node newNode = new Node();
		newNode.data = data;
		
		if(isEmpty()) {
			first = newNode;
		} else {
			
			// assign old last to newnode
			last.next = newNode;
			// the old last will be the newnodes previous 
			newNode.previous = last;
		}
		
		// the linked lists' last field should point to the new node
		last = newNode;
		
	}
	
	// assume non-empty list
	public Node deleteFirst() {
		
		Node temp = first;
		// there is only one item in the list
		if(first.next == null) {
			last = null;
		} else {
			first.next.previous = null;
		}
		
		// we are assigning the reference of the node following the old first node to the first field in the linked list object
		first = first.next;
		// return the deleted old first node
		return temp; 
	}
	

	// assume non-empty list
	public Node deleteLast() {
	
		Node temp = last;
		
		if(first.next == null) {
			first = null;
		} else {
			last.previous.next = null;
		}
		
		last = last.previous;
		return temp;
	}
	
	// assume non-empty list
	public boolean insertAfter(int key, int data) {
		
		Node newNode = new Node();
		newNode.data = data;
		Node keyNode = first;
		
		// search for the correct node
		while(keyNode.data != key) {
			keyNode = keyNode.next;
			if(keyNode == null)
				return false;
		}
		
		if(keyNode == last) {
			keyNode.next=null;
			last = newNode;
		}else {
		
			// set the new node as the previous node for the next node in line
			keyNode.next.previous = newNode;
			// set the next node as next for the new node
			newNode.next = keyNode.next;
		
		}
		// set new node as next for the key node
		keyNode.next = newNode;
		// set the key node as previous for the new node
		newNode.previous = keyNode;
		
		return true;
	}
	
	// assume non-empty list
	public Node DeleteKey(int key) {
		Node keyNode = first;
		
		// search for the correct node
		while(keyNode.data != key) {
			keyNode = keyNode.next;
			if(keyNode == null)
				return null;
		}

		
		Node tempNode = keyNode;
		
		if(keyNode == first) {
			// make the variable first point to the next node in the list
			first = keyNode.next;
		}else {
			keyNode.previous.next = keyNode.next;
		}
			
			
		if(keyNode == last) {
			last = keyNode.previous;
		}else {
			keyNode.next.previous = keyNode.previous;
		}
		
		return tempNode;
	}
	
	public void displayList() {
		
		System.out.println("List (first --> last");
		Node currentNode = first;
		while(currentNode != null) {
			currentNode.displayNode();
			currentNode = currentNode.next;
		}
	}
	
	public void displayBackward() {
		System.out.println("List (last -- first");
		Node currentNode = last;
		while(currentNode != null) {
			currentNode.displayNode();
			currentNode = currentNode.previous;
		}
		
	}
}
