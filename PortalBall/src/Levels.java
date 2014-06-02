/*  Ray Kim  
    June 1, 2014 
    Levels.java   
    Class that creates the levels for BallPortal
*/

import java.util.ArrayList;

import acm.program.GraphicsProgram;


public class Levels extends GraphicsProgram{

	ArrayList<Integer> level;
	
	public Levels()
	{
		System.out.println("Static Constructor");
	}
	
	public ArrayList<Integer> level1()
	{
		level = new ArrayList<Integer>();

		level= new ArrayList<Integer>();
		level.add(new Integer(0));level.add(new Integer(1));level.add(new Integer(2));level.add(new Integer(3));
		level.add(new Integer(4));level.add(new Integer(5));level.add(new Integer(6));level.add(new Integer(7));
		level.add(new Integer(8));level.add(new Integer(9));level.add(new Integer(10));level.add(new Integer(11));
		
		level.add(new Integer(111));
		
		level.add(new Integer(200));level.add(new Integer(201));level.add(new Integer(202));
		level.add(new Integer(204));level.add(new Integer(205));level.add(new Integer(206));level.add(new Integer(207));
		level.add(new Integer(208));level.add(new Integer(211));
		
		level.add(new Integer(300));level.add(new Integer(311));
		
		level.add(new Integer(400));level.add(new Integer(401));level.add(new Integer(402));level.add(new Integer(403));
		level.add(new Integer(405));level.add(new Integer(407));level.add(new Integer(408));level.add(new Integer(409));
		level.add(new Integer(410));level.add(new Integer(411));
		
		level.add(new Integer(500));level.add(new Integer(505));level.add(new Integer(511));
		
		level.add(new Integer(600));level.add(new Integer(602));level.add(new Integer(603));level.add(new Integer(604));
		level.add(new Integer(605));level.add(new Integer(606));level.add(new Integer(607));level.add(new Integer(608));
		level.add(new Integer(609));level.add(new Integer(610));level.add(new Integer(611));
		
		level.add(new Integer(700));level.add(new Integer(702));level.add(new Integer(703));level.add(new Integer(707));
		level.add(new Integer(711));
		
		level.add(new Integer(800));level.add(new Integer(802));level.add(new Integer(803));level.add(new Integer(805));
		level.add(new Integer(807));level.add(new Integer(809));level.add(new Integer(811));
		
		level.add(new Integer(900));level.add(new Integer(905));level.add(new Integer(909));level.add(new Integer(910));
		level.add(new Integer(911));
		
		level.add(new Integer(1000));level.add(new Integer(1002));level.add(new Integer(1003));level.add(new Integer(1007));
		
		level.add(new Integer(1100));level.add(new Integer(1101));level.add(new Integer(1102));level.add(new Integer(1103));
		level.add(new Integer(1104));level.add(new Integer(1105));level.add(new Integer(1106));level.add(new Integer(1107));
		level.add(new Integer(1108));level.add(new Integer(1109));level.add(new Integer(1110));level.add(new Integer(1111));
		
		return level;
	}
	
	public ArrayList<Integer> level2()
	{
		level = new ArrayList<Integer>();

		level= new ArrayList<Integer>();
		level.add(new Integer(0));level.add(new Integer(1));level.add(new Integer(2));level.add(new Integer(3));
		level.add(new Integer(4));level.add(new Integer(5));level.add(new Integer(6));level.add(new Integer(7));
		level.add(new Integer(8));level.add(new Integer(9));level.add(new Integer(10));level.add(new Integer(11));
		
		level.add(new Integer(111));
		
		level.add(new Integer(200));level.add(new Integer(211));
		
		level.add(new Integer(300));level.add(new Integer(311));
		
		level.add(new Integer(400));level.add(new Integer(411));
		
		level.add(new Integer(500));level.add(new Integer(503));level.add(new Integer(505));level.add(new Integer(511));
		
		level.add(new Integer(600));level.add(new Integer(603));level.add(new Integer(611));
		
		level.add(new Integer(700));level.add(new Integer(703));level.add(new Integer(707));
		level.add(new Integer(711));
		
		level.add(new Integer(800));level.add(new Integer(803));level.add(new Integer(811));
		
		level.add(new Integer(900));level.add(new Integer(903));
		level.add(new Integer(911));
		
		level.add(new Integer(1000));level.add(new Integer(1002));level.add(new Integer(1003));level.add(new Integer(1007));
		
		level.add(new Integer(1100));level.add(new Integer(1101));level.add(new Integer(1102));level.add(new Integer(1103));
		level.add(new Integer(1104));level.add(new Integer(1105));level.add(new Integer(1106));level.add(new Integer(1107));
		level.add(new Integer(1108));level.add(new Integer(1109));level.add(new Integer(1110));level.add(new Integer(1111));
		
		return level;
	}
	
}
