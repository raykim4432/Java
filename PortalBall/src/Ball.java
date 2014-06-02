/*  Ray Kim  
    June 1, 2014 
    Ball.java   
    Class that contains Ball class for BallPortal
*/
import acm.graphics.GOval;
import java.lang.Math;

public class Ball extends GOval{

	private int verticalVelocity = 0;
	private int horizontalVelocity = 0;
	
	private static final int gravityRate = 1;
	
	public Ball(double arg0, double arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}//end of constructor

	public int getVertVel()
	{
		return verticalVelocity;
	}
	
	public void alterVertVel(int addVel)
	{
		verticalVelocity += addVel;
	}
	
	public int getHorVel()
	{
		return horizontalVelocity;
	}
	
	public void alterHorVel(int addVel)
	{
		horizontalVelocity += addVel;
	}
	
	public void zeroOutVertVel()
	{
		verticalVelocity = 0;
	}
	
	public void applyGravity()
	{
		verticalVelocity +=gravityRate;
		
	}//end of applyGravity()
	
	public void reverseVectorVert()
	{
		//decrease velocity to 75% and inverse vector
		if(Math.abs(verticalVelocity) < 1)
		{
			verticalVelocity = 0;
		} else {
			verticalVelocity *= -.75;
		}
		
		this.move(0, verticalVelocity);
		
	}//end of reverseVectorVert()
	
	public void reverseVectorHor()
	{
		//decrease velocity to 75% and inverse vector
		if(Math.abs(horizontalVelocity) < 1)
		{
			horizontalVelocity = 0;
		} else {
			horizontalVelocity *= -.75;
		}
			
		this.move(horizontalVelocity, 0);
	}//end of reverseVectorVert()
	
	public void jump(int jumpHeight)
	{
		//ball jumps hits own height
		this.move(0, (-jumpHeight*2)-gravityRate);
	}
	
	
	public void resetBall()
	{
		this.setLocation(0,60);
	}//end resetBall
}
