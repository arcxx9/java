package Bridge;


abstract class Message
{
	protected MessageSender messageSender;

	abstract public void sendMessage(String message, String userSend, String userReceive);

}
