package panels;

import gameClasses.Game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import FrameClasses.GameFrame;
import FrameClasses.HelpFrame;

import panels.startScreen.ExitButtonAction;
import panels.startScreen.StartButtonAction;

public class endScreen extends JPanel
{

	private static final long serialVersionUID = 1L;
	
	String winner;
	private Image image;
	JFrame frame;
	endScreen(String image, JFrame frame)
	{
		this(new ImageIcon(image).getImage(), frame);
	}
	public endScreen(Image image, JFrame frame) {
		this.image = image;
		this.frame = frame;
		Dimension size = new Dimension(image.getWidth(null), image.getHeight(null));
	    setPreferredSize(size);
	    setMinimumSize(size);
	    setMaximumSize(size);
	    setSize(size);
	    setLayout(null);
	    
	    //Adding buttons
	    JButton restartButton = new JButton("Restart");
	    restartButton.setBounds(350, 650, 100, 40);
	    this.add(restartButton);
	    restartButton.addActionListener(new RestartButtonAction());
	    JButton exitButton = new JButton("Exit");
	    exitButton.setBounds(500, 650, 100, 40);
	    this.add(exitButton);
	    JButton help = new JButton("Help");
	    help.setBounds(650, 650, 100, 40);
	    this.add(help);
	    exitButton.addActionListener(new ExitButtonAction());
	    help.addActionListener(new HelpButtonAction());
		
	    //Adding results
	   ImageIcon im = new ImageIcon();
	    JLabel label=new JLabel("Winner is");
		label.setBounds(500, 500, 100, 40);
		label.setLocation(5,10);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Sherif", Font.BOLD, 20));
		this.add(label);
		
		JLabel label1=new JLabel(winner);
		label1.setBounds(500, 500, 100, 40);
		label1.setLocation(5,30);
		label1.setForeground(Color.WHITE);
		label1.setFont(new Font("Sherif", Font.BOLD, 20));
		this.add(label1);
		

	}

	public void paintComponent(Graphics g) {
	    g.drawImage(image, 0, 0, null);
	  }
	
	public class RestartButtonAction implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			Game game = new Game();
			frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
			
		}
		
	}
	public class ExitButtonAction implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
			
		}
		
	}
	

	public class HelpButtonAction implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			System.out.println("Instructions:");
			HelpFrame frame = new HelpFrame(new ImageIcon("Images\\gameOver.png").getImage());
		
			
		}
	}
	
}