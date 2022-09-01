package view;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;



import Bridge.ShortMessage;
import Bridge.SmsMessageSender;
import classidb.Database;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;

public class SmsSend extends JFrame {
	
	private JPanel panelSms;
	private String userSend;
	private String userReceive;
	private JTextField textField;

	public SmsSend(String userS, String userR) {
		userSend = userS;
		userReceive = userR;
		initialize();
	}

	private void initialize() {
		

		 ImageIcon iconaSuccesso = new ImageIcon(Home.class.getResource("/images/successo.png"));
	        ImageIcon iconaErrore = new ImageIcon(Home.class.getResource("/images/errore.png"));
	        
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setBounds(200, 200, 395, 243);

		panelSms = new JPanel();
		panelSms.setBackground(new Color(0, 204, 255));

		panelSms.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(panelSms);

		panelSms.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(6, 107, 368, 26);
		panelSms.add(textField);
		textField.setColumns(10);
		
		JLabel lblSms = new JLabel("Stai scrivendo un SMS a:" + userReceive);
		lblSms.setForeground(new Color(255, 255, 255));
		lblSms.setBounds(6, 20, 306, 16);
		panelSms.add(lblSms);
		
		JButton btnInvia = new JButton("Invia");
		btnInvia.setForeground(new Color(0, 204, 255));
		btnInvia.setBackground(new Color(255, 255, 255));
		btnInvia.setBounds(133, 167, 117, 29);
		panelSms.add(btnInvia);
		
		JLabel lblmaxCaratteri = new JLabel("(Max 5 caratteri)");
		lblmaxCaratteri.setForeground(new Color(255, 255, 255));
		lblmaxCaratteri.setBackground(new Color(0, 204, 255));
		lblmaxCaratteri.setBounds(6, 82, 130, 14);
		panelSms.add(lblmaxCaratteri);
		btnInvia.addActionListener(new ActionListener() {

			 public void actionPerformed(ActionEvent e) { 
				
				 
				 
				 ShortMessage shortMessage = new ShortMessage(new SmsMessageSender()); //sto creando un oggetto di shortmessage
				 shortMessage.sendMessage(textField.getText(), userSend, userReceive); //prende il testo inserito dall'utente loggato, l'username dell'utende che lo invia e l'username dell'utente che lo riceve.
				 JOptionPane.showMessageDialog(panelSms, "SMS inviata con successo" ,null,0,iconaSuccesso);
	     			CercaUtente cutente= new CercaUtente(); //mi rende di nuovo visibile il pannello cerca utente
	     			cutente.setVisible(true);
	     			SmsSend.this.dispose(); //chiude il pannello smssend.
	     			

			}

			});
		
		
		
	}
}
