package classidb;

/* Classe corrispondente della tabella Follower nel database.
	 */ 

public class Follower {
	
	private String username;
	private String follow;
	
	public String getUsername() { 
		return this.username;
	
	}
	
	public String getFollow() {
		return this.follow;
		
	}
 
	public Follower (Follower fol) {
		this.username = username;
		this.follow = follow;
	}
	
   public Follower (String username , String follow) {
	   
		this.username = username;
		this.follow = follow;
   }
}
