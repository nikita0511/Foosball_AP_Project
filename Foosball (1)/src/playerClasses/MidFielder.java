package playerClasses;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Observable;
import java.util.Random;

import fieldClasses.Ball;


import panels.gameScreen;


public abstract class MidFielder extends Player{
	
	int x;
	public int y;
	int a;
	int b;
	int numOfPlayers;
	int velY = 0;
	final int velX = 0;
	public gameScreen game;
	Ball ball;

	public MidFielder(gameScreen game, int x, int y, int numOfPlayers, Ball ball){
		this.game = game;
		this.y = y;
		this.x = x;
		this.ball = ball;
		this.numOfPlayers = numOfPlayers;
		b = y;
		a = (game.getHeight() + 400 - 18 * numOfPlayers) /(numOfPlayers + 1);
		
	}
	
	public void paint(Graphics2D g) {
		g.fillRect(x, y, 10, 40);
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x, y, 10, 40);
	}
	
	public int getTopY()
	{
		return 335;
	}


	public void move() {
		
		if(y < b-a)
		{
			velY = 0;
			y = b-a;
		}
		
		if(y > b+a)
		{
			velY = 0;
			y = b+a;
		}
		
		y = y + velY;
		defendBall();
		//game.repaint();
			
	}

	
		private int noOfPlayers;
			
			public MidFielder( int noOfPlayers)
			{
				this.noOfPlayers = noOfPlayers; 
			}


			@Override
			public void update(Observable o, Object arg) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void kickBall() {
				// TODO Auto-generated method stub
				
			}
			public int getX()
			{
				return x;
			}
			public int getY()
			{
				return y;
			}
			
			void passBallMFtoAttackers(Attacker[] attackers)
			{
				Random randomGenerator = new Random();
				int AttackerNumber = randomGenerator.nextInt(game.leftTeam.numOfAttackers);
				int xAttacker = attackers[AttackerNumber].getX();
				int yAttacker =  attackers[AttackerNumber].getY();
				if(randomGenerator.nextInt(2)==0)
				{
					//kickBall(xAttacker,yAttacker);
				}
				else
				{
					//kickBall(Xgoal,Ygoal);
				}
				
			}
			
			public abstract void shootBall();
			
}

