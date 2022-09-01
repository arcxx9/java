package strategy;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import classidb.Database;

import java.sql.*;

/**
 * Contanti e` una semplice classe che implementa l'ovverride del
 * metodo paga (astratto). Si utilizza per il Design Pattern strategy
 */

public class Contanti implements StrategiaPagamento{
	
	@Override
	public void paga(int idTorneo, String username){
		
		Database D = Database.getIstance();
	    
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
		  	D.conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbtwitter?autoReconnect=true&useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","antonio97");
            D.stmt = D.conn.createStatement();           
            D.stmt.executeUpdate
         ( "INSERT INTO `dbtwitter`.`partecipazione` (`idTorneo`, `username`,`metododipagamento`) VALUES ('"+idTorneo+"','"+username+"','Contanti')" );           	
 
	 }catch(ClassNotFoundException e) {
	        System.out.println(e);
	    }
	    catch(SQLException e)
	    {
	        System.out.println(e);
	    }
	}
	
}
