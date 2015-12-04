package chat.model;

import java.util.ArrayList;

/**
 * Base version of the 2015 Chatbot class. Only stub methods are provided. Students will complete methods as part
 * of the project.
 * @author Gabe Aguilar
 * @version 1.2 10/21/15 Completed the lengthChecker method. Fixed the Constructor and getter for userName
 */
public class Chatbot
{
	private ArrayList<String> memeList;
	private ArrayList<String> politicalTopicList;
	private String userName;
	private String content;
	
	/**
	 * Creates an instance of the Chatbot with the supplied username.
	 * @param userName The username for the chatbot.
	 */
	public Chatbot(String userName)
	{
		this.userName = userName;
		this.memeList = new ArrayList<String>();
		this.politicalTopicList = new ArrayList<String>();
		this.content = "Motivational";
		
	}
	
	private void buildMemeList()
	{
		this.memeList.add("cute animals");
		this.memeList.add("doge");
		this.memeList.add("troll");
		this.memeList.add("unhelpful highschool teacher");
		this.memeList.add("spoderman");
		this.memeList.add("");
		this.memeList.add("bad luck brian");
		this.memeList.add("aliens");
		this.memeList.add("john cena");
		this.memeList.add("gaben");
	}
	
	private void buildPoliticalTopicsList()

	{
	this.politicalTopicList.add("trump");
	this.politicalTopicList.add("election");
	this.politicalTopicList.add("democrat");
	this.politicalTopicList.add("republican");
	this.politicalTopicList.add("liberal");
	this.politicalTopicList.add("conservative");
	this.politicalTopicList.add("clinton");
	this.politicalTopicList.add("biden");
	this.politicalTopicList.add("carson");
	this.politicalTopicList.add("rubio");
	this.politicalTopicList.add("fiorina");
	this.politicalTopicList.add("sanders");
	this.politicalTopicList.add("vote");
	this.politicalTopicList.add("11/8/2016");
	}
	
	/**
	 * Checks the length of the supplied string. Returns false if the supplied String is empty or null,
	 * otherwise returns true. 
	 * @param currentInput
	 * @return A true or false based on the length of the supplied String.
	 */
	public boolean lengthChecker(String currentInput)
	{
		boolean hasLength = false;
		if(currentInput != null && currentInput.length() > 0)
		{
			hasLength = true;
		}
		return hasLength;
	}
	
	/**
	 * Checks if the supplied String matches the content area for this Chatbot instance.
	 * @param currentInput The supplied String to be checked.
	 * @return Whether it matches the content area.
	 */
	public boolean contentChecker(String currentInput)

	{
		Boolean hasContent = false;
		if(currentInput.toLowerCase().contains(content.toLowerCase()))
		{
			hasContent = true; 
		}
		return hasContent;
	}
	public boolean quitChecker(String currentInput)
	{
		Boolean didQuit = false;
		if (currentInput.equals("quit"))
		{
			didQuit = true;
		}
		
		return didQuit;
	}
	
	public boolean KeyboardMashChecker(String currentInput)
	{
		boolean mashTyping = false;
		if(currentInput.equals("sdf"))
		{
			mashTyping = true;
		}
		return mashTyping;
	}
	/**
	 * Checks if supplied String matches ANY of the topics in the politicalTopicsList. Returns
	 * true if it does find a match and false if it does not match.
	 * @param currentInput The supplied String to be checked.
	 * @return Whether the String is contained in the ArrayList.
	 */
	public boolean politicalTopicChecker(String currentInput)
	{
		boolean hasTopic = false;
		
		for(String currentTopic: politicalTopicList)
		{
			if(currentTopic.equalsIgnoreCase(currentInput))
			{
				hasTopic = true;
			}
		}
		return hasTopic;
	}
	
	
	/**
	 * Checks to see that the supplied String value is in the current memesList variable.
	 * @param currentInput The supplied String to be checked.
	 * @return Whether the supplied String is a recognized meme.
	 */
	public boolean memeChecker(String currentInput)
	{
		Boolean hasMeme = false;
		
		for (String meme: memeList)
		{
			if (currentInput.toLowerCase().contains(meme.toLowerCase()));
			{
				hasMeme = true;
			}
		}
		return hasMeme;
	}
	
	public boolean keyboardMashChecker(String currentInput) 
	{
		// TODO Auto-generated method stub
		boolean mashTyping = false;
		
		if(currentInput.equals("sdf") || currentInput.equals("dfg") || currentInput.equals("cvb") || currentInput.equals(",./"))
		{
			mashTyping = true;
		} 
		
		return mashTyping;	
	}
	
	/**
	 * Returns the username of this Chatbot instance.
	 * @return The username of the Chatbot.
	 */
	public String getUserName()
	{
		return userName;
	}
	
	/**
	 * Returns the content area for this Chatbot instance.
	 * @return The content area for this Chatbot instance.
	 */
	public String getContent()
	{
		return null;
	}
	
	public String processConversation(String currentInput)
		{
		String nextConversation = "oh, what else are you interested in talking about today?";
		int randomTopic = (int) (Math.random() * 5); //Generates random number between 0-4.
		
		if(keyboardMashChecker(currentInput))
		{
			return "stop mashing the keybaord!!";
		}
		switch (randomTopic)
		{
		case 0:
			if(memeChecker(currentInput))
			{
				nextConversation = "That is a very popular meme this year. What else are you wanting to talk about";
			}
			break;
		case 1:
			if(politicalTopicChecker(currentInput))
			{
				nextConversation = "";
			}
				
			break;
		case 2:
			if(contentChecker(currentInput))
			{
				nextConversation = "some words and question";
			}
			break;
		case 3:
			if(currentInput.length() > 20)
			{
				nextConversation = "some words and question";
			}
			break;
		case 4:
			nextConversation = "some wods and a question";
			break;
		default:
			nextConversation = "The universe has ended sad panda";
			
			break;
		}
		
		return nextConversation;
		
	}

	/**
	 * Getter method for the memesList object.
	 * @return The reference to the meme list.
	 */
	public ArrayList<String> getMemesList()
	{
		return null;
	}
	
	/**
	 * Getter method for the politicalTopicList object.
	 * @return The reference to the political topic list.
	 */
	public ArrayList<String> getPoliticalTopicList()
	{
		return null;
	}
	
	/**
	 * Updates the content area for this Chatbot instance.
	 * @param content The updated value for the content area.
	 */
	public void setContent(String content)
	{
		
	}
}