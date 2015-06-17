package playerClasses;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import fieldClasses.Ball;

import panels.gameScreen;
import teamClasses.LeftTeam;

public class PlayerGK extends GoalKeeper implements KeyListener{

	public PlayerGK(gameScreen game, int x, Ball ball) {
		super(x, ball);
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
		
		Random rd = new Random();
		int defenderNum = rd.nextInt();
		
		double delx = this.x - game.leftTeam.defenders[1].a;
		double dely = this.y - game.leftTeam.defenders[1].b;
		double speed = Math.sqrt(ball.velX * ball.velX + ball.velY * ball.velY);
		double direction = Math.atan(dely/delx);
		
		ball.velX = (int) (speed * Math.cos(direction));  
		ball.velY = (int) (speed * Math.sin(direction));  
		
		//game.repaint();
	}

	public void move() {
		
		if(y < 255)
		{
			velY = 0;
			y = 255;
		}
		
		if(y > 500)
		{
			velY = 0;
			y = 500;
		}
		y = y + velY;
		defendBall();
		//defendBall(410,413);
	}
	
	public void paint(Graphics2D g) {
		g.fillRect(x, y, 10, 40);
		g.setColor(Color.RED);
	}
	
	
	double deltaX, deltaY;
	double direction;
	double speed;
	
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
	
	public boolean defendBall(int x, int y) 
	{
		// TODO Auto-generated method stub
		if((this.ball).getBounds().intersects(getBounds()))
		{
			deltaX = Math.abs(x - this.x);
			deltaY = Math.abs(y - this.y);
			direction = Math.atan(deltaY / deltaX);
			speed = 5;
			this.ball.a += (speed * Math.cos(direction));
			if(y<this.ball.b)
			{
				this.ball.b -= (speed * Math.sin(direction));
			}
			else if(y>this.ball.b)
			{
				this.ball.b += (speed * Math.sin(direction));
				
			}
			System.out.println(direction);
			System.out.println(this.ball.a);
			System.out.println(this.ball.b);
		}
		return false;
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x, y, 10, 40);
	}

	

}
