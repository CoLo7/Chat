package chat.controller;

import chat.view.ChatView;
import chat.model.Chatbot; 

/**
 * Application controller for the Chatbot project
 * @author gagu5735
 * @version 1.11 10/21/15 fixed error 
 */


public class ChatController 
{	
	private ChatView display;
	private Chatbot myBot;

	public ChatController()
	{
		display = new ChatView();
		String userName = display.collectUserText("What is your name?");
		myBot = new Chatbot(userName);
		
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
			conversation = display.collectUserText(myBot.processConversation(conversation));
			
		}
	}
	
	private void shutDown()
	{
	
	}

}

