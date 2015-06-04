package de.htwg.TextAdventure.tuiDemo;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import de.htwg.util.observer.IObserver;

public class TUI implements IObserver{
	
	private static final int PANEL_WIDTH = 900;
	private static final int PANEL_HEIGTH = 600;
	public boolean quit = false;
	
	/**
	 * GUI for the Game
	 */
	public TUI(){
		quit = false;
		JFrame frame = new JFrame("TextAdventure");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(PANEL_WIDTH, PANEL_HEIGTH);
		frame.setResizable(true);
		
		//------------
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
		//------------ taken from: http://stackoverflow.com/questions/2442599/how-to-set-jframe-to-appear-centered-regardless-of-the-monitor-resolution
		
		
		JPanel panel = MainPanelTUI.maPanel();
		frame.add(panel);
		frame.setVisible(true);
		frame.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
            	quit = true;
            }
        });
	}
	
	public void printText() {
		
	}
	
	public void sleep() {
		System.out.println("lu1l");
		Scanner sc = new Scanner(System.in);
		while(sc.nextLine() == "")
			;
		System.out.println("lu2l");
	}

	@Override
	public void update() {
		printText();
	}

}
