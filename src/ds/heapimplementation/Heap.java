package ds.heapimplementation;

import java.util.ArrayList;
import java.util.List;

public class Heap {

	private Node[] heapArray;
	// size of array
	private int maxSize;
	// number of nodes in the array
	private int currentSize;
	
	public Heap(int size) {
		this.maxSize = size;
		currentSize = 0;
		// actually creates the array
		heapArray = new Node[size];
	}
	
	public int getSize() {
		return currentSize;
	}
	
	public boolean isEmpty() {
		return (currentSize == 0);
	}
	
	public boolean insert(int key) {
	
		if(currentSize == maxSize) {
			return false;
		}
		
		Node newNode = new Node(key);
		heapArray[currentSize] = newNode;
		
		// if larger than parent move up
		trickleUp(currentSize);
		
		currentSize++;
		return true;
	}
	
	private void trickleUp(int index) {
		
		int parentIndex = (index-1)/2;
		Node nodeToInsert = heapArray[index];
		
		// while the parent is greater than the current index swap the parent with the current index
		while(index > 0 &&  heapArray[parentIndex].getKey() < nodeToInsert.getKey()) {
			
			// move parent down
			heapArray[index] = heapArray[parentIndex];
			
			index = parentIndex;
			parentIndex = (parentIndex-1)/2;
			
		}
		
		heapArray[index] = nodeToInsert;
		
	}
	
	public Node remove() {
		
		Node root = heapArray[0];
		currentSize--;
		heapArray[0] = heapArray[currentSize];
		
		trickleDown(0);
		
		return root;
		
	}
	
	private void trickleDown(int index) {
		
		int leftChildIndex;
		int rightChildIndex;
		
		int largerChildIndex;
		// save last into top variable
		Node top = heapArray[index];
		
		// while index not on bottom row (at least 1 chile)
		while(index < currentSize/2)   {

			leftChildIndex = (2*index)+1;
			//rightIndex = (2*index)+2;
			rightChildIndex = leftChildIndex++;
			
			// find the larger child
			if( rightChildIndex < currentSize &&
				heapArray[leftChildIndex].getKey() < heapArray[rightChildIndex].getKey()) {
				
				largerChildIndex = rightChildIndex;
				
			} else {
				
				largerChildIndex = leftChildIndex;
				
			}
			
			if(top.getKey() >= heapArray[leftChildIndex].getKey()) {
				// root the largest key
				break;
			}
			
			heapArray[index] = heapArray[largerChildIndex];
			index = largerChildIndex;
			
		}
		
		heapArray[index] = top;
		
	}
	
	public void displayHeap() {
		
		List<String> heapList = new ArrayList<String>();
		recursiveDisplayHeap(0, heapList, 0);
		
		for(String heapString: heapList)
			System.out.println(heapString);
	}

	public void recursiveDisplayHeap(int arrayIndex, List<String> heapList, int heapLevel) {
		
		//for(Node node: heapArray)
		//	System.out.print(node.getKey()+", ");
		
		//System.out.println(heapArray[index].getKey());
		
		// is the string is empty create a new one
		// otherwise append the current node to the string
		if(heapList.size() == heapLevel) {
			heapList.add(""+heapArray[arrayIndex].getKey());
		}else {
			heapList.set(heapLevel, heapList.get(heapLevel) +" "+heapArray[arrayIndex].getKey());
		}
		
		// get the left and right indices
		int leftChildIndex = (2*arrayIndex)+1;
		int rightChildIndex = leftChildIndex++;
		
		// if the right indarrayIndexn't out of bounds
		// or if the array position is set
		// call the method again
		
		heapLevel++;
		
		if(rightChildIndex < maxSize && heapArray[rightChildIndex] != null) {
			recursiveDisplayHeap(rightChildIndex, heapList, heapLevel);
		}
		
		// do the same for the left index
		if(leftChildIndex < maxSize && heapArray[leftChildIndex] != null) {
			recursiveDisplayHeap(leftChildIndex, heapList, heapLevel);
		}
		
	}
	
	/* MY ANSWER
	public boolean remove() {
		
		if(currentSize == 0) {
			return false;
		}
		
		trickleDown(currentSize);
		
		currentSize--;
		return true;
		
	}
	
	private void trickleDown(int index) {
		
		Node nodeToInsert = heapArray[index];
		int leftIndex = (2*index)+1;
		int rightIndex = (2*index)+2;
		
		while(index < currentSize && 
			  heapArray[leftIndex].getKey() > heapArray[index].getKey() && 
			  heapArray[rightIndex].getKey() > heapArray[index].getKey())   {

			// if the left index is greater than the current index move the left index up
			if(heapArray[leftIndex].getKey() > heapArray[index].getKey()) {
				heapArray[index] = heapArray[leftIndex];
				index = leftIndex;
			} 
			// if the right index is greater than the current index move the right index up
			else if(heapArray[rightIndex].getKey() > heapArray[index].getKey()) {
				heapArray[index] = heapArray[rightIndex];
				index = rightIndex;
			}
			
			leftIndex = (2*index)+1;
			rightIndex = (2*index)+2;

		}
		
		heapArray[index] = nodeToInsert;
		
	}*/
}
