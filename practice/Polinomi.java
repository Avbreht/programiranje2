
public class Polinomi {

	public static void main(String[] args) {
		
		int[] p1 = {1, 2, 3}; 
		int[] p2 = {4, -1, 2, 0, 1};
		int[] p3 = {1}; 
		int[] op1 = prviOdvod(p1); 
		int[] op2 = prviOdvod(p2); 
		int[] op3 = prviOdvod(p3); 
		izpis(p1); 
		izpis(op1);
		izpis(p3); 
		izpis(op3); 
		izpis(p2); 
		izpis(op2); 
		

	}

	public static int[] prviOdvod(int[] p) {
		if (p.length <= 1) return new  int[0];
		int[] op = new int[p.length - 1]; 
		for (int i = 0; i < op.length; ++i) {
			op[i] = (i + 1) *  p[i + 1]; 
		}
		return op; 
	}
	
	public static double[] odvod(double[] p, int n) {
		if (n > p.length) return new double[0];
		
		double[] op = new double[p.length - n];
		
		// factorial  
		int f = 1; 
		for (int i = 2; i <= n; ++i) f *= i;
		
		for (int i = n; i < p.length; ++i) {
			op[i - n] = f * p[i];
			// correcting the factor
			f /= i - n + 1;
			f *= i + 1;
		}
		return op;
	}
	
	public static void izpis(int[] p) {
		for (int i = 0; i < p.length; ++i) System.out.print(p[i] + " "); 
		System.out.println();
	}
	
}
