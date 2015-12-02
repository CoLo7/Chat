package chat.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import chat.controller.*;

public class ChatPanel extends JPanel
{
	private ChatController baseController;
	private SpringLayout baseLayout;
	private JButton submitButton;
	private JTextArea chatArea;
	private JTextField typingField;
	private JLabel promptLabel;
	
	public ChatPanel(ChatController baseController)
	{
		this.baseController = baseController;
		baseLayout = new SpringLayout();
		chatArea = new JTextArea(10, 30);
		
		typingField = new JTextField(30);
		
		promptLabel = new JLabel("Chat with me");
		
		submitButton = new JButton("Send your Text the the ChatBot");
		
		
		setupPanel();
		setupLayout();
		setupListeners();
	}
	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.NORTH, chatArea, 35, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.NORTH, typingField, 77, SpringLayout.SOUTH, chatArea);
		baseLayout.putConstraint(SpringLayout.WEST, chatArea, 0, SpringLayout.WEST, typingField);
		baseLayout.putConstraint(SpringLayout.WEST, typingField, 10, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, promptLabel, 30, SpringLayout.SOUTH, chatArea);
		baseLayout.putConstraint(SpringLayout.WEST, promptLabel, 153, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, submitButton, 1, SpringLayout.NORTH, typingField);
		baseLayout.putConstraint(SpringLayout.WEST, submitButton, 24, SpringLayout.EAST, typingField);
	}
	private void setupPanel()
	{
		this.setLayout(baseLayout);
		this.setBackground(Color.MAGENTA);
		this.add(chatArea);
		this.add(typingField);
		this.add(submitButton);
		this.add(promptLabel);
		typingField.setToolTipText("type here for chatbot");
		chatArea.setEnabled(false);
	}
	private void setupListeners()
	{
		submitButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				//Grab user typed answer. Display typed answer. Send text to chatbot. Chatbot will process. Chatbot will respond
				String userText = typingField.getText();
				chatArea.append("\nUser: " + userText);
				typingField.setText("");
				String response = baseController.userToChatbot(userText);
				chatArea.append("\nChatbot: " + response);
			}
		});
	}
	
}
