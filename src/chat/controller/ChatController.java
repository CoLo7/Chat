package chat.controller;

import chat.view.ChatFrame;
import chat.view.ChatView;
import chat.model.Chatbot; 

/**
 * Application controller for the Chatbot project
 * @author gagu5735
 * @version 1.11 10/21/15 fixed error 
 */

public class ChatController 
{	
	private Chatbot myBot;
	private ChatView display;
	private ChatFrame baseFrame;
	

	public ChatController()
	{
		display = new ChatView();
		String userName = display.collectUserText("What is your name?");
		myBot = new Chatbot(userName);
		baseFrame = new ChatFrame(this);
		
	}
	public void start()
	{
		display.displayText("Hello " + myBot.getUserName());
		chat();
	}
	
	private void chat()
	{
		String conversation = display.collectUserText("What would you like to talk about today?");
		while(myBot.lengthChecker(conversation))
		{
			conversation = myBot.processConversation(conversation);
			conversation = display.collectUserText(myBot.processConversation(conversation));
			
		}
	}
	
	private void shutDown()
	{
		display.displayText("goodbye, " + myBot.getUserName() + " it has been a pleasure good sir/miss");
		System.exit(0);
	}

	public Chatbot getChatbot()
	{
		return myBot;
	}
	
	public Chatbot setChatbot()
	{
		return myBot;
	}
}

