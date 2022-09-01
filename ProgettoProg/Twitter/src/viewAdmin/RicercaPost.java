package viewAdmin;




import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


import classidb.Database;
import java.awt.Color;




public class RicercaPost {
private JFrame panelRicerca;
private String parola;



public RicercaPost (String parolaR) {
    parola = parolaR;
    initialize ();
}
private void initialize () {
    Database D = Database.getIstance();
    panelRicerca = new JFrame();
    panelRicerca.getContentPane().setBackground(new Color(0, 204, 255));
    panelRicerca.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    panelRicerca.setBounds(100, 100, 530, 390);
    panelRicerca.getContentPane().setLayout(null);
    JLabel labelMenu = new JLabel("Ricerca il post");
    labelMenu.setBounds(187, 10, 200, 60) ;
    JScrollPane scrollPane = new JScrollPane();
    scrollPane.setViewportBorder(new EmptyBorder(0, 1, 0, 0));
    scrollPane.setEnabled(false); 
    scrollPane.setBounds(20, 34, 495, 266);
    panelRicerca.getContentPane().add(scrollPane);
    JTable table = new JTable (D.ricercaHastag(parola));
    table.setBounds(6, 190, 426, -134);
    scrollPane.setViewportView(table);
    scrollPane.setColumnHeaderView(labelMenu);
    panelRicerca.setVisible(true);
    
    
    JButton bottoneBack = new JButton("INDIETRO");
    bottoneBack.setBackground(new Color(255, 255, 255));
    bottoneBack.setForeground(new Color(0, 204, 255));
    bottoneBack.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		MenuAdmin Menu = new MenuAdmin();
    		Menu.setVisible(true);
    		panelRicerca.dispose();
    	}
    });
    bottoneBack.setBounds(195, 313, 117, 29);
    panelRicerca.getContentPane().add(bottoneBack);

}


}
 









