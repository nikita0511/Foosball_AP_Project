package FrameClasses;

import java.awt.Image;
import javax.swing.JFrame;

public class HelpFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	Image image;
	public HelpFrame(Image image)
	{
		this.image = image;
		//super("Foosball");
		addPanel();
		this.setLocationRelativeTo(null);
		this.setLocation(50, 50);
		this.setVisible(true);
		this.pack();
        this.setResizable(false);
	}

	private void addPanel()
	{
		HelpPanel helpPanel = new HelpPanel(this,image);
		this.getContentPane().add(helpPanel);
	}
	}
