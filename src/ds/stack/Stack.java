package ds.stack;

public class Stack {

	private int maxSize;
	// the stack
	private char[] stackArray;
	// index of last item placed on the stack
	private int top;
	
	public Stack(int size) {
		this.maxSize = size;
		this.stackArray = new char[maxSize];
		this.top = -1;
	}
	
	public void push(char j) {
		if(isFull()) {
			System.out.println("this stack is already full");
		}else {
			top++;
			stackArray[top] = j;
		}
	}
	
	// remove top element from the stack
	public char pop() {
		if(isEmpty()) {
			System.out.println("shatck is empty");
			return '0';
		}else {
			int oldTop = top;
			top--;
			return stackArray[oldTop];
		}
	}
	
	// return element at the top of the stack
	// but do not remove it
	public char peak() {
		return stackArray[top];
	}
	
	public boolean isEmpty() {
		return (top == -1);
	}
	
	public boolean isFull() {
		return (maxSize-1 == top);
	}
}
