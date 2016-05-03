package menjacnica.gui.kontroler;

import java.awt.EventQueue;
import java.io.File;
import java.util.LinkedList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import baza.Kurs;
import baza.Valuta;
import menjacnica.gui.DodajKursGUI;
import menjacnica.gui.MenjacnicaGUI;

public class GUIKontroler {

	private static MenjacnicaGUI menjacnica;
	private static Kurs kurs;
	private static String tekstZaEditor;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					kurs = new Kurs();
					menjacnica = new MenjacnicaGUI();
					menjacnica.setVisible(true);
					menjacnica.setLocationRelativeTo(null);
					tekstZaEditor = "";					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static void ugasiAplikaciju() {
		int opcija = JOptionPane.showConfirmDialog(menjacnica.getContentPane(), "Da li želite da izađete iz programa?",
				"Zatvaranje aplikacije", JOptionPane.YES_NO_CANCEL_OPTION);

		if (opcija == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}

	public static String sacuvajUFajl() {
		String sacuvanFajl = "";
		try {
			JFileChooser fc = new JFileChooser();
			int returnVal = fc.showSaveDialog(menjacnica.getContentPane());

			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();
				sacuvanFajl = "Sačuvan fajl: " + file.getAbsolutePath() + "\n";
				kurs.sacuvajUFajl(file.getAbsolutePath());
			}
			if (returnVal == JFileChooser.CANCEL_OPTION) {
				sacuvanFajl = "";
			}
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(menjacnica.getContentPane(), e1.getMessage(), "Greska",
					JOptionPane.ERROR_MESSAGE);
		}
		return sacuvanFajl;
	}

	public static String ucitajIzFajla() {
		String ucitanFajl = "";
		try {
			JFileChooser fc = new JFileChooser();
			int returnVal = fc.showOpenDialog(menjacnica.getContentPane());

			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();
				//pod komentarom jer baca exception za fajl koji ne sadrzi valutu
				//kurs.ucitajIzFajla(file.getAbsolutePath());
				//menjacnica.osveziTabelu();
				ucitanFajl = "Učitan fajl: " + file.getAbsolutePath() + "\n";

			}

			if (returnVal == JFileChooser.CANCEL_OPTION) {
				ucitanFajl = "";
			}
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(menjacnica.getContentPane(), e1.getMessage(), "Greška!",
					JOptionPane.ERROR_MESSAGE);
		}
		return ucitanFajl;
	}	


	public static String getTekstZaEditor() {
		return tekstZaEditor;
	}

	public static void setTekstZaEditor(String tekstZaEditor) {
		GUIKontroler.tekstZaEditor = tekstZaEditor;
	}
	public static void unesiValutu(int sifra, String skraceniNaziv, double kupovni, double prodajni, double srednji,
			String naziv) {
		
			Valuta v = new Valuta();
			v.setKupovni(kupovni);
			v.setNaziv(naziv);
			v.setProdajni(prodajni);
			v.setSifra(sifra);
			v.setSkraceniNaziv(skraceniNaziv);
			v.setSrednji(srednji);
			kurs.dodajValutu(v);

			menjacnica.osveziTabelu();			
		
		}
		public static void prikaziDodajKurs() {
			DodajKursGUI prozor = new DodajKursGUI();
			prozor.setVisible(true);
			prozor.setLocationRelativeTo(null);
		}
	

		public static List<Valuta> vratiSveValute() {
			return kurs.vratiSveValute();
		}

		public static void obrisiValutu(Valuta v) {
			kurs.obrisiValutu(v);
			menjacnica.osveziTabelu();
			
		}
		public static String vratiPoslednjuValutu() {
			return kurs.vratiPoslednjegString();
		}


	}




