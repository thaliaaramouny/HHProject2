package package_game;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GUI implements ActionListener 
{

	JFrame window;
	JPanel titleScreen, startButtonScreen, textPanel, choicePanel, statsPanel;
	JLabel title, timerLabel, timerCount, healthLabel, healthCount;
	JButton startButton, move1, move2;
	ButtonGroup bg1;
	JTextArea textArea;
	Font titleFont, headerFont, buttonFont;
	Font textFont, textFont1;
    JTextField text = new JTextField(20);
    Image hh;

	
	public void createGUI() 
	{
		/////WINDOW/////
		window = new JFrame("Horror House Game");
		
		//size of window
		final int WINDOW_WIDTH = 800;
		final int WINDOW_HEIGHT = 600;
	
		// set the size of frame/window
		window.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		
		// set the program to end when the window is closed
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//setting background color
		window.getContentPane().setBackground(Color.BLACK);
		
		//setting layout of window
		window.setLayout(null);
	
		/////Creating stats panel////
		statsPanel = new JPanel();
		statsPanel.setBounds(100,15,600,50);
		statsPanel.setBackground(Color.black);
		statsPanel.setLayout(new GridLayout(1,4));
		window.add(statsPanel);
		
		//creating timer labels and health labels
		//creating timer label
		timerLabel = new JLabel("Timer: ");
		timerLabel.setFont(headerFont);
		timerLabel.setForeground(Color.white);
		statsPanel.add(timerLabel);
		
		//to display timer count after timerlabel:
		timerCount = new JLabel();		
		timerCount.setFont(headerFont);
		timerCount.setForeground(Color.white);
		statsPanel.add(timerCount);
		
		//creating health label 
		healthLabel = new JLabel("Health: ");
		healthLabel.setFont(headerFont);
		healthLabel.setForeground(Color.white);
		statsPanel.add(healthLabel);
		//to display health value after label:
		healthCount = new JLabel();
		healthCount.setFont(headerFont);
		healthCount.setForeground(Color.white);
		statsPanel.add(healthCount);
		
		//making window visible
		window.setVisible(true);
		
		///// Title Screen /////
		titleScreen = new JPanel();
		//customizing size and background
		titleScreen.setBounds(100, 100, 600,500);
		titleScreen.setBackground(Color.black);
		//creating title
		title = new JLabel("Horror House");
		title.setForeground(Color.white);
		//creating custom fonts to use
		titleFont = new Font("Times New Roman", Font.BOLD, 90);
		textFont = new Font("Lucida Handwriting", Font.PLAIN, 26);
		//setting font and adding to panel
		title.setFont(titleFont);
		titleScreen.add(title);
		
		// creating startButtonScreen
		startButtonScreen = new JPanel();
		startButtonScreen.setBounds(300,400,200,100);
		startButtonScreen.setBackground(Color.black);
		//creating startButton
		startButton = new JButton("PLAY");
		startButton.setBackground(Color.black);
		startButton.setForeground(Color.red);
		startButton.setFont(textFont);
		startButton.setFocusPainted(false);
		
		//adding button to buttonScreen
		startButtonScreen.add(startButton);
		
		//adding title panel and start button panel to window
		window.add(titleScreen);
		window.add(startButtonScreen);
		startButton.addActionListener(this);
	
		
		//////creating GAME SCREEN//////
		headerFont = new Font("Times New Roman", Font.BOLD, 21);
		textFont1 = new Font("Lucida Handwriting", Font.PLAIN, 18);
		buttonFont = new Font("Times New Roman", Font.BOLD, 18);
		//creating the text panel
		textPanel = new JPanel();
		textPanel.setBounds(100,100, 600, 250);
		textPanel.setBackground(Color.black);
		window.add(textPanel);
		
		textArea = new JTextArea("A child shows up at a house on Halloween eve, for trick or treating.\n"
				+ "A large wooden door is in front of the child.\n"
				+ "The child knocks on the door.\n"
				+ "The door opens slowley.\n");
		textArea.setBounds(100,100,600,250);
		textArea.setBackground(Color.black);
		textArea.setForeground(Color.white);
		textArea.setFont(textFont1);
		///what are these?
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		textArea.setEditable(false);
		textPanel.add(textArea);
		textPanel.setVisible(false);
		
		//creating the button panel
		choicePanel = new JPanel();
		choicePanel.setBounds(250,350, 300, 150);
		choicePanel.setBackground(Color.black);
		choicePanel.setLayout(new GridLayout(4,1));
		choicePanel.setVisible(false);
		window.add(choicePanel);
		
		//creating buttons for player moves
		// BUTTON 1
		move1 = new JButton("Enter the house.");
		move1.setFont(buttonFont);
		move1.setForeground(Color.red);
		choicePanel.add(move1);
		
		//RADIO BUTTON 2
		move2 = new JButton("Turn around and leave.");
		move2.setFont(buttonFont);
		move2.setForeground(Color.white);
		choicePanel.add(move2);
		
		//adding ActionListener to buttons
		move1.addActionListener(this);
		move2.addActionListener(this);
		
		//creating ButtonGroup for JRadioButtons
		bg1 = new ButtonGroup();
		bg1.add(move1);
		bg1.add(move2);
		
	}
		
		//EventHandler for start button
		@Override
		   public void actionPerformed(ActionEvent start)
		   {
			textPanel.setVisible(true);
			choicePanel.setVisible(true);
		    window.remove(startButtonScreen);
		    window.add(textPanel);
		    window.add(choicePanel);
		    window.validate();
		   }
}
			
