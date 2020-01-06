package ds.binarysearchtree;

public class Application {

	public static void main(String[] args) {
		
		BST tree = new BST();
		tree.insert(10, "ten");
		tree.insert(20, "twehty");
		tree.insert(15, "fifteen");
		tree.insert(4, "four");
		tree.insert(8, "eight");
		tree.insert(16, "sixteen");
		tree.insert(24, "twenty four");
		
		System.out.println(tree.findMin().key);
		System.out.println(tree.findMax().key);
		
		/*System.out.println(tree.remove(10));
		
		System.out.println(tree.findMin().key);
		System.out.println(tree.findMax().key);*/
		
		System.out.println("Tree:");

		tree.displayTree();
		
		tree.displayTreeFromVideo();
	}
}
