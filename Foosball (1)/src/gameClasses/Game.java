package gameClasses;
import FrameClasses.GameFrame;

//implementing strategy pattern

public class Game {
	
	public String level;
	
	public int attackers;
	public int defenders;
	public int midfielders;
	public int ballX;
	
	public int ballY;

	public Object leftTeam;

	public Game()
	{
		
		GameFrame frame = new GameFrame(this);
		//makeGame();
		
	}


}
