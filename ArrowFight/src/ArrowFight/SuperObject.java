package ArrowFight;

import java.awt.Point;

public class SuperObject {
	
	protected Point position = new Point();
	
	protected double angle = 0;
	
	protected int getX() {
		return position.x;
	}
	
	protected int getY() {
		return position.y;
	}
	
	protected void setX(int newX) {
		position.x = newX;
	}
	
	protected void setY(int newY) {
		position.y = newY;
	}
	
	protected double getAngle() {
		return angle;
	}
	
	protected void setAngle(double angle) {
		this.angle = angle;
	}
}
