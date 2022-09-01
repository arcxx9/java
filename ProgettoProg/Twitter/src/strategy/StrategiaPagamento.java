package strategy;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * StrategiaPagamento è una interfaccia che ha soltanto un metodo.
 * Ogni classe che estende questa interface, implementa l'override
 */

public interface StrategiaPagamento {
	
	 public void paga(int idTorneo, String username);
	
}