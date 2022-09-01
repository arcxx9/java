package strategy;

import enumerazione.Enum;

/**
 * Classe che dalla enumerazione invoca il metodo corrispondente.
 * Utilizza il pattern design strategy
 */

public class GestorePagamento {
	public static StrategiaPagamento setPagamentoStrategy(Enum Enum, String username, int idTorneo){
		
		StrategiaPagamento strategy=null;

			switch(Enum){
				case CONTANTI:
						strategy = new Contanti(); 
						strategy.paga(idTorneo, username);
					break;
				case BANCOMAT:
						strategy = new Bancomat();
						strategy.paga(idTorneo, username);
					break;	
				case CARTA_CREDITO:
						strategy = new CartadiCredito();
						strategy.paga(idTorneo, username);
					break;		
			}
			return strategy;
		}
}
