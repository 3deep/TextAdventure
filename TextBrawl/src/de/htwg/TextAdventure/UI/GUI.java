package de.htwg.TextAdventure.UI;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;

import de.htwg.TextAdventure.controller.TextAdventureController;
import de.htwg.util.observer.IObserver;

public class GUI implements IObserver, ActionListener {
	
	private static final int PANEL_WIDTH = 930;
	private static final int PANEL_HEIGTH = 600;
	private TextAdventureController controller;
	MainPanel mainPanel;

	/**
	 * GUI for the Game
	 */
	public GUI(TextAdventureController controller){
		this.controller = controller;
		JFrame frame = new JFrame("TextAdventure");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(PANEL_WIDTH, PANEL_HEIGTH);
		frame.setResizable(true);
		
		//------------
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
		//------------ taken from: http://stackoverflow.com/questions/2442599/how-to-set-jframe-to-appear-centered-regardless-of-the-monitor-resolution
		
		//panel = MainPanel.maPanel();
		mainPanel = new MainPanel();
		frame.add(mainPanel.givePanel());
		frame.setVisible(true);
		addListener();
		mainPanel.setButtonActive(1, false);
		mainPanel.setButtonActive(2, false);
		mainPanel.setButtonActive(3, false);
		mainPanel.setButtonActive(4, false);
		mainPanel.changeButtonText(5, "New Game");
	}
	
	private void addListener(){
		mainPanel.button1.addActionListener(this);
		mainPanel.button2.addActionListener(this);
		mainPanel.button3.addActionListener(this);
		mainPanel.button4.addActionListener(this);
		mainPanel.button5.addActionListener(this);
	}

	public void printText() {
		mainPanel.printString(controller.getStatus());
	}
	
	public void printStats() {
		mainPanel.printStats(controller.printPlayerStats());
	}

	@Override
	public void update() {
		printStats();
		printText();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		printStats();
		printText();
		JButton source = (JButton)e.getSource();
		if(source.getText().equalsIgnoreCase("new game"));
		
	}

}
