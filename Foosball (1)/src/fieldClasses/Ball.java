package fieldClasses;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Observable;

import javax.swing.JOptionPane;

import panels.gameScreen;
import teamClasses.Team;

public class Ball extends Observable implements Runnable
{
	//singleton pattern
	
	private static Ball ball;
	
	public int velX = 1;
	public int velY = 1;
	
	public int a;
	public int b;
	
	public gameScreen game;
	public Team LastContactTeam;
	
	public int leftT = 0, rightT = 0;
	
	 
	private Ball(gameScreen game)
	{
		this.game = game;
	}
	
	public static Ball getBall(gameScreen game, int a, int b){
		if(null == ball){
			ball = new Ball(game);
			ball.a = a;
			ball.b = b;
		}
		return ball;
	}
	
	public void moveBall()
	{
		if (a + velX < 60)
			velX = 1;
		if (a + velX > game.getWidth() - 85)
			velX = -1;
		if (b + velY < 160)
			velY = 1;
		if (b + velY > game.getHeight() - 60)
			velY = -1;
		
		if(leftCollision() || rightCollision())
		{

			if(leftCollision()==true)
			{
				velX = 1;
				rightT++;
				System.out.println(rightT);

				if(rightT == 5)
				{
					System.out.println(rightT);
					game.gameOver();
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Computer SCORED!", "GOAL",JOptionPane.ERROR_MESSAGE);
					a = 715;
					b = 375;
					velX = -1;
					game.addLabels();
					
				}
			}
			else if(rightCollision()==true)
			{
				velY = -1;
				leftT++;
				if(leftT == 5)
				{
					System.out.println(leftT);
					game.gameOver();
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Player SCORED", "GOAL",JOptionPane.ERROR_MESSAGE);
					a = 100;
					b = 375;
					game.addLabels();
				}
			}
		}
		
		if(CollisionWithComputer())
		{
			
			if(game.ball.velX >=1)
				game.ball.velX = -1;
			else if(game.ball.velX <= -1)
			{
				game.ball.velY = -1*(game.ball.velY);
			}
		}
		a = (int) (a + velX);
		b = (int) (b + velY);
		
		moveComputerPlayers();
		//DetectBall();
		}
	
	public void paint(Graphics2D g)
	{
		g.fillOval((int)a, (int)b, 15, 15);
	}
	
	
	public boolean leftCollision() 
	{
		return (game.leftGoal).getBounds().intersects(getBounds());
	}
	
	
	public boolean rightCollision() 
	{
		return (game.rightGoal).getBounds().intersects(getBounds());
	}


	private boolean CollisionWithComputer() {

		boolean attackers = false;
		boolean defenders = false;
		boolean midfielders = false;
		for(int i = 0; i< game.rightTeam.numOfAttackers; i++)
		{
			attackers = attackers || (game.rightTeam.attackers[i]).getBounds().intersects(getBounds());
		}
		for(int i = 0; i< game.rightTeam.numOfDefenders; i++)
		{
			
			defenders = defenders || (game.rightTeam.defenders[i]).getBounds().intersects(getBounds());
		}
		for(int i = 0; i< game.rightTeam.numOfMidfielders; i++)
		{
			
			midfielders = midfielders || (game.rightTeam.midfielders[i]).getBounds().intersects(getBounds());
		}

		return ((game.rightTeam.goalKeeper).getBounds().intersects(getBounds()) || attackers || defenders ||midfielders);
	}
	
