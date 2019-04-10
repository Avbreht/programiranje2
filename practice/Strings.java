
public class Strings {

	public static void main(String[] args) {
		String z = "00110010011101101010101011110000"; 
		//String s = z.substring(0, 8);
		//String w = z.substring(8, 16); 
		//System.out.println(s);
		//System.out.print(w);
		
		int[] test = dvojisko(z);
		String[] controltest = control(z); 
		izpis(controltest);
		izpis(test); 
	}

	public static void izpis(String[] p) {
		System.out.print("{");
		for (int i = 0; i < p.length - 1; ++i) System.out.print(p[i] + ", "); 
		System.out.print(p[p.length - 1]);
		System.out.print("}");
		System.out.println(); }
	
	public static void izpis(int[] p) {
		System.out.print("{");
		for (int i = 0; i < p.length - 1; ++i) System.out.print(p[i] + ", "); 
		System.out.print(p[p.length - 1]);
		System.out.print("}");
		System.out.println(); }
		
	public static String[] control(String niz) {
		int n = 0;
		int counter = 0;
		String[] tabela = new String[(niz.length())/8]; 
		while (niz.length() >= n + 8) {
			String s = niz.substring(n, n+8);
			tabela[counter] = s;
			n += 8;
			counter++ ; 
		}
		return tabela;
	}
	
	public static int[] dvojisko(String niz) {
		int n = 0;
		int counter = 0;
		int[] tabela = new int[(niz.length())/8]; 
		String resultstring = "";
		while (niz.length() >= n + 8) {
			String s = niz.substring(n, n+8);
			n += 8;
			int i = Integer.parseInt(s, 2);
			resultstring.concat(" " + i);
			tabela[counter] = i;
			counter++ ; 
		}
		return tabela; 
	}
}
