package menjacnica.gui.kontroler;

import java.awt.EventQueue;
import java.io.File;
import java.util.LinkedList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import baza.Valuta;
import menjacnica.gui.MenjacnicaGUI;

public class GUIKontroler {

	private static MenjacnicaGUI menjacnica;	
	private static String tekstZaEditor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
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

	

}
