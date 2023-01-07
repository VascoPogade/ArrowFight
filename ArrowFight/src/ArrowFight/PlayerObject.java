package ArrowFight;

import java.awt.Graphics;
import java.awt.geom.Rectangle2D;
import java.util.Timer;

public class PlayerObject extends SuperObject {
	
	
	private int reloadTime;
	private boolean readyToShoot;
	private double bowAngle;
	private double bodyTurningSpeed;
	private double bowTurningSpeed;
	private double addedMovingAngle;
	private double addedBowAngle;
	private Timer reloadTimer;
	
	
	public PlayerObject(int posX, int posY) {
		super(posX,posY,0.0, 30, 50, 2.0);
		bowAngle = 0.0;
		bodyTurningSpeed = 0.1;
		bowTurningSpeed = 0.3;
		readyToShoot = true;
	}
	
	protected void turnBodyRight() {
		addedMovingAngle = bodyTurningSpeed;
	}
	
	protected void turnBodyLeft() {
		addedMovingAngle = (-1) * bodyTurningSpeed;
	}
	
	protected void stopTurningBody() {
		addedMovingAngle = 0.0;
	}
	
	protected void turnBowRight() {
		addedBowAngle = bowTurningSpeed;
	}
	
	protected void turnBowLeft() {
		addedBowAngle = (-1) * bowTurningSpeed;
	}
	
	protected void stopTurningBow() {
		addedBowAngle = 0.0;
	}
	
	protected void moveForward() {
		distanceToMove = possibleSpeed;
	}
	
	protected void moveBackwards() {
		distanceToMove = (-1) * possibleSpeed;
	}
	
	protected void stopMoving() {
		distanceToMove = 0.0;
	}
	
	
	protected void checkCollision(SuperObject other) {
		Rectangle2D.Double otherRec = other.turnIntoRectangle();
		Rectangle2D.Double thisRec = this.turnIntoRectangle();
		
		if(thisRec.intersects(otherRec)) {
			if(other instanceof OpponentObject) {
				
			}else if(other instanceof ObstacleObject) {
				
			}else if(other instanceof ProjectileObject) {
				health = health - 10;
			}
			
			if(getX() == (0+width/2)||getX()== (800-width/2)) {
				
			}
			if(getY() == 0+height/2||getY()== 700-height/2) {
				
			}
		}
	}
	
	protected void MoveMe() {
		bodyAngle = bodyAngle + addedMovingAngle;
		bowAngle = bowAngle + addedBowAngle;
		super.MoveMe();
	}
	
	protected void shoot() {
		
		double startPointX = 0.0;
		
		
	}
	
	

	@Override
	protected void renderMe(Graphics g) {
		// TODO Auto-generated method stub
		
	}

}
