package panels;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseListener;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import FrameClasses.GameFrame;



public class secondScreen extends JPanel  {
//implements ActionListener, Runnable
	JButton totalButton,doneButton;
	private JPanel contentPane;
	private JPanel coinTossPanel;
	public JRadioButton comb1,comb2,comb3,comb4,comb5;
	JLabel nameLabel,levelLabel;//,attackerLabel,midLabel,defenderLabel,totalLabel, goalKeeperLabel, levelLabel;
	//gameFrame.game.defenders;gameFrame.game.midfielders,gameFrame.game.attackers,gameFrame.game.goalkeeper;
	int count =0,total;
	JRadioButton noviceLevel, intermediateLevel, advancedLevel;
	String name;
	public String attack;
	private GameFrame gameFrame;
	gameScreen gamescreen;

		private static final long serialVersionUID = 1L;
		
		public secondScreen(JPanel contentPane, GameFrame gameFrame)
		{
			//InfoClass i = new InfoClass();
			this.contentPane=contentPane;
			setOpaque(true);
			this.gameFrame=gameFrame;
			//this.setSize(2000, 2000);
			this.setLocation(10, 10);
			this.setVisible(true);
		      int frameWidth = 1200;
		      int frameHeight = 650;
		      Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

		      this.setBounds((int) screenSize.getWidth() - frameWidth, 0, frameWidth, frameHeight);
		  
		         nameLabel = new JLabel("Attacker       MidFielder        Defender");	 
		      //   nameLabel.setBounds(300, 100, 100, 40);
		         comb1 = new JRadioButton("   2              5                 3");
		       comb2 = new JRadioButton("   3              3                 4");
		       comb3 = new JRadioButton("   4              2                 4");
		       comb4 = new JRadioButton("   1              4                 5");
		       comb5 = new JRadioButton("   1              3                 6");
		       
		       
		      // JLabel label6=new JLabel(myTextfield                   1);
		       ButtonGroup bt = new ButtonGroup();
		 
		       
		       JPanel panel=new JPanel(new BorderLayout(2,2));
			   JPanel labelFields = new JPanel(new BorderLayout(2,2));
			   labelFields.setBorder(new TitledBorder("Player Details"));

		       JPanel panel1 = new JPanel(new GridLayout(0,1,1,1));
		       JPanel panel2 = new JPanel(new GridLayout(0,1,1,1));
		       JPanel guiCenter = new JPanel(new GridLayout(0,1,1,1));
		       panel1.setBackground(Color.green);
		       panel2.setBackground(Color.green);
		      // labelFields.setBackground(Color.green);
		       guiCenter.setBackground(Color.yellow);
		       panel.setBackground(Color.yellow);
		       
               // totalButton = new JButton("Total");
		       
		       //totalButton.setBounds(300, 300, 300, 30);
		       
		       
		       panel1.add(nameLabel);//setBorder(new TitledBorder("nameLabel"));
		       panel1.add(comb1);
		       panel1.add(comb2);
		       panel1.add(comb3);
		       panel1.add(comb4);
		       panel1.add(comb5);
		       bt.add(comb1);
		       bt.add(comb2);
		       bt.add(comb3);
		       bt.add(comb4);
		       bt.add(comb5);
		       
		       
		 //      totalButton.addActionListener(new TotalPlayers());
		       //totalLabel = new JLabel(""+total);
		       
		       doneButton = new JButton("Done");
		       doneButton.setBounds(10,10,10,10);
		       doneButton.setSize(50, 50);
		       doneButton.addActionListener(new DoneButton());
		       
		        guiCenter.setBorder(new TitledBorder("Level"));
		        levelLabel=new JLabel("LEVEL");
		        
		        ButtonGroup button = new ButtonGroup();
		        
		        
		        guiCenter.add( levelLabel, BorderLayout.NORTH );
		        noviceLevel = new JRadioButton("Novice");
		        noviceLevel.setMnemonic(KeyEvent.VK_B);
		        noviceLevel.setActionCommand("Novice");
		        noviceLevel.setBounds(500, 100, 100, 40);
		        noviceLevel.setBackground(Color.pink);
			    
		        
		        
		        
		        intermediateLevel = new JRadioButton("Intermediate");
		        intermediateLevel.setMnemonic(KeyEvent.VK_B);
		        intermediateLevel.setActionCommand("Novice");
		        intermediateLevel.setBounds(500, 100, 100, 40);
		        intermediateLevel.setBackground(Color.pink);
		        
		        advancedLevel = new JRadioButton("Advanced");
			    advancedLevel.setMnemonic(KeyEvent.VK_B);
			    advancedLevel.setActionCommand("Advanced");
			    advancedLevel.setBounds(500, 100, 100, 40);
			    advancedLevel.setBackground(Color.pink);
		        
			    guiCenter.add(noviceLevel);
		        guiCenter.add(intermediateLevel);
		        guiCenter.add(advancedLevel);
		        
		        button.add(noviceLevel);
		        button.add(intermediateLevel);
		        button.add(advancedLevel);
		        guiCenter.add(doneButton);


		        panel.add(guiCenter, BorderLayout.CENTER);

		        this.add(panel);

		       
   
		       
		        labelFields.add(panel1, BorderLayout.CENTER);
		        labelFields.add(panel2, BorderLayout.EAST);
		     
		      
		        panel.add(labelFields, BorderLayout.NORTH);
		      this.add(panel);
		}    
   		    
		
		public class DoneButton implements ActionListener
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				
			//JOptionPane.showMessageDialog(null, "Check", "Test",JOptionPane.ERROR_MESSAGE);
				if((comb1.isSelected() == true) ||(comb2.isSelected() == true) ||(comb3.isSelected() == true) ||(comb4.isSelected() == true) ||(comb5.isSelected() == true))
				{
				if((noviceLevel.isSelected() == true) || (intermediateLevel.isSelected() == true) ||(advancedLevel.isSelected() == true))
				{
					JPanel coinTossPanel =  new coinToss(contentPane, gameFrame);
			    	contentPane.add(coinTossPanel, "Coin Toss Screen");
			    	
			    	//strategy pattern
			    	if(noviceLevel.isSelected())
			    	{
			    		gameFrame.game.level = "Novice";
			    	}
			    	if(intermediateLevel.isSelected())
			    	{
			    		gameFrame.game.level = "Intermediate";
			    	}
			    	if(advancedLevel.isSelected())
			    	{
			    		gameFrame.game.level = "Expert";
			    	}
				

			     CardLayout cardLayout = (CardLayout) contentPane.getLayout();
	             cardLayout.show(contentPane, "Coin Toss Screen");
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Select a level", "Error",JOptionPane.ERROR_MESSAGE);
					
				}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "First select combination of players", "Error",JOptionPane.ERROR_MESSAGE);
					
				}
				
				
				if(comb1.isSelected() == true)
				{
					gameFrame.game.attackers = 2;
					gameFrame.game.defenders = 3;
					gameFrame.game.midfielders = 5;

					//System.out.println("check");
					//JOptionPane.showMessageDialog(null, "check", "tst",JOptionPane.ERROR_MESSAGE);  
					 
					//gamescreen.DisplayDetails(2,3,5);
	       
				}
				else if(comb2.isSelected() == true)
		        {
					gameFrame.game.attackers = 3;
					gameFrame.game.defenders = 4;
					gameFrame.game.midfielders = 3;

		        }
		        else if(comb3.isSelected() == true)
		        {
		        	gameFrame.game.attackers = 4;
		        	gameFrame.game.defenders = 4;
		        	gameFrame.game.midfielders = 2;

		        }
		        else if(comb4.isSelected() == true)
		        {
		        	gameFrame.game.attackers = 1;
		        	gameFrame.game.defenders = 5;
		        	gameFrame.game.midfielders = 4;

		        }
		        else if(comb5.isSelected() == true)
		        {
		        	gameFrame.game.attackers = 1;
		        	gameFrame.game.defenders = 6;
		        	gameFrame.game.midfielders = 3;

		        }

			}
		}
			
	}