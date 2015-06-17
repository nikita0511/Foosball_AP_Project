package playerClasses;

import java.awt.Color;
import java.awt.Graphics2D;

import fieldClasses.Ball;

import panels.gameScreen;

public class ComputerGK extends GoalKeeper{

	public ComputerGK(gameScreen game, int x, Ball ball) {
		super(x, ball);
		// TODO Auto-generated constructor stub
	}

	
	public void paint(Graphics2D g) {
		g.fillRect(x, y, 10, 40);
		g.setColor(Color.RED);
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



}
