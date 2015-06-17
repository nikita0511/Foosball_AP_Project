package FrameClasses;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

//import FrameClasses.endScreen.RestartButtonAction;

public class HelpPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private Image image;
	JFrame frame;
	HelpPanel(JFrame frame, Image image)
	{
		this.image = image;
		this.frame = frame;
		Dimension size = new Dimension(image.getWidth(null), image.getHeight(null));
	    System.out.println(size);
		setPreferredSize(size);
	    setMinimumSize(size);
	    setMaximumSize(size);
	    setSize(size);
	    setLayout(null);
	    
	  //Adding Buttons
	    JButton backButton = new JButton("Back");
	    backButton.setBounds(350, 650, 100, 40);
	    this.add(backButton);
	    backButton.addActionListener(new BackButtonAction());
	    
	    //Adding Instruction
		JLabel label=new JLabel("Instructions are Here");
		label.setBounds(500, 500, 100, 40);
		label.setLocation(5,30);
		//label1.setForeground(Color.WHITE);
		label.setFont(new Font("Sherif", Font.BOLD, 20));
		this.add(label);

	    

	}
	
	class BackButtonAction implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			//startPanel =  new startScreen(contentPane, new ImageIcon("Images/anime.jpg").getImage());
		}
	
	}
	public void paintComponent(Graphics g) {
	    g.drawImage(image, 0, 0, null);
	  }
}
	
