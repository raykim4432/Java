/*  Ray Kim  
    June 1, 2014 
    Portal.java   
    Class that creates Portals
*/

import acm.graphics.GRect;

public class Portal extends GRect{

	private static final int WALL_PORTAL_HEIGHT = 50;
	private static final int WALL_PORTAL_WIDTH = 5;
	private static final int FLOOR_PORTAL_HEIGHT = 5;
	private static final int FLOOR_PORTAL_WIDTH = 50;
	private static final int EXTRA_SPACING = 3;
	private static final int BALL_SIZE = 30;
	
	private int portalOrientation = 0;
	
	public Portal(double arg0, double arg1) {
		super(WALL_PORTAL_HEIGHT, WALL_PORTAL_WIDTH);
		// TODO Auto-generated constructor stub
	}

	public void setPortalWall()
	{
		this.setSize(WALL_PORTAL_WIDTH, WALL_PORTAL_HEIGHT);
		portalOrientation = 1;
	}
	
	public void setPortalFloor()
	{
		this.setSize(FLOOR_PORTAL_WIDTH, FLOOR_PORTAL_HEIGHT);
		portalOrientation = 0;
	}
	
	public int getPortalOrientation()
	{
		return portalOrientation;
	}
	
	public void setWallPortalLeft(double d, double e)
	{
		this.setLocation(d-WALL_PORTAL_WIDTH-EXTRA_SPACING,e-WALL_PORTAL_HEIGHT+BALL_SIZE);
	}
	
	public void setWallPortalRight(double d, double e)
	{
		this.setLocation(d+BALL_SIZE+EXTRA_SPACING,e-WALL_PORTAL_HEIGHT+BALL_SIZE);
	}
	
	public void setFloorPortal(double d, double e)
	{
		this.setLocation(d-15,e+BALL_SIZE-FLOOR_PORTAL_HEIGHT);
	}
	
}
