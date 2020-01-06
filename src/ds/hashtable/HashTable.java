package ds.hashtable;

public class HashTable {

	String[] hashArray;
	int arraySize;
	// counter for the number of elements in a hash table
	int size = 0;
	
	public HashTable(int noOfSlots) {
		
		if(isPrime(noOfSlots)) {
			hashArray = new String[noOfSlots];
			arraySize = noOfSlots;
		} else {
			int primeCount = getNextPrime(noOfSlots);
			hashArray = new String[primeCount];
			arraySize = primeCount;
			System.out.println("Hash table size given " + noOfSlots + " is not a prime number");
			System.out.println("Hash table size changed to " + primeCount);
		}
	}
		
		
	private boolean isPrime(int num) {
			
		for(int i=2; i*i <= num; i++) {
			if(num % i == 0) {
				return false;
			}
		}
			
		return true;
	}
	
	private int getNextPrime(int minNumber) {
		
		// starting with the original number
		// continue until a prime number is found
		for(int i=minNumber; true; i++) {
			if(isPrime(i)) {
				return i;
			}
		}
		
	}
	
	// returns preferred index position 
	private int hashFunc1(String word) {
		
		int hashVal = word.hashCode();
		hashVal = hashVal % arraySize;
		
		// if negative hashcode returned
		// add the array size to make it positive
		if(hashVal < 0)
			hashVal += arraySize;
		
		// index position to insert or search in
		return hashVal;
	}
		
	// return step size greater than 0
	private int hashFunc2(String word) {
		
		int hashVal = word.hashCode();
		//hashVal %= arraySize;
		hashVal = hashVal % arraySize;
		
		if(hashVal < 0) {
			hashVal += arraySize;
		}
		
		// get step size
		// use a prime number less than array size
		// MUST USE A PRIME NUMBER
		// MUST BE SMALLER THAN ARRAY SIZE 
		return 3 - hashVal % 3;
	}
	
	public void insert(String word) {
		
		int hashVal = hashFunc1(word);
		int stepSize = hashFunc2(word);
		
		// increase the hashVal by the stepSize 
		// and mod by arraySize 
		// (get the remainder of arraySize divided by the hashVal)
		// until you find an empty array slot
		while(hashArray[hashVal] != null) {
			hashVal += stepSize;
			hashVal %= arraySize;
		}
		
		hashArray[hashVal] = word;
		System.out.println("inserted word: "+word);
		size++;
		
	}
	
	public String find(String word) {
		
		int hashVal = hashFunc1(word);
		int stepSize = hashFunc2(word);
		
		
		while(hashArray[hashVal] != null) {

			// if required word found 
			if(hashArray[hashVal].equals(word)) {
				return hashArray[hashVal];
			}
			
			// increment by step size
			hashVal += stepSize;
			hashVal %= arraySize;
			
		}
		
		return hashArray[hashVal];
		
	}
	
	public void displayTable() {
		System.out.print("Table: ");
		for(int i = 0; i< arraySize; i++) {
			if(hashArray[i] != null) {
				System.out.print(hashArray[i]+ " ");
			} else {
				System.out.print("** ");
			}
		}
		
		System.out.println("");
	}
}
