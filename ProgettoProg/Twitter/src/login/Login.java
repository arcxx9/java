package login;

import java.sql.DriverManager;




import java.sql.SQLException;

 

import classidb.Database;

 

 

/**  Questa classe viene invocata nell'autenticazione all'avvio del programma
 * Contiene il design pattern Singleton
 * @author Sommella Antonio e Di Donna Alessandro */

 

public class Login {

 

    private static Login istance = null; //Utilizzo del design pattern Singleton
    
    private Login () { //Rendo il costruttore privato per utilizzarlo solo tramite getIstanced

 

    }
    

 

    public static Login getIstanced() {
        if(istance == null) { //se non è ancora stato istanziato
            istance = new Login(); //istanzialo
        }
        return istance; //ritorna l'istanza
    }
    
    
    //Metodo che permette l'autenticazione al database e al programma
    public int autenticazione(String usernameDaVerificare, String passwordDaVerificare) {
        
        boolean esito = false, esitoAdmin = false;
        
        try { 
            Database D = Database.getIstance();
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            D.conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbtwitter?autoReconnect=true&useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","antonio97");
          
            D.stmt = D.conn.createStatement(); 
            D.rs = D.stmt.executeQuery("SELECT * FROM utente"); //faccio una query per vedere tutti gli utenti presenti all'interno del database.
            
            while( (D.rs.next()) && (esito == false) ) { //controllo username e password se sono corrette e se si accede come amministratore o come utente.
                if(D.rs.getString("password").equals(passwordDaVerificare) && D.rs.getString("username").equals(usernameDaVerificare)) {  //controllo username e password inseriti con quelli nel database
                    esito = true;
                    if(D.rs.getInt("admin") == 1) { //questo è l'if per vedere se sei un admin,è booleano,1 se admin,0 se utente.
                        esitoAdmin = true;
                    }
                }          
            }
            
        } catch(ClassNotFoundException e) { 
            System.out.println(e);
        }
        catch(SQLException e){ 
            System.out.println(e);
        }
        
        if(esito == true && esitoAdmin == true) {
            return 1;
        }
        
        if(esito == true && esitoAdmin == false) {
            return 2;
        }
        
        
        return -1;
    }

 


}
