package fieldClasses;

import java.awt.Graphics2D;
import java.awt.Rectangle;

import panels.gameScreen;



public class rightGoalPost extends goalPosts{
	
	private gameScreen game;

	public rightGoalPost(gameScreen game){
		this.game = game;
	}
	
	public void paint(Graphics2D g) {
		g.fillRect(760, 335, 8, 120);
	}
	
	public Rectangle getBounds() {
		return new Rectangle(760, 335, 8, 120);
	}
	
	public int getTopY()
	{
		return 335;
	}

	@Override
	public void Goal() {
		// TODO Auto-generated method stub
		
	}

}
