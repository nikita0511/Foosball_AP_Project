package fieldClasses;

import java.awt.Graphics2D;
import java.awt.Rectangle;

import panels.gameScreen;


public class leftGoalPost extends goalPosts{
	
	private gameScreen game;

	public leftGoalPost(gameScreen game){
		this.game = game;
	}
	
	public void paint(Graphics2D g) {
		g.fillRect(60, 335, 8, 120);
	}
	
	public Rectangle getBounds() {
		return new Rectangle(60, 335, 8, 120);
	}
	
	public int getTopY()
	{
		return 335;
	}

	@Override
	public void Goal() {
		
		
	}
}
