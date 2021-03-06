package chat.controller;

import chat.view.ChatFrame;
import chat.view.ChatView;
import chat.model.Chatbot; 

/**
 * Application controller for the Chatbot project
 * @author gagu5735
 * @version 1.11 10/21/15 fixed error 
 */
//Declare Variables 
public class ChatController 
{	
	private Chatbot myBot;
	private ChatView display;
	private ChatFrame baseFrame;
	
//Initialize the Variables
	public ChatController()
	{
		display = new ChatView();
		String userName = display.collectUserText("What is your name?");
		myBot = new Chatbot(userName);
		baseFrame = new ChatFrame(this);
		
	}
	//Displays popup asking user for name
	public void start()
	
	{
		display.displayText("Hello " + myBot.getUserName());
		chat();
	}
	
	private void chat()
	{
		//String conversation = display.collectUserText("What would you like to talk about today?");
		//while(myBot.lengthChecker(conversation))
		//{
		//	conversation = myBot.processConversation(conversation);
		//	conversation = display.collectUserText(myBot.processConversation(conversation));
		//	
		//}
	}
	//sees if user wanted to quit and if they do it shutsdown if not then it jumps to the processConversation method.
	public String userToChatbot(String conversation)
	{
		String response = "";
		
		if(myBot.quitChecker(conversation))
		{
			shutDown();
		
		}
		
		response = myBot.processConversation(conversation);
		
		return response;
	}
	//If user types in quit then it displays goodbye it has been a pleasure and then will exit
	private void shutDown()
	{
		display.displayText("goodbye, " + myBot.getUserName() + " it has been a pleasure good sir/miss");
		System.exit(0);
	}

	public Chatbot getChatbot() 
	{
		return myBot;
	}
	public ChatView getChatView() 
	{
		return display;
	}
	public ChatFrame getBaseFrame() 
	{
		return baseFrame;
	}
	
	public void setMyBot(Chatbot myBot) 
	{
		this.myBot = myBot;
	}
	
	public void setDisplay(ChatView display) 
	{
		this.display = display;
	}
	
	public void setBaseFrame(ChatFrame baseFrame) 
	{
		this.baseFrame = baseFrame;
	}
	
}

