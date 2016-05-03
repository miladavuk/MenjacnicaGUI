package menjacnica.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Color;

public class OAutoru extends JDialog {

	private final JPanel panelZaTextArea = new JPanel();

	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 */
	public OAutoru() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		panelZaTextArea.setLayout(new FlowLayout());
		panelZaTextArea.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(panelZaTextArea, BorderLayout.CENTER);
		{
			JTextArea txtrAutor = new JTextArea();
			txtrAutor.setBackground(new Color(204, 255, 255));
			txtrAutor.setForeground(Color.MAGENTA);
			txtrAutor.setFont(new Font("Arial Unicode MS", Font.BOLD | Font.ITALIC, 17));
			txtrAutor.setPreferredSize(new Dimension(400, 180));
			txtrAutor.setEnabled(false);
			txtrAutor.setEditable(false);
			txtrAutor.setText("Autor: Milada Vuković. ");
			panelZaTextArea.add(txtrAutor);
		}
		{
			JPanel panelZaDugme = new JPanel();
			panelZaDugme.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(panelZaDugme, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				panelZaDugme.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{

			}
		}
	}

}

