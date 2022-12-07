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
import javax.swing.ImageIcon;

import java.text.DecimalFormat;//new
import java.sql.Time;//new
import javax.swing.Timer;//new

public class GUI 
{
	JFrame window;
	JPanel centerPanel, bottomPanel, textPanel, choicePanel, statsPanel, commentPanel,buttonPanel;
	JPanel imagePanel, imagePanel2, imagePanel3, imagePanel4, imagePanel5, imagePanel6, imagePanel7, imagePanel8, imagePanel9, imagePanel10, imagePanel11;
	JLabel title, timerLabel, timerCount, healthLabel, healthCount, img1, img2, img3, img4, img5, img6, img7, img8, img9, img10, img11, img12, pinLabel;
	JTextField txt1;
	JButton startButton, move1, move2, viewCouch, skipCouch, enterKitchen, viewDrawer, readSheet, pickUpBook, enterPin;
	ButtonGroup bg1;
	JTextArea textArea;
	JTextField pin; //for pin
	Font titleFont, headerFont, buttonFont;
	Font textFont, textFont1, textFont2;
//JTextField text = new JTextField(20);
    ImageIcon icon, icon1, newImage, image;
//this is all for the Timer
	Timer timer;
    int second, minute;
    //these are the names of string
    String stringSecond, stringMinute;
	int correctPin, userPin;
    DecimalFormat dFormat = new DecimalFormat("00");
    
