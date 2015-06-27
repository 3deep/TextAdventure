package de.htwg.TextAdventure.UI;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GUI {
	
	private static final int PANEL_WIDTH = 900;
	private static final int PANEL_HEIGTH = 600;
	
	/**
	 * GUI for the Game
	 */
	public GUI(){
		JFrame frame = new JFrame("TextAdventure");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(PANEL_WIDTH, PANEL_HEIGTH);
		frame.setResizable(true);
		
		//------------
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
		//------------ taken from: http://stackoverflow.com/questions/2442599/how-to-set-jframe-to-appear-centered-regardless-of-the-monitor-resolution
		
		
		JPanel panel = MainPanel.maPanel();
		frame.add(panel);
		frame.setVisible(true);
	}

}
