package view;

import java.awt.EventQueue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import classidb.Database;
import mediator.ChatMediator;
import mediator.ChatMediatorImpl;

import mediator.User;
import mediator.UserImpl;

import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import java.awt.Color;


public class Post extends JFrame {

	private JPanel panelPost;
	private static int MESSAGE_LENGTH = 140;
	public String parola;
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Post window = new Post();
					window.panelPost.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Post() {

		ImageIcon iconaSuccesso = new ImageIcon(Home.class.getResource("/images/successo.png"));
		ImageIcon iconaErrore = new ImageIcon(Home.class.getResource("/images/errore.png"));

		Database D = Database.getIstance();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setBounds(100, 100, 606, 429);

		panelPost = new JPanel();
		panelPost.setBackground(new Color(0, 204, 255));

		panelPost.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(panelPost);

		panelPost.setLayout(null);

		JTextPane txtpnScriviPost = new JTextPane();
		txtpnScriviPost.setText("Scrivi post..");
		txtpnScriviPost.setBounds(6, 231, 524, 102);
		panelPost.add(txtpnScriviPost);

		JButton btnPubblica = new JButton("PUBBLICA");
		btnPubblica.setForeground(new Color(0, 204, 255));
		btnPubblica.setBackground(new Color(255, 255, 255));
		btnPubblica.setBounds(357, 344, 117, 29);
		panelPost.add(btnPubblica);
		
		

		btnPubblica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChatMediator mediator = new ChatMediatorImpl();  //richiama il pattern mediator
				User username = new UserImpl(mediator, Home.getUsername()); 
				mediator.addUser(username);
				ArrayList<classidb.Post> allFol = D.elencoFolPost(); //prende l'elenco dei post dei follwer dal database
				for(int i = 0; i < allFol.size(); i++) {
					User all = new UserImpl(mediator, allFol.get(i).getUsername());
					mediator.addUser(all);
					
				}
				
				
			
				
				
				if (txtpnScriviPost.getText().length() <= MESSAGE_LENGTH) { //
					username.send(txtpnScriviPost.getText(), Home.getUsername()); //ti va a scrivere il messaggio che ha inserito l'utente nel post e ti prende il nome dell'utente che l'ha scritto.
					
					JOptionPane.showMessageDialog(panelPost, "Post Pubblicato con successo ", null, 0, iconaSuccesso);
				} else {

					JOptionPane.showMessageDialog(panelPost, "Hai superato i 140 caratteri ", null, 0, iconaErrore);
				}

			}

		});
		JScrollPane scrollPane = new JScrollPane();

		scrollPane.setViewportBorder(new EmptyBorder(0, 1, 0, 0));

		scrollPane.setEnabled(false);

		scrollPane.setBounds(10, 11, 549, 195);

		panelPost.add(scrollPane);

		JTable table = new JTable(D.iMieiPost(Home.getUsername())) {

			@Override

			public boolean isCellEditable(int row, int column) {

				return false;

			}

		};

		

		table.setBounds(6, 193, 426, -134);

		scrollPane.setViewportView(table);
		
		
		JButton btnLogOut = new JButton("INDIETRO");
		btnLogOut.setForeground(new Color(0, 204, 255));
		btnLogOut.setBackground(new Color(255, 255, 255));

		btnLogOut.setBounds(65, 344, 117, 29);

		panelPost.add(btnLogOut);

		btnLogOut.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				MenuUtente menu = new MenuUtente();
				menu.main(null);
				Post.this.dispose();

			}

		});
			
	}
}
