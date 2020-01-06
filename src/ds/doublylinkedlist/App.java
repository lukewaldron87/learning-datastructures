package ds.doublylinkedlist;

import ds.singlylinkedlist.SinglyLinkedList;

public class App {

	public static void main(String[] args) {
		DoublyLinkedList myList = new DoublyLinkedList();
		myList.insertFirst(100);
		myList.insertFirst(50);
		myList.insertFirst(99);
		myList.insertFirst(88);
		myList.insertLast(88888);
		myList.insertFirst(2);
		myList.insertFirst(1);
		myList.insertLast(99999);
		
		
		myList.displayList();
		
		myList.deleteLast();
		myList.insertAfter(2, 3);
		myList.DeleteKey(50);
		
		myList.displayList();
		myList.displayBackward();
		
	}

}
