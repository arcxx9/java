package mediator;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import classidb.Database;
import classidb.Post;

public class UserImpl extends User {
	public UserImpl(ChatMediator med, String string) {
		super(med, string);
	}

	@Override
	public void send(String msg, String pubblicato) {
		Database D = Database.getIstance();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			D.conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/dbtwitter?autoReconnect=true&useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
					"root", "antonio97");
			D.stmt = D.conn.createStatement();
			D.stmt.executeUpdate("INSERT INTO `dbtwitter`.`post` ( `testo`,`pubblicato`) VALUES ('#'"+" '"  + msg + "','" + pubblicato + "')");

		} catch (ClassNotFoundException e) {
			System.out.println(e);
		} catch (SQLException e) {
			System.out.println(e);
		}
		System.out.println(this.name + ": Scrive il post=" + msg);
		mediator.sendMessage(msg, this);

	}

	@Override
	public void receive(String msg) {
		System.out.println(this.name + ": Riceve il post:" + msg);
	}
}
