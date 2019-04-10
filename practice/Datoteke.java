
public class Datoteke {

	public static void main(String[] args) {
		int[] testArray = {1, 2, 3, 4, 5, 6, 7}; 
		izpis1(testArray); 
		izpis2(testArray); 
		counterTest1();
		counterTest2(); 
		
		String string1 = "0123456789"; 
		i_thCharacter(5, string1); 
		
	}
	
	// Doodling around with arrays:
	
	public static void izpis1 (int[] arr) {
			System.out.print(arr[0]);
			for (int i = 1; i < arr.length; ++i) {
				System.out.print(" " + arr[i]);
			}
			System.out.println();
	}
	
	public static void izpis2(int[] arr) {
		System.out.print(arr[0]);
		for (int i = 1; i < arr.length; i++) {
			System.out.print(" " + arr[i]);
		}
		System.out.println(); 
	}
	
	public static void counterTest1 () {
		for (int i = 1; i <= 10; i++) {
			
			if (i == 1) System.out.print(i);
			else System.out.print(" " + i); 
		}
		System.out.println(); 
	}
	
	public static void counterTest2() {
		for (int i = 1; i <= 10; ++i) {
			if (i == 1) System.out.print(i);
			else System.out.print(" " + i); 
		}
		System.out.println(); 
	}
	
	// Getting a little serious: 
	
	public static void i_thCharacter (int n, String s){
		if (n <= s.length()) System.out.print(s.charAt(n)); 
		else System.exit(0); 
		
	}
	
	
	
	
	
	
	
	
	
}

