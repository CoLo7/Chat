package chat.view;
import javax.swing.JOptionPane;

public class ChatView 
{
	public void displayText(String ChatInput)
	{
		JOptionPane.showMessageDialog(null, ChatInput);
		
	}
	
	
	public String getChatInput (String currentText)
	{
		String returnedText = "";
		returnedText =  JOptionPane.showInputDialog(null, currentText);
		return returnedText;
	}

}
