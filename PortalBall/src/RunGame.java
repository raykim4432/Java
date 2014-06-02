/*  Ray Kim  
    June 1, 2014 
    RunGame.java   
    Class that contains run method for BallPortal Final project
*/
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import acm.graphics.GObject;
import acm.graphics.GOval;
import acm.graphics.GRect;
import acm.graphics.GRectangle;
import acm.io.IODialog;
import acm.program.GraphicsProgram;

public class RunGame extends GraphicsProgram{

	private static final int GRID_UNIT = 50;
	private static final int APP_WIDTH_IN_GRIDS = 12;
	private static final int APP_HEIGHT_IN_GRIDS = 12;
	private static final int APPLET_WIDTH = APP_HEIGHT_IN_GRIDS*GRID_UNIT;
	private static final int APPLET_HEIGHT = APP_HEIGHT_IN_GRIDS*GRID_UNIT;
	private static final int BALL_SIZE = 30;
	private static final int BALL_SPEED = 5;
	private static final int WALL_PORTAL_HEIGHT = 50;
	private static final int WALL_PORTAL_WIDTH = 5;
	private static final int FLOOR_PORTAL_HEIGHT = 5;
	private static final int FLOOR_PORTAL_WIDTH = 50;
	private static final int EXTRA_SPACING = 3;
	private static final int FRAME_RATE = 15;

	private boolean continueLevel = true;
	
	private int lastDirection;
	
	private Ball ball1;
	
	private GRect winSquare;
	
	private GRectangle winSquareBounds;
	
	Levels levelMaker = new Levels();
	
	Portal yellowPortal;
	Portal bluePortal;
	
	//arrays that contains what grids will have walls in levels 1
	ArrayList<Integer> level;
	
	//array with wall objects
	ArrayList<GRect> wallObjects;
		
	//array containing GRectangle objects
	ArrayList<GRectangle> wallBounds;
	
	public void init()
	{
		setSize(APPLET_WIDTH, APPLET_HEIGHT); 
		setBackground(Color.GRAY);
		
		//loading grids that have walls into array level
		
		
		//put ball in game
		ball1 = new Ball(BALL_SIZE, BALL_SIZE);
		ball1.setFillColor(Color.GREEN);
		ball1.setFilled(true);
		add(ball1);
		ball1.resetBall();
		
		//placing portals into game
		yellowPortal = new Portal(0, 0);
		yellowPortal.setFillColor(Color.YELLOW);
		yellowPortal.setFilled(true);
		add(yellowPortal, -100, -100);
		
		bluePortal = new Portal(0, 0);
		bluePortal.setFillColor(Color.BLUE);
		bluePortal.setFilled(true);
		add(bluePortal, -100, -100);
		
		//position win square
		winSquare = new GRect(GRID_UNIT, GRID_UNIT);
		add(winSquare, APPLET_WIDTH, 1100);
		winSquareBounds = winSquare.getBounds();
		
		addKeyListeners();
	}
	
	
	public void run()
	{
		
		//load wall grid for level 1
		level = levelMaker.level2();
		
		//level 1
		runLevel(level);
				
		//print win message
		IODialog dialog = new IODialog();
		dialog.println("Level 1 complete");
				
		//remove level 1 walls
		removeAll();
		continueLevel = true;
		
		
		
	}
	
	public void makeWalls(ArrayList<Integer> activeSquares)
	{
		int xCoord = 0;
		int yCoord = 0;
		
		wallObjects = new ArrayList<GRect>();
		wallBounds = new ArrayList<GRectangle>();
		
		for(Integer square: activeSquares)
		{

			
			xCoord = (square%100)*GRID_UNIT;
			yCoord = (square/100)*GRID_UNIT;
			
			GRect anonGrect = new GRect(GRID_UNIT, GRID_UNIT);
			anonGrect.setFillColor(Color.BLACK);
			anonGrect.setFilled(true);
			add(anonGrect, xCoord, yCoord);
			
			//load wall objects into array
			wallObjects.add(anonGrect);
			
			//load wall object GRectangle bounds into an array
			GRectangle bound = anonGrect.getBounds();
			wallBounds.add(bound);
			
		}
		
	}//end of makeWalls()
	
	public void runLevel(ArrayList<Integer> level)
	{
		//creating walls
		makeWalls(level);
		
		while(continueLevel)
		{
			GRectangle ballBounds = ball1.getBounds();
			
			tangent(ballBounds);
			
			yellowPortalCollision(ballBounds);
			bluePortalCollision(ballBounds);
			
			ball1.move(ball1.getHorVel(), ball1.getVertVel());
			
			if(winCondition(ballBounds))
			{
				continueLevel = false;
			}
			
			pause(FRAME_RATE);
		}
			
		
	}//end of runLevel()
	
	private boolean winCondition(GRectangle ballBounds)
	{
		if(ballBounds.intersects(winSquareBounds))
		{
			return true;
		}
		
		return false;
	}
	
	private void tangent(GRectangle ballBounds)
	{
		boolean applyGravity = true;
		
		for(GRectangle bounds: wallBounds)
		{
			if(ballBounds.intersects(bounds) && bounds.getY()>ball1.getY())
			{
				ball1.reverseVectorVert();
				ball1.reverseVectorHor();
				applyGravity = false;
			} else if(ballBounds.intersects(bounds))
			{
				ball1.reverseVectorVert();
				ball1.reverseVectorHor();
			}
		}
		
		if(applyGravity)
		{
			ball1.applyGravity();
			ball1.move(0, ball1.getVertVel());
		}
		
	}//end of tangent()
	
