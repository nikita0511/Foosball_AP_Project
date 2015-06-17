package panels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.*;
import java.util.Random;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import FrameClasses.FieldFrame;
import FrameClasses.GameFrame;
import FrameClasses.lastFrame;
import fieldClasses.*;
import gameClasses.ExpertGame;
import gameClasses.GameLevel;
import gameClasses.IntermediateGame;
import gameClasses.NoviceGame;
import teamClasses.*;


public class gameScreen extends JPanel implements ActionListener
{

	public GameFrame gameFrame;
	public FieldFrame frame;
	
	//setting up the foosball field
	
	public Ball ball;
	public LeftTeam leftTeam = null;
	public RightTeam rightTeam;
	public leftGoalPost leftGoal = new leftGoalPost(this);
	public rightGoalPost rightGoal = new rightGoalPost(this);
	public GameLevel level;
	
	private Image image;
	int playerScore = 0;
	int computerScore = 0;
	public String LastContactTeam;
	Timer timer = new Timer(5,this);
	int x = 100, y = 350, velX = 0, velY = 0;
	
	private JPanel contentPane;
	
	public gameScreen(GameFrame gameFrame, Image image, FieldFrame frame) {

		this.image = image;
		this.gameFrame = gameFrame;
		this.frame = frame;
		ball = Ball.getBall(this, gameFrame.game.ballX, gameFrame.game.ballY);
		this.LastContactTeam = "rightTeam";
		this.leftTeam = new LeftTeam(this, "Player1", gameFrame.game.defenders, gameFrame.game.attackers,gameFrame.game.midfielders, ball);
		//randomising formation of computer's team
		randomizeComputerTeam();
		
		//implementing the strategy pattern here
		if(gameFrame.game.level == "Novice")
		{
			this.level = new NoviceGame();
		}
		if(gameFrame.game.level == "Intermediate")
		{
			this.level = new IntermediateGame();
		}
		if(gameFrame.game.level == "Expert")
		{
			this.level = new ExpertGame();
		}
		
		Dimension size = new Dimension(image.getWidth(null), image.getHeight(null) + 120);
	    setPreferredSize(size);
	    setMinimumSize(size);
	    setMaximumSize(size);
	    setSize(size);
	    setLayout(null);
		this.setSize(5000, 5000);
		
		addKeyListener(new KeyListener(){

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				for (int i =0; i <leftTeam.numOfMidfielders; i++){
					((KeyListener) leftTeam.midfielders[i]).keyPressed(e);
				}
				for (int i =0; i <leftTeam.numOfDefenders; i++){
					((KeyListener) leftTeam.defenders[i]).keyPressed(e);
				}
				for (int i =0; i <leftTeam.numOfAttackers; i++){
					((KeyListener) leftTeam.attackers[i]).keyPressed(e);
				}
				((KeyListener) leftTeam.goalKeeper).keyPressed(e);
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				for (int i =0; i <leftTeam.numOfMidfielders; i++){
					((KeyListener) leftTeam.midfielders[i]).keyReleased(e);
				}
				for (int i =0; i <leftTeam.numOfDefenders; i++){
					((KeyListener) leftTeam.defenders[i]).keyReleased(e);
				}
				for (int i =0; i <leftTeam.numOfAttackers; i++){
					((KeyListener) leftTeam.attackers[i]).keyReleased(e);
				}
				((KeyListener) leftTeam.goalKeeper).keyReleased(e);
			}
		});
		setFocusable(true);
			
		
		
		//image.getScaledInstance(100, 100,Image.SCALE_DEFAULT);
		JLabel label=new JLabel("User Details");
		label.setBounds(500, 500, 100, 40);
		label.setLocation(5,10);
		this.add(label);
		JLabel label1=new JLabel("Player");
		label1.setBounds(500, 500, 100, 40);
		label1.setLocation(5,20);
		this.add(label1);
		
		JLabel label3=new JLabel("Computer Details");
		label3.setBounds(500, 500, 100, 40);
		label3.setLocation(500,10);
		this.add(label3);
		JLabel label4=new JLabel("Computer");
		label4.setBounds(500, 500, 100, 40);
		label4.setLocation(500,20);
		this.add(label4);
		
		JLabel label5=new JLabel("Score: ");
		label5.setBounds(500, 500, 100, 40);
		label5.setLocation(5,70);
		this.add(label5);
		
		JLabel label6=new JLabel("Score: ");
		label6.setBounds(500, 500, 100, 40);
		label6.setLocation(500,70);
		this.add(label6);
		
		JLabel label7=new JLabel(gameFrame.game.level);
		label7.setBounds(500, 500, 100, 40);
		label7.setLocation(400,80);
		this.add(label7);
		
		JLabel label8=new JLabel("Attackers: "+rightTeam.numOfAttackers);
		label8.setBounds(500, 500, 100, 40);
		label8.setLocation(500,30);
		this.add(label8);
		
		JLabel label9=new JLabel("Defenders: "+rightTeam.numOfDefenders);
		label9.setBounds(500, 500, 100, 40);
		label9.setLocation(500,40);
		this.add(label9);
		
		JLabel label10=new JLabel("Midfielders: "+rightTeam.numOfMidfielders);
		label10.setBounds(500, 500, 100, 40);
		label10.setLocation(500,50);
		this.add(label10);
		
