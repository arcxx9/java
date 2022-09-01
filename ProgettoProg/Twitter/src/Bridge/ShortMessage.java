package Bridge;

import javax.swing.JOptionPane;

public class ShortMessage extends Message
{
	public ShortMessage(MessageSender messageSender)
	{
		super.messageSender = messageSender;
	}
	
	public void sendMessage(String message, String userSend, String userReceive)
	{
		if(message.length()<=5)
		{
			messageSender.sendMessage(message, userSend, userReceive);
		}
		else
		{
		
			System.out.println("Scusa non e` stato possibile inviare il messaggio...");
		}
	}



	

}