	public Rectangle getBounds() 
	{
		return new Rectangle((int)a, (int)b, 15, 15);
	}
	
	
		public void moveComputerPlayers()
		{	
			int velY;
			int last;
			int error = game.level.setError();
			if(b<412)
			{	velY = -1 * error;
				if( game.rightTeam.attackers[0].y>150)
			{		
			
			for(int i=0; i< game.rightTeam.attackers.length; i++)
					{	 last =  game.rightTeam.attackers.length-1;
						game.rightTeam.attackers[i].y += velY;
						game.repaint();
					}
			}
			if(game.rightTeam.midfielders[0].y>150)
			{
			for(int i=0; i< game.rightTeam.midfielders.length; i++)
			{	 last =  game.rightTeam.midfielders.length-1;
				game.rightTeam.midfielders[i].y += velY;
				game.repaint();
			}
			}
			if(game.rightTeam.defenders[0].y>150)
			{
			for(int i=0; i< game.rightTeam.defenders.length; i++)
			{	 last =  game.rightTeam.defenders.length-1;
				game.rightTeam.defenders[i].y += velY;
				game.repaint();
				
			}
			}
					velY=0;
					if(game.rightTeam.goalKeeper.y>270)
					{
						game.rightTeam.goalKeeper.y--;
						
					}
					velY=0;
				}		
			else if(b>410)
			{	last = game.rightTeam.attackers.length-1;
			
			velY = 1 * error;
			if( game.rightTeam.attackers[last].y<600)
			{	
				for(int i=0; i< game.rightTeam.attackers.length; i++)
				{	last =  game.rightTeam.attackers.length-1;
					game.rightTeam.attackers[i].y += velY;
					//System.out.println("Shifted to: "+velY);
					game.repaint();
				
				}
			}
				
				last = game.rightTeam.midfielders.length-1;
				if( game.rightTeam.midfielders[last].y<600)
				{
				for(int i=0; i< game.rightTeam.midfielders.length; i++)
				{	last =  game.rightTeam.midfielders.length-1;
					game.rightTeam.midfielders[i].y += velY;
					//System.out.println("Shifted to: "+velY);
					game.repaint();
					
				}
			}
				
				last = game.rightTeam.defenders.length-1;
				if( game.rightTeam.defenders[last].y<600)
				{
				for(int i=0; i< game.rightTeam.defenders.length; i++)
				{	last =  game.rightTeam.defenders.length-1;
					game.rightTeam.defenders[i].y += velY;
					game.repaint();
					
				}
			}
				velY=0;
				if(game.rightTeam.goalKeeper.y<480)
				{
					game.rightTeam.goalKeeper.y++;
					
				}
				velY=0;
			}
			}
	
	void shootAttackers()
	{
		//kickBall(Xgoal,Ygoal);
	}

	@Override
	public void run() 
	{
		// TODO Auto-generated method stub
		
	}
	