		JLabel labell8=new JLabel("Attackers: "+leftTeam.numOfAttackers);
		labell8.setBounds(500, 500, 100, 40);
		labell8.setLocation(5,30);
		this.add(labell8);
		
		JLabel labell9=new JLabel("Defenders: "+leftTeam.numOfDefenders);
		labell9.setBounds(500, 500, 100, 40);
		labell9.setLocation(5,40);
		this.add(labell9);
		
		JLabel labell10=new JLabel("Midfielders: "+leftTeam.numOfMidfielders);
		labell10.setBounds(500, 500, 100, 40);
		labell10.setLocation(5,50);
		this.add(labell10);
		
		timer.start();
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		setFocusable(true);
		
		

	}
	
	public void addLabels()
	{	
		if(ball.leftT != 0)
		{
		JLabel label1=new JLabel(" " +Integer.toString(ball.leftT));
		label1.setBounds(500, 500, 100, 40);
		label1.setLocation(5+50*ball.leftT,70);
		this.add(label1);
		}
		if(ball.rightT!=0)
		{
		JLabel label2=new JLabel(" "+Integer.toString(ball.rightT));
		label2.setBounds(500, 500, 100, 40);
		label2.setLocation(500+50*ball.rightT,70);
		this.add(label2);
		}
	}
	public void randomizeComputerTeam()
	{
		Random randomGenerator = new Random();
		
		int value = randomGenerator.nextInt(5);
		if(value==0)
		{
			this.rightTeam = new RightTeam(this, "Computer", 3, 2, 5, ball);
			
		}
		else if(value ==1)
		{
			this.rightTeam = new RightTeam(this, "Computer", 4,3,3, ball);
		
		}
		else if(value ==2)
		{
			this.rightTeam = new RightTeam(this, "Computer",4,4,2, ball);
		
		}
		else if(value ==3)
		{
			this.rightTeam = new RightTeam(this, "Computer",5,1,4, ball);
		
		}
		else if(value ==4)
		{
			this.rightTeam = new RightTeam(this, "Computer", 6,1,3, ball);
		
		}
	}

	private static final long serialVersionUID = 1L;
	public void paintComponent(Graphics g) {
		
	    g.drawImage(image, 5, 120, null);
	    Graphics2D g2d = (Graphics2D) g;
	    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
	    
	    //g2d.setColor(Color.ORANGE);
	    ball.paint(g2d);
	    
	    //g2d.setColor(Color.BLACK);
	    g2d.fillRect(104, 160, 3, 470);
	    g2d.fillRect(204, 160, 3, 470);
	    g2d.fillRect(374, 160, 3, 470);
	    g2d.fillRect(554, 160, 3, 470);
	    g2d.fillRect(719, 160, 3, 470);
	    g2d.fillRect(629, 160, 3, 470);
	    g2d.fillRect(449, 160, 3, 470);
	    g2d.fillRect(264, 160, 3, 470);
	    
	   // g2d.setColor(Color.BLACK);
	    leftGoal.paint(g2d);
	    rightGoal.paint(g2d);
	    for (int i =0; i <leftTeam.numOfMidfielders; i++){
	    	g2d.setColor(Color.BLUE);
			leftTeam.midfielders[i].paint(g2d);
		}
	    for (int i =0; i <leftTeam.numOfDefenders; i++){
	    	g2d.setColor(Color.BLUE);
			leftTeam.defenders[i].paint(g2d);
		}
	    for (int i =0; i <leftTeam.numOfAttackers; i++){
	    	g2d.setColor(Color.BLUE);
			leftTeam.attackers[i].paint(g2d);
		}
	    for (int i =0; i <rightTeam.numOfMidfielders; i++)
	    {
	    	g2d.setColor(Color.RED);
			rightTeam.midfielders[i].paint(g2d);
		}
	    for (int i =0; i <rightTeam.numOfDefenders; i++)
	    {
	    	g2d.setColor(Color.RED);
	    	rightTeam.defenders[i].paint(g2d);
		}
	    for (int i =0; i <rightTeam.numOfAttackers; i++)
	    {
	    	g2d.setColor(Color.RED);
	    	rightTeam.attackers[i].paint(g2d);
		}
	    g2d.setColor(Color.BLUE);
	    leftTeam.goalKeeper.paint(g2d);
	    g2d.setColor(Color.RED);
	    rightTeam.goalKeeper.paint(g2d);
	    
	  }
	

	@Override
	public void actionPerformed(ActionEvent e) {
		

		move();
		repaint();
		try {
			Thread.sleep(1);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	private void move(){
		ball.moveBall();
		
		for (int i =0; i <leftTeam.numOfMidfielders; i++){
			leftTeam.midfielders[i].move();
		}
		  for (int i =0; i <leftTeam.numOfDefenders; i++){
				leftTeam.defenders[i].move();
			}
		leftTeam.goalKeeper.move();
		
		for (int i =0; i <leftTeam.numOfAttackers; i++){
			leftTeam.attackers[i].move();
		}

	}
	
	public void gameOver()
	{
		lastFrame frame = new lastFrame();
		//frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
		
	}
	
	
	
}
