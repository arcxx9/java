package Bridge;


public class LongMessage extends Message
{

	public LongMessage(MessageSender messageSender)
	{
		super.messageSender = messageSender;
	}

	@Override
	public void sendMessage(String message, String userSend, String userReceive)
	{
		messageSender.sendMessage(message, userSend, userReceive);
	}

}
