package ArrowFight;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class StartPagePanel extends JPanel {
	
	private static final long serialVersionUID = 1L;

	public StartPagePanel() {
		
		JLabel arrowFightLabel = new JLabel("Arrow-Fight");
		arrowFightLabel.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		
		JButton start = new JButton("Start Game");
		start.addActionListener(new startButtonListener());
		
		
		add(arrowFightLabel);
		add(start);
		
	}
	
	private class startButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			
		}
		
		
		
	}

}