    ButtonListener BL = new ButtonListener();
    textFieldListener TF = new textFieldListener();
	public void createGUI() 
	{
		/////WINDOW/////
		window = new JFrame("Horror House Game");
		
		//size of window
		final int WINDOW_WIDTH = 880;
		final int WINDOW_HEIGHT = 820;
	
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
		textFont2 = new Font("Monospaced", Font.PLAIN, 15);
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
		timerCount.setText("3:00");
		second =0;
		minute =3;
		statsPanel.add(timerCount);
		timerCount.setText("03:00");//new
		second = 0; //new
		minute = 3; //new
		
		/////IMAGES/////
		//Start screen image
		img1 = new JLabel();
		img1.setIcon(new ImageIcon("Images/House.png"));
		//Door image
		img2 = new JLabel();
		img2.setIcon(new ImageIcon("Images/frontDoor.png"));
		//LR image
		img3 = new JLabel();
		img3.setIcon(new ImageIcon("Images/LivingRoom.png"));
		//Close up couch 
		img4 = new JLabel();
		img4.setIcon(new ImageIcon("Images/Couch.png"));
		//Newspaper
		img5 = new JLabel();
		img5.setIcon(new ImageIcon("Images/note.png"));
		//Kitchen
		img6 = new JLabel();
		img6.setIcon(new ImageIcon("Images/KitchenDoor.png"));
		//Zoom in drawer 
		img7 = new JLabel();
		img7.setIcon(new ImageIcon("Images/Cabinate.png"));
		//Book
		img8 = new JLabel();
		img8.setIcon(new ImageIcon("Images/Drawer.png"));
		//Formula Sheet
		img9 = new JLabel();
		img9.setIcon(new ImageIcon(""));
		//Exit Door 
		img10 = new JLabel();
		img10.setIcon(new ImageIcon("Images/ExitDoor.png"));
		
		
		
		
		//image panel1
		imagePanel= new JPanel();
		imagePanel.add(img2);
		imagePanel.setBackground(Color.black);
		//image panel 2
		imagePanel2 = new JPanel();
		imagePanel2.add(img3);
		imagePanel2.setBackground(Color.black);
		//image panel 3
		imagePanel3 = new JPanel();
		imagePanel3.add(img4);
		imagePanel3.setBackground(Color.black);
//		//image panel 4
		imagePanel4 = new JPanel();
		imagePanel4.add(img5);
		imagePanel4.setBackground(Color.black);
		//image panel 5
//		imagePanel5 = new JPanel();
//		imagePanel5.add(img6);
//		imagePanel5.setBackground(Color.black);
//		//image panel 5
//		imagePanel6 = new JPanel();
//		imagePanel6.add(img7);
//		imagePanel6.setBackground(Color.black);
//		//image panel 2
//		imagePanel7 = new JPanel();
//		imagePanel7.add(img8);
//		imagePanel7.setBackground(Color.black);
//		//image panel 3
//		imagePanel8 = new JPanel();
//		imagePanel8.add(img9);
//		imagePanel8.setBackground(Color.black);
//		//image panel 4
//		imagePanel9 = new JPanel();
//		imagePanel9.add(img10);
//		imagePanel9.setBackground(Color.black);
//		//image panel 5
//		imagePanel10 = new JPanel();
//		imagePanel10.add(img11);
//		imagePanel10.setBackground(Color.black);
//		//image panel 5
//		imagePanel11 = new JPanel();
//		imagePanel11.add(img12);
//		imagePanel11.setBackground(Color.black);
		
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
		centerPanel.add(img1);
		
		// creating startButtonScreen
		bottomPanel = new JPanel();
		bottomPanel.setBackground(Color.black);
		
		//creating startButton to add in bottomPanel
		startButton = new JButton("PLAY");
		startButton.setBackground(Color.black);
		startButton.setForeground(Color.RED);
		startButton.setFont(textFont);
		
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
		move1.setBackground(Color.black);
		move1.setFont(buttonFont);
		move1.setForeground(Color.red);
		
		
		//BUTTON 2
		move2 = new JButton("Turn around and leave.");
		move2.setBackground(Color.black);
		move2.setFont(buttonFont);
		move2.setForeground(Color.red);

		//BUTTON 3
		viewCouch = new JButton("View Couch");
		viewCouch.setBackground(Color.black);
		viewCouch.setFont(buttonFont);
		viewCouch.setForeground(Color.red);
		viewCouch.setVisible(false);
		bottomPanel.add(viewCouch);
		
		//From couch to kitchen 
		enterKitchen = new JButton("Enter Kitchen");
		enterKitchen.setBackground(Color.black);
		enterKitchen.setFont(buttonFont);
		enterKitchen.setForeground(Color.red);
		enterKitchen.setVisible(false);
		bottomPanel.add(enterKitchen);
		
		//button 5
		viewDrawer = new JButton("View Drawer");
		viewDrawer.setBackground(Color.black);
		viewDrawer.setFont(buttonFont);
		viewDrawer.setForeground(Color.red);
		viewDrawer.setVisible(false);
		bottomPanel.add(viewDrawer);
		
		//button6
		readSheet = new JButton("Read formula sheet");
		readSheet.setBackground(Color.black);
		readSheet.setFont(buttonFont);
		readSheet.setForeground(Color.red);
		readSheet.setVisible(false);
		bottomPanel.add(readSheet);
		
		//button 7
		pickUpBook = new JButton("Pick up book");
		pickUpBook.setBackground(Color.black);
		pickUpBook.setFont(buttonFont);
		pickUpBook.setForeground(Color.red);
		pickUpBook.setVisible(false);
		bottomPanel.add(pickUpBook);
		
		//final button
		enterPin = new JButton("ENTER PIN");
		enterPin.setBackground(Color.black);
		enterPin.setFont(buttonFont);
		enterPin.setForeground(Color.red);
		enterPin.setVisible(false);
		bottomPanel.add(enterPin);
		
		//pin related stuff
		correctPin = 314;
		pinLabel = new JLabel("Enter your 3-digit code here: ");
		pinLabel.setFont(textFont1);
		pinLabel.setForeground(Color.white);
		pin = new JTextField("",10);
		pin.setVisible(false);
		bottomPanel.add(pinLabel);
		pinLabel.setVisible(false);
		bottomPanel.add(pin);
		pin.addActionListener(TF);
		
		//adding ActionListener to buttons
		startButton.addActionListener(BL);
		move1.addActionListener(BL);
		move2.addActionListener(BL);
		viewCouch.addActionListener(BL);
		enterKitchen.addActionListener(BL);
		viewDrawer.addActionListener(BL);
		readSheet.addActionListener(BL);
		pickUpBook.addActionListener(BL);
		enterPin.addActionListener(BL);
		
		//
		
	
		//making window visible
		window.setVisible(true);
		
	}
	
	

	
	//button listener for all buttons
	private class ButtonListener implements ActionListener
	{
///////////////////////////////////////////////////////////////////
		
