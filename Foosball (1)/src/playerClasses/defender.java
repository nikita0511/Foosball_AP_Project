package playerClasses;


import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Observable;
import java.util.Random;



import fieldClasses.Ball;

import panels.gameScreen;



public abstract class defender extends Player{
	
	
	public int x;
	public int y;
	int a;
	int b;
	int numOfPlayers;
	int velY = 0;
	final int velX = 0;
	protected gameScreen game;
	Ball ball;

	public defender(gameScreen game, int x, int y, int numOfPlayers, Ball ball){
		this.game = game;
		this.y = y;
		this.x = x;
		this.ball = ball;
		this.numOfPlayers = numOfPlayers;
		b = y;
		a = (game.getHeight() + 400)/(numOfPlayers + 1);
		
	}
	
	public void paint(Graphics2D g) 
	{
		g.fillRect(x, y, 10, 40);
		//g.setColor(Color.RED);
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x, y, 10, 40);
	}


	public void move() 
	{
		
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
			
	}

	public boolean defendBall() {
		// TODO Auto-generated method stub
		if((this.ball).getBounds().intersects(getBounds())){
			this.ball.velX = -1 *(this.ball.velX);
			//this.ball.velY = -1 * (this.ball.velY);
		}
		return false;
		
	}
	public int getX()
	{
		return x;
	}
	public int getY()
	{
		return y;
	}
	

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
	
	void passBallDefendertoMF(MidFielder[] midfielders)
	{
		Random randomGenerator = new Random();
		int MFNumber = randomGenerator.nextInt(game.leftTeam.numOfMidfielders);
		int xMF = midfielders[MFNumber].getX();
		int yMF = midfielders[MFNumber].getY();
		if(randomGenerator.nextInt(2)==0)
		{
			//kickBall(xMF,yMF);
		}
		else
		{
			//kickBall(Xgoal,Ygoal);
		}
	}
		
	public abstract void shootBall();
	




}
