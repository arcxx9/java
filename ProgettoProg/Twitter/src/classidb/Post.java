package classidb;


/* Classe corrispondente della tabella Post nel database.
	 */

public class Post {
	
	private String username;
	private String testo;
	
	public String getUsername() {
		return this.username;
	
	}
	
	public String getTest() {
		return this.testo;
		
	}
 
	public Post (String username) {
		this.username = username;
		
	}
	
   public Post (String username , String testo) {
	   
		this.username = username;
		this.testo = testo;
   }
}
