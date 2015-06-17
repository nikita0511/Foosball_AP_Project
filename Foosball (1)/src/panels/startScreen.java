package panels;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import FrameClasses.FieldFrame;
import FrameClasses.GameFrame;


public class startScreen extends JPanel
{

	private static final long serialVersionUID = 1L;
	
	private Image image;
	JFrame frame3;
	JPanel contentPane;
	private JPanel coinTossPanel;
	private GameFrame gameFrame;
	public JButton playButton,exitButton;
		
	
	public startScreen(JPanel contentPane, Image image, GameFrame gameFrame)
	{	
		this.contentPane=contentPane;
		setOpaque(true);
		this.gameFrame=gameFrame;
		this.image = image;
		Dimension size = new Dimension(image.getWidth(null), image.getHeight(null));
	    setPreferredSize(size);
	    setMinimumSize(size);
	    setMaximumSize(size);
	    setSize(size);
	    setLayout(null);
	    playButton = new JButton("PLAY");
	    playButton.setBounds(200, 450, 100, 40);
	    this.add(playButton);
	    playButton.addActionListener(new StartButtonAction());
	    exitButton = new JButton("EXIT");
	    exitButton.setBounds(700, 450, 100, 40);
	    this.add(exitButton);
	    exitButton.addActionListener(new ExitButtonAction());
		
	}
	
	public void paintComponent(Graphics g) {
	    g.drawImage(image, 0, 0, null);
	  }
	
	public class ExitButtonAction implements ActionListener
	{
		
    	@Override
		public void actionPerformed(ActionEvent e) 
		{
			System.exit(0);
		}
		
	}
	
	public class StartButtonAction implements ActionListener
	{
		
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			JPanel secondScreenPanel = new secondScreen(contentPane, gameFrame);
			contentPane.add(secondScreenPanel, "User Input Screen");
			CardLayout cardLayout = (CardLayout) contentPane.getLayout();
            cardLayout.show(contentPane, "User Input Screen");
			
		}
		
	}

	public JButton getButton() {
		return playButton;
	}

}
