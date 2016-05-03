package menjacnica.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import java.awt.Toolkit;

import javax.swing.ButtonGroup;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JSlider;
import java.awt.Font;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import javax.swing.JRadioButton;

@SuppressWarnings("serial")
public class IzvrsiZamenuGUI extends JFrame {

	private JPanel contentPane;
	private JLabel lblProdajniKurs;
	private JLabel lblKupovniKurs;
	private JTextField textFieldKupovniKurs;
	private JComboBox comboBoxValute;
	private JLabel lblIznos;
	private JRadioButton kupovinaRadioButton;
	private JRadioButton prodajaRadioButton;
	private JTextField prodajniTextField;
	private JTextField iznosTextField;
	private ButtonGroup buttonGroup;

	/**
	 * Create the frame.
	 */
	public IzvrsiZamenuGUI() {
		setPreferredSize(new Dimension(300, 500));
		setResizable(false);
		setTitle("Izvr\u0161i zamenu");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 380);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblKupovniKurs());
		contentPane.add(getLblProdajniKurs());
		contentPane.add(getTextFieldKupovniKurs());
		contentPane.add(getComboBoxValute());
		contentPane.add(getLblIznos());
		contentPane.add(getKupovinaRadioButton());
		contentPane.add(getProdajaRadioButton());
		buttonGroup = new ButtonGroup();
		buttonGroup.add(getProdajaRadioButton());
		buttonGroup.add(getKupovinaRadioButton());
		
		

		JLabel lblTransakcija = new JLabel("Vrsta transakcije:");
		lblTransakcija.setBounds(298, 126, 106, 16);
		contentPane.add(lblTransakcija);

		contentPane.add(getProdajniTextField());
		contentPane.add(getIznosTextField());

		JSlider slider = new JSlider();
		
		slider.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				iznosTextField.setText("" + slider.getValue());
			}
		});
		slider.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				iznosTextField.setText("" + slider.getValue());
			}
		});
		slider.setFont(new Font("Palatino", Font.BOLD, 15));
		slider.setMajorTickSpacing(10);
		slider.setPaintLabels(true);
		slider.setMinimum(0);
		slider.setMaximum(100);
		slider.setVisible(true);
		slider.setMinorTickSpacing(5);
		slider.setBounds(6, 209, 438, 39);
		iznosTextField.setText("" + slider.getValue());
		contentPane.add(slider);

		JButton btnIzvrsiZamenu = new JButton("Izvr\u0161i zamenu");
		btnIzvrsiZamenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (getKupovinaRadioButton().isSelected()) {
					String tekst = "Kupovina - valuta: " + comboBoxValute.getSelectedItem().toString()
							+ ", iznos: " + iznosTextField.getText() + "\n";
					MenjacnicaGUI.dodajTekstUEditor(tekst);
				}
				if (prodajaRadioButton.isSelected()) {
					String tekst = "Prodaja - valuta: " + comboBoxValute.getSelectedItem().toString() + ", iznos: "
							+ iznosTextField.getText() + "\n";
					MenjacnicaGUI.dodajTekstUEditor(tekst);
				}
				dispose();
			}
		});
		btnIzvrsiZamenu.setBounds(6, 275, 175, 39);
		contentPane.add(btnIzvrsiZamenu);

		JButton btnOdustani = new JButton("Odustani");
		btnOdustani.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnOdustani.setBounds(269, 275, 175, 39);
		contentPane.add(btnOdustani);
	}

	private JLabel getLblProdajniKurs() {
		if (lblProdajniKurs == null) {
			lblProdajniKurs = new JLabel("Prodajni kurs:");
			lblProdajniKurs.setBounds(298, 5, 146, 47);
		}
		return lblProdajniKurs;
	}

	private JLabel getLblKupovniKurs() {
		if (lblKupovniKurs == null) {
			lblKupovniKurs = new JLabel("Kupovni kurs:");
			lblKupovniKurs.setBounds(6, 5, 146, 47);
		}
		return lblKupovniKurs;
	}

	private JTextField getTextFieldKupovniKurs() {
		if (textFieldKupovniKurs == null) {
			textFieldKupovniKurs = new JTextField();
			textFieldKupovniKurs.setPreferredSize(new Dimension(50, 20));
			textFieldKupovniKurs.setBounds(6, 64, 146, 39);
			textFieldKupovniKurs.setEditable(false);
			textFieldKupovniKurs.setColumns(10);
		}
		return textFieldKupovniKurs;
	}

	private JComboBox getComboBoxValute() {
		if (comboBoxValute == null) {
			comboBoxValute = new JComboBox();
			comboBoxValute.setBounds(162, 63, 126, 40);
			comboBoxValute.addItem("EUR");
			comboBoxValute.addItem("USD");
			comboBoxValute.addItem("CHF");
		}
		return comboBoxValute;
	}

	private JLabel getLblIznos() {
		if (lblIznos == null) {
			lblIznos = new JLabel("Iznos:");
			lblIznos.setBounds(6, 115, 146, 39);
		}
		return lblIznos;
	}

	private JRadioButton getKupovinaRadioButton() {
		if (kupovinaRadioButton == null) {
			kupovinaRadioButton = new JRadioButton("Kupovina");
			kupovinaRadioButton.setSelected(true);
			kupovinaRadioButton.setBounds(298, 145, 146, 24);
			kupovinaRadioButton.setPreferredSize(new Dimension(90, 13));
			
			
		}
		return kupovinaRadioButton;
	}
	private JRadioButton getProdajaRadioButton() {
		if (prodajaRadioButton == null) {
			prodajaRadioButton = new JRadioButton("Prodaja");
			prodajaRadioButton.setBounds(298, 169, 128, 23);
			prodajaRadioButton.setPreferredSize(new Dimension(90, 13));			
			
		}
		return prodajaRadioButton;
	}

	private JTextField getProdajniTextField() {
		if (prodajniTextField == null) {
			prodajniTextField = new JTextField();
			prodajniTextField.setPreferredSize(new Dimension(50, 20));
			prodajniTextField.setEditable(false);
			prodajniTextField.setColumns(10);
			prodajniTextField.setBounds(298, 64, 146, 39);
		}
		return prodajniTextField;
	}

	private JTextField getIznosTextField() {
		if (iznosTextField == null) {
			iznosTextField = new JTextField();
			iznosTextField.setPreferredSize(new Dimension(50, 20));
			iznosTextField.setColumns(10);
			iznosTextField.setBounds(6, 153, 146, 39);
		}
		return iznosTextField;
	}
}