
public class PoudarjanjeZnakov {

	public static void main(String[] args) {
		
		System.out.println(poudari("Zadnja novica danes!")); 
		System.out.println(delnoPoudari("Najpomembnejsa *novica* do *dan* danes!")); 

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
	
	public static String delnoPoudari(String niz) {
		int stevec = 0; 
		String s = ""; 
		for (int i = 0; i < niz.length(); ++i) {
			char znak = niz.charAt(i); 
			if (znak == '*') {
				stevec += 1;
				continue; 
			}
			if (stevec % 2 == 0) s += znak;
			else s += Character.toUpperCase(znak); 
		}
		return s; 
	}
}
