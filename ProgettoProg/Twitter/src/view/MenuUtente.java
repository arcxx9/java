package view;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuUtente extends JFrame {

	private JPanel panelMenu;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuUtente frame = new MenuUtente();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MenuUtente() {
		ImageIcon iconaSuccesso = new ImageIcon(Home.class.getResource("/images/successo.png"));
		ImageIcon iconaErrore = new ImageIcon(Home.class.getResource("/images/errore.png"));
		ImageIcon logo = new ImageIcon(MenuUtente.class.getResource("/images/twitter.png"));
		
		
		
		
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panelMenu = new JPanel();
		panelMenu.setForeground(new Color(0, 204, 255));
		panelMenu.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panelMenu);
		panelMenu.setLayout(null);
		panelMenu.setBackground(new Color(0, 204, 255));
		

        JLabel label = new JLabel("");
		ImageIcon  img= new ImageIcon(MenuUtente.class.getResource("/images/twitter.png"));
		label.setIcon(new ImageIcon(Home.class.getResource("/images/twitter.png")));
		label.setBounds(24,10,61,48);
		panelMenu.add(label);
		
		
		
		JLabel labelMenu = new JLabel("Ciao: " + Home.getUsername());
		labelMenu.setForeground(new Color(255, 255, 255));
		labelMenu.setBounds(187, 18, 200, 60);
		panelMenu.add(labelMenu);
		JButton btnUtenti = new JButton("Cerca Utenti");
		btnUtenti.setBackground(new Color(255, 255, 255));
		btnUtenti.setForeground(new Color(0, 204, 255));
		btnUtenti.setBounds(20, 70, 170, 29);
		panelMenu.add(btnUtenti);
		btnUtenti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CercaUtente cu = new CercaUtente();
				cu.setVisible(true);
				MenuUtente.this.dispose();
			}
		});
		JButton btnMyFollow = new JButton("Seguiti/Follower");
		btnMyFollow.setBackground(new Color(255, 255, 255));
		btnMyFollow.setForeground(new Color(0, 204, 255));
		btnMyFollow.setBounds(254, 70, 170, 29);
		panelMenu.add(btnMyFollow);
		btnMyFollow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MyFollow myFol = new MyFollow();
				myFol.setVisible(true);
				MenuUtente.this.dispose();
			}
		});

		JButton btnLogOut = new JButton("LOG OUT");
		btnLogOut.setBackground(new Color(255, 255, 255));
		btnLogOut.setForeground(new Color(0, 204, 255));

		btnLogOut.setBounds(20, 200, 117, 29);

		panelMenu.add(btnLogOut);

		btnLogOut.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				JOptionPane.showMessageDialog(panelMenu, "Logout effettuato con successo.", null, 0, iconaSuccesso);

				Home H = new Home();

				H.main(null);

				MenuUtente.this.dispose();

			}

		});
		JButton btnTornei = new JButton("Cerca Tornei");
		btnTornei.setBackground(new Color(255, 255, 255));
		btnTornei.setForeground(new Color(0, 204, 255));
		btnTornei.setBounds(20, 120, 170, 29);
		panelMenu.add(btnTornei);
		
		JButton btnPost = new JButton("Post");
		btnPost.setBackground(new Color(255, 255, 255));
		btnPost.setForeground(new Color(0, 204, 255));
		btnPost.setBounds(254, 120, 170, 29);
		panelMenu.add(btnPost);
		
		JButton btnMsg = new JButton("");
		btnMsg.setIcon(new ImageIcon(MenuUtente.class.getResource("/images/communications.png")));
		btnMsg.setBounds(301, 182, 64, 47);
		panelMenu.add(btnMsg);
		
		btnMsg.addActionListener(new ActionListener () {
				public void actionPerformed(ActionEvent e) {
			Messaggi msg = new Messaggi();
			msg.setVisible(true);
			MenuUtente.this.dispose();
		}
	});
		
		btnTornei.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CercaTornei tornei = new CercaTornei();
				tornei.setVisible(true);
				MenuUtente.this.dispose();
			}
		});
		btnPost.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			Post post = new Post();
			post.setVisible(true);
			MenuUtente.this.dispose();
				
			}
		});

	}
}
