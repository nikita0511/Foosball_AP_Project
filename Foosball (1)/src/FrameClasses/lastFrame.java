package FrameClasses;
import java.awt.Dimension;
import java.awt.Toolkit;

import panels.*;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class lastFrame extends JFrame{

	private static final long serialVersionUID = 1L;
	
	public lastFrame()
	{
		super("Foosball");
		addPanel();
		//this.setLocationRelativeTo(null);
		//this.setLocation(50, 50);
		 this.setSize(950, 800);
		 Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		 this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		this.setVisible(true);
		//this.pack();
        this.setResizable(false);
	}

	private void addPanel()
	{
		endScreen endPanel = new endScreen(new ImageIcon("Images\\gameOver.png").getImage(),this);
		this.getContentPane().add(endPanel);
	}
	
	

}

