package ArrowFight;

import java.awt.Graphics;
import java.awt.geom.Rectangle2D;

public class ObstacleObject extends SuperObject{

	protected ObstacleObject(double x, double y, double angle, int width, int height) {
		super(x, y, angle, width, height, angle);
		// TODO Auto-generated constructor stub
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

	@Override
	protected void drawMe(Graphics g) {
		// TODO Auto-generated method stub
		
	}

}
