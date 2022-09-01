package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import classidb.Database;
import enumerazione.Enum;

public class Messaggi extends JFrame {
	private JPanel panelMsg;
	private String usernameUtente;
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Messaggi window = new Messaggi();
					window.panelMsg.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Messaggi() {
		ImageIcon iconaSuccesso = new ImageIcon(Home.class.getResource("/images/successo.png"));
        ImageIcon iconaErrore = new ImageIcon(Home.class.getResource("/images/errore.png"));
        
		Database D = Database.getIstance();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setBounds(100, 100, 536, 390);

		panelMsg = new JPanel();
		panelMsg.setForeground(new Color(255, 255, 255));
		panelMsg.setBackground(new Color(0, 204, 255));

		panelMsg.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(panelMsg);

		panelMsg.setLayout(null);
		

		JLabel lblMessaggi = new JLabel("Messaggi");
		lblMessaggi.setForeground(new Color(255, 255, 255));

		lblMessaggi.setLabelFor(panelMsg);

		lblMessaggi.setHorizontalAlignment(SwingConstants.CENTER);

		lblMessaggi.setBackground(new Color(255, 255, 255));

		lblMessaggi.setBounds(194, 6, 100, 20);

		panelMsg.add(lblMessaggi);

		JScrollPane scrollPane = new JScrollPane();

		scrollPane.setViewportBorder(new EmptyBorder(0, 1, 0, 0));

		scrollPane.setEnabled(false);

		scrollPane.setBounds(20, 34, 495, 266);

		panelMsg.add(scrollPane);

		JTable table = new JTable(D.msgRicevuto(Home.getUsername())) {

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

		btnLogOut.setBounds(189, 313, 117, 29);

		panelMsg.add(btnLogOut);

		btnLogOut.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				MenuUtente menu = new MenuUtente();
				menu.main(null);
				Messaggi.this.dispose();

			}

		});


	}
}
