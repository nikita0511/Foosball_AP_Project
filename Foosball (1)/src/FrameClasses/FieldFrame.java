package FrameClasses;


import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import panels.gameScreen;

public class FieldFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	GameFrame gameFrame;
	public FieldFrame(GameFrame gameFrame)
	{	
		super("FOOSBALL");
		this.gameFrame = gameFrame;
		gameScreen game = new gameScreen(gameFrame, new ImageIcon("Images/field2.jpg").getImage(),this); 
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//this.setLocationRelativeTo(null);
        this.setSize(840, 700);
        this.add(game);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);       
       // this.setLocationByPlatform(true);
        this.setVisible(true);
        this.setResizable(false);
	}

}

