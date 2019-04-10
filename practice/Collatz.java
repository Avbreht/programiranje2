
public class Collatz {

	public static void main(String[] args) {
		
		System.out.println("Dolzino C(" + 6 + ") je " + dolzina(6)); 
		System.out.println("Najvecji clen zaporedja C(" + 6 + ") je " + najvecji(6)); 
		izpisZaporedja(6) ; 
			
	}
	
	public static int dolzina (int n) {
		int i = 1;
		while (n > 1) {
			if (n % 2 == 0) n /= 2; 
			else n = (n * 3) + 1; 
			++i; 
		}
		return i; 
	}
	
	public static int najvecji(int n) {
		int najvecji = n;
		while (n > 1) { 
			if (n % 2 == 0) n /= 2; 
			else n = (3 * n) + 1; 
			if (najvecji < n) najvecji = n; 
		}
		return najvecji; 
	}
	
	public static void izpisZaporedja(int n) {
		System.out.print("Collatzovo zaporedje z zacetnim clenom " + n + ": " + n);
		while (n > 1) {
			if (n % 2 == 0) n /= 2; 
			else n = (n * 3) + 1;
			System.out.print(" " + n);
		}
	}
}
