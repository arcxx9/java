package classidb;



/**
 * Classe corrispondente alla 
 * tabella Partecipazione del db.
 */

public class Partecipazione {
	private String Giorno;
	private int idTorneo;
	private String username;
	private float prezzo;
	private String data;
	
		

	public Partecipazione(Partecipazione part) {
		this.Giorno = part.Giorno;
		this.idTorneo = part.idTorneo;
		this.username = part.username;
		this.prezzo = part.prezzo;
		this.data = part.data;
		}
	
	public Partecipazione(String Giorno, int idTorneo, String username, float prezzo, String data) {
		this.Giorno=Giorno;
		this.idTorneo=idTorneo;
		this.username=username;
		this.prezzo=prezzo;
		this.data=data;
	
		
		
	}
		
	
	public String getGiorno() {
		return this.Giorno;
	}
	public int getidTorneo() {
		return this.idTorneo;
	}
	
	public String getUsernameutente() {
		return this.username;
	}
	
	public float getPrezzo() {
		return this.prezzo;
	}
	
	public String getData() {
		return this.data;
		
	}
	
	//@Override
	//public String toString() {
	//	return nomefilm +" | " + nomesala +" | "+ "€ " + prezzo +" | " + Giorno + " | " + nome+" | "+cognome+"";
	


}