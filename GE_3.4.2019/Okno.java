import java.awt.*;
import java.awt.event.*;
import javax.swing.*; 


@SuppressWarnings("serial") 
public class Okno extends JFrame implements ActionListener {

	
	Platno platno; 
	private JMenuItem menuOdpri, menuShrani, menuKoncaj; 
	private JMenuItem menuPrazen, menuCikel, menuPoln, menuPolnDvodelen; 
	private JMenuItem menuBarvaPovezave, menuBarvaTocke, menuBarvaAktivneTocke;
	private JMenuItem menuBarvaIzbraneTocke;
	private JMenuItem menuBarvaRoba, menuDebelinaPovezave, menuDebelinaRoba, menuPolmer; 
	private JMenuItem menuNastavi; 
	
	Nastavitve nastavitve;
	
	public Okno() {
		super() ; 
		setTitle("Urejevalnik grafov"); 
		platno = new Platno(600, 600);
		add(platno); 
		
		 nastavitve = new Nastavitve(this); 
		
		JMenuBar menubar = new JMenuBar();
		
		JMenu menuDatoteka = new JMenu("Datoteka"); 
		JMenu menuGraf = new JMenu("Graf"); 
		JMenu menuNastavitve = new JMenu("Nastavitve"); 
	
		menuOdpri = new JMenuItem("Odpri"); 
		menuShrani = new JMenuItem("Shrani");
		menuKoncaj = new JMenuItem("Koncaj"); 
		menuPrazen = new JMenuItem("Prazen"); 
		menuCikel = new JMenuItem("Cikel"); 
		menuPoln = new JMenuItem("Poln"); 
		menuPolnDvodelen = new JMenuItem("Poln dvodelen"); 
		menuBarvaPovezave = new JMenuItem("Barva povezave"); 
		menuBarvaTocke = new JMenuItem("Barva tocke"); 
		menuBarvaAktivneTocke = new JMenuItem("Barva Aktivne tocke"); 
		menuBarvaIzbraneTocke = new JMenuItem("Barva izbrane tocke"); 
		menuBarvaRoba = new JMenuItem("Barva roba");
		menuDebelinaPovezave = new JMenuItem("Debelina povezave"); 
		menuDebelinaRoba = new JMenuItem("Debelina roba"); 
		menuPolmer = new JMenuItem("Polmer tocke"); 
		menuNastavi = new JMenuItem("Nastavitve"); 
		
		menuDatoteka.add(menuOdpri); 
		menuDatoteka.add(menuShrani); 
		menuDatoteka.addSeparator();
		menuDatoteka.add(menuKoncaj); 
		menuGraf.add(menuPrazen);
		menuGraf.add(menuCikel);
		menuGraf.add(menuPoln);
		menuGraf.add(menuPolnDvodelen);
		menuNastavitve.add(menuBarvaPovezave); 
		menuNastavitve.add(menuBarvaTocke); 
		menuNastavitve.add(menuBarvaAktivneTocke); 
		menuNastavitve.add(menuBarvaIzbraneTocke); 
		menuNastavitve.add(menuBarvaRoba); 
		menuNastavitve.addSeparator();
		menuNastavitve.add(menuDebelinaPovezave); 
		menuNastavitve.add(menuDebelinaRoba);  
		menuNastavitve.addSeparator();
		menuNastavitve.add(menuPolmer);
		menuNastavitve.add(menuNastavi);
		
		menubar.add(menuDatoteka); 
		menubar.add(menuGraf); 
		menubar.add(menuNastavitve);
		
		setJMenuBar(menubar); 
		
		menuOdpri.addActionListener(this); 
		menuShrani.addActionListener(this); 
		menuKoncaj.addActionListener(this); 
		menuPrazen.addActionListener(this); 
		menuCikel.addActionListener(this); 
		menuPoln.addActionListener(this); 
		menuPolnDvodelen.addActionListener(this); 
		menuBarvaTocke.addActionListener(this); 
		menuBarvaAktivneTocke.addActionListener(this); 
		menuBarvaIzbraneTocke.addActionListener(this);
		menuBarvaRoba.addActionListener(this); 
		menuDebelinaPovezave.addActionListener(this); 
		menuDebelinaRoba.addActionListener(this); 
		menuPolmer.addActionListener(this); 
		menuNastavi.addActionListener(this); 
	
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource(); 
		if (source == menuOdpri) {
			JFileChooser chooser = new JFileChooser();
			int gumb = chooser.showOpenDialog(this); 
			if (gumb == JFileChooser.APPROVE_OPTION) {
				String ime = chooser.getSelectedFile().getPath();
				Graf graf = Graf.preberi(ime); // if the method is not static then 
											   // we can't call it in another class
				platno.narisi(graf);
			}
		}
		
		else if (source == menuShrani) {
			JFileChooser chooser = new JFileChooser();
			int gumb = chooser.showSaveDialog(this); 
			if (gumb == JFileChooser.APPROVE_OPTION) {
				String ime = chooser.getSelectedFile().getPath();
				platno.graf.shrani(ime);				
			}
		}
		
		else if (source == menuKoncaj) {
			dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING)); 
		}
		
		else if (source == menuPrazen) {
			String niz = JOptionPane.showInputDialog(this, "Število Toèk:");
			if (niz != null && niz.matches("\\d+")) {
				Graf g = Graf.prazen(Integer.parseInt(niz)); // capital letter because it's a static method
				g.razporedi(300, 300, 250);
				platno.narisi(g);
			}
			
		}
		
		else if (source == menuCikel) {
			String niz = JOptionPane.showInputDialog(this, "Število Toèk:");
			if (niz != null && niz.matches("\\d+")) {
				Graf g = Graf.cikel(Integer.parseInt(niz)); 
				g.razporedi(300, 300, 250);
				platno.narisi(g);
			}
		}
		
		else if (source == menuPoln) {
			String niz = JOptionPane.showInputDialog(this, "Število Toèk:");
			if (niz != null && niz.matches("\\d+")) {
				Graf g = Graf.poln(Integer.parseInt(niz));
				g.razporedi(300, 300, 250);
				platno.narisi(g);
			}
		}
		
		else if (source == menuPolnDvodelen) {
			JTextField prva = new JTextField(); 
			JTextField druga = new JTextField();
			JComponent[] polja = {
					new JLabel("Velikost prve  množice:"), prva, 
					new JLabel("Velikost druge množice:"), druga
			}; 
			int rez = JOptionPane.showConfirmDialog(this, polja, "Input", JOptionPane.OK_CANCEL_OPTION); 
			if (rez == JOptionPane.OK_OPTION && prva.getText().matches("\\d+") && druga.getText().matches("\\d+")) {
				int n = Integer.parseInt(prva.getText());
				int m = Integer.parseInt(druga.getText());
				Graf g = Graf.polnDvodelen(n, m); 
				g.razporedi(300, 300, 250);
				platno.narisi(g);
			}
		}
		
		else if (source == menuBarvaPovezave) {
			Color barva = 
			JColorChooser.showDialog(this, "Barva Povezave", platno.barvaPovezave);
			if (barva != null) {
				platno.barvaPovezave = barva; 
				platno.repaint();
			}
			
		}
		
		else if (source == menuBarvaTocke) {
			Color barva = 
			JColorChooser.showDialog(this, "Barva Toèke", platno.barvaTocke);
			if (barva != null) {
				platno.barvaTocke = barva; 
				platno.repaint();
				}
		}
		
		else if (source == menuBarvaAktivneTocke) {
			Color barva = 
			JColorChooser.showDialog(this, "Barva Aktivne Toèke", platno.barvaAktivneTocke);
			if (barva != null) {
				platno.barvaAktivneTocke = barva; 
				platno.repaint();
			}
		}
		
		else if (source == menuBarvaIzbraneTocke) {
			Color barva = 
			JColorChooser.showDialog(this, "Barva Izbrane Toèke", platno.barvaIzbraneTocke);
			if (barva != null) {
				platno.barvaIzbraneTocke = barva; 
				platno.repaint();
			}
			
		}
		
		else if (source == menuBarvaRoba) {
			Color barva = 
			JColorChooser.showDialog(this, "Barva Roba", platno.barvaRoba);
			if (barva != null) {
				platno.barvaRoba = barva; 
				platno.repaint();
			}
			
		}
		
		else if (source == menuDebelinaPovezave) {
			String niz = JOptionPane.showInputDialog(this, "Debelina Povezave:", platno.debelinaPovezave);
			if (niz != null && niz.matches("\\d*\\.?\\d+")) {
				platno.debelinaPovezave = Float.parseFloat(niz); 
				platno.repaint();
			}
		}
		
		else if (source == menuDebelinaRoba) {
			String niz = JOptionPane.showInputDialog(this, "Debelina Roba:", platno.debelinaRoba);
			if (niz != null && niz.matches("\\d*\\.?\\d+")) {
				platno.debelinaRoba = Float.parseFloat(niz); 
				platno.repaint();
			}
		}
		
		else if (source == menuPolmer) {
			String niz = JOptionPane.showInputDialog(this, "Polmer Toèke", platno.polmer);
			if (niz != null && niz.matches("\\d*\\.?\\d+")) {
				platno.polmer = Double.parseDouble(niz); 
				platno.repaint();
			}
		}
		
		else if (source == menuNastavi) {
			nastavitve.setVisible(true); // odpremo  novo dialogno okno za nastavitve
		}
	}
	
}

