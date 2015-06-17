package playerClasses;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Observable;
import java.util.Random;

import fieldClasses.Ball;

import panels.gameScreen;



public abstract class GoalKeeper extends Player{
		
		public int y = 375;
		public int x;
		public int velY = 0;
		public int velX = 0;
		protected gameScreen game;
		Ball ball;

		public GoalKeeper(int x, Ball ball){
			this.x = x;
			this.ball = ball;
		}
		
		
		
		public Rectangle getBounds() {
			return new Rectangle(x, y, 10, 40);
		}
		
		public void paint(Graphics2D g) {
			g.fillRect(x, y, 10, 40);
		}


		public void move() 
		{
			
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

			}


			@Override
			public void update(Observable o, Object arg) {
				// TODO Auto-generated method stub
				
			}
			
			void passBallGKtoDefenders(defender[] defenders)
			{
				Random randomGenerator = new Random();
				int defenderNumber = randomGenerator.nextInt(game.leftTeam.numOfDefenders);
				int xDefender = defenders[defenderNumber].getX();
				int yDefender = defenders[defenderNumber].getY();
			}

			



}

