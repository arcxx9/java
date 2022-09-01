package classidb;



/**
 * Classe corrispondente della tabella Torneo nel database.
 	 */

public class Torneo {
	private String data;
	private float prezzo;
	private int idgioco;
	
	
	public Torneo(String data, int idgioco, float prezzo) {
		this.data = data;
		this.prezzo = prezzo;
		this.idgioco = idgioco;
		
		
	}
	
	
	public String getData() {
		return this.data;
	}
	public float getPrezzo() {
		return this.prezzo;
	}
	public int getIdGioco () {
		return this.idgioco;
	}
	
		
	public Torneo(Torneo T) {
		this.data = T.data;
		this.prezzo = T.prezzo;
		this.idgioco = T.idgioco;
		
	}

	@Override
	public String toString() {
		return data +" | " + prezzo;
	}
	
	
	
}
