package viewAdmin;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import view.Home;
import view.MenuUtente;
import view.MyFollow;
import java.awt.Color;
import javax.swing.UIManager;

public class MenuAdmin extends JFrame {

	private JPanel panelAdmin;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuAdmin frame = new MenuAdmin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MenuAdmin() {
		ImageIcon iconaSuccesso = new ImageIcon(Home.class.getResource("/images/successo.png"));
		ImageIcon iconaErrore = new ImageIcon(Home.class.getResource("/images/errore.png"));
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panelAdmin = new JPanel();
		panelAdmin.setBackground(new Color(0, 204, 255));
		panelAdmin.setForeground(Color.CYAN);
		panelAdmin.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panelAdmin);
		panelAdmin.setLayout(null);
		JLabel labelMenu = new JLabel("Ciao: " + Home.getUsername());
		labelMenu.setForeground(new Color(255, 255, 255));
		labelMenu.setBounds(187, 10, 200, 60);
		panelAdmin.add(labelMenu);

		JButton btnInserisciGioco = new JButton("Inserisci Gioco");
		btnInserisciGioco.setBackground(new Color(255, 255, 255));
		btnInserisciGioco.setForeground(new Color(0, 204, 255));
		btnInserisciGioco.setBounds(24, 70, 170, 29);
		panelAdmin.add(btnInserisciGioco);
		btnInserisciGioco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InserisciGioco insertGame = new InserisciGioco();
				insertGame.setVisible(true);
				MenuAdmin.this.dispose();
			}
		});
		JButton btnTorneo = new JButton("Inserisci Torneo");
		btnTorneo.setBackground(new Color(255, 255, 255));
		btnTorneo.setForeground(new Color(0, 204, 255));
		btnTorneo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InserisciTorneo torneo = new InserisciTorneo();
				torneo.setVisible(true);
			}
		});
		btnTorneo.setBounds(254, 70, 170, 29);
		panelAdmin.add(btnTorneo);
		
		JButton btnLogOut = new JButton("LOG OUT");
		btnLogOut.setForeground(new Color(51, 204, 255));
		btnLogOut.setBackground(new Color(255, 255, 255));
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				JOptionPane.showMessageDialog(panelAdmin, "Logout effettuato con successo.", null, 0,
						iconaSuccesso);
				Home H = new Home();
				H.main(null);
				MenuAdmin.this.dispose();
			}
		});
		btnLogOut.setBounds(24, 231, 170, 29);
		panelAdmin.add(btnLogOut);
		
		JButton btnPost = new JButton("Ricerca Hashtag");
		btnPost.setForeground(new Color(0, 204, 255));
		btnPost.setBackground(new Color(255, 255, 255));
		btnPost.setBounds(24, 120, 170, 29);
		panelAdmin.add(btnPost);
		
		btnPost.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
               
				Object [] opz = {"Annulla","Cerca" };
				
				JPanel panel = new JPanel();
				JTextField parola;
				parola = new JTextField();
				parola.setBounds(6, 20, 368, 26);
				panel.add(parola );
				
				
				int scelta = JOptionPane.showOptionDialog(panel, parola, "Cercare l'hashtag", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, opz, null);
				if(scelta==1) {
					RicercaPost ricercapost = new RicercaPost(parola.getText());
				}
				
				
			}
				
		});
		
		JButton btnParola = new JButton("Ricerca Parola");
		btnParola.setBackground(new Color(255, 255, 255));
		btnParola.setForeground(new Color(0, 204, 255));
		btnParola.setBounds(254, 120, 170, 29);
		panelAdmin.add(btnParola);
		
		btnParola.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
               
				Object [] opz = {"Annulla","Cerca" };
				
				JPanel panel = new JPanel();
				JTextField parola;
				parola = new JTextField();
				parola.setBounds(6, 20, 368, 26);
				panel.add(parola );
				
				
				int scelta = JOptionPane.showOptionDialog(panel, parola, "Cercare la parola", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, opz, null);
				if(scelta==1) {
					RicercaParola ricercaparola = new RicercaParola (parola.getText());
				}
				
				
			}
				
		});
		
		JLabel label = new JLabel("");
		ImageIcon  img= new ImageIcon(Home.class.getResource("/images/twitter.png"));
		label.setIcon(new ImageIcon(MenuAdmin.class.getResource("/images/twitter.png")));
		label.setBounds(24,10,61,48);
		panelAdmin.add(label);
		
	}
}