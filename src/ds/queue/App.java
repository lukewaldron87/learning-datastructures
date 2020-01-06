package ds.queue;

public class App {

	public static void main(String[] args) {

		Queue myQueue = new Queue(5);
		myQueue.insert(1000);
		myQueue.insert(6);
		myQueue.insert(98);
		myQueue.insert(74);
		myQueue.insert(22);
		myQueue.view();
		myQueue.insert(99);
		myQueue.insert(99);
		myQueue.view();
	}

}
