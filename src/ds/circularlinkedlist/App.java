package ds.circularlinkedlist;

import ds.singlylinkedlist.SinglyLinkedList;

public class App {

	public static void main(String[] args) {
		CircularLinkedList myList = new CircularLinkedList();
		myList.insertFirst(100);
		myList.insertFirst(50);
		myList.insertFirst(99);
		myList.insertFirst(88);
		myList.insertLast(99999);
		myList.insertFirst(2);
		myList.insertFirst(1);
		myList.insertLast(989898);
		
		myList.displayList();

	}

}
