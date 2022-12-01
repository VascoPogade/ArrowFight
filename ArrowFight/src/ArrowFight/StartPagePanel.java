package ArrowFight;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class StartPagePanel extends JPanel {
	
	private final long serialVersionUID = 1L;
	private JPanel panelManager;

	public StartPagePanel(MainArrowFightPanel mainArrowFightPanel) {
		
		panelManager = mainArrowFightPanel; 
		
		JLabel arrowFightLabel = new JLabel("Arrow-Fight");
		arrowFightLabel.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		
		JButton start = new JButton("Start Game");
//		start.addActionListener(new startButtonListener());
		
		
		add(arrowFightLabel);
		add(start);
		
	}
	
	private class startButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			((CardLayout) panelManager.getLayout()).next(panelManager);
			panelManager.validate();
		}
	}

}
