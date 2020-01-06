package ds.singlylinkedlist;

public class App {

	public static void main(String[] args) {
		SinglyLinkedList myList = new SinglyLinkedList();
		myList.insertFirst(100);
		myList.insertFirst(50);
		myList.insertFirst(99);
		myList.insertFirst(88);
		//myList.insertLast(99999);
		myList.insertFirst(2);
		myList.insertFirst(1);
		//myList.insertLast(989898);
		
		myList.displayList();
		
		

	}

}
