package mediator;

import java.util.ArrayList;

import classidb.Post;

public abstract class User {
protected ChatMediator mediator;
protected String name;
public User(ChatMediator med, String string){
this.mediator=med;
this.name=string;
}
public abstract void send(String msg, String pubblicato);
public abstract void receive(String msg);

}	
