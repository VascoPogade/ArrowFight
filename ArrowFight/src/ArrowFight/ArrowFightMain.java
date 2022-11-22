package ArrowFight;

import javax.swing.JFrame;

public class ArrowFightMain {

	public static void main(String[] args) {
		
		final JFrame gameFrame = new JFrame("ArrowFight");
		gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameFrame.setBounds(300, 75, 800, 700);
		gameFrame.add(new StartPagePanel());
//		gameFrame.pack();
		gameFrame.setVisible(true);
		gameFrame.setResizable(false);
	}
}
