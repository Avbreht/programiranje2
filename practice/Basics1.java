
public class Basics1 {

	public static void main(String[] args) {
		
		razcep(1024); 
		razcep(1534); 
		razcep(8645); 
		razcep(10008); 
	}
	
	/* razcep prints out the factorization
	 * the prints don't require anything to be returned 
	   that is why we use void in the definition */
	
	public static void razcep(int n){
		
		// giving op the value: =
		
		char op = '='; 
		
		/* ++i increments i and returns the incremented value
		   i++ increments i and returns the value before incrementing */
		
		System.out.print(n);
		
		for (int d = 2; d * d <= n; ++d) {
			int e = 0;
			while (n % d == 0) {
				n = n / d;  // or: n /= d; 
				++e; 
			}
		
			// After getting a result for one prime we print it's power:
			
			if (e > 0) {
				System.out.print(" " + op + " " + d);
				if (e > 1) System.out.print("^" + e);
				op = '*';
			}
		}
		
		// If n is not 1 we print the continuation of the prime factorization:
		
		if (n > 1) System.out.print(" " + op + " " + n);
		System.out.println(); 
	}

}
