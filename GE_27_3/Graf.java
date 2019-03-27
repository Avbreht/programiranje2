import java.io.*;
import java.io.PrintWriter;
import java.util.*; 


public class Graf {

	int stevec; 
	Map<String, Tocka> tocke; 
	
	public Graf() {
		stevec = 0; 
		tocke = new HashMap<String, Tocka>(); 
	}
	
	public Tocka tocka(String ime) { 
		return tocke.get(ime); 
	}
	
	public boolean povezava(Tocka v, Tocka u) {
		return v.sosedi.contains(u); 
	}
	
	public Tocka dodajTocko(String ime) { 
		Tocka v = tocka(ime); 
		if (v == null) {
			v = new Tocka(ime); 
			tocke.put(ime, v); 
		}
		return v; 
	}
	
	public Tocka dodajTocko() { 
		while (true) {
			String ime = Integer.toString(++stevec); 
			if (tocka(ime) != null) continue; 
			Tocka v = new Tocka(ime); 
			tocke.put(ime, v);
			return v;
		}
	}
	
	public void dodajPovezavo(Tocka v, Tocka u) {
		if (v == u) return; 
		v.sosedi.add(u); 
		u.sosedi.add(v); 
	}
	
	public void odstraniPovezavo(Tocka v, Tocka u) { 
		v.sosedi.remove(u); 
		u.sosedi.remove(v); 
	}
	
	public void odstraniTocko(Tocka v) {
		for (Tocka u : v.sosedi) u.sosedi.remove(v); 
		tocke.remove(v.ime); 
	}
	
	public Tocka[] dodajTocke(int n) {
		Tocka[] tab = new Tocka[n];
		for (int i = 0; i < n; ++i) tab[i] = dodajTocko();
		return tab;
	}
	
	public static Graf prazen(int n) {
		Graf graf = new Graf(); 
		graf.dodajTocke(n); 
		return graf; 
	}
		
	public static Graf cikel(int n) {
		Graf graf = new Graf(); 
		Tocka[] tab = graf.dodajTocke(n);
		for (int i = 0; i < n; ++i) graf.dodajPovezavo(tab[i], tab[(i + 1) % n]);
		return graf; 
	}
	
	public static Graf poln(int n) {
		Graf graf = new Graf(); 
		Tocka[] tab = graf.dodajTocke(n);
		for (int i = 0; i < n; ++i) {
			for (int j = i + 1; j < n; ++j) {
				graf.dodajPovezavo(tab[i], tab[j]);
			}
			
		}
		return graf; 
	}
	
	public static Graf polnDvodelen(int n, int m) {
		Graf graf = new Graf(); 
		Tocka[] tab1 = graf.dodajTocke(n);
		Tocka[] tab2 = graf.dodajTocke(m);
		for (int i = 0; i < n; ++i) {
			for (int j = i + 1; j < m; ++j) {
				graf.dodajPovezavo(tab1[i], tab2[j]);
			}
			
		}
		return graf; 
	}
	
	public void izpis() {
		for (Tocka v : tocke.values()) {
			System.out.print(v + ":");
			for (Tocka u : v.sosedi) System.out.print(" " + u);
			System.out.println();
		}
	}
	
	public void razporedi(double x, double y, double r) {
		int n = tocke.size();
		int i = 0;
		for (Tocka v : tocke.values()) {
			double kot = 2 * i * Math.PI / n;   
			v.x = x + r * Math.cos(kot); 
			v.y = y + r * Math.sin(kot); 
			++i; 
		}
	}
	
	public void shrani(String ime) {
		try {
			PrintWriter dat = new PrintWriter(new FileWriter(ime)); 
			for (Tocka v : tocke.values()) {
				dat.println(v + ": " + v.x + " " + v.y); 
			}
			dat.println("***"); 
			for (Tocka v : tocke.values()) {
				dat.print(v + ":");
				for (Tocka u : v.sosedi) dat.print(" " + u);
			}
			dat.close(); 
		}
		catch (IOException e) {
			e.printStackTrace(); 
		}
	}
	
	public static Graf preberi(String ime) {
		try {
			Graf graf = new Graf(); 
			BufferedReader dat = new BufferedReader(new FileReader(ime)); 
			
			int blok = 1; 
			while (dat.ready()) {
				String vrstica = dat.readLine().trim(); 
				if (vrstica.equals("")) continue; 
				if (vrstica.equals("***")) blok = 2;
				else if (blok == 1) {
					String[] podatki = vrstica.split("[ :]+");
					Tocka v = graf.dodajTocko(podatki[0]); 
					v.x = Double.parseDouble(podatki[1]);
					v.y = Double.parseDouble(podatki[2]);
					
				}
				else if (blok == 2) {
					String [] podatki = vrstica.split("[ :]+"); 
					Tocka v = graf.tocka(podatki[0]); 
					if (v == null) v = graf.dodajTocko(podatki[0]); 
					for (int i = 1; i < podatki.length; ++i) {
						Tocka u = graf.tocka(podatki[i]); 
						if (u == null) u = graf.dodajTocko(podatki[i]); 
						graf.dodajPovezavo(v, u);
					}
				}
			}
			
			dat.close(); 
			return graf; 
		}
		catch (IOException e) {
			e.printStackTrace(); 
			return null; 
		}
	}
	
}




















