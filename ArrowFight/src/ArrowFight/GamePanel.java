package ArrowFight;

import java.awt.Graphics;

import javax.swing.*;

public class GamePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private Timer timer;
	
	PlayerObject player;
	OpponentObject opponent;

	public GamePanel() {
		JLabel testLabel = new JLabel("Hallo");
		add(testLabel);
		
	}
	
	protected void startGame() {
		player = new PlayerObject();
		opponent = new OpponentObject();
//		timer = new Timer();
		
	}
	
	public void paintComponent(Graphics g) {
		
	}
	
	
}
