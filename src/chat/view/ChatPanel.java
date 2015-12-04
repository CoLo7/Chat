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
	private JButton resetButton;
	private JTextArea chatArea;
	private JTextField textField;
	private JLabel promptLabel;
	
	public ChatPanel(ChatController baseController)
	{
		this.baseController = baseController;
		baseLayout = new SpringLayout();
		chatArea = new JTextArea(10, 30);
		
		textField = new JTextField(30);
		
		promptLabel = new JLabel("Chat with me");
		baseLayout.putConstraint(SpringLayout.SOUTH, promptLabel, -6, SpringLayout.NORTH, textField);
		
		
		
		submitButton = new JButton("Send Text ChatBot");
		
		resetButton = new JButton("Reset Chatbot");
	
		setupPanel();
		setupLayout();
		setupListeners();
	}
	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.NORTH, promptLabel, -22, SpringLayout.NORTH, textField);
		baseLayout.putConstraint(SpringLayout.EAST, promptLabel, 316, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.WEST, promptLabel, 233, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, textField, 260, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, chatArea, -155, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, chatArea, 10, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.EAST, chatArea, -10, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.WEST, textField, 0, SpringLayout.WEST, chatArea);
		baseLayout.putConstraint(SpringLayout.EAST, textField, 0, SpringLayout.EAST, chatArea);
		baseLayout.putConstraint(SpringLayout.EAST, submitButton, 0, SpringLayout.EAST, chatArea);
		baseLayout.putConstraint(SpringLayout.NORTH, submitButton, 0, SpringLayout.NORTH, resetButton);
		baseLayout.putConstraint(SpringLayout.NORTH, resetButton, 32, SpringLayout.SOUTH, textField);
		baseLayout.putConstraint(SpringLayout.WEST, resetButton, 0, SpringLayout.WEST, chatArea);
		baseLayout.putConstraint(SpringLayout.NORTH, chatArea, 10, SpringLayout.NORTH, this);
	}
	private void setupPanel()
	{
		this.setLayout(baseLayout);
		this.setBackground(Color.MAGENTA);
		this.add(chatArea);
		this.add(textField);
		this.add(submitButton);
		this.add(resetButton);
		this.add(promptLabel);
		textField.setToolTipText("type here for chatbot");
		chatArea.setEnabled(false);
	}
	private void setupListeners()
	{
		submitButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				//Grab user typed answer. Display typed answer. Send text to chatbot. Chatbot will process. Chatbot will respond
				String userText = textField.getText();
				chatArea.append("\nUser: " + userText);
				textField.setText("");
				String response = baseController.userToChatbot(userText);
				chatArea.append("\nChatbot: " + response);
			}
		});
		
		resetButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				//Reset the ChatBot window
				chatArea.setText("");
			}
		});
	}
	

	public JTextField getTextField()
	{
		return textField;
	}

	public void setChatTextField(JTextField chatTextField)
	{
		this.textField = chatTextField;
	}
}
