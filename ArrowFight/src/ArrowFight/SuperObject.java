package ArrowFight;


import java.awt.Graphics;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

public abstract class SuperObject {
	
	protected Point2D.Double position;
	
	protected double bodyAngle;
	
	protected boolean alive;
	
	protected int width;
	
	protected int height;
	
	protected int health;
	
	protected double speed;
	
	protected SuperObject(double posX, double posY, double bodyDegreeAngle, int width, int height, double speed) {
		position = new Point2D.Double(posX,posY);
		this.bodyAngle = (Math.toRadians(bodyDegreeAngle) + Math.PI);
		alive = true;
		health = 100;
		this.width = width;
		this.height = height;
		this.speed = speed;
	}
	
	protected Rectangle2D.Double turnIntoRectangle() {
		return new Rectangle2D.Double(getX(),getY(),width,height);
	}
	
	protected boolean getAlive() {
		return alive;
	}
	
	protected void setAlive(boolean alive) {
		this.alive = alive;
	}
	
	protected double getX() {
		return position.x;
	}
	
	protected double getY() {
		return position.y;
	}
	
	protected void setX(int newX) {
		position.x = newX;
	}
	
	protected void setY(int newY) {
		position.y = newY;
	}
	
	protected double getBodyAngle() {
		return bodyAngle;
	}
	
	protected void setBodyAngle(double bodyAngle) {
		this.bodyAngle = bodyAngle;
	}
	
	protected int getHeight() {
		return height;
	}
	
	protected int getWidth() {
		return width;
	}
	
	protected void setHealth(int health) {
		this.health = health;
	}
	
	protected int getHealth() {
		return health;
	}
	
	protected void checkCollision(SuperObject other) {
		Rectangle2D.Double otherRec = other.turnIntoRectangle();
		Rectangle2D.Double thisRec = this.turnIntoRectangle();
		
		if(thisRec.intersects(otherRec)) {
			if(other instanceof PlayerObject) {
				
			}else if(other instanceof OpponentObject) {
				
			}else if(other instanceof ObstacleObject) {
				
			}else if(other instanceof ProjectileObject) {
				
			}
			
			if(getX() == (0+width/2)||getX()== (800-width/2)) {
				
			}
			if(getY() == 0+height/2||getY()== 700-height/2) {
				
			}
		}
	}
	
	protected Point2D.Double AngleToDouble(double angle) {
		
		
		double x = Math.sin(angle);
		double y = Math.cos(angle);
		
		return new Point2D.Double(x, y);
		
	}
	
	protected void MoveMe() {
		
		Point2D.Double deltaXY = AngleToDouble(bodyAngle);
		
		position.x = position.x + (deltaXY.x * speed);
		position.y = position.y + (deltaXY.y * speed);
		
	}
	
	protected abstract void drawMe(Graphics g);
}
