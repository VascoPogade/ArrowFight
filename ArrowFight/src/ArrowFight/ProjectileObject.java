package ArrowFight;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;

public class ProjectileObject extends SuperObject {

	public ProjectileObject(double posX, double posY , double bodyAngle) {
		super(posX,posY,bodyAngle, 3, 12, 4.0);
	}
	
	protected void checkCollision(SuperObject other) {
		Rectangle2D.Double otherRec = other.turnIntoRectangle();
		Rectangle2D.Double thisRec = this.turnIntoRectangle();
		
		if(thisRec.intersects(otherRec)) {
			if(other instanceof PlayerObject) {
				setAlive(false);
			}else if(other instanceof OpponentObject) {
				setAlive(false);
			}else if(other instanceof ObstacleObject) {
				setAlive(false);
			}else if(other instanceof ProjectileObject) {
				setAlive(false);
			}
			
			if(getX() == (0+width/2)||getX()== (800-width/2)) {
				setAlive(false);
			}
			if(getY() == 0+height/2||getY()== 700-height/2) {
				setAlive(false);
			}
		}
	}

	@Override
	protected void drawMe(Graphics g) {
		
		Graphics2D g2d = (Graphics2D) g;   
        g2d.setColor(Color.BLACK);        
         
        AffineTransform transform = new AffineTransform();        
        RoundRectangle2D missileShape = new RoundRectangle2D.Double(position.x,position.y,width,height, 5, 1); 
         
        transform.rotate(bodyAngle,missileShape.getCenterX(), missileShape.getCenterY());
        Shape transformedMissileShape = transform.createTransformedShape(missileShape);
         
        g2d.fill(transformedMissileShape);
		
//		Graphics2D g2d = (Graphics2D) g;
//		
//		RoundRectangle2D.Double missile = new RoundRectangle2D.Double(position.x,position.y,width,height, 2, 2);
//		g2d.draw(missile);
	}
	
}
