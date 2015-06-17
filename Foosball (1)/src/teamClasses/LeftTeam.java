package teamClasses;

import java.awt.Image;

import javax.swing.ImageIcon;

import fieldClasses.Ball;

import panels.gameScreen;
import playerClasses.PlayerAttacker;
import playerClasses.PlayerDefender;
import playerClasses.PlayerGK;
import playerClasses.PlayerMF;

public class LeftTeam extends Team implements PlayerTeam{
	Ball ball;
	
	public LeftTeam(gameScreen gamePanel, String name, int numOfDefenders, int numOfAttackers, int numOfMidfielders, Ball ball)
	{   
		super(gamePanel,name, numOfDefenders, numOfMidfielders, numOfAttackers, ball);
		this.name = name;
		this.ball = ball;
		this.formTeam();
	}
	
	protected void formTeam()
	{
		
		Image image = new ImageIcon("Images/field2.jpg").getImage();
		int fieldHeight = (image.getHeight(null)-75);
		makeGoalKeeper();
		makeDefenders (fieldHeight);
		makeMidFielders( fieldHeight);
		makeAttackers( fieldHeight);
		
	}
	private void makeGoalKeeper()
	{
		goalKeeper = new PlayerGK(gamePanel, 100, ball);
	}
	private void makeDefenders(int  fieldHeight)
	{
		int baseCoordinate =  fieldHeight/(numOfDefenders);
		int incrementCoordinate = baseCoordinate;
		defenders = new PlayerDefender[numOfDefenders];
		for(int i = 0; i <numOfDefenders; i++)
		{
			
			
			defenders[i] = new PlayerDefender(gamePanel,200, incrementCoordinate, numOfDefenders, ball);
			incrementCoordinate += baseCoordinate;
		}
		
	}
	private void makeMidFielders(int  fieldHeight)
	{
		int baseCoordinate =  fieldHeight/(numOfMidfielders);
		int incrementCoordinate = baseCoordinate;
		midfielders = new PlayerMF[numOfMidfielders];
		for(int i = 0; i <numOfMidfielders; i++)
		{
			
			midfielders[i] = new PlayerMF(gamePanel,370,incrementCoordinate, numOfMidfielders, ball);
			incrementCoordinate += baseCoordinate;
		}
		
	}
	private void makeAttackers(int fieldHeight)
	{
		int baseCoordinate =  fieldHeight/(numOfAttackers);
		int incrementCoordinate = baseCoordinate;
		attackers = new PlayerAttacker[numOfAttackers];
		for(int i = 0; i <numOfAttackers; i++)
		{
			
			attackers[i] = new PlayerAttacker(gamePanel,550,incrementCoordinate, numOfAttackers, ball);
			incrementCoordinate += baseCoordinate;
		}
		
	}
	
	

	@Override
	public void move() {
		// TODO Auto-generated method stub
		
	}
}

	