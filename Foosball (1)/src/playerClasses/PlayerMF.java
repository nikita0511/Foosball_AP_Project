package playerClasses;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import fieldClasses.Ball;

import panels.gameScreen;

public class PlayerMF extends MidFielder implements KeyListener{

	
	public PlayerMF(gameScreen game,int x, int y, int numOfPlayers, Ball ball) {
		super(game,x, y+40+37, numOfPlayers, ball);
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
	
public void kickBall() {
		
		Random rd = new Random();
		int defenderNum = rd.nextInt(game.leftTeam.numOfDefenders);
		
		double delx = game.leftTeam.goalKeeper.x - game.leftTeam.defenders[defenderNum].x;
		double dely = game.leftTeam.goalKeeper.x - game.leftTeam.defenders[defenderNum].y;
		double speed = Math.sqrt(ball.velX * ball.velX + ball.velY * ball.velY);
		double direction = Math.atan(dely/delx);
		
		ball.velX =  (int) ((speed * Math.cos(direction)) * 10000);  
		ball.velY =  (int) ((speed * Math.sin(direction)) * 10000);  
		
		//game.repaint();
	}

@Override
public void shootBall() {
	// TODO Auto-generated method stub
	
}
}

