
public class Razcep {

	public static void main(String[] args) {
		razcep(1024);
		razcep(1534);
		razcep(18800);
		razcep(64);

	}

	public static void razcep(int n) {
		// op is the name of the operation '=' is its value 
		char op = '=';
		System.out.print(n);
		for (int d = 2; d * d <= n; ++d) {
			int e = 0;
			while (n % d == 0) {
				n /= d; 
				++e;
			}
			if (e > 0) {
				System.out.print(" " + op + " " + d);
				if (e > 1) System.out.print("^" + e);
				op = '*'; 
			}
		}
		if (n > 1) System.out.print(" " + op + " " + n);
		System.out.println(); 
	}
	
	
	
	
	
	
	
}
