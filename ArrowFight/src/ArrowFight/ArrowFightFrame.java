package ArrowFight;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

public class ArrowFightFrame {
	
	JFrame gameFrame;
	CardLayout card;
	
	public ArrowFightFrame(){
		
		gameFrame = new JFrame("ArrowFight");
		gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameFrame.setBounds(300, 75, 800, 700);
		
//		card = new CardLayout();
//		gameFrame.setLayout(card);
//		gameFrame.add("StartPage",new StartPagePanel());
//		gameFrame.add("GamePanel", new GamePanel());
		
		
		
//		gameFrame.add(new StartPagePanel());
//		gameFrame.add(new GamePanel());
		gameFrame.getContentPane().add(new MainArrowFightPanel());
		gameFrame.pack();

		
		JMenuBar menuBar = new JMenuBar();
		JMenu quit = new JMenu("Spiel verlassen");
		JMenu play = new JMenu("Spiel weiterführen");
		JMenu pause = new JMenu("Spiel pausieren");
		
		quit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//hier Code für quit
			}
		});
		
		play.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//hier Code für play
			}
		});
		
		pause.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//hier Code für pause
			}
		});
		
		menuBar.add(quit);
		menuBar.add(play);
		menuBar.add(pause);
		
		gameFrame.setJMenuBar(menuBar);
		
		
		
		gameFrame.setVisible(true);
		gameFrame.setResizable(false);
	}
	
	 protected void changeToStartPagePanel() {
		card.next(gameFrame);
	}
	 
	 protected void changeToGamePanel() {
		 card.next(gameFrame);
	 }
	
}
