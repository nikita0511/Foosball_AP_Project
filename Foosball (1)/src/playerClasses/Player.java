package playerClasses;

import java.util.Observable;
import java.util.Observer;

public abstract class Player extends Observable implements Observer
{
	public final int minKickSpeed = -5;
	public final int maxKickSpeed = 5;
	
	public abstract void kickBall();
	public abstract boolean defendBall();
//public abstract void TackleBall();


}
