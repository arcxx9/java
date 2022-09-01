package view;

import login.*;
import java.awt.*;
import javax.swing.*;

import classidb.Post;
import login.Login;
import viewAdmin.InserisciTorneo;
import viewAdmin.MenuAdmin;

import java.awt.event.*;
import java.util.ArrayList;

public class Home {



	
		 
	    private JFrame frameHome;
	    private static JTextField textFieldUsername;
	    private static JTextField textFieldPassword;
	 
	    /**
	     * Launch the application.
	     */
	    public static void main(String[] args) {
	        EventQueue.invokeLater(new Runnable() {
	            public void run() {
	                try {
	                    Home window = new Home();
	                    window.frameHome.setVisible(true);
	                } catch (Exception e) {
	                    e.printStackTrace();
	                }
	            }
	        });
	    }
	    
	    
	    
	 
	    /**
	     * Create the application.
	     */
	    public Home() {
	        initialize();
	    }
	 
	    /**
	     * Initialize the contents of the frame.
	     */
	    private void initialize() {
	        
	        ImageIcon iconaSuccesso = new ImageIcon(Home.class.getResource("/images/successo.png"));
	        ImageIcon iconaErrore = new ImageIcon(Home.class.getResource("/images/errore.png"));
	        
	            
	        frameHome = new JFrame();// creaiamo un nuovo frame
	        frameHome.getContentPane().setForeground(new Color(255, 255, 255));
	        frameHome.getContentPane().setBackground(new Color(0, 204, 255));
	        frameHome.setTitle("Home");// setto il titolo
	        frameHome.setBounds(100, 100, 450, 300);// setto la grandezza
	        frameHome.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Quando finisce esce dal frame
	        frameHome.getContentPane().setLayout(null);
	        
	        JLabel label = new JLabel("");
			ImageIcon  img= new ImageIcon(Home.class.getResource("/images/twitter.png"));
			label.setIcon(new ImageIcon(Home.class.getResource("/images/twitter.png")));
			label.setBounds(24,10,61,48);
			frameHome.getContentPane().add(label);
	        
	        
	        
	        JLabel labelLogin = new JLabel("LOGIN"); //etichetta sul frame
	        labelLogin.setForeground(new Color(255, 255, 255));
	        labelLogin.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
	        labelLogin.setBounds(187, 32, 50, 16);//posizione etichetta
	        frameHome.getContentPane().add(labelLogin);//metodo dello swing per inserire l etichetta nel frame
	        
	        
	        textFieldUsername = new JTextField();// crea un nuovo canpo testo
	        textFieldUsername.setBounds(199, 78, 130, 26);//setta posizione dove va inserito il campo di testo
	        frameHome.getContentPane().add(textFieldUsername);
	        textFieldUsername.setColumns(10);
	       
	        textFieldPassword = new JPasswordField(30);
	        textFieldPassword.setBounds(199, 122, 130, 26);
	        frameHome.getContentPane().add(textFieldPassword);
	        textFieldPassword.setColumns(10);
	       
	        JLabel labelUsername = new JLabel("Username:");// crea eticchetta username
	        labelUsername.setForeground(new Color(255, 255, 255));
	        labelUsername.setBounds(90, 83, 84, 16);//setta posizione
	        frameHome.getContentPane().add(labelUsername);
	       
	        JLabel labelPassword = new JLabel("Password:");
	        labelPassword.setForeground(new Color(255, 255, 255));
	        labelPassword.setBounds(90, 127, 84, 16);
	        frameHome.getContentPane().add(labelPassword);
	        
	        
	        JButton bottoneLogin = new JButton("LOGIN");// creazone bottone login
	        bottoneLogin.setBackground(new Color(255, 255, 255));
	        bottoneLogin.setForeground(new Color(0, 204, 255));
	        
	        bottoneLogin.addActionListener(new ActionListener() {
	        		public void actionPerformed(ActionEvent e)
	        		{
	        		Login log = Login.getIstanced(); //prende l'istanza dal database del login
	        	      if(log.autenticazione(textFieldUsername.getText(), textFieldPassword.getText())==1) //qui ci dice se l'utente è admin
	        	      {
	        	   
	        	    	  JOptionPane.showMessageDialog(frameHome, "Benvenuto admin: " + textFieldUsername.getText(),null,0,iconaSuccesso);
	        	    	  MenuAdmin mAdmin = new MenuAdmin();
	        	    	  mAdmin.setVisible(true); //rendi visibile il menu admin sopra creato
	        	    	  frameHome.dispose(); //chiudi frame home
	        		} else if(log.autenticazione(textFieldUsername.getText(), textFieldPassword.getText())==2) { 
	        			
	        			JOptionPane.showMessageDialog(frameHome, "Benvenuto utente: " + textFieldUsername.getText(),null,0,iconaSuccesso);
	        			MenuUtente mutente= new MenuUtente();
	        			mutente.setVisible(true);
	        			frameHome.dispose();
	        		} else if(log.autenticazione(textFieldUsername.getText(), textFieldPassword.getText())==-1) {
	        			JOptionPane.showMessageDialog(frameHome, "Username/password errate",null,0,iconaErrore);
	        			
	        			
	        		}
	        			
	        		}
	        		
	    });
       
	        bottoneLogin.setBounds(297,207,117,29);// setta la posizione del login
	        frameHome.getContentPane().add(bottoneLogin);
	        
	        JButton btnSingIn = new JButton ("SIGN IN");
	        btnSingIn.setForeground(new Color(0, 204, 255));
	        btnSingIn.setBackground(new Color(255, 255, 255));
	        btnSingIn.setBounds(27, 207, 117, 29);
	        frameHome.getContentPane().add(btnSingIn);
	        btnSingIn.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            RegistrazioneUtente regU = new RegistrazioneUtente();
	            frameHome.setVisible(false);
	            regU.setVisible(true);
	            
	            
	        }
	        });
	    }
		public void setVisible(boolean bool) { //è un metodo che ci fa fa rendere visibile il frame
	        try {
	            if (bool == true) {
	                Home window = new Home();
	                window.frameHome.setVisible(true);
	            } else {
	            	Home window = new Home();
	                window.frameHome.setVisible(false);
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
		
		public static String getUsername() {
			return textFieldUsername.getText();
		}
}