
public class Test {

	public static void main(String[] args) {
		Graf graf = Graf.cikel(5); 
		graf.izpis(); 
		
		Graf g = new Graf(); 
		Tocka a = g.dodajTocko("a"); 
		Tocka b = g.dodajTocko("b");
		Tocka c = g.dodajTocko("c");
		Tocka d = g.dodajTocko("d");
		Tocka e = g.dodajTocko("e");
		Tocka f = g.dodajTocko("f");
		g.dodajPovezavo(a, b);
		g.dodajPovezavo(b, c);
		g.dodajPovezavo(c, d);
		g.dodajPovezavo(e, f);
		g.izpis(); 

	}

}
