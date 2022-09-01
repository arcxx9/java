package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import classidb.Database;

public class MyFollow extends JFrame {

	private JPanel panelMyFollow;
	private String usernameUtente;
	private JTable table_1;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyFollow panel = new MyFollow();
					panel.panelMyFollow.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	public MyFollow() {

		ImageIcon iconaSuccesso = new ImageIcon(Home.class.getResource("/images/successo.png"));
		ImageIcon iconaErrore = new ImageIcon(Home.class.getResource("/images/errore.png"));
		Database D = Database.getIstance();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setBounds(100, 100, 536, 390);

		panelMyFollow = new JPanel();
		panelMyFollow.setBackground(new Color(0, 204, 255));

		panelMyFollow.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(panelMyFollow);

		panelMyFollow.setLayout(null);
		ImageIcon  img= new ImageIcon(Home.class.getResource("/images/twitter.png"));

		JLabel lblUtenti = new JLabel("Seguiti");
		lblUtenti.setForeground(new Color(255, 255, 255));

		lblUtenti.setLabelFor(panelMyFollow);

		lblUtenti.setHorizontalAlignment(SwingConstants.CENTER);

		lblUtenti.setBackground(new Color(255, 255, 255));

		lblUtenti.setBounds(82, 8, 100, 20);

		panelMyFollow.add(lblUtenti);

		JScrollPane scrollPane = new JScrollPane();

		scrollPane.setViewportBorder(new EmptyBorder(0, 1, 0, 0));

		scrollPane.setEnabled(false);

		scrollPane.setBounds(20, 34, 246, 266);

		panelMyFollow.add(scrollPane);

		JTable table = new JTable(D.ricercaFollower()) {

			@Override

			public boolean isCellEditable(int row, int column) {

				return false;

			}

		};

		
		
		
		JButton btnLogOut = new JButton("INDIETRO");
		btnLogOut.setBackground(new Color(255, 255, 255));
		btnLogOut.setForeground(new Color(0, 204, 255));

		btnLogOut.setBounds(20, 312, 117, 29);

		panelMyFollow.add(btnLogOut);

		btnLogOut.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				MenuUtente menu = new MenuUtente();
				menu.main(null);
				MyFollow.this.dispose();

			}

		});
		
		

		table.setBounds(6, 193, 426, -134);

		scrollPane.setViewportView(table);

		JButton btnUnfollow = new JButton("UNFOLLOW");
		btnUnfollow.setBackground(new Color(255, 255, 255));
		btnUnfollow.setForeground(new Color(0, 204, 255));

		btnUnfollow.setBounds(149, 312, 117, 29);

		 panelMyFollow.add(btnUnfollow);
		 
		 JScrollPane scrollPane_1 = new JScrollPane();
		 scrollPane_1.setViewportBorder(new EmptyBorder(0, 1, 0, 0));
		 scrollPane_1.setEnabled(false);
		 scrollPane_1.setBounds(278, 34, 246, 266);
		 panelMyFollow.add(scrollPane_1);
		 
		 table_1 = new JTable(D.ricercaFollow());
		 table_1.setEnabled(false);
		 table_1.setColumnSelectionAllowed(true);
		 scrollPane_1.setViewportView(table_1);
		 
		 JLabel lblFollower = new JLabel("Follower");
		 lblFollower.setHorizontalAlignment(SwingConstants.CENTER);
		 lblFollower.setForeground(Color.WHITE);
		 lblFollower.setBackground(Color.WHITE);
		 lblFollower.setBounds(349, 8, 100, 20);
		 panelMyFollow.add(lblFollower);
		
		//Fare un action che rimuove A db l utente loggato e l username dell utente che seleziona 
		btnUnfollow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int row;
				row = table.getSelectedRow();
				
				usernameUtente = (String) table.getValueAt(row, 2);
				if(!Home.getUsername().equals(usernameUtente)) {
					
			
					
				try {
				D.rimuoviFollower(Home.getUsername(), usernameUtente);
				
				
				JOptionPane.showMessageDialog( panelMyFollow, "Non segui pi� questo utente",null,0,iconaSuccesso);
				((DefaultTableModel)table.getModel()).removeRow(row);
				
				} catch (SQLIntegrityConstraintViolationException s) {
					JOptionPane.showMessageDialog( panelMyFollow, "Gi� non segui questo utente",null,0,iconaErrore);
					
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
				
				} else {
					
					JOptionPane.showMessageDialog( panelMyFollow, "Non puoi non seguire te stesso",null,0,iconaErrore);

				}
				}

				
				
					
			
	});

	}
}