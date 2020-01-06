package ds.linkedlistNEW;

import ds.doublylinkedlist.DoublyLinkedList;

public class App {

	public static void main(String[] args) {


		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		
		node1.setNext(node2);
		node2.setNext(node3);
		node3.setNext(node4);
		node4.setNext(null);
		
		Node rootNode = node1;
		
		rootNode = insertFirst(0, rootNode);
		rootNode = insertLast(5, rootNode);
		rootNode = insertAfter(3, 33, rootNode);
		
		printList(rootNode);
		System.out.println(listLength(rootNode));
		
		rootNode = deleteKey(33, rootNode);
		
		printList(rootNode);
		System.out.println(listLength(rootNode));
		
		rootNode = recursiveReverseList(rootNode, null);
		printList(rootNode);

	}
	
	private static Node insertFirst(int data, Node rootNode) {
	
		return new Node(data, rootNode);		
	}
	
	private static Node insertLast(int data, Node rootNode) {
		
		Node newNode = new Node(data, null);
		Node currentNode = rootNode;
		
		while(currentNode.getNext() != null) {
			currentNode = currentNode.getNext();
		}
		
		currentNode.setNext(newNode);
		
		return rootNode;
		
	}
	
	private static Node insertAfter(int nodeData, int newData, Node rootNode) {
		
		Node currentNode = rootNode;
		
		while(currentNode.getData() != nodeData) {
			currentNode = currentNode.getNext();
		}
		
		Node newNode = new Node(newData, currentNode.getNext());
		currentNode.setNext(newNode);
		
		return rootNode;
	}
	
	private static Node deleteKey(int nodeData, Node rootNode) {
		
		Node currentNode = rootNode;
		Node previousNode = null;
		
		while(currentNode.getData() != nodeData) {
			previousNode = currentNode;
			currentNode = currentNode.getNext();
		}
		
		previousNode.setNext(currentNode.getNext());
		
		return rootNode;
	}
	
	private static void printList(Node rootNode) {
		
		Node currentNode = rootNode;
		
		System.out.print("List: ");
		
		while(currentNode != null) {

			System.out.print(currentNode.getData()+" ");
			currentNode = currentNode.getNext();
			
		}
		
		System.out.println();
		
	}
	
	private static int listLength(Node rootNode) {
		
		int listLength = 0;
		Node currentNode = rootNode;
		
		while(currentNode != null) {

			listLength++;
			currentNode = currentNode.getNext();
			
		}
		
		return listLength;
		
	}
	
	private static Node recursiveReverseList(Node currentNode, Node previousNode) {
		
		Node rootNode;
		
		if(currentNode.getNext() != null)
			rootNode = recursiveReverseList(currentNode.getNext(), currentNode);
		else
			rootNode = currentNode;
			
			
		currentNode.setNext(previousNode);
		
		return rootNode;
		
	}

}
