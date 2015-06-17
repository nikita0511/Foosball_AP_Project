package playerClasses;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import fieldClasses.Ball;

import panels.gameScreen;

public class PlayerDefender extends defender implements KeyListener{

	public PlayerDefender(gameScreen game, int x, int y, int numOfPlayers, Ball ball) {
		super(game, x, (y+40+37), numOfPlayers, ball);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int key = e.getKeyCode();
        if(key == KeyEvent.VK_UP)
            velY = -1;
        else if(key == KeyEvent.VK_DOWN)
            velY = 1;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		int key = e.getKeyCode();
        if(key == KeyEvent.VK_UP)
            velY = 0;
        else if(key == KeyEvent.VK_DOWN)
            velY = 0;
	}

	@Override
	public void kickBall() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean defendBall() 
	{
		if((ball).getBounds().intersects(getBounds())){
			if(ball.velX <= -1)
				ball.velX = 1;
			else if(ball.velX >= 1)
			{
				ball.velY = -1*(ball.velY);
			}
			
		}
		return false;
	}

	@Override
	public void shootBall() {
		// TODO Auto-generated method stub
		
	}


}
