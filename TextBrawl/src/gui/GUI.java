package gui;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GUI {
	
	//private GameOverScreen GO;
	//private StartScreen SC;
	
	public GUI(){
		JFrame frame = new JFrame("TextAdventure");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(900, 600);
		frame.setResizable(true);
		
		//------------
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
		//------------ taken from: http://stackoverflow.com/questions/2442599/how-to-set-jframe-to-appear-centered-regardless-of-the-monitor-resolution
		
		
		JPanel panel = mainPanel.maPanel();
		frame.add(panel);
		frame.setVisible(true);
	}

}
