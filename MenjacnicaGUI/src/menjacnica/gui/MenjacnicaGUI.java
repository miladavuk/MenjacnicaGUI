package menjacnica.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.KeyStroke;
import javax.swing.border.EmptyBorder;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JEditorPane;
import javax.swing.border.TitledBorder;
import baza.Valuta;
import baza.ValutaTableModel;
import menjacnica.gui.kontroler.GUIKontroler;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.Font;

public class MenjacnicaGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JMenuBar menuBarMenjacnicaGUI;
	private JMenu mnFile;
	private JMenuItem mntmOpen;
	private JMenuItem mntmSave;
	private JMenuItem mntmExit;
	private JMenu mnHelp;
	private JMenuItem mntmAbout;
	private JScrollPane scrollPaneZaTabelu;
	private JTable table;
	private JPanel panelZaDugmice;
	private JButton btnDodajKurs;
	private JButton btnIzvrsiZamenu;
	private JPopupMenu popupMenu;
	private JButton btnIzbrisiKurs;
	private JMenuItem mntmDodajKurs;
	private JMenuItem mntmIzbrisiKurs;
	private JMenuItem mntmIzvrsiIzmenu;
	private JScrollPane scrollPaneZaEditor;
	private static JTextArea editorPane;
	

	/**
	 * Create the frame.
	 */
	public MenjacnicaGUI() throws IOException {
		setIconImage(Toolkit.getDefaultToolkit().getImage(MenjacnicaGUI.class.getResource("/ikonice/dol.png")));
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				GUIKontroler.ugasiAplikaciju();

			}
		});

		
		setTitle("Menja\u010Dnica");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 735, 364);
		setJMenuBar(getMenuBar_1());
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getScrollPaneZaTabelu(), BorderLayout.CENTER);
		contentPane.add(getPanelZaDugmice(), BorderLayout.EAST);		
		contentPane.add(getScrollPane_1(), BorderLayout.SOUTH);
		
	}

	private JMenuBar getMenuBar_1() {
		if (menuBarMenjacnicaGUI == null) {
			menuBarMenjacnicaGUI = new JMenuBar();
			menuBarMenjacnicaGUI.add(getMnFile());
			menuBarMenjacnicaGUI.add(getMnHelp());
		}
		return menuBarMenjacnicaGUI;
	}

	private JMenu getMnFile() {
		if (mnFile == null) {
			mnFile = new JMenu("File");
			mnFile.add(getMntmOpen());
			mnFile.add(getMntmSave());
			mnFile.add(getMntmExit());
		}
		return mnFile;
	}

	private JMenuItem getMntmOpen() {
		if (mntmOpen == null) {
			mntmOpen = new JMenuItem("Open");
			mntmOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK));
			mntmOpen.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dodajTekstUEditor(GUIKontroler.ucitajIzFajla());
				}
			});
			mntmOpen.setIcon(new ImageIcon(MenjacnicaGUI.class.getResource("/ikonice/folder.png")));
		}
		return mntmOpen;
	}

	private JMenuItem getMntmSave() {
		if (mntmSave == null) {
			mntmSave = new JMenuItem("Save");
			mntmSave.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {					
						dodajTekstUEditor(GUIKontroler.sacuvajUFajl());					
				}
			});
			mntmSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
			mntmSave.setIcon(
					new ImageIcon(MenjacnicaGUI.class.getResource("/ikonice/Floppy_Disk.png")));
		}
		return mntmSave;
	}

	private JMenuItem getMntmExit() {
		if (mntmExit == null) {
			mntmExit = new JMenuItem("Exit");
			mntmExit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					GUIKontroler.ugasiAplikaciju();
				}
			});
			mntmExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.ALT_MASK));
		}
		return mntmExit;
	}

	private JMenu getMnHelp() {
		if (mnHelp == null) {
			mnHelp = new JMenu("Help");
			mnHelp.add(getMntmAbout());
		}
		return mnHelp;
	}

	private JMenuItem getMntmAbout() {
		if (mntmAbout == null) {
			mntmAbout = new JMenuItem("About");
			mntmAbout.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					OAutoru oa = new OAutoru();
					oa.setVisible(true);
				}
			});
		}
		return mntmAbout;
	}

	private JScrollPane getScrollPaneZaTabelu() {
		if (scrollPaneZaTabelu == null) {
			scrollPaneZaTabelu = new JScrollPane();
			scrollPaneZaTabelu.setEnabled(false);
			addPopup(scrollPaneZaTabelu, getPopupMenu());
			scrollPaneZaTabelu.setViewportView(getTable());
		}
		return scrollPaneZaTabelu;
	}

	private JTable getTable() {
		if (table == null) {
			table = new JTable();
			ValutaTableModel model = new ValutaTableModel(null);
			table.setModel(model);
		}
		return table;
	}

	private JPanel getPanelZaDugmice() {
		if (panelZaDugmice == null) {
			panelZaDugmice = new JPanel();
			panelZaDugmice.setPreferredSize(new Dimension(140, 10));
			panelZaDugmice.add(getBtnDodajKurs());
			panelZaDugmice.add(getBtnIzbrisiKurs());
			panelZaDugmice.add(getBtnIzvrsiIzmenu());
		
			

		}
		return panelZaDugmice;
	}

	private JButton getBtnDodajKurs() {
		if (btnDodajKurs == null) {
			btnDodajKurs = new JButton("Dodaj kurs");			
			btnDodajKurs.setPreferredSize(new Dimension(120, 25));
			btnDodajKurs.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GUIKontroler.prikaziDodajKurs();
					osveziTabelu();
				}
			});
		}
		return btnDodajKurs;
	}

	private JButton getBtnIzvrsiIzmenu() {
		if (btnIzvrsiZamenu == null) {
			btnIzvrsiZamenu = new JButton("Izvrši zamenu");
			btnIzvrsiZamenu.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GUIKontroler.prikaziIzvrsiIzmenu();
				}
			});

			btnIzvrsiZamenu.setPreferredSize(new Dimension(120, 25));
		}
		return btnIzvrsiZamenu;
	}



	public void osveziTabelu() {
		ValutaTableModel model = (ValutaTableModel) table.getModel();
		model.setValute(GUIKontroler.vratiSveValute());
	}

	public void postaviTekstUEditor() {
		editorPane.setText(GUIKontroler.getTekstZaEditor());
		getContentPane();
	}

	private JPopupMenu getPopupMenu() {
		if (popupMenu == null) {
			popupMenu = new JPopupMenu();

			popupMenu.add(getMntmDodajKurs());
			popupMenu.add(getMntmIzbrisiKurs());
			popupMenu.add(getMntmIzvrsiIzmenu());
		}
		return popupMenu;
	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}

	private JButton getBtnIzbrisiKurs() {
		if (btnIzbrisiKurs == null) {
			btnIzbrisiKurs = new JButton("Izbriši kurs");
			btnIzbrisiKurs.setPreferredSize(new Dimension(120, 25));
			btnIzbrisiKurs.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					if (getTable().getSelectedRow() != -1) {

						int opcija = JOptionPane.showConfirmDialog(getContentPane(),
								"Da li ste sigurni da želite da obrišete kurs?", "Brisanje kursa",
								JOptionPane.YES_NO_OPTION);

						if (opcija == JOptionPane.YES_OPTION) {
							int red = getTable().getSelectedRow();
							Valuta v = new Valuta();							
							v.setSifra((Integer) getTable().getValueAt(red, 0));
							v.setSkraceniNaziv((String) getTable().getValueAt(red, 1));							
							v.setProdajni((Double) getTable().getValueAt(red, 2));
							v.setSrednji((Double) getTable().getValueAt(red, 3));
							v.setKupovni((Double) getTable().getValueAt(red, 4));
							v.setNaziv((String) getTable().getValueAt(red, 5));
							try {
								GUIKontroler.obrisiValutu(v);
								osveziTabelu();
								dodajTekstUEditor(
										"Izbrisan je red sa indeksom: " + (red + 1)+ "\n") ;
								JOptionPane.showInternalMessageDialog(getContentPane(), "Uspešno ste izbrisali red", "Uspeh",JOptionPane.INFORMATION_MESSAGE );
							} catch (Exception e1) {
								JOptionPane.showInternalMessageDialog(getContentPane(), "Niste izbrisali red"+e1.getMessage(), "Greška",JOptionPane.WARNING_MESSAGE );
							}
						}

					} else {
						JOptionPane.showMessageDialog(getContentPane(),
								"Niste izabrali red koji želite da obrišete!");
					}
				}
			});
		}
		return btnIzbrisiKurs;
	}



	private JMenuItem getMntmDodajKurs() {
		if (mntmDodajKurs == null) {
			mntmDodajKurs = new JMenuItem("Dodaj kurs");
			mntmDodajKurs.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GUIKontroler.prikaziDodajKurs();
					osveziTabelu();
				}
			});
			
		}
		return mntmDodajKurs;
	}

	private JMenuItem getMntmIzbrisiKurs() {
		if (mntmIzbrisiKurs == null) {
			mntmIzbrisiKurs = new JMenuItem("Izbriši kurs");
			
		}
		return mntmIzbrisiKurs;
	}

	private JMenuItem getMntmIzvrsiIzmenu() {
		if (mntmIzvrsiIzmenu == null) {
			mntmIzvrsiIzmenu = new JMenuItem("Izvrši izmenu");
			mntmIzvrsiIzmenu.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					GUIKontroler.prikaziIzvrsiIzmenu();
				}
			});
			
		}
		return mntmIzvrsiIzmenu;
	}

	public static void dodajTekstUEditor(String tekst) {
		if (editorPane.getText() != null)
			editorPane.setText(editorPane.getText() + tekst);
		else
			editorPane.setText(tekst);
	}

	private JScrollPane getScrollPane_1() {
		if (scrollPaneZaEditor == null) {
			scrollPaneZaEditor = new JScrollPane();
			scrollPaneZaEditor.setPreferredSize(new Dimension(300, 80));
			scrollPaneZaEditor.setViewportView(getEditorPane());			
		}
		return scrollPaneZaEditor;
	}
	private JTextArea getEditorPane() {
		if (editorPane == null) {
			editorPane = new JTextArea();
			editorPane.setFont(new Font("Monospaced", Font.PLAIN, 13));
			editorPane.setBackground(new Color(255, 255, 255));
			editorPane.setEditable(false);
			editorPane.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Status", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		}
		return editorPane;
	}
}
