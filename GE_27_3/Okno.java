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
	
	public Okno() {
		super() ; 
		setTitle("Urejevalnik grafov"); 
		platno = new Platno(600, 600);
		add(platno); 
		
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
			
		}
		
		else if (source == menuPrazen) {
			
		}
		
		else if (source == menuCikel) {
			
		}
		
		else if (source == menuPoln) {
			
		}
		
		else if (source == menuPolnDvodelen) {
			
		}
		
		else if (source == menuBarvaPovezave) {
			
		}
		
		else if (source == menuBarvaTocke) {
			
		}
		
		else if (source == menuBarvaAktivneTocke) {
			
		}
		
		else if (source == menuBarvaIzbraneTocke) {
			
		}
		
		else if (source == menuBarvaRoba) {
			
		}
		
		else if (source == menuDebelinaPovezave) {
			
		}
		
		else if (source == menuDebelinaRoba) {
			
		}
		
		else if (source == menuPolmer) {
	
		}
	}
	
}

