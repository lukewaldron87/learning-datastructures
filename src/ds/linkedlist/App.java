package ds.linkedlist;

public class App {

	public static void main(String[] args) {
		
		Node nodeA = new Node();
		nodeA.setData(1);
		
		Node nodeB = new Node();
		nodeB.setData(2);
		
		Node nodeC = new Node();
		nodeC.setData(3);
		
		Node nodeD = new Node();
		nodeD.setData(4);
		
		nodeA.setNext(nodeB);
		nodeB.setNext(nodeC);
		nodeC.setNext(nodeD);
		
		System.out.println("length from nodeA: "+listLength(nodeA)); // 4
		System.out.println("length from nodeB: "+listLength(nodeB)); // 3
		
		//printList(nodeA);

		System.out.println("reverseList");
		Node node = recursiveReverse(nodeA);
		System.out.println("node: "+node.getData());
		printList(node);
	}
	
	public static int listLength(Node node) {
		
		int length = 0;
		
		Node currentNode = node;
		
		while(currentNode != null) {
			length++;
			currentNode = currentNode.getNext();
		}
		
		return length;
	}
	
	
	public static void printList(Node node) {
		
		System.out.println("printList");
		
		Node currentNode = node;
		
		while(currentNode != null) {
			System.out.print(currentNode.getData()+" ");
			currentNode = currentNode.getNext();
		}
		
		System.out.println();
			
	}
	
	/*public static Node reverseList(Node node) {
		
		Node currentNode = null;
		
		if(node.getNext() != null) {
			previousNode = reverseList(node.getNext());
			//node.setNext(null);
			//System.out.println(previousNode.getData()+" -> "+node.getData());
			//previousNode.setNext(node);
		}
		
		
		return previousNode;
	}*/
	
	public static Node recursiveReverse(Node head) {
		Node first;

		// if the current node is null and therefore the final node of the list return it
		if (head.getNext() == null)
			return head;

		// get the next node
		first = recursiveReverse(head.getNext());
		// link the next node to the current node
		head.getNext().setNext(head);
		// link this node to null
		head.setNext(null);

		return first;
	}
	
	public static Node simpleReverseList(Node node) {
		
        Node prev = null; 
        Node current = node; 
        Node next = null; 
        
		
        while (current != null) { 
        	// get the next node
            next = current.getNext();
            // link the current node to the previous one
            current.setNext(prev); 
            // set the previous node to the current one
            prev = current; 
            // set the current node to the next node
            current = next; 
        } 
        
        //return the previous node; 
        return prev;
	}
}
