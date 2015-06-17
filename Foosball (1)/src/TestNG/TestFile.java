package TestNG;

import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;
import fieldClasses.Ball;
import gameClasses.Game;
import org.testng.annotations.Test;
import panels.gameScreen;
import playerClasses.Attacker;
import playerClasses.ComputerGK;
import playerClasses.GoalKeeper;
import playerClasses.PlayerAttacker;
import playerClasses.PlayerGK;
import teamClasses.LeftTeam;
@Test(groups={ "My Test"})
public class TestFile{
	
	gameScreen game;
	Attacker attacker ;
	public void checkLeftGoalPost()
	
	{
		/*boolean midfielders;
		boolean attackers;
		Game game;
		boolean defenders;
		LeftTeam leaftTeam;
		GoalKeeper goalkeeper;
		boolean a= (game.leftTeam.goalKeeper).getBounds().intersects(getBounds()) || attackers || defenders ||midfielders;
	*/
		
	//gameScreen game;
	Ball b2 = Ball.getBall(game, 0, 0);
	boolean test1 = b2.leftCollision();
    Assert.assertEquals(test1,(game.leftGoal).getBounds());//.getBounds().intersects(getBounds()));
	
	}

public void checkRightGoalPost()
	
	{
	Ball b1 = Ball.getBall(game, 0, 0);

	boolean test2 = b1.rightCollision();
    Assert.assertEquals(test2,(game.rightGoal).getBounds());//.getBounds().intersects(getBounds()));
	
	}

public void checkPlayerGK()
{
	Ball b1 = Ball.getBall(game, 0, 0);
	PlayerGK plg = new PlayerGK(game, 0,b1);
	boolean test3 = plg.defendBall();
	Assert.assertEquals(test3, false);
}

public void checkComputerGK()
{
	Ball b2 = Ball.getBall(game, 0, 0);
	ComputerGK cg = new ComputerGK(game, 0,b2);
	boolean test4 = cg.defendBall();
	Assert.assertEquals(test4, false);
}


public void CheckLocationOfPlayerAttacker()
{
	PlayerAttacker pla= new PlayerAttacker(game, 0, 0, 0, null);
	//Assert.assertEq
	
	
}
}