package panels;


import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.util.Random;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import FrameClasses.FieldFrame;
import FrameClasses.GameFrame;


public class coinToss extends JPanel{

	private static final long serialVersionUID = 1L;
	int tossCoin;
	String first = "Heads";
	String second = "Tails";
	int playerChoice;
	JLabel result;
	JPanel contentPane;
	private JPanel gamePanel;
	private GameFrame gameFrame;
	
	public coinToss(JPanel contentPane, GameFrame gameFrame)
	{
		this.contentPane = contentPane;
		setOpaque(true);
		this.gameFrame=gameFrame;
		Dimension size = new Dimension(1000,1000);
	    setPreferredSize(size);
	    setMinimumSize(size);
	    setMaximumSize(size);
	    setSize(size);
	    setLayout(null);
		makeCoinButtons();
		makeTossCoinButton();
		//this.frame3=frame;
		result = new JLabel("");
		result.setLocation(200,200);
		this.add(result);
		result.setBounds(200, 200, 200, 200);
		//result.setVisible(true);
	}
	

	void makeCoinButtons()
	{
		JRadioButton coinHeads = new JRadioButton(first);
	    coinHeads.setMnemonic(KeyEvent.VK_B);
	    coinHeads.setActionCommand(first);
	    coinHeads.setSelected(true);
	    coinHeads.setBounds(150, 100, 100, 40);
	    JRadioButton coinTails = new JRadioButton(second);
	    coinTails.setMnemonic(KeyEvent.VK_B);
	    coinTails.setActionCommand(second);
	    coinTails.setBounds(250, 100, 100, 40);
	    //coinTails.setSelected(true);
	    
	    ButtonGroup coinSides = new ButtonGroup();
	    coinSides.add(coinHeads);
	    coinSides.add(coinTails);
	    this.add(coinHeads);
	    this.add(coinTails);
	    RadioListener myListener = new RadioListener();
	    coinHeads.addActionListener(myListener);
	    coinTails.addActionListener(myListener);
	    //coinHeads.addActionListener(e);
	    //coinTails.addActionListerner(this);
	   //frame.getContentPane().add(coinTossPanel);
		
	}
	
	void makeTossCoinButton()
	{
		JButton tossCoinButton = new JButton("Toss Coin!");
		tossCoinButton.setBounds(400, 100, 100, 40);
		this.add(tossCoinButton);
		tossCoinButton.addActionListener(new JButtonAction());
		
	}
	public class JButtonAction implements ActionListener
	{
		
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			
			tossCoin();
			if(playerChoice==tossCoin)
			{
				System.out.println("Player won the toss!");
				result.setText("You won the toss!");
				gameFrame.game.ballX = 100;
				gameFrame.game.ballY = 375;
				
			}
			else if(playerChoice!=tossCoin)
			{
				System.out.println("Player lost the toss!");
				result.setText("You lost the toss!");
				gameFrame.game.ballX = 715;
				gameFrame.game.ballY = 375;
				
			}
			//frame3.dispatchEvent(new WindowEvent(frame3, WindowEvent.WINDOW_CLOSING));
			//fourthFrame frame=new fourthFrame();
			//JPanel gamePanel = new gameScreen(contentPane,new ImageIcon("Images/field2.jpg").getImage());
			//contentPane.add(gamePanel, "Game Screen");
			//CardLayout cardLayout = (CardLayout) contentPane.getLayout();
            //cardLayout.show(contentPane, "Game Screen");
			FieldFrame fr = new FieldFrame(gameFrame );
			gameFrame.dispatchEvent(new WindowEvent(gameFrame, WindowEvent.WINDOW_CLOSING));
			
		}
		
	}
	
	class RadioListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{
			if (e.getActionCommand() == first) 
			{
				playerChoice=1;
			} 
			else if (e.getActionCommand() == second) 
			{
				playerChoice=0;
			}
		}
	}
	
	public void tossCoin()
	{
		Random randomGenerator = new Random();
		tossCoin = randomGenerator.nextInt(2);
		
	}
}
