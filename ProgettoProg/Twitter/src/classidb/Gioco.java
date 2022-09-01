package classidb;



/* Classe corrispondente della tabella Gioco nel database.
 	 */

public class Gioco {
	private String nomeGioco;
	private String tipo;
	private int idgioco;
	
	
	public Gioco(int idgioco, String nomeGioco, String tipo) {
		this.idgioco = idgioco;
		this.nomeGioco = nomeGioco;
		this.tipo = tipo;
		
		
	}
	
	
	public String getNomeGioco() {
		return this.nomeGioco;
	}
	public String getTipo() {
		return this.tipo;
	}
	public int getIdGioco() {
		return this.idgioco;
	}
	
		
	public Gioco(Gioco G) {
		this.nomeGioco = G.nomeGioco;
		this.tipo = G.tipo;
		
	}

	


	@Override
	public String toString() {
		return  nomeGioco +" | " + tipo;
	}
	
	public int toInt() {
		return idgioco; 
	}
	
	
}
