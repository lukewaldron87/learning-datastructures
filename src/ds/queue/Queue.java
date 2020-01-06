package ds.queue;

public class Queue {

	private int maxSize;
	private long[] queArray;
	// the index position for the element at the front
	private int front; 
	// the index position for the element at the back
	private int rear;
	private int nItems; // counter to maintain the number of items in our queue
	
	public Queue(int size) {
		this.maxSize = size;
		this.queArray = new long[size];
		// index position of the first slot of the array
		this.front = 0;
		// there is no item in the array yet to be considered the last item (see line 25)
		this.rear = -1;
		// no array elements yet
		this.nItems = 0;
	}
	
	public void insert(long j) {
		//if(isFull()) {
		//	System.out.println("The Queue is full");
		//}else {
			if(rear == maxSize-1) {
				rear = -1;
			}
			
			rear++;
			queArray[rear] = j;
			nItems ++;
		//}
	}
	
	// remove item from the front
	public long remove() {
		long firstElement = queArray[front];
		front++;
		if(front == maxSize) {
			// array is empty
			// set front to 0
			// so the entire array can be used again
			front = 0;
		}
		nItems--;
		return firstElement;
	}
	
	public long peekFront() {
		return queArray[front];
	}
	
	public boolean isEmpty() {
		return (nItems == 0);
	}
	
	public boolean isFull() {
		return (nItems == maxSize);
	}
	
	public void view() {
		System.out.print("[ ");
		for(int i=0; i<queArray.length; i++) {
			System.out.print(queArray[i]+" ");
		}
		System.out.println("]");
	}
}