	private void yellowPortalCollision(GRectangle ballBounds)
	{
		GRectangle yellowPortalBounds = yellowPortal.getBounds();
		if(ballBounds.intersects(yellowPortalBounds))
		{
			if(bluePortal.getPortalOrientation() == 0)
			{
				ball1.setLocation(bluePortal.getX()+15, bluePortal.getY()-BALL_SIZE);
			} else {
				if(lastDirection == 1)
				{
					ball1.setLocation(bluePortal.getX()-BALL_SIZE-EXTRA_SPACING, (bluePortal.getY()+WALL_PORTAL_HEIGHT/2)-BALL_SIZE/2);
					ball1.alterHorVel(-ball1.getVertVel());
					ball1.zeroOutVertVel();
				} else {
					ball1.setLocation(bluePortal.getX()+WALL_PORTAL_WIDTH+EXTRA_SPACING, (bluePortal.getY()+WALL_PORTAL_HEIGHT/2)-BALL_SIZE/2);
					ball1.alterHorVel(ball1.getVertVel());
					ball1.zeroOutVertVel();
				}
			}
		}//end of if
	}
	
	private void bluePortalCollision(GRectangle ballBounds)
	{
		GRectangle bluePortalBounds = bluePortal.getBounds();
		if(ballBounds.intersects(bluePortalBounds))
		{
			if(yellowPortal.getPortalOrientation() == 0)
			{
				ball1.setLocation(yellowPortal.getX()+15, yellowPortal.getY()-BALL_SIZE);
			} else {
				if(lastDirection == 1)
				{
					ball1.setLocation(yellowPortal.getX()-BALL_SIZE-EXTRA_SPACING,(yellowPortal.getY()+WALL_PORTAL_HEIGHT/2)-BALL_SIZE/2);
					ball1.alterHorVel(-ball1.getVertVel());
					ball1.zeroOutVertVel();
				} else {
					ball1.setLocation(yellowPortal.getX()+WALL_PORTAL_WIDTH+EXTRA_SPACING, (yellowPortal.getY()+WALL_PORTAL_HEIGHT/2)-BALL_SIZE/2);
					ball1.alterHorVel(ball1.getVertVel());
					ball1.zeroOutVertVel();
				}
			}
		}//end of if
	}
	
	private boolean collision()
	{
		GRectangle ballBounds = ball1.getBounds();
		for(GRectangle bounds: wallBounds)
		{
			if(ballBounds.intersects(bounds))
			{
				
				return true;
			}
		}
		
		return false;
	}

	private boolean multipleCollision()
	{
		int lastY = -1;
		int collisionCount = 0;
		GRectangle ballBounds = ball1.getBounds();
		for(GRectangle bounds: wallBounds)
		{
			if(ballBounds.intersects(bounds))
			{
				
				if(!(bounds.getY() == lastY))
				{
					collisionCount++;
				}
				
				lastY = (int)bounds.getY();
			}
		}
		
		if(collisionCount>=2)
		{
			return true;
		} else {
			return false;
		}
		
	}//end of collision()
	
	public void keyPressed(KeyEvent event)
	{
		int key = event.getKeyCode();
		
		switch (key)
		{
			case KeyEvent.VK_DOWN:
				lastDirection = 0;
				break;
			case KeyEvent.VK_LEFT:
				if(!multipleCollision())
				{
					ball1.move(-BALL_SPEED, 0);
					lastDirection = 1;
				} else {
					ball1.move(BALL_SPEED*2+1, 0);
				}
				break;
			case KeyEvent.VK_RIGHT:
				if(!multipleCollision())
				{
					ball1.move(BALL_SPEED, 0);
					lastDirection = 2;
				} else {
					ball1.move(-BALL_SPEED*2-1, 0);
				}
				break;
			case KeyEvent.VK_UP:
				if(!multipleCollision())
				{
					ball1.move(0, -BALL_SPEED);
				}
				break;
			case KeyEvent.VK_SPACE:
				if(collision())
					ball1.jump(BALL_SIZE);
				
				break;
			case KeyEvent.VK_F:
				switch (lastDirection)
				{
					case 0:
						bluePortal.setPortalFloor();
						bluePortal.setFloorPortal(ball1.getX(), ball1.getY());
						bluePortal.sendToFront();
						break;
					case 1:
						bluePortal.setPortalWall();
						bluePortal.setWallPortalLeft(ball1.getX(), ball1.getY());
						bluePortal.sendToFront();
						break;
					case 2:
						bluePortal.setPortalWall();
						bluePortal.setWallPortalRight(ball1.getX(), ball1.getY());
						bluePortal.sendToFront();
						break;
				}
				break;
			case KeyEvent.VK_D:
				switch (lastDirection)
				{
					case 0:
						yellowPortal.setPortalFloor();
						yellowPortal.setFloorPortal(ball1.getX(), ball1.getY());
						yellowPortal.sendToFront();
						break;
					case 1:
						yellowPortal.setPortalWall();
						yellowPortal.setWallPortalLeft(ball1.getX(), ball1.getY());
						yellowPortal.sendToFront();
						break;
					case 2:
						yellowPortal.setPortalWall();
						yellowPortal.setWallPortalRight(ball1.getX(), ball1.getY());
						yellowPortal.sendToFront();
						break;
				}
				break;
			case KeyEvent.VK_ENTER:
				continueLevel = false;
				break;
			case KeyEvent.VK_R:
				ball1.resetBall();
				break;
		}
	}//end keyPressed
}
