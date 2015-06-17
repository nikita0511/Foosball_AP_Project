package teamClasses;

import java.awt.Image;

import javax.swing.ImageIcon;

import fieldClasses.Ball;

import panels.gameScreen;
import playerClasses.Attacker;
import playerClasses.ComputerAttacker;
import playerClasses.ComputerDefender;
import playerClasses.ComputerGK;
import playerClasses.ComputerMF;
import playerClasses.GoalKeeper;
import playerClasses.MidFielder;
import playerClasses.PlayerAttacker;
import playerClasses.PlayerDefender;
import playerClasses.PlayerGK;
import playerClasses.PlayerMF;
import playerClasses.defender;

public class RightTeam extends Team implements ComputerTeam{

	public RightTeam(gameScreen gamePanel, String name, int numOfDefenders, int numOfAttackers, int numOfMidfielders, Ball ball)
	{   
		super(gamePanel,name, numOfAttackers, numOfMidfielders, numOfDefenders,ball);
		this.formTeam(ball);
	}

	protected void formTeam(Ball ball)
	{
		Image image = new ImageIcon("Images/field2.jpg").getImage();
		int fieldHeight = (image.getHeight(null)-75);
		makeGoalKeeper(ball);
		makeDefenders(fieldHeight,ball);
		makeMidFielders(fieldHeight,ball);
		makeAttackers(fieldHeight,ball);
		
	}
	private void makeGoalKeeper(Ball ball)
	{
		goalKeeper = new PlayerGK(gamePanel, 715, ball);
	}
	private void makeDefenders(int  fieldHeight,Ball ball)
	{
		int baseCoordinate =  fieldHeight/(numOfDefenders);
		int incrementCoordinate = baseCoordinate;
		defenders = new ComputerDefender[numOfDefenders];
		for(int i = 0; i <numOfDefenders; i++)
		{
			
			
			defenders[i] = new ComputerDefender(gamePanel,625, incrementCoordinate, numOfDefenders,ball);
			incrementCoordinate += baseCoordinate;
		}
		
	}
	private void makeMidFielders(int  fieldHeight,Ball ball)
	{
		int baseCoordinate =  fieldHeight/(numOfMidfielders);
		int incrementCoordinate = baseCoordinate;
		midfielders = new ComputerMF[numOfMidfielders];
		for(int i = 0; i <numOfMidfielders; i++)
		{
			
			midfielders[i] = new ComputerMF(gamePanel,445,incrementCoordinate, numOfMidfielders,ball);
			incrementCoordinate += baseCoordinate;
		}
		
	}
	private void makeAttackers(int fieldHeight,Ball ball)
	{
		int baseCoordinate =  fieldHeight/(numOfAttackers);
		int incrementCoordinate = baseCoordinate;
		attackers = new ComputerAttacker[numOfAttackers];
		for(int i = 0; i <numOfAttackers; i++)
		{
			
			attackers[i] = new ComputerAttacker(gamePanel,260,incrementCoordinate, numOfAttackers,ball);
			incrementCoordinate += baseCoordinate;
		}
		
	}
	

	@Override
	public void move() {
		// TODO Auto-generated method stub
		
	}
}
