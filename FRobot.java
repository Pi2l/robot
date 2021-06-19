package robocup;
import robocode.*;
import java.awt.Color;

// API help : https://robocode.sourceforge.io/docs/robocode/robocode/Robot.html

/**
 * FRobot - a robot by (your name here)
 */
public class FRobot extends Robot
{
	boolean moveForward;
	/**
	 * run: FRobot's default behavior
	 */
	public void run() {
		// Initialization of the robot should be put here

		// After trying out your robot, try uncommenting the import at the top,
		// and the next line:

		setColors(Color.red,Color.blue,Color.green); // body,gun,radar
		setScanColor(Color.green);
		
		moveForward = false;
		// Robot main loop
		while(true) {
				// Replace the next 4 lines with any behavior you would like

			ahead(50);
			turnGunRight(360);
			if(!moveForward){
				back(50);
				moveForward = false;
			}
			turnGunRight(360);
		}
	}

	/**
	 * onScannedRobot: What to do when you see another robot
	 */
	public void onScannedRobot(ScannedRobotEvent e) {
		double dist = e.getDistance();
		out.println(dist);
		if(e.getDistance() < 200) fire(3);
		if(dist > 500) {
			fire(1);
		}
		else fire(2.1);

	}

	/**
	 * onHitByBullet: What to do when you're hit by a bullet
	 */
	public void onHitByBullet(HitByBulletEvent e) {
		// Replace the next line with any behavior you would like
		turnRight(e.getBearing() + 90);
		back(30);
		moveForward = true;
	}
	
	/**
	 * onHitWall: What to do when you hit a wall
	 */
	public void onHitWall(HitWallEvent e) {
		// Replace the next line with any behavior you would like
		// back(20);
	}
	
	
	public void onHitRobot(HitRobotEvent e) {
		
		turnGunRight(e.getBearing());
		fire(3);
	}
}
