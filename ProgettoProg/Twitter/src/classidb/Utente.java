package classidb;

/* Classe corrispondente della tabella Utente nel database.
	 */

public class Utente {
	 private String nome;
	    private String cognome;
	    private String username;
	    private String password;
	   
	   
	    public Utente (String nome, String cognome, String username, String password) {
	        this.cognome = cognome;
	        this.nome = nome;
	        this.username=username;
	        this.password=password;
	       
	       
	    }
	   
	    public String getNome() {
	        return this.nome;
	    }
	    public String getCognome() {
	        return this.cognome;
	    }
	    public String getPassword() {
	        return this.password;
	    }
	    public String getUsername() {
	        return this.username;
	    }
	    public Utente (Utente U) {
	        this.nome =nome;
	        this.cognome=cognome;
	        this.username=username;
	        this.password=password;
	       
	    }
	   
	 
	    @Override
	    public String toString() {
	        return nome + "," +cognome;
	    }
	   
	}

