package viewAdmin;

import javax.swing.JFrame;


import javax.swing.JTextField;





import java.awt.EventQueue;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import classidb.Database;
import classidb.Gioco;
import classidb.Torneo;
import view.ControllerInserimento;
import view.Home;

import javax.swing.UIManager;

import com.toedter.calendar.JDateChooser;

import javax.swing.SwingConstants;
import java.awt.Color;

import java.awt.SystemColor;

/**
 * Interfaccia grafica per la creazione
 * di nuovi tornei.
 * @author Sommella Antonio e Di Donna Alessandro
 */
public class InserisciTorneo extends JFrame {

	private JTextField textFieldCosto;
	private JFrame frameInserisciTorneo;
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InserisciTorneo frame = new InserisciTorneo();
					frame.frameInserisciTorneo.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	public InserisciTorneo() {
		initialize();

	}

	private void initialize() {

		ImageIcon iconaSuccesso = new ImageIcon(Home.class.getResource("/images/successo.png"));
		ImageIcon iconaErrore = new ImageIcon(Home.class.getResource("/images/errore.png"));
            
		
		Database D = Database.getIstance();

		frameInserisciTorneo = new JFrame();
		frameInserisciTorneo.getContentPane().setBackground(new Color(0, 204, 255));
		frameInserisciTorneo.setResizable(false);
		frameInserisciTorneo.setBounds(100, 100, 450, 300);
		frameInserisciTorneo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameInserisciTorneo.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("");
		ImageIcon  img= new ImageIcon(Home.class.getResource("/images/twitter.png"));
		label.setIcon(new ImageIcon(InserisciTorneo.class.getResource("/images/twitter.png")));
		label.setBounds(24,10,61,48);
		frameInserisciTorneo.getContentPane().add(label);
		

		Label dataTorneo = new Label("Data Torneo");
		dataTorneo.setForeground(new Color(255, 255, 255));
		dataTorneo.setAlignment(Label.LEFT);
		dataTorneo.setBounds(2, 77, 152, 19);
		frameInserisciTorneo.getContentPane().add(dataTorneo);

		JDateChooser dateChooser = new JDateChooser();

		dateChooser.setBounds(164, 77, 150, 19);
		dateChooser.setDateFormatString("dd-MM-yyyy HH:mm:ss");
		frameInserisciTorneo.getContentPane().add(dateChooser);

		Label gioco = new Label("Scegli il gioco");
		gioco.setBackground(new Color(0, 204, 255));
		gioco.setForeground(Color.WHITE);

		gioco.setBounds(2, 107, 144, 42);
		frameInserisciTorneo.getContentPane().add(gioco);

		JComboBox boxGioco = new JComboBox(D.elencoGioco().toArray());
		boxGioco.setBounds(164, 122, 230, 27);
		frameInserisciTorneo.getContentPane().add(boxGioco);

		Label prezzo = new Label("Prezzo");
		prezzo.setForeground(new Color(255, 255, 255));
		prezzo.setFont(UIManager.getFont("Label.font"));
		prezzo.setBounds(2, 172, 100, 19);
		frameInserisciTorneo.getContentPane().add(prezzo);
		
		textFieldCosto = new JTextField();
		textFieldCosto.setBounds(167, 172, 62, 27);
		frameInserisciTorneo.getContentPane().add(textFieldCosto);
		textFieldCosto.setColumns(10);
		
		

		JButton bottoneBack = new JButton("INDIETRO");
		bottoneBack.setBackground(new Color(255, 255, 255));
		bottoneBack.setForeground(new Color(0, 204, 255));
		bottoneBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuAdmin Menu = new MenuAdmin();
				Menu.setVisible(true);
				frameInserisciTorneo.dispose();
			}
		});
		bottoneBack.setBounds(24, 222, 117, 29);
		frameInserisciTorneo.getContentPane().add(bottoneBack);

	
		JButton bottoneInserisci = new JButton("INSERISCI");
		bottoneInserisci.setForeground(new Color(0, 204, 255));
		bottoneInserisci.setBackground(new Color(255, 255, 255));
			bottoneInserisci.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ControllerInserimento.eUnNumero(textFieldCosto.getText())) {

					int idgioco = D.elencoGioco().get(boxGioco.getSelectedIndex()).toInt();


					DateFormat dateformat1 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
					String data = dateformat1.format(dateChooser.getDate());
					
					Torneo torneo = new Torneo(data, idgioco, Float.parseFloat(textFieldCosto.getText()));
					D.insertTorneo(torneo);
					
					
					int scelta = JOptionPane.showConfirmDialog(frameInserisciTorneo,
							"Torneo Inserito. Inserire Altro Torneo?");
					if (scelta == JOptionPane.NO_OPTION) {
						frameInserisciTorneo.dispose();
					} else if (scelta == JOptionPane.CANCEL_OPTION) {

					} else if (scelta == JOptionPane.YES_OPTION) {
						

					}


				} else
					JOptionPane.showMessageDialog(frameInserisciTorneo, "Il costo deve essere un numero ", null, 0,
							iconaErrore);
			}
		}); 
		bottoneInserisci.setBounds(295, 222, 117, 29);
		frameInserisciTorneo.getContentPane().add(bottoneInserisci);

		
		
		JLabel lblInsertTorneo = new JLabel("Inserisci Torneo");
		lblInsertTorneo.setForeground(new Color(255, 255, 255));
		lblInsertTorneo.setBounds(160, 6, 148, 16);
		frameInserisciTorneo.getContentPane().add(lblInsertTorneo);

	}

	public void setVisible(boolean bool) {
		try {
			if (bool == true) {
				InserisciTorneo window = new InserisciTorneo();
				window.frameInserisciTorneo.setVisible(true);
			} else {
				InserisciTorneo window = new InserisciTorneo();
				window.frameInserisciTorneo.setVisible(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}
