package Bridge;
import java.sql.DriverManager;

import java.sql.SQLException;


import classidb.Database;

public class EmailMessageSender implements MessageSender
{
	public void sendMessage(String message, String userSend, String userReceive)
	{
		
		Database D = Database.getIstance();
		
		try{
		  	Class.forName("com.mysql.cj.jdbc.Driver");
		  	 D.conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbtwitter?autoReconnect=true&useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","antonio97");
            D.stmt = D.conn.createStatement();           
            D.stmt.executeUpdate( "INSERT INTO `dbtwitter`.`messaggi` (`inviato_user`, `ricevuto_user`,`testo`,`tipo`) VALUES ('"+userSend+"','"+userReceive+"','"+message+"','Mail')" );     
	 }catch(ClassNotFoundException e) {
	        System.out.println(e);
	    }
	    catch(SQLException e)
	    {
	        System.out.println(e);
	    }
		System.out.println("'"+message+ "'   : Questo messaggio e` stato inviato tramite Email");
	}

	
	
}
