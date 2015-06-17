package teamClasses;

import fieldClasses.Ball;
import panels.gameScreen;
import playerClasses.Attacker;
import playerClasses.GoalKeeper;
import playerClasses.MidFielder;
import playerClasses.defender;

public abstract class Team implements ComputerTeam, PlayerTeam{
	
	public String name;
	public gameScreen gamePanel;
	protected final int players = 11;
	public int numOfDefenders=0;
	public int numOfAttackers;
	public int numOfMidfielders;
	
	public GoalKeeper goalKeeper;
	public defender[] defenders;
	public Attacker[] attackers;
	public MidFielder[] midfielders;
	public Ball ball;
	
	public Team(gameScreen gamePanel,String name, int numOfAttackers, int numOfMidfielders, int numOfDefenders, Ball ball)
	{
		this.gamePanel = gamePanel;
		this.numOfDefenders = numOfDefenders;
		this.numOfMidfielders = numOfMidfielders;
		this.numOfAttackers = numOfAttackers;
		this.name=name;
		this.ball=ball;
	}
	
	protected void formTeam()
	{
		
		
	}
	
	
	

}
