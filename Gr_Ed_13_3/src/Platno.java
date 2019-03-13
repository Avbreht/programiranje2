import java.awt.*;
import javax.swing.*; 

@SuppressWarnings("serial")
public class Platno extends JPanel {

	
	int sirina, visina; 
	Graf graf; 
	
	Color barvaPovezave;
	Color barvaTocke;
	Color barvaRoba; 
	Color barvaOzadja; 
	double polmer; 
	float debelinaPovezave; 
	float debelinaRoba; 
		
	public Platno(int sirina, int visina) {
		this.sirina = sirina; 
		this.visina = visina; 
		graf = null; 
		barvaPovezave = Color.BLUE; 
		barvaTocke = Color.RED; 
		barvaRoba = Color.BLACK; 
		barvaOzadja = Color.WHITE; 
		polmer = 20; 
		debelinaPovezave = 2.5f; 
		debelinaRoba = 1; 
		
	}
	
	// Takes the graph and writes it in components: 
	public void narisi(Graf g) {
		graf = g;
		repaint(); 
	}
	
	@Override 
	public Dimension getPreferredSize() {
		return new Dimension(sirina, visina); 
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g); 
		setBackground(barvaOzadja);
		if (graf == null) return; 
		Graphics2D g2 = (Graphics2D)g;
		g.setColor(barvaPovezave);
		g2.setStroke(new BasicStroke(debelinaPovezave));
		for (Tocka v : graf.tocke.values()) {
			for (Tocka u : v.sosedi) {
				if (v.ime.compareTo(u.ime) > 0) {
				g.drawLine(round(v.x), round(v.y), round(u.x), round(u.y));
				
				}
			}
		}
		
		int premer = round(2 * polmer); 
		g2.setStroke(new BasicStroke(debelinaRoba));
		for (Tocka v : graf.tocke.values()) {
			g.setColor(barvaTocke);
			g.fillOval(round(v.x - polmer), round(v.y - polmer), premer, premer);
			g.setColor(barvaRoba);
			g.drawOval(round(v.x - polmer), round(v.y - polmer), premer, premer);
		}
	}
	
	private static int round(double x) {
		return (int)(x + 0.5); 
	}	
}











