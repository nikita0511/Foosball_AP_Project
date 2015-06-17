package FrameClasses;

import gameClasses.Game;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import panels.startScreen;

public class GameFrame extends JFrame
{
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel startPanel;
	public Game game;
	
	
	
	
	public GameFrame(Game game)
	{	
		super("FOOSBALL");
		this.game  =  game;
		contentPane = new JPanel();
		contentPane.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
	    contentPane.setLayout(new CardLayout());
	   
	    startPanel =  new startScreen(contentPane, new ImageIcon("Images/anime.jpg").getImage(),this);
	    contentPane.add(startPanel,"Start Screen");
	   
	    
	    //this.getContentPane().add(choiceBox, BorderLayout.PAGE_START);
        this.getContentPane().add(contentPane, BorderLayout.CENTER);       
        //this.pack(); 
        this.setLocationRelativeTo(null);
        this.setSize(890, 650);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);       
        this.setVisible(true);
        this.setResizable(false);
    
	    
	}

}
