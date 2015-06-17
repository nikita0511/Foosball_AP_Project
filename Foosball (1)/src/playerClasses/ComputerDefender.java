package playerClasses;

import java.util.Observer;

import fieldClasses.Ball;

import panels.gameScreen;

public class ComputerDefender extends defender implements Observer{

	public ComputerDefender(gameScreen game, int x, int y, int numOfPlayers, Ball ball) {
		super(game, x, y+40+37, numOfPlayers, ball);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void kickBall() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public boolean defendBall() 
	{
		if((game.ball).getBounds().intersects(getBounds())){
			if(game.ball.velX >=1)
				game.ball.velX = -1;
			else if(game.ball.velX <= -1)
			{
				game.ball.velY = -1*(game.ball.velY);
			}
			
		}
		return false;
	}


	@Override
	public void shootBall() {
		// TODO Auto-generated method stub
		
	}


}
