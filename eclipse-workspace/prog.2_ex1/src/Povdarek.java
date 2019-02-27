
public class Povdarek {

	public static void main(String[] args) {
		System.out.println(poudari("Zadnja novica"));
		System.out.println(delno_poudari("Zadnja *novica* danes!"));
		
	}
	
	public static String poudari(String niz) {
		String s = ""; 
		for (int i = 0; i < niz.length(); ++i) {
			char znak = niz.charAt(i); 
			if (i > 0) s += ' ';
			s += Character.toUpperCase(znak); 					
		}
		return s;
	}
	
	public static String delno_poudari(String niz) {
		boolean krepko = false;  
		String s = ""; 
		for (int i = 0; i < niz.length(); ++i) {
			char znak = niz.charAt(i); 
			if (znak == '*') krepko = !krepko; 
			else if (krepko) s+= Character.toUpperCase(znak); 
			else s += znak; 
			 
		}
		return s;
	}
	
	
	
	
	
}
