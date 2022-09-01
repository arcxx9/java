package mediator;
import java.util.ArrayList;
import java.util.List;
public class ChatMediatorImpl implements ChatMediator {
private List<User> users; //dichiara una lista di utenti.
  public ChatMediatorImpl(){
  this.users=new ArrayList<>(); 
  }
  @Override
  public void addUser(User user){ //metodo per aggiungere gli utenti al database
  this.users.add(user);
  }
  @Override
  public void sendMessage(String msg, User user) { //metodo che invia i messaggi
	for(User u : this.users){ //Aggiungi user alla lista
    // il messaggio non dovrebbe essere ricevuto dall'utente che lo ha inviato
		if(u != user){ //se diverso dall'utente che l'ha inviato allora gli invia il messaggio
		u.receive(msg);
		}
	}
  }
}
