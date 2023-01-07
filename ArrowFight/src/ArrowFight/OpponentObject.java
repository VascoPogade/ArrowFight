package ArrowFight;

import java.awt.Graphics;
import java.awt.geom.Rectangle2D;

public class OpponentObject extends SuperObject {
	public OpponentObject(int x, int y , double angle) {
		super(x,y,angle, y, y, angle);
	}
	
	protected void checkCollision(SuperObject other) {
		Rectangle2D.Double otherRec = other.turnIntoRectangle();
		Rectangle2D.Double thisRec = this.turnIntoRectangle();
		
		if(thisRec.intersects(otherRec)) {
			if(other instanceof PlayerObject) {
				
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

	@Override
	protected void renderMe(Graphics g) {
		// TODO Auto-generated method stub
		
	}
	
}
