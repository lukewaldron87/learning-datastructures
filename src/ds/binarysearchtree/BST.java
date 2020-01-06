package ds.binarysearchtree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BST {

	private Node root;
	
	public void insert(int key, String value) {
		
		Node newNode = new Node(key, value);
		
		if(root == null) {
			root = newNode;
		}else {
			
			Node current = root;
			Node parent;
			
			// continue until you find a null node (an empty one)
			// thrn insert the value to that position
			while(true) {
				
				parent = current;
				if(key < current.key) {
					current = current.leftChild;
					
					// It's parent is the leaf node
					if(current == null) {
						parent.leftChild = newNode;
						return;
					}
				}else {
					current = current.rightChild;
					if(current == null) {
						parent.rightChild = newNode;
						return;
					}
				}
				
			}
		}
		
	}
	
	public Node findMin() {
		Node current = root;
		Node last = null;
		
		// continue along the left of the tree until the next node is null (empty)
		while(current != null){
			last = current;
			current = current.leftChild;
		}
		
		// return the last node on the left (the minimum)
		return last;
		
	}
	
	public Node findMax() {
		Node current = root;
		Node last = null;
		
		// continue along the right of the tree until the next node is null (empty)
		while(current != null){
			last = current;
			current = current.rightChild;
		}
		
		// return the last node on the right (the maximum)
		return last;
		
	}
	
	public boolean remove(int key) {
		
		Node currentNode = root;
		Node parentNode = root;
		
		boolean isLeftChild = false;
		
		// search for node with correct key
		while(currentNode.key != key) {
			parentNode = currentNode;

			// set current node to left or right
			// depending if key is greater or less than currentNode.key
			if(key < currentNode.key) {
				isLeftChild = true;
				currentNode = currentNode.leftChild;
			}else {
				isLeftChild = false;
				currentNode = currentNode.rightChild;
			}
			
			if(currentNode == null) {
				return false;
			}
		}
		
		Node nodeToDelete = currentNode;
		
		// if is a leaf node
		if(nodeToDelete.leftChild == null &&
		   nodeToDelete.rightChild == null) {
			
			
			if(nodeToDelete == root) {
				root = null;
			}
			// if the node is a left nodedelete the leaf node
			else if(isLeftChild) {
				parentNode.leftChild = null;
			}else {
				parentNode.rightChild = null;
			}

		}
		
		// if node has 1 child that is on the left
		else if( nodeToDelete.rightChild == null) {
			
			if(nodeToDelete == root) {
					root = nodeToDelete.leftChild;
			}
			// check if nodeToDelete is left or right node
			else if(isLeftChild) {
				// set the current node to the child node
				parentNode.leftChild = nodeToDelete.leftChild;
			}else {
				parentNode.rightChild = nodeToDelete.leftChild;
			}
			
		}
		// if node has 1 child that is on the right
		else if(nodeToDelete.leftChild == null) {
			
			if(nodeToDelete == root) {
				root = nodeToDelete.rightChild;
			}
			// check if nodeToDelete is left or right node
			else if(isLeftChild) {
				// set the current node to the child node
				parentNode.leftChild = nodeToDelete.rightChild;
			}
			else {
				parentNode.rightChild = nodeToDelete.rightChild;
			}
		}
		
		
		// if node has 2 children
		
		else{
			
			Node successor = getSuccessor(nodeToDelete);
			
			// connect patent of Node to successor 
			if(nodeToDelete == root) {
				root = successor;
			}
			// check if nodeToDelete is left or right node
			else if(isLeftChild) {
				// set the current node to the child node
				parentNode.leftChild = successor;
			}
			else {
				parentNode.rightChild = successor;
			}
			
			successor.leftChild = nodeToDelete.leftChild;
		}
		

		
		return true;
	}
	
	private Node getSuccessor(Node nodeToDelete) {
		
		Node successorParent = nodeToDelete;
		Node successor = nodeToDelete;
		
		// go right then continue left
		Node currentNode = nodeToDelete.rightChild;
		while(currentNode != null) {
			successorParent = successor;
			successor = currentNode;
			currentNode = currentNode.leftChild;
		}
		
		// if successor not a right child
		if(successor != nodeToDelete.rightChild) {
			successorParent.leftChild = successor.rightChild;
			successor.rightChild = nodeToDelete.rightChild;
		}
		
		return successor;
	}
	
	public void displayTree(){
		
		List<String> rows = new ArrayList<String>();
		recursiveDisplayTree(root, rows, 0);
		
		for(String row: rows)
			System.out.println(row);
		
	}
	
	private static void recursiveDisplayTree(Node treeNode, List<String> rows, int rowIndex){
		
		// append the node to the string if already added
		if(rows.size() >= rowIndex+1)
			rows.set(rowIndex, (rows.get(rowIndex)+" "+treeNode.key) );
		else
			rows.add(""+treeNode.key);
		
		// move to the next nodes that are not empty 
		if(treeNode.leftChild != null)
			recursiveDisplayTree(treeNode.leftChild, rows, rowIndex+1);
		
		if(treeNode.rightChild != null)
			recursiveDisplayTree(treeNode.rightChild, rows, rowIndex+1);
		
	}
	
	
	// Solution from video
	public void displayTreeFromVideo() {
        Stack globalStack = new Stack();
        globalStack.push(root);
        int nBlanks = 32;
        boolean isRowEmpty = false;
        System.out.println("......................................................");
        
        while(isRowEmpty==false) {
            Stack localStack = new Stack();
            isRowEmpty = true;
            for(int j=0; j<nBlanks; j++) {
                System.out.print(" ");
            }
                
            //
            while(globalStack.isEmpty()==false) {
                Node temp = (Node)globalStack.pop(); 
                if(temp != null) {
                    System.out.print(temp.key); 
                    localStack.push(temp.leftChild); 
                    localStack.push(temp.rightChild);
                    if(temp.leftChild != null || temp.rightChild != null) {
                        isRowEmpty = false; 
                    }
                } else {
                    System.out.print("--"); 
                    localStack.push(null); 
                    localStack.push(null);
                }
                
                for(int j=0; j<nBlanks*2-2; j++) {
                    System.out.print(" ");
                }
            }
            
            System.out.println();
            nBlanks = nBlanks/2;
            
            while(localStack.isEmpty()==false)
                globalStack.push( localStack.pop() ); 
            }
        System.out.println( "......................................................");
 
 }

}
