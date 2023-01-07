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
		super(posX,posY,bodyAngle, 3, 12, 2.0);
		setDistanceToMove(possibleSpeed);
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
//				other.setAlive(false);
			}
			
			if(position.x <= (200+(width/2)) || position.x >= (300-(width/2))) {
				setAlive(false);
			}
			if(getY() <= 0+height/2||getY() >= 700-height/2) {
				setAlive(false);
			}
		}
	}

	@Override
	protected void renderMe(Graphics g) {
		
		Graphics2D g2d = (Graphics2D) g;   
        g2d.setColor(Color.BLACK);        
         
        AffineTransform aff = new AffineTransform();        
        RoundRectangle2D arrow = new RoundRectangle2D.Double(position.x,position.y,width,height, 0, 0); 
         
        //bodyAngle wird mit * -1 multipliziert damit die Grad gegen den Uhrzeigersinn gezaehlt werden
        aff.rotate((-1) * bodyAngle,arrow.getCenterX(), arrow.getCenterY());
        Shape rotatedArrow = aff.createTransformedShape(arrow);
         
        g2d.fill(rotatedArrow);
		
	}
	
}
