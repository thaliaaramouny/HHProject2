package package_game;

import java.awt.BorderLayout;
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

import java.text.DecimalFormat;//new
import java.sql.Time;//new
import javax.swing.Timer;//new

public class GUI 
{
	JFrame window;
	JPanel centerPanel, bottomPanel, textPanel, choicePanel, statsPanel, commentPanel;
	JLabel title, timerLabel, timerCount, healthLabel, healthCount;
	JButton startButton, move1, move2, viewCouch;
	ButtonGroup bg1;
	JTextArea textArea;
	Font titleFont, headerFont, buttonFont;
	Font textFont, textFont1;
//    JTextField text = new JTextField(20);
    Image hh;
//this is all for the Timer
	Timer timer;
    int second, minute;
    String ddSecond, ddMinute;
    DecimalFormat dFormat = new DecimalFormat("00");
    ButtonListener BL = new ButtonListener();
    


	
	public void createGUI() 
	{
		/////WINDOW/////
		window = new JFrame("Horror House Game");
		
		//size of window
		final int WINDOW_WIDTH = 900;
		final int WINDOW_HEIGHT = 600;
	
		// set the size of frame/window
		window.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		window.setResizable(false);
		
		// set the program to end when the window is closed
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//setting background color
		window.getContentPane().setBackground(Color.BLACK);
		
		//layout 
		window.setLayout(new BorderLayout());
		
		//FONTS NEEDED
		headerFont = new Font("Times New Roman", Font.BOLD, 21);
		textFont1 = new Font("Monospaced", Font.PLAIN, 18);
		buttonFont = new Font("Times New Roman", Font.PLAIN, 18);
	
		/////CREATING STATS PANEL/////
		statsPanel = new JPanel();
		statsPanel.setBackground(Color.DARK_GRAY);
		statsPanel.setLayout(new GridLayout(1,2)); //changed
		//creating timer labels and health labels for statsPanel
		//timer label
		timerLabel = new JLabel("Timer: ");
		timerLabel.setFont(headerFont);
		timerLabel.setForeground(Color.white);
		statsPanel.add(timerLabel);
		//to display timer count after timerLabel
		timerCount = new JLabel();		
		timerCount.setFont(headerFont);
		timerCount.setForeground(Color.white);
		statsPanel.add(timerCount);
		
//		
//		//health label 
//		healthLabel = new JLabel("Health: ");
//		healthLabel.setFont(headerFont);
//		healthLabel.setForeground(Color.white);
//		statsPanel.add(healthLabel);
//		//to display health value after label:
//		healthCount = new JLabel();
//		healthCount.setFont(headerFont);
//		healthCount.setForeground(Color.white);
//		statsPanel.add(healthCount);

		
		///// Title Screen /////
		//creating custom fonts to use
		titleFont = new Font("Times New Roman", Font.BOLD, 90);
		textFont = new Font("Lucida Handwriting", Font.PLAIN, 26);
		//creating panel
		centerPanel = new JPanel();
		centerPanel.setBackground(Color.black);
		//creating title to add to center panel
		title = new JLabel("Horror House");
		title.setForeground(Color.white);
		title.setFont(titleFont);
		
		textArea = new JTextArea();
		textArea.setBackground(Color.black);
		textArea.setForeground(Color.white);
		//add size with scrollbar
		textArea.setFont(textFont1);
		textArea.setEditable(false);
		//adding to centerPanel
		centerPanel.add(title);
		
		// creating startButtonScreen
		bottomPanel = new JPanel();
		bottomPanel.setBackground(Color.black);
		
		//creating startButton to add in bottomPanel
		startButton = new JButton("PLAY");
		startButton.setBackground(Color.black);
		startButton.setForeground(Color.RED);
		startButton.setFont(textFont);
		startButton.addActionListener(BL);
		//adding components to bottomPanel
		bottomPanel.add(startButton);

		//adding panels to window
		window.add(bottomPanel,BorderLayout.SOUTH);
		window.add(centerPanel,BorderLayout.CENTER);
		window.add(statsPanel, BorderLayout.NORTH);
	
		//////creating GAME SCREEN//////
		//creating buttons for player moves
		//BUTTON 1
		move1 = new JButton("Enter the house.");
		move1.setBackground(Color.DARK_GRAY);
		move1.setFont(buttonFont);
		move1.setForeground(Color.white);
		
		
		//BUTTON 2
		move2 = new JButton("Turn around and leave.");
		move2.setBackground(Color.DARK_GRAY);
		move2.setFont(buttonFont);
		move2.setForeground(Color.white);

		//BUTTON 3
		viewCouch = new JButton("View Couch");
		viewCouch.setBackground(Color.DARK_GRAY);
		viewCouch.setFont(buttonFont);
		viewCouch.setForeground(Color.white);
//		bottomPanel.add(viewCouch); //add this in button listener

		//adding ActionListener to buttons
		move1.addActionListener(BL);
		move2.addActionListener(BL);
		viewCouch.addActionListener(BL);
		
		//making window visible
		window.setVisible(true);
		
	}
	
