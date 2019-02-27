package prog2_ex2;

public class Zacni_z_1 {
	// correct the name for this
	public static void main(String[] args) {
		String[] t = zaporedje(20);
		for (int i = 0; i < t.length; ++i) System.out.println(t[i]); 

	}

	public static String[] zaporedje(int n) {
		String[] zap = new String[n];
		zap[0] = "1";
		for (int i = 1; i < n; ++i) {
			String p = zap[i - 1]; 
			String t = "";
			int j = 0; 
			while (j < p.length()) {
				int k = j;
				while (k < p.length() && p.charAt(k) == p.charAt(j)) ++k; 
				t += "" + (k - j) + p.charAt(j);   
				// the emptz string makes java turn the number into a string, 
				// without it it would turn the string into ascii and add it to the number
				j = k; 
			}
			zap[i] = t; 
		}
		return zap; 
		// see why the time complexity is linear
	}
		
}
