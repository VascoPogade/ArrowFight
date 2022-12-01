package ArrowFight;

import java.awt.CardLayout;
import java.awt.Dimension;

import javax.swing.JPanel;

public class MainArrowFightPanel extends JPanel {

	public MainArrowFightPanel() {
		CardLayout card = new CardLayout();
		setLayout(card);
		add("StartPage",new StartPagePanel(this));
		add("GamePanel", new GamePanel());
		setPreferredSize( new Dimension(800,600));

	}
}
