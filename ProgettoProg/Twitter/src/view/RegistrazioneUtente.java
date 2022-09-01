package view;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import javax.swing.*;

import classidb.Database;
import classidb.Utente;
import view.*;
import java.awt.Color;

public class RegistrazioneUtente {
	private JFrame frameReg;
	private JTextField textFieldNome;
	private JTextField textFieldCognome;
	private JTextField textFieldUsername;
	private JTextField textFieldPassword;
	private JTextField textFieldRipPass;

	public RegistrazioneUtente() {
		initialize();

	}

	private void initialize() {
		ImageIcon iconaSuccesso = new ImageIcon(Home.class.getResource("/images/successo.png"));
		ImageIcon iconaErrore = new ImageIcon(Home.class.getResource("/images/errore.png"));

		Database D = Database.getIstance();

		frameReg = new JFrame();
		frameReg.getContentPane().setForeground(new Color(255, 255, 255));
		frameReg.getContentPane().setBackground(new Color(0, 204, 255));
		frameReg.setBounds(100, 100, 500, 400);
		frameReg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameReg.getContentPane().setLayout(null);
		
        

		JLabel labelNome = new JLabel("Nome");
		labelNome.setForeground(new Color(255, 255, 255));
		labelNome.setBounds(20, 30, 100, 26);
		frameReg.getContentPane().add(labelNome);
		
		JLabel labelCognome = new JLabel("Cognome");
		labelCognome.setForeground(new Color(255, 255, 255));
		labelCognome.setBounds(20, 70, 100, 26);

		frameReg.getContentPane().add(labelCognome);

		JLabel labelUsername = new JLabel("Username");
		labelUsername.setForeground(new Color(255, 255, 255));

		labelUsername.setBounds(20, 110, 100, 26);

		frameReg.getContentPane().add(labelUsername);

		JLabel labelPassword = new JLabel("Password");
		labelPassword.setForeground(new Color(255, 255, 255));

		labelPassword.setBounds(20, 150, 100, 26);

		frameReg.getContentPane().add(labelPassword);

		textFieldNome = new JTextField();

		textFieldNome.setBounds(130, 30, 219, 26);

		frameReg.getContentPane().add(textFieldNome);

		textFieldNome.setColumns(10);

		textFieldCognome = new JTextField();

		textFieldCognome.setBounds(130, 70, 219, 26);

		frameReg.getContentPane().add(textFieldCognome);

		textFieldCognome.setColumns(10);

		textFieldUsername = new JTextField();

		textFieldUsername.setBounds(130, 110, 219, 26);

		frameReg.getContentPane().add(textFieldUsername);

		textFieldUsername.setColumns(10);

		textFieldPassword = new JPasswordField();

		textFieldPassword.setBounds(130, 150, 219, 26);

		frameReg.getContentPane().add(textFieldPassword);

		textFieldPassword.setColumns(10);

		JCheckBox checkPass = new JCheckBox("Show Password");
		checkPass.setBackground(new Color(0, 204, 255));
		checkPass.setForeground(new Color(255, 255, 255));

		checkPass.setBounds(350, 150, 130, 20);

		frameReg.getContentPane().add(checkPass);

		checkPass.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				if (checkPass.isSelected()) {

					((JPasswordField) textFieldPassword).setEchoChar((char) 0); 
                       
				} else {

					((JPasswordField) textFieldPassword).setEchoChar('●') ; //qui settiamo il simbolo per non far vedere la password

				}

			}

		});

		JLabel labelRipPass = new JLabel("Ripeti Password");
		labelRipPass.setForeground(new Color(255, 255, 255));

		labelRipPass.setBounds(20, 190, 100, 26);

		frameReg.getContentPane().add(labelRipPass);

		textFieldRipPass = new JPasswordField();

		textFieldRipPass.setBounds(130, 190, 219, 26);

		frameReg.getContentPane().add(textFieldRipPass);

		textFieldRipPass.setColumns(10);

		JButton bottoneSignIn = new JButton("Crea");
		bottoneSignIn.setForeground(new Color(0, 204, 255));
		bottoneSignIn.setBackground(new Color(255, 255, 255));
		bottoneSignIn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

			if (textFieldPassword.getText().equals(textFieldRipPass.getText())) {
			if (!ControllerInserimento.eVuota(textFieldUsername.getText())
			&& !ControllerInserimento.eVuota(textFieldPassword.getText())
			&& !ControllerInserimento.eVuota(textFieldRipPass.getText())) {			 
			try {
			Utente U = new Utente(textFieldNome.getText(), textFieldCognome.getText(), textFieldUsername.getText(), textFieldPassword.getText());

			try {		 

			D.createUser(U);
			JOptionPane.showMessageDialog(frameReg, "Utente Creato", null, 0, iconaSuccesso);

			Home home = new Home();
			frameReg.setVisible(false);
			home.setVisible(true);
	
		

			} catch (SQLIntegrityConstraintViolationException s) {

			JOptionPane.showMessageDialog(frameReg, "Username esistente", null, 0,

			iconaErrore);

			} catch (SQLException e1) {

			JOptionPane.showMessageDialog(frameReg, "Errore Generico!", null, 0,

			iconaErrore);


			 

			}


			 

			} catch (HeadlessException e1) {


			 

			JOptionPane.showMessageDialog(frameReg, "Errore Generico!", null, 0, iconaErrore);

			}


			 

			} else {

			JOptionPane.showMessageDialog(frameReg, "Username o Password non può essere vuoto!",

			null, 0, iconaErrore);

			}


			 

			} else {

			JOptionPane.showMessageDialog(frameReg, "Le Password non coincidono!", null, 0, iconaErrore);

			}

			}


			 

			});


			 

			bottoneSignIn.setBounds(327, 300, 117, 29);

			frameReg.getContentPane().add(bottoneSignIn);


			 

			JButton btnAnnulla = new JButton("Annulla");
			btnAnnulla.setBackground(new Color(255, 255, 255));
			btnAnnulla.setForeground(new Color(0, 204, 255));

			btnAnnulla.setBounds(27, 300, 117, 29);

			frameReg.getContentPane().add(btnAnnulla);

			btnAnnulla.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

			Home Ho = new Home();

			frameReg.setVisible(false);
			Ho.setVisible(false);

		


			 

			}

			});

			}
	public void setVisible(boolean bool) {
        try {
            if (bool == true) {
                RegistrazioneUtente window = new RegistrazioneUtente();
                window.frameReg.setVisible(true);
            } else {
            	RegistrazioneUtente window = new RegistrazioneUtente();
                window.frameReg.setVisible(false);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

	

