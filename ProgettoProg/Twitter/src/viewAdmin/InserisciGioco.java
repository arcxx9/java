package viewAdmin;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import javax.swing.JSlider;
import javax.swing.JTextField;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import classidb.Database;
import classidb.Gioco;
import view.Home;
import java.awt.Color;

public class InserisciGioco {

	private JFrame frameInserisciGioco;
	private JTextField textFieldNomeGioco;
	private JTextField textFieldTipo;

	//Interfaccia per l'inserimento di un nuovo giovo.
	 

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InserisciGioco window = new InserisciGioco();
					window.frameInserisciGioco.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public InserisciGioco() {
		initialize();

	}

	private void initialize() {

		Database D = Database.getIstance();

		frameInserisciGioco = new JFrame();
		frameInserisciGioco.getContentPane().setBackground(new Color(0, 204, 255));
		frameInserisciGioco.setBounds(100, 100, 450, 300);
		frameInserisciGioco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameInserisciGioco.getContentPane().setLayout(null);
		
		

		JLabel labelNomeGioco = new JLabel("Nome Gioco:");
		labelNomeGioco.setForeground(new Color(255, 255, 255));
		labelNomeGioco.setBounds(41, 60, 124, 16);
		frameInserisciGioco.getContentPane().add(labelNomeGioco);

		JLabel labelTipo = new JLabel("Tipo");
		labelTipo.setForeground(new Color(255, 255, 255));
		labelTipo.setBounds(41, 105, 133, 16);
		frameInserisciGioco.getContentPane().add(labelTipo);

		JButton bottoneInserisci = new JButton("INSERISCI");
		bottoneInserisci.setForeground(new Color(0, 204, 255));
		bottoneInserisci.setBackground(new Color(255, 255, 255));
		bottoneInserisci.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				{
					int idgioco = 0;
					
					Gioco G = new Gioco(idgioco,textFieldNomeGioco.getText(), textFieldTipo.getText());
					D.insertGame(G);

					int scelta = JOptionPane.showConfirmDialog(frameInserisciGioco,
							"Gioco Inserito. Inserire Altro Gioco?");
					if (scelta == JOptionPane.NO_OPTION) {
						MenuAdmin menuA = new MenuAdmin();
						menuA.setVisible(true);
						frameInserisciGioco.dispose();
					} else if (scelta == JOptionPane.CANCEL_OPTION) {

					} else if (scelta == JOptionPane.YES_OPTION) {
						textFieldNomeGioco.setText("");

					}

				}

			}
		});
		bottoneInserisci.setBounds(298, 223, 117, 29);
		frameInserisciGioco.getContentPane().add(bottoneInserisci);

		textFieldNomeGioco = new JTextField();
		textFieldNomeGioco.setBounds(207, 55, 219, 26);
		frameInserisciGioco.getContentPane().add(textFieldNomeGioco);
		textFieldNomeGioco.setColumns(10);

		textFieldTipo = new JTextField();
		textFieldTipo.setBounds(207, 100, 219, 26);
		frameInserisciGioco.getContentPane().add(textFieldTipo);
		textFieldNomeGioco.setColumns(10);

		JButton bottoneAnnulla = new JButton("INDIETRO");
		bottoneAnnulla.setBackground(new Color(255, 255, 255));
		bottoneAnnulla.setForeground(new Color(0, 204, 255));
		bottoneAnnulla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuAdmin Menu = new MenuAdmin();
				Menu.setVisible(true);
				frameInserisciGioco.dispose();
			}
		});

		bottoneAnnulla.setBounds(21, 223, 117, 29);
		frameInserisciGioco.getContentPane().add(bottoneAnnulla);

		JLabel lblInserisciGioco = new JLabel("Inserisci Gioco");
		lblInserisciGioco.setForeground(new Color(255, 255, 255));
		lblInserisciGioco.setBounds(161, 6, 104, 16);
		frameInserisciGioco.getContentPane().add(lblInserisciGioco);
	}

	public void setVisible(boolean bool) {
		try {
			if (bool == true) {
				InserisciGioco window = new InserisciGioco();
				window.frameInserisciGioco.setVisible(true);
			} else {
				InserisciGioco window = new InserisciGioco();
				window.frameInserisciGioco.setVisible(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
