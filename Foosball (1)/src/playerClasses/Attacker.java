package playerClasses;

import java.awt.*;

import java.util.Observable;

import fieldClasses.Ball;

import panels.gameScreen;



public abstract class Attacker extends Player{
	
	
	public int y;
	int x;
	int a;
	int b;
	int numOfPlayers;
	int velY = 0;
	final int velX = 0;
	protected gameScreen game;
	Ball ball;

public Attacker(gameScreen game, int x, int y, int numOfPlayers, Ball ball){
		this.game = game;
		this.x = x;
		this.y = y;
		this.ball = ball;
		this.numOfPlayers = numOfPlayers;
		b = y;
		a = (game.getHeight() + 400 - 18 * numOfPlayers) /(numOfPlayers + 1);
	
		}
	
	public void paint(Graphics2D g) 
	{
		g.fillRect(x, y, 10, 40);
		
	}
	
	public Rectangle getBounds() 
	{
		return new Rectangle(x, y, 10, 40);
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
			
	}

	public boolean defendBall() {
		// TODO Auto-generated method stub
		if((this.ball).getBounds().intersects(getBounds())){
			this.ball.velX = -1 * (this.ball.velX);
			//this.ball.velY = -1 * (this.ball.velY);
		}
		return false;
		
	}

	@Override
	public void update(Observable o, Object arg) {
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
	
	public abstract void shootBall();


	

}