	public void DetectBall()
	{	
		//System.out.println("Detect Ball called!");
		int GKCoordinateY = game.rightTeam.goalKeeper.y;
	
		int[] attackersCoordinateY = new int[game.rightTeam.numOfAttackers];
	
		for(int i =0; i<game.rightTeam.numOfAttackers; i++)
		{
			attackersCoordinateY[i] = game.rightTeam.attackers[i].y;
		}
		int[] MFCoordinateY = new int[game.rightTeam.numOfMidfielders];
	
		for(int i =0; i<game.rightTeam.numOfMidfielders; i++)
		{
			MFCoordinateY[i] = game.rightTeam.midfielders[i].y;
		}
	
		int[] DefenderCoordinateY = new int[game.rightTeam.numOfDefenders];
		for(int i =0; i<game.rightTeam.numOfDefenders; i++)
		{
				DefenderCoordinateY[i] = game.rightTeam.defenders[i].y;
		}
		
		int nearestPlayer=nearestPlayers();
		if(nearestPlayer==0)
		{
			//attackers
			int min=0;
			for(int i=1; i<game.rightTeam.numOfAttackers;i++)
			{
				if(Math.abs(attackersCoordinateY[i]-b)<Math.abs(attackersCoordinateY[min]-b))
				{
					min=i;
				}
				
			}
			if(b>game.rightTeam.attackers[min].y)
			{
				velY=1;
			}
			else if(b<game.rightTeam.attackers[min].y)
			{
				velY=-1;
				
			}
			else
			{
				velY=0;
			}
			while((b!=game.rightTeam.attackers[min].y)&&game.rightTeam.attackers[0].y>150 && game.rightTeam.attackers[game.rightTeam.numOfAttackers-1].y<600)
			{
				for(int i=0; i< game.rightTeam.attackers.length; i++)
				{
					
						// last =  game.rightTeam.attackers.length-1;
						game.rightTeam.attackers[i].y += velY;
						//System.out.println("Shifted to: "+velY);
						game.repaint();
					
				}
			}
			velY=0;
			
		}
		else if(nearestPlayer==1)
		{
			int min=0;
			for(int i=1; i<game.rightTeam.numOfDefenders;i++)
			{
				if(Math.abs(DefenderCoordinateY[i]-b)<Math.abs(DefenderCoordinateY[min]-b))
				{
					min=i;
				}
				
						
			}
			if(b>game.rightTeam.defenders[min].y)
			{
				velY=1;
			}
			else if(b<game.rightTeam.defenders[min].y)
			{
				velY=-1;
				
			}
			else
			{
				velY=0;
			}
			while((b!=game.rightTeam.defenders[min].y)&&game.rightTeam.defenders[0].y>150 && game.rightTeam.defenders[game.rightTeam.numOfDefenders-1].y<600)
			{
			
				for(int i=0; i< game.rightTeam.defenders.length; i++)
				{
					
						// last =  game.rightTeam.attackers.length-1;
						game.rightTeam.defenders[i].y += velY;
						//System.out.println("Shifted to: "+velY);
						game.repaint();
				
					
				}
				
			}
			velY=0;
			//defenders
		}
		else if(nearestPlayer==2)
		{
			int min=0;
			for(int i=1; i<game.rightTeam.numOfMidfielders;i++)
			{
				if(Math.abs(MFCoordinateY[i]-b)<Math.abs(MFCoordinateY[min]-b))
				{
					min=i;
				}
						
			}
			if(b>game.rightTeam.midfielders[min].y)
			{
				velY=1;
			}
			else if(b<game.rightTeam.midfielders[min].y)
			{
				velY=-1;
				
			}
			else
			{
				velY=0;
			}
			while((b!=game.rightTeam.midfielders[min].y)&& (game.rightTeam.midfielders[0].y>150) && (game.rightTeam.midfielders[game.rightTeam.numOfMidfielders-1].y<600))
			{
				for(int i=0; i< game.rightTeam.midfielders.length; i++)
				{	
					
						// last =  game.rightTeam.attackers.length-1;
						game.rightTeam.midfielders[i].y += velY;
						//System.out.println("Shifted to: "+velY);
						game.repaint();
					
					
				}
				
				
			}
			velY=0;
			//Mfs
		}
		else if(nearestPlayer==3)
		{
			if(b>game.rightTeam.goalKeeper.y)
			{
				velY=1;
			}
			else if(b<game.rightTeam.goalKeeper.y)
			{
				velY=-1;
				
			}
			else
			{
				velY=0;
			}
			while((b!=game.rightTeam.goalKeeper.y) && (game.rightTeam.goalKeeper.y>280) && (game.rightTeam.goalKeeper.y<550))
			{
				
					game.rightTeam.goalKeeper.y += velY;
					game.repaint();
					
				
				
			}
			velY=0;

			
			
		}
	
	
	
	}
	
	public int nearestPlayers()
	{
		
		int DfromAttackers= Math.abs(a-game.rightTeam.attackers[0].getX());
		int DfromDefenders= Math.abs(a-game.rightTeam.defenders[0].getX());
		int DfromMF= Math.abs(a-game.rightTeam.midfielders[0].getX());
		int DfromGK = Math.abs(a-game.rightTeam.goalKeeper.x);
		int min,dis;
		if(DfromAttackers<DfromDefenders)
		{
			dis = DfromAttackers;
			min =0;
		}
		else
		{
			dis = DfromDefenders;
			min=1;
		}
		if(DfromMF<dis)
		{
			dis= DfromMF;
			min=2;
		}
		if(DfromGK<dis)
		{
			dis=DfromGK;
			min=3;
		}
		return min;
		
		
	}
	
}


