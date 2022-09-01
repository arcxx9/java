package view;

import java.awt.Color;

import java.awt.EventQueue;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import classidb.Database;
import enumerazione.Enum;
import strategy.GestorePagamento;

public class CercaTornei extends JFrame {
	private JPanel panelTornei;
	private int idTorneo;
	
	Enum Numero = null; //Serve per il pagamento.
	
	public static void main(String[] args) { //crea ed apre il pannello per la ricerca dei tornei.
		EventQueue.invokeLater(new Runnable() { 
			public void run() {
				try {
					CercaTornei window = new CercaTornei();
					window.panelTornei.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public CercaTornei() {

		ImageIcon iconaSuccesso = new ImageIcon(Home.class.getResource("/images/successo.png"));
		ImageIcon iconaErrore = new ImageIcon(Home.class.getResource("/images/errore.png"));
		
		Database D = Database.getIstance(); //si va a prendere l'istanza dal database

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        
		//setta le grandezze del pannello
		setBounds(100, 100, 536, 390);

		panelTornei = new JPanel();
		panelTornei.setBackground(new Color(0, 204, 255));

		panelTornei.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(panelTornei);

		panelTornei.setLayout(null);
		

      
		JLabel lblTornei = new JLabel("Tornei");

		lblTornei.setLabelFor(panelTornei);

		lblTornei.setHorizontalAlignment(SwingConstants.CENTER);

		lblTornei.setBackground(Color.cyan);

		lblTornei.setBounds(194, 6, 100, 20);

		panelTornei.add(lblTornei);

		JScrollPane scrollPane = new JScrollPane();

		scrollPane.setViewportBorder(new EmptyBorder(0, 1, 0, 0));

		scrollPane.setEnabled(false);

		scrollPane.setBounds(20, 34, 495, 266);

		panelTornei.add(scrollPane);

		JTable table = new JTable(D.elencoTornei()) { //crea la tabella dove escono tutti i tornei

			@Override

			public boolean isCellEditable(int row, int column) { 

				return false;

			}

		};
		
		TableColumn id = table.getColumnModel().getColumn(0); //prende la prima colonna
		//setta la grandezza delle colonne
		id.setMinWidth(0);
		id.setMaxWidth(0);
		id.setPreferredWidth(0); ///setta la larghezza preferita
		
		TableColumn nome = table.getColumnModel().getColumn(1); //prende la seconda colonna
		nome.setPreferredWidth(TEXT_CURSOR);
		TableColumn tipo = table.getColumnModel().getColumn(2); //prende la terza colonna
		tipo.setPreferredWidth(TEXT_CURSOR);
		
		TableColumn prezzo = table.getColumnModel().getColumn(4); //prende la quarta colonna
		prezzo.setPreferredWidth(TEXT_CURSOR);
		
		table.setBounds(6, 193, 426, -134);
		scrollPane.setViewportView(table); 
		scrollPane.setViewportView(table);
		table.setBounds(6, 193, 426, -134);
		scrollPane.setViewportView(table);

		JButton btnPartecipa = new JButton("PARTECIPA"); //creo il bottone partecipa
		btnPartecipa.setBackground(new Color(255, 255, 255));
		btnPartecipa.setForeground(new Color(0, 204, 255));

		btnPartecipa.setBounds(398, 316, 117, 29);

		panelTornei.add(btnPartecipa); //lo aggiungo al pannello

		btnPartecipa.addActionListener(new ActionListener() { //creo delle azioni al bottone
			public void actionPerformed(ActionEvent e) {
				int row;
				row = table.getSelectedRow(); //qua seleziono la riga
				idTorneo = (int) table.getValueAt(row, 0); //prendo dalla prima riga e prima colonna

				Float prezzo = (Float) table.getValueAt(row, 4); //prendo dalla prima riga e quarta colonna, quindi vado a prendere in totale, l'id del torneo e il prezzo.
			
	

				Object[] options1 = { "Annulla", "Contanti", "Bancomat", "Carta di credito" }; 
				JPanel panel = new JPanel();

				panel.add(new JLabel("Totale: " + prezzo + "\nCome si desidera pagare?")); //mi crea un pannello dove mi dice il prezzo totale da pagare

				int scelta = JOptionPane.showOptionDialog(null, panel, "Selezionare tipo pagamento",
						JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, options1, null);
				if (scelta == 1) {  //se la scelta è 1 pago in contanti

					GestorePagamento.setPagamentoStrategy(Numero.CONTANTI, Home.getUsername(), idTorneo); //qui richiamo il pattern strategy per effettuare il pagamento
					int res = JOptionPane.showOptionDialog(panel,
							"Pagamento di " + prezzo + " in contanti effettuato", null,
							JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
					if (res == JOptionPane.OK_OPTION) {
						
						

					}
				}
				if (scelta == 2) {
					GestorePagamento.setPagamentoStrategy(Numero.BANCOMAT, Home.getUsername(), idTorneo);
					int res = JOptionPane.showOptionDialog(panel,
							"Pagamento di " + prezzo + " in bancomat effettuato", null,
							JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
					if (res == JOptionPane.OK_OPTION) {
					
						
					}
				}
				if (scelta == 3) {

					GestorePagamento.setPagamentoStrategy(Numero.CARTA_CREDITO, Home.getUsername(), idTorneo);
					int res = JOptionPane.showOptionDialog(panel,
							"Pagamento di " + prezzo + "â‚¬ in carta di credito effettuato", null,
							JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
					if (res == JOptionPane.OK_OPTION) {
	
						
					}
				}

			}
		});
		JButton btnLogOut = new JButton("INDIETRO"); 
		btnLogOut.setForeground(new Color(0, 204, 255));
		btnLogOut.setBackground(new Color(255, 255, 255));

		btnLogOut.setBounds(20, 316, 117, 29);

		panelTornei.add(btnLogOut);

		btnLogOut.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				MenuUtente menu = new MenuUtente();
				menu.main(null);
				CercaTornei.this.dispose();

			}

		});

	}
}
