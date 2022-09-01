package classidb;

import java.sql.Connection;


import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import mediator.User;
import view.Home;

public class Database {
	// Definisco pubbliche le variabili di connessione al database
	public Connection conn;
	public Statement stmt;
	public PreparedStatement pstmt;
	public ResultSet rs;

	private static Database istance = null; // Utilizzo del design pattern Singleton
	// Costruttore della classe privato per essere accessibile solo dal metodo
	// getIstance

	protected Database() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	public static Database getIstance() {
		if (istance == null) // Controllo se la classe ancora non è stata istanziata
			istance = new Database(); // Se non è stata istanziata, instanziala
		return istance; // Ritorna l'istanza
	}

	// Apro connessioni al db
	public void openConnection() {
		try {

			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/dbtwitter?autoReconnect=true&useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
					"root", "antonio97");
			stmt = conn.createStatement();
		} catch (SQLException s) {
			System.out.println(s);
		}
	}

	// Chiudo connessioni al db
	public void closeConnection() {
		try {
			conn.close();
			stmt.close();

		} catch (SQLException s) {
			System.out.println(s);
		}

	}

	public void createUser(Utente U) throws SQLIntegrityConstraintViolationException, SQLException { //registrazione utente
		try {
			Class.forName("com.mysql.jdbc.Driver");
			openConnection();

			stmt.executeUpdate("INSERT INTO `dbtwitter`.`utente` (`nome`,`cognome`,`username`,`password`) VALUES ('"
					+ U.getNome() + "','" + U.getCognome() + "','" + U.getUsername() + "','" + U.getPassword() + "');");

			closeConnection();

		} catch (SQLIntegrityConstraintViolationException s) {
			System.out.println(s);
			throw (s);
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {
			throw (e);

		}
	}
	
	public void insertGame (Gioco G) {
		try {
			openConnection();

			stmt.executeUpdate("INSERT INTO `dbtwitter`.`gioco` (`nome`,`tipo`) VALUES ('"
					+ G.getNomeGioco() + "','" + G.getTipo() + "');");

			closeConnection();
		} catch (SQLException e) {
			System.out.println(e);
		}
		
	}
	public ArrayList<Gioco> elencoGioco() {
		ArrayList<Gioco> elencoGioco = new ArrayList<Gioco>();
		try {

			openConnection();
			// Eseguo la query
			rs = stmt.executeQuery("SELECT * FROM gioco");

			// Ciclo fin quando le tuple non sono finite (false)
			while (rs.next() == true) {
				// Instanzio l'oggetto G sovraccaricando il costruttore con i valori presi dalla
				// tabella
				Gioco G = new Gioco(rs.getInt("idgioco"), rs.getString("nome"), rs.getString("tipo"));
				// Inserisco l'oggetto G, appena creato, nell'arraylist elencoGioco
				elencoGioco.add(G);

			}
			closeConnection();

		} catch (SQLException e) {
			System.out.println(e);
		}
		return elencoGioco;
}
public void insertTorneo (Torneo T) {
	try {
		openConnection();

		stmt.executeUpdate("INSERT INTO `dbtwitter`.`torneo` (`idgioco`,`data`,`prezzo`) VALUES ('"
				+ T.getIdGioco() + "','" + T.getData() + "','" + T.getPrezzo() + "');");

		closeConnection();
	} catch (SQLException e) {
		System.out.println(e);
	}
	
}
public DefaultTableModel elencoTornei() {
	Vector<Vector<Object>> data = new Vector<Vector<Object>>();
	Vector<String> columnNames = new Vector<String>();
	try {
		/**
		 * Inizio con la connessione al Database.
		 */
		openConnection();

		// Table tornei

		rs = stmt.executeQuery("SELECT t.idtorneo, g.nome, g.tipo , t.data , t.prezzo  FROM torneo t, gioco g where t.idgioco=g.idgioco");

		ResultSetMetaData metaData = rs.getMetaData();


		int columnCount = metaData.getColumnCount();

		for (int column = 1; column <= columnCount; column++) {

			columnNames.add(metaData.getColumnName(column));

		}

		while (rs.next()) {

			Vector<Object> vector = new Vector<Object>();

			for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {

				vector.add(rs.getObject(columnIndex));

			}

			data.add(vector);

		}

		closeConnection();

	} catch (SQLException e) {

		System.out.println(e);

	}

	return new DefaultTableModel(data, columnNames);

}
	public DefaultTableModel elencoUtenti() {
		Vector<Vector<Object>> data = new Vector<Vector<Object>>();
		Vector<String> columnNames = new Vector<String>();
		try {
			/**
			 * Inizio con la connessione al Database.
			 */
			openConnection();

			// Table utente

			rs = stmt.executeQuery("SELECT username, nome, cognome FROM utente");

			ResultSetMetaData metaData = rs.getMetaData();


			int columnCount = metaData.getColumnCount();

			for (int column = 1; column <= columnCount; column++) {

				columnNames.add(metaData.getColumnName(column));

			}

			while (rs.next()) {

				Vector<Object> vector = new Vector<Object>();

				for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {

					vector.add(rs.getObject(columnIndex));

				}

				data.add(vector);

			}

			closeConnection();

		} catch (SQLException e) {

			System.out.println(e);

		}

		return new DefaultTableModel(data, columnNames);

	}

	public void inserisciFollower(String username, String usernameFollow)
			throws SQLIntegrityConstraintViolationException, SQLException {

		try {
			openConnection();
			stmt.executeUpdate("INSERT INTO `dbtwitter`.`follower` (`username`,`follow`) VALUES ('" + username + "','"
					+ usernameFollow + "');");
			closeConnection();

		} catch (SQLIntegrityConstraintViolationException s) {

			System.out.println(s);
			throw (s);
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	public void rimuoviFollower(String username, String usernameFollow)
			throws SQLIntegrityConstraintViolationException, SQLException {

		try {
			openConnection();
			stmt.executeUpdate ("DELETE FROM `dbtwitter`.`follower` WHERE (`username` = '"+username+"') and (`follow` = '"+usernameFollow+"')");
			closeConnection();

		} catch (SQLIntegrityConstraintViolationException s) {

			System.out.println(s);
			throw (s);
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

public ArrayList<Post> elencoFolPost() {
	ArrayList<Post> elencoFolPost = new ArrayList<Post>();
	
	try {

		openConnection();
		// Eseguo la query
		rs = stmt.executeQuery("SELECT f.username FROM utente u, follower f WHERE u.username=f.follow and f.follow= '" + Home.getUsername() + "';");;

		// Ciclo fin quando le tuple non sono finite (false)
		while (rs.next() == true) {
			Post post = new Post(rs.getString("username"));
			elencoFolPost.add(post);

		}
		closeConnection();
		
		
	} catch (SQLException e) {
		System.out.println(e);
	}
	return elencoFolPost;

}

	public DefaultTableModel ricercaFollower() {
		Vector<Vector<Object>> data = new Vector<Vector<Object>>();
		Vector<String> columnNames = new Vector<String>();
		try {
			/**
			 * Inizio con la connessione al Database.
			 */
			openConnection();

			// Table follower

			rs = stmt.executeQuery("SELECT u.nome, u.cognome, f.follow FROM utente u, follower f WHERE u.username=f.follow and f.username= '" + Home.getUsername() + "';");

			ResultSetMetaData metaData = rs.getMetaData();


			int columnCount = metaData.getColumnCount();

			for (int column = 1; column <= columnCount; column++) {

				columnNames.add(metaData.getColumnName(column));

			}

			while (rs.next()) {

				Vector<Object> vector = new Vector<Object>();

				for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {

					vector.add(rs.getObject(columnIndex));

				}

				data.add(vector);

			}

			closeConnection();

		} catch (SQLException e) {

			System.out.println(e);

		}

		return new DefaultTableModel(data, columnNames);

	}
	public DefaultTableModel ricercaFollow() {
		Vector<Vector<Object>> data = new Vector<Vector<Object>>();
		Vector<String> columnNames = new Vector<String>();
		try {
			/**
			 * Inizio con la connessione al Database.
			 */
			openConnection();

			// Table follower

			rs = stmt.executeQuery("SELECT u.nome, u.cognome, f.username FROM utente u, follower f WHERE u.username=f.follow and f.follow= '" + Home.getUsername() + "';");

			ResultSetMetaData metaData = rs.getMetaData();


			int columnCount = metaData.getColumnCount();

			for (int column = 1; column <= columnCount; column++) {

				columnNames.add(metaData.getColumnName(column));

			}

			while (rs.next()) {

				Vector<Object> vector = new Vector<Object>();

				for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {

					vector.add(rs.getObject(columnIndex));

				}

				data.add(vector);

			}

			closeConnection();

		} catch (SQLException e) {

			System.out.println(e);

		}

		return new DefaultTableModel(data, columnNames);

	}
	public DefaultTableModel iMieiPost(String username) {
		Vector<Vector<Object>> data = new Vector<Vector<Object>>();
		Vector<String> columnNames = new Vector<String>();
		try {
			/**
			 * Inizio con la connessione al Database.
			 */
			openConnection();

			// Table Post

			rs = stmt.executeQuery("SELECT p.testo,f.follow FROM dbtwitter.utente u, dbtwitter.follower f, dbtwitter.post p WHERE u.username=f.follow and f.username= '" + Home.getUsername()+"' AND p.pubblicato=f.follow; ");

			ResultSetMetaData metaData = rs.getMetaData();


			int columnCount = metaData.getColumnCount();

			for (int column = 1; column <= columnCount; column++) {

				columnNames.add(metaData.getColumnName(column));

			}

			while (rs.next()) {

				Vector<Object> vector = new Vector<Object>();

				for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {

					vector.add(rs.getObject(columnIndex));

				}

				data.add(vector);

			}

			closeConnection();

		} catch (SQLException e) {

			System.out.println(e);

		}

		return new DefaultTableModel(data, columnNames);

	}
	
	public DefaultTableModel msgRicevuto(String username) {
		Vector<Vector<Object>> data = new Vector<Vector<Object>>();
		Vector<String> columnNames = new Vector<String>();
		try {
			/**
			 * Inizio con la connessione al Database.
			 */
			openConnection();

			// Table Messaggi

			rs = stmt.executeQuery("SELECT testo, tipo, ricevuto_user FROM dbtwitter.messaggi where inviato_user= '"+ username + "' ");

			ResultSetMetaData metaData = rs.getMetaData();


			int columnCount = metaData.getColumnCount();

			for (int column = 1; column <= columnCount; column++) {
				if ("ricevuto_user".equals(metaData.getColumnName(column))) {
					columnNames.add("Ricevuto Da");
				} else {
					columnNames.add(metaData.getColumnName(column));
				}
			}

			while (rs.next()) {

				Vector<Object> vector = new Vector<Object>();

				for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {

					vector.add(rs.getObject(columnIndex));

				}

				data.add(vector);

			}

			closeConnection();

		} catch (SQLException e) {

			System.out.println(e);

		}

		return new DefaultTableModel(data, columnNames);

	}
	
	
	public DefaultTableModel ricercaHastag(String parola) {

		 Vector<Vector<Object>> data = new Vector<Vector<Object>>();

		 Vector<String> columnNames = new Vector<String>();

		 try {

		/**

		* Inizio con la connessione al Database.

		*/

		 openConnection();

		 // Table Hashtag

		 rs = stmt.executeQuery("SELECT testo, pubblicato FROM dbtwitter.post WHERE testo LIKE '%#"+parola+"%'");
         ResultSetMetaData metaData = rs.getMetaData();

		 int columnCount = metaData.getColumnCount();
         for (int column = 1; column <= columnCount; column++) {
         columnNames.add(metaData.getColumnName(column));

		}

		 while (rs.next()) {
         Vector<Object> vector = new Vector<Object>();
         for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
         vector.add(rs.getObject(columnIndex));

		}

		 data.add(vector);

		}

		 closeConnection();


		 } catch (SQLException e) {

		 System.out.println(e);

		}

		 return new DefaultTableModel(data, columnNames);

		}
	
	public DefaultTableModel ricercaParola(String parola) {

		 Vector<Vector<Object>> data = new Vector<Vector<Object>>();

		 Vector<String> columnNames = new Vector<String>();

		 try {

		/**

		* Inizio con la connessione al Database.

		*/

		 openConnection();

		 // Table Parola

		 rs = stmt.executeQuery("SELECT inviato_user,ricevuto_user,testo,tipo FROM dbtwitter.messaggi WHERE testo LIKE '%"+parola+"%'");
         ResultSetMetaData metaData = rs.getMetaData();

		 int columnCount = metaData.getColumnCount();
         for (int column = 1; column <= columnCount; column++) {
         columnNames.add(metaData.getColumnName(column));

		}
		 
         while (rs.next()) {
         Vector<Object> vector = new Vector<Object>();
         for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
		 vector.add(rs.getObject(columnIndex));


		}

		 data.add(vector);

		}


		 closeConnection();
		 

		 } catch (SQLException e) {
 

		 System.out.println(e);
		 

		}


		 return new DefaultTableModel(data, columnNames);

		}

}
