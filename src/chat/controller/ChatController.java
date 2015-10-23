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
		String userName = display.getChatInput("What is your name?");
		myBot = new Chatbot(userName);
		
	}
	public void start()
	{
		display.displayText("Hello " + myBot.getUserName());
	}
}

