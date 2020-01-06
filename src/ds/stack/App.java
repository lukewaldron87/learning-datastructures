package ds.stack;

public class App {

	public static void main(String[] args) {

//		Stack theStack = new Stack(10);
//		theStack.push(20);
//		theStack.push(40);
//		theStack.push(60);
//		theStack.push(80);
//		theStack.push(90);
//		theStack.push(70);
//		theStack.push(50);
//		theStack.push(30);
//		theStack.push(10);
//		theStack.push(0);
//		theStack.push(1);
//		
//		while(!theStack.isEmpty()) {
//			long value = theStack.pop();
//			System.out.println(value);
//		}
		
		
		System.out.println(reverstString("hello"));
	}
	
	public static String reverstString(String str) {

		Stack theStack = new Stack(str.length());
		String newString = "";
		
		for(int i=0; i<str.length(); i++) {
			theStack.push(str.charAt(i));
		}
		
		while(!theStack.isEmpty()) {
			newString += theStack.pop();
		}
		
		return newString;
	}

}

