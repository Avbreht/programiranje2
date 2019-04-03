import java.awt.*;
import javax.swing.*; 
import java.awt.event.*;
import java.util.*;

 
@SuppressWarnings("serial")
public class Platno extends JPanel implements MouseListener, MouseMotionListener, KeyListener{

	
	int sirina, visina; 
	Graf graf; 
	Tocka aktivnaTocka; 
	Set<Tocka> izbraneTocke; 
	
	Color barvaPovezave;
	Color barvaTocke;
	Color barvaRoba; 
	Color barvaOzadja; 
	Color barvaAktivneTocke; 
	Color barvaIzbraneTocke; 
	double polmer; 
	float debelinaPovezave; 
	float debelinaRoba; 
	private int klikX, klikY; 
	private int premikX, premikY; 
	
	public Platno(int sirina, int visina) {
		this.sirina = sirina; 
		this.visina = visina; 
		graf = null; 
		aktivnaTocka = null; 
		izbraneTocke = new HashSet<Tocka>(); 
		
		barvaPovezave = Color.BLUE; 
		barvaTocke = Color.RED; 
		barvaRoba = Color.BLACK; 
		barvaOzadja = Color.WHITE; 
		barvaAktivneTocke = Color.MAGENTA; 
		barvaIzbraneTocke = Color.YELLOW; 
		polmer = 20; 
		debelinaPovezave = 2.5f; 
		debelinaRoba = 1; 
		
		
		
		addMouseListener(this); 
		addMouseMotionListener(this); 
		addKeyListener(this); 
		setFocusable(true); 
	}
	
	
	// Takes the graph and writes it in components: 
	public void narisi(Graf g) {
		graf = g;
		aktivnaTocka = null; 
		izbraneTocke.clear(); 
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
			if (v == aktivnaTocka) g.setColor(barvaAktivneTocke);
			else if (izbraneTocke.contains(v)) g.setColor(barvaIzbraneTocke);
			else g.setColor(barvaTocke);
			g.fillOval(round(v.x - polmer), round(v.y - polmer), premer, premer);
			g.setColor(barvaRoba);
			g.drawOval(round(v.x - polmer), round(v.y - polmer), premer, premer);
			
		}	
	}
	
	private static int round(double x) {
		return (int)(x + 0.5); 
	}

	@Override
	public void mousePressed(MouseEvent e) { 
		if (graf == null) return; 
		klikX = premikX = e.getX(); 
		klikY = premikY = e.getY(); 
		Tocka najblizja = null; 
		double razdalja = Double.POSITIVE_INFINITY; 
		for (Tocka v : graf.tocke.values()) {
			double r = Math.sqrt(Math.pow(klikX - v.x, 2) + Math.pow(klikY - v.y, 2)); 
			if (r < razdalja) {
				razdalja = r; 
				najblizja = v; 
			}
		}
		if (razdalja < polmer + 5) {
			aktivnaTocka = najblizja;  
			repaint(); 
		}
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		if (graf == null) return; 
		if (aktivnaTocka == null) {
			for (Tocka v : izbraneTocke) {
				v.x += e.getX() - premikX; 
				v.y += e.getY() - premikY; 				
			}
		}
		else {
			aktivnaTocka.x += e.getX() - premikX; 
			aktivnaTocka.y += e.getY() - premikY; 
			
		}
		premikX = e.getX(); 
		premikY = e.getY(); 
		repaint();	
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		 if (graf == null) return; 
		 
		 if (e.getX() == klikX && e.getY() == klikY) {
			 if (aktivnaTocka == null) {
				 Tocka v = graf.dodajTocko(); 
				 v.x = e.getX(); 
				 v.y = e.getY(); 
				 for (Tocka u : izbraneTocke) graf.dodajPovezavo(v, u);
			 }
			 else {
				 if (izbraneTocke.contains(aktivnaTocka)) izbraneTocke.remove(aktivnaTocka);
				 else izbraneTocke.add(aktivnaTocka); 
			 }
		 }
		 aktivnaTocka = null; 
		 repaint(); 
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		if (graf == null) return ; 
		char tipka = e.getKeyChar(); 
		if (tipka == 'a') {
			izbraneTocke.addAll(graf.tocke.values()); 
		}
		else if (tipka == 's') {
			izbraneTocke.clear();
		}
		else if (tipka == 't') {
			for (Tocka v : izbraneTocke) graf.odstraniTocko(v); 
			izbraneTocke.clear(); 
		}
		else if (tipka == 'p') {
			for (Tocka v : izbraneTocke) {
				for (Tocka u : izbraneTocke) { 
					graf.odstraniPovezavo(v, u);
				}
			}
		}
		else if (tipka == 'z') {
			for (Tocka v : izbraneTocke) {
				for (Tocka u : izbraneTocke) { 
					graf.dodajPovezavo(v, u);
				}
			}
		}
		repaint(); 
	} 

	//------------------------------------------------

	@Override
	public void mouseClicked(MouseEvent e) {}
	
	@Override
	public void mouseMoved(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}
	@Override
	public void keyReleased(KeyEvent e) {}

	@Override
	public void keyTyped(KeyEvent e) {}

	
	//-------------------------------------------------------
}











