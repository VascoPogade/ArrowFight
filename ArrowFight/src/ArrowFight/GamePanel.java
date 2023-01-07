package ArrowFight;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

public class GamePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private Timer timer;
	
	private PlayerObject player;
	private OpponentObject opponent;
	private ProjectileObject testMissile1;
	private ProjectileObject testMissile2;
	private ProjectileObject testMissile3;
	private PlayerObject testPlayer1;
	private JLabel testLabel;
	private List<SuperObject> gameObjectList;
	private boolean gameOver;
	
	private int crossbowsDestroyed;

	public GamePanel() {
		testLabel = new JLabel("Hallo");
		add(testLabel);
		gameObjectList = new ArrayList<SuperObject>();
		gameOver = false;
		startGame();
		
	}
	
	protected void startGame() {
		timer = new Timer(20,new CentralTimeListener());
//		player = new PlayerObject(20,20,40);
//		opponent = new OpponentObject();
		testMissile1 = new ProjectileObject(600.0,400.0,90.0);
		gameObjectList.add(testMissile1);
		testMissile2 = new ProjectileObject(100.0,300.0,270.0);
		gameObjectList.add(testMissile2);
		testMissile3 = new ProjectileObject(200.0,200.0,300.0);
		testPlayer1 = new PlayerObject(300.0, 300.0);
		gameObjectList.add(testPlayer1);
		gameObjectList.add(testMissile3);

		timer.start();
	}
	
	protected void endGame() {
		gameObjectList.clear();
		gameOver = true;
		timer.stop();
	}
	
	protected void nextOpponent() {
//		opponent = new OpponentObject(1,1,1.0);
	}
	
	public void paintComponent(Graphics g) {
		g.drawString("Crossbows destroyed: " + crossbowsDestroyed, 20, 60);
		
		for(SuperObject object:gameObjectList) {
			object.renderMe(g);
		}
	}
	
	protected void checkObjectsAlive() {
		
		for(SuperObject object:gameObjectList) {
			if(object.getAlive() == false) {

				
				if(object instanceof PlayerObject) {
					endGame();
					
				}else if(object instanceof OpponentObject) {
					gameObjectList.remove(gameObjectList.indexOf(object));
					nextOpponent();
					
				}else if(object instanceof ProjectileObject) {
					gameObjectList.remove(gameObjectList.indexOf(object));
					
				}
			}
		}
	}
	
	protected static void createMissile(int x) {
		
	}
	
	private class CentralTimeListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			crossbowsDestroyed++;
			checkObjectsAlive();
			
			for(SuperObject currentObject : gameObjectList) {
				for(SuperObject otherObject : gameObjectList) {
					if(otherObject == currentObject) {
						
					}else {
						currentObject.checkCollision(otherObject);
					}
				}
				
				currentObject.MoveMe();
				
			}
			
			repaint();
		}
		
	}
	
	private class GameKeyListener implements KeyListener{

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
}