package ds.singlylinkedlist;

public class SinglyLinkedList {

	private Node first;
	//private Node last;
	
	public SinglyLinkedList() {

	}
	
	public boolean isEmpty() {
		return (first == null);
	}
	
	// used to insert at the beginning of the list
	public void insertFirst(int data) {
		
		Node newNode = new Node();
		newNode.data = data;
		
		//if(first != null && first.next == null) {
		//	last = first;
		//	newNode.next = last;
		//}else{
		
			// point the variable "next" to the node object referenced by the variable "first"
			newNode.next = first;
		//}
		// point the variable "first" to the new Node object
		first = newNode;
	}
	
	/*public void insertLast(int data) {
		
		Node newNode = new Node();
		newNode.data = data;
		last.next = newNode;
		last = newNode;
	}*/
	
	public Node deleteFirst() {
		Node temp = first;
		first = first.next;
		// return the deleted node
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