		public void countdownTimer() 
		{
		//(update every 1 sec,)
		timer = new Timer(1000, new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				second--;
				stringSecond = dFormat.format(second);
				stringMinute = dFormat.format(minute);
				timerCount.setText(stringMinute +":"+stringSecond);
				
				if(second == -1) 
				{
					second = 59;
					minute--;
					stringSecond = dFormat.format(second);
					stringMinute = dFormat.format(minute);
					timerCount.setText(stringMinute +":"+stringSecond);
				}
				
				if(minute==0 && second==0) 
				{
					timer.stop();
				}
			}
		}
		
		); // <- sad winky face 

		}
		
///////////////////////////////////////////////////////////////////

		@Override
		public void actionPerformed(ActionEvent e)
		{
			if (e.getSource() == startButton) 
			{
				countdownTimer();//new
				timer.start();//new
				window.remove(centerPanel);
				window.add(imagePanel);
				startButton.setVisible(false);
				title.setVisible(false);
				imagePanel.add(textArea);
				bottomPanel.add(move1);
				bottomPanel.add(move2);
				textArea.setText("A child shows up at a house on Halloween eve, for trick or treating.\n"
				+ "A large wooden door is in front of the child.\n"
				+ "The child knocks on the door.\n"
				+ "The door opens slowly.\n");
			}
			
			if(e.getSource() == move1)
			{
				//image
				window.remove(imagePanel);
				window.add(imagePanel2);
				imagePanel2.add(textArea);
				
				//buttons
				move1.setVisible(false);
				move2.setVisible(false);
				viewCouch.setVisible(true);
				enterKitchen.setVisible(true);
				
				//text
				textArea.setFont(textFont2);
				textArea.setText("The Child walks inside.The door closes behind him.\n"
					+"The child screams and looks around the room panicked and scared.\n"
					+"As the child turns around he sees a keypad with the digits 1-9.\n"
					+"An Over-head speaker starts to speak, and he hears.\n"
					+"WELCOME YOUNG ONE. YOU HAVE ENTERED MY HORROR HOUSE,\n" 
					+"AS I SPEAK THE HOUSE IS BEING PUMPED WITH NITROUS OXIDE.\n"
					+"YOU WILL DIE IN EXACTLY 15 MINUTES. HAHAHA\n"
					+"'FIND THEM FAST AND INPUT YOUR CODE INTO THE KEYPAD'\n"
					+"The child looks around and realizes he walked straight\n"
					+"into an old dark living room.\n"
					+"He decides to look around for any clues to help him escape.");
				
				
			}
			
			if(e.getSource() == move2)
			{
				move1.setVisible(false);
				move2.setVisible(false);
				textArea.setText("YOU SURVIVE");
				
			}
			
			if (e.getSource() == viewCouch)
			{
				viewCouch.setVisible(false);
				viewCouch.setVisible(false);
				textArea.setFont(textFont1);
				textArea.setText("Hmm, what is that in the corner of the couch?\n"
				+"The child takes a closer look to see an old crumpled newspaper \n"
				+ "wedged in between the dirty cushions.It might have something helpful!\n"
				+ "Its a newspaper stained with bloody fingerprints\n"
				+ "... \n"
				+"Wow, well 31 seems to be an important number here! \n"
				+ "You might want to hold on to it.");
				enterKitchen.setVisible(true);
			}
			
			if (e.getSource() == enterKitchen)
			{
				viewCouch.setVisible(false);
				textArea.setFont(textFont1);
				textArea.setText("The child walks around in the kitchen and sees \n"
						+ "an open junk drawer \n");
				enterKitchen.setVisible(false);
				viewDrawer.setVisible(true);
				
			
			}
			
			if (e.getSource()== viewDrawer) {
				viewDrawer.setVisible(false);
				readSheet.setVisible(true);
				pickUpBook.setVisible(true);
				textArea.setText("The junk drawer is filled with various books,\n"
						+"and sheets and sheets of formulas for\n"
						+"different chemical compounds.");
			}
			
			if (e.getSource()== readSheet) {
				readSheet.setVisible(false);
				textArea.setText("Ahh, chemical compounds and using the scientific method,\n"
						+ " nothing here for you, but you better find a digit\n"
						+ " before you get lightheaded!\n");
				
			}
			
			if(e.getSource() == pickUpBook) {
				pickUpBook.setVisible(false);
				readSheet.setVisible(false);
				textArea.setText("It reads'Evil Science: 1st Edition, \n"
						+ "Publishing date: March 14th, 1880'	\n"
						+ "Dates and times are important, think twice \n"
						+ "about your findings and you may be surprised. \n"
						+ "Hmm what can be so important about this date? \n"
						+ "March 14th, 3/14, a 3 digit numberï¿½\n"
						+ "Time is running out, beat it or prepare for your demise\n");
				enterPin.setVisible(true);
			}
			
			if(e.getSource() == enterPin) 
			{
				textArea.setVisible(false);
				pin.setEditable(true);
				pinLabel.setVisible(true);
				pin.setVisible(true);
				
				enterPin.setVisible(false);
				
				
			}
		}
	
	}
	
	private class textFieldListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e)
		{
			
			userPin = Integer.parseInt(pin.getText());
			if(userPin == correctPin) {
<<<<<<< HEAD
				textArea.setText(" A GHOSTLY VOICE FILLS THE ROOM: ï¿½NOOOO, COME BACK, COME BACKKKKKï¿½\n"
=======
				textArea.setFont(textFont1);
				textArea.setText(" A GHOSTLY VOICE FILLS THE ROOM: “NOOOO, COME BACK, COME BACKKKKK”\n"
>>>>>>> branch 'main' of https://github.com/thaliaaramouny/HHProject2.git
						+ "As the door opens the child runs, and runs, runs. As the house shrinks in \n"
						+ "the distance the sounds fade as well. Still loopy from all of the NITROUS OXIDE \n"
						+ "emmissions, the child collapses.\n"
						+ "1 WEEK LATER\n"
						+ "As the childï¿½s eyes slowly open he saw the room filled \n"
						+ "with flowers and get-well cards. In the chair beside him,\n"
						+ " he saw his mom slumped over. He just watched as she slept peacefully beside him.\n"
						+ "He finally felt reassured that he was safe, \n"
						+ "far from the house, far from the evil man who took him, \n"
						+ "and far from the fears that slowly drowned him. \n"
						+ "He looks outside the window, which was cracked open ever so slightly.\n"
						+ "A chill fall breeze gently grazes the back of his neck.\n"
						+ "As the child starts to go to sleep, his body does not.\n"
						+ "YOU WIN \n"
						+ "HUMANITY LOSES \n");
				
				textArea.setVisible(true);	
			}
			
			if(userPin != correctPin) {
				textArea.setText("A GHOSTLY VOICE FILLS THE ROOM: \n"
						+ "“HAHAHA, YOU COULD NEVER ESCAPE ME! \n"
						+ "MY CHILD, I’M SO SORRY FOR WHAT I HAVE TURNED YOU INTO, \n"
						+ "BUT YOU MUST NEVER LEAVE, WE SHALL DIE TOGETHER.”\n"
						+ "As his voice grows faint, everything becomes dark\n"
						+ "YOU LOSE\n"
						+ "HUMANITY WINS\r\n");
				textArea.setVisible(true);	
			}
			System.out.println("check");
			
		}
	}		
}
