package ArrowFight;

import java.awt.*;
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
	
	protected ProjectileObject shoot() {
		
		double startPointX;
		double startPointY;

		double startAngle = bowAngle;

		startPointX = width/2;
		startPointY = height/2;

		ProjectileObject arrow = new ProjectileObject(startPointY, startPointY, startAngle);

		return arrow;
	}
	
	

	@Override
	protected void renderMe(Graphics g) {

		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.BLACK);

		AffineTransform aff = new AffineTransform();
		RoundRectangle2D body = new RoundRectangle2D.Double(position.x,position.y,width,height, 0, 0);
		Arc2D.Double handle = new Arc2D.Double(body.getCenterX()-5.0, body.getCenterY()+5.0, 5.0, 5.0, 80.0, 0.0, ARC2D.OPEN)

		//bodyAngle wird mit * -1 multipliziert damit die Grad gegen den Uhrzeigersinn gezaehlt werden
		aff.rotate((-1) * bodyAngle,body.getCenterX(), body.getCenterY());
		Shape rotatedBody = aff.createTransformedShape(body);

		g2d.fill(rotatedBody);
		
	}

}
