package view;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import Bridge.EmailMessageSender;
import Bridge.LongMessage;
import Bridge.ShortMessage;
import Bridge.SmsMessageSender;
import classidb.Database;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Color;

public class EmailSend extends JFrame {
	
	private JPanel panelEmail;
	private String userSend;
	private String userReceive;

	public EmailSend(String userS, String userR) { //il metodo per inviare email
		userSend = userS;
		userReceive = userR;
		initialize();
	}

	private void initialize() {
		
		  ImageIcon iconaSuccesso = new ImageIcon(Home.class.getResource("/images/successo.png"));
	        ImageIcon iconaErrore = new ImageIcon(Home.class.getResource("/images/errore.png"));
	        
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setBounds(200, 200, 472, 330);

		panelEmail = new JPanel();
		panelEmail.setBackground(new Color(0, 204, 255));

		panelEmail.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(panelEmail);

		panelEmail.setLayout(null);
		
		JTextPane txtpnScriviEmail = new JTextPane();
		txtpnScriviEmail.setBounds(6, 64, 460, 182);
		panelEmail.add(txtpnScriviEmail);
		
		JButton btnInvio = new JButton("Invio");
		btnInvio.setForeground(new Color(0, 204, 255));
		btnInvio.setBackground(new Color(255, 255, 255));
		btnInvio.setBounds(181, 258, 117, 29);
		panelEmail.add(btnInvio);
		
		JLabel lblNewLabel = new JLabel("Sta scrivendo una mail a:" +userReceive);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(6, 6, 460, 29);
		panelEmail.add(lblNewLabel);
		
		
		btnInvio.addActionListener(new ActionListener() {

			 public void actionPerformed(ActionEvent e) {
				 
				 
				 LongMessage longMessage = new LongMessage(new EmailMessageSender());
				 longMessage.sendMessage(txtpnScriviEmail.getText(), userSend, userReceive);
				 JOptionPane.showMessageDialog(panelEmail, "Email inviata con successo" ,null,0,iconaSuccesso);
     			CercaUtente cutente= new CercaUtente();
     			cutente.setVisible(true);
     			EmailSend.this.dispose();
				 
			

			}

			});
		
		
		
	}

}