	//button listener for all buttons
	private class ButtonListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			if (e.getSource() == startButton) 
			{
				title.setVisible(false);
				startButton.setVisible(false);
				centerPanel.add(textArea);
				
				bottomPanel.add(move1);
				bottomPanel.add(move2);
				textArea.setText("A child shows up at a house on Halloween eve, for trick or treating.\n"
				+ "A large wooden door is in front of the child.\n"
				+ "The child knocks on the door.\n"
				+ "The door opens slowley.\n");
				
//				add image1 in centerPanel
			}
			
			if(e.getSource() == move1)
			{
			textArea.setText("the Child walks inside. \n"
					+"The door closes behind him.\n"
					+"The child screams and looks around the room panicked and scared.\n"
					+"As the child turns around he sees a keypad with the digits 1-9.\n"
					+"An Over-head speaker starts to speak, and he hears.\n"
					+"WELCOME YOUNG ONE. YOU HAVE ENTERED MY HORROR HOUSE, FILLED WITH MANY SCARY ITEMS.\n " 
					+ "AS I SPEAK THE HOUSE IS BEING PUMPED WITH NITROUS OXIDE. YOU WILL DIE IN EXACTLY 15 MINUTES. \n"
					+"'HAHAHA'"
					+"'FIND THEM FAST AND INPUT YOUR CODE INTO THE KEYPAD'\n"
					+"The child looks around and sees two rooms, one labeled 'LIVING ROOM' and the other 'KITCHEN'\n"
					+"The child decides to go to the 'LIVING ROOM' first.");
			}
			
			if(e.getSource() == move2)
			{
				textArea.setText("YOU SURVIVE");
				bottomPanel.setVisible(false);
			}
			
			if (e.getSource() == viewCouch)
			{
				textArea.setText("Hmm, what is that in the corner of the couch?\n"
				+"The child takes a closer look to see an old crumpled newspaper wedged in between the dirty cushions.\n"
				+"It might have something helpful!\n"
				+ "Its a newspaper stained with bloody fingerprints… \n"
				+"Its title reads “Mad Scientist and his Zombies”, which talks about a mysterious scientist who was trying to bring back his loved ones from the dead, but he accidently brought them back as zombies.\n"
				+"One day his house-lab exploded, and these zombies went loose.\n"
				+"Ever since, he was nowhere to be found. \n" 
				+"The child skims through the rest of the newspaper and sees that the date of the article was published on October 31st, 2020.\n" 
				+"Then he notices that the scientist was 31 years old at the time, and he had created 31 zombies before he disappeared.\n"
				+"Wow… well 31 seems to be an important number here! You might want to hold on to it.");
			}
		}
	
	}

			public void countdownTimer() {
			//(update every 1 sec,)
			timer = new Timer(1000, new ActionListener() 
			{
				public void actionPerformed(ActionEvent e) {
					second--;
					ddSecond = dFormat.format(second);
					ddMinute = dFormat.format(minute);
					timerCount.setText(ddMinute +":"+ddSecond);
					
					if(second == -1) 
					{
						second = 59;
						minute--;
						ddSecond = dFormat.format(second);
						ddMinute = dFormat.format(minute);
						timerCount.setText(ddMinute +":"+ddSecond);
					}
					if(minute==0 && second==0) 
					{
						timer.stop();
					}
				}
			}
			); // <- sad winky face 
		}
}

		
		
		

			
