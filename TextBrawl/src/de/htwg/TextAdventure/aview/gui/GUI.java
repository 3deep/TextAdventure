package de.htwg.TextAdventure.aview.gui;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

import de.htwg.TextAdventure.controller.ITextAdventureController;
import de.htwg.util.observer.IObserver;
import de.htwg.util.observer.Observable;

public class GUI implements IObserver, ActionListener {
	
	private static final int PANEL_WIDTH = 930;
	private static final int PANEL_HEIGTH = 600;
	private ITextAdventureController controller;
	MainPanel mainPanel;

	/**
	 * GUI for the Game
	 */
	public GUI(ITextAdventureController controller){
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
		((Observable) controller).addObserver(this);
		addListener();
		setStart();
	}
	
	private void setStart(){
		mainPanel.setButtonActive(1, false);
		mainPanel.setButtonActive(2, false);
		mainPanel.setButtonActive(3, false);
		mainPanel.setButtonActive(4, false);
		mainPanel.setButtonActive(6, true);
		mainPanel.setButtonActive(5, true);
		mainPanel.changeButtonText(5, "New Game");
		mainPanel.changeButtonText(6, "Quit");
	}
	
	private void addListener(){
		mainPanel.button1.addActionListener(this);
		mainPanel.button2.addActionListener(this);
		mainPanel.button3.addActionListener(this);
		mainPanel.button4.addActionListener(this);
		mainPanel.button5.addActionListener(this);
		mainPanel.button6.addActionListener(this);
	}

	public void printText() {
		mainPanel.printString(controller.getStatus());
	}
	
	public void printStats() {
		mainPanel.printStats(controller.printPlayerStats());
	}

	@Override
	public void update() {
		printAll();
		if(controller.battleEnded())
			setButtonsNormal();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton source = (JButton)e.getSource();
		if(source.getText().equalsIgnoreCase("new game")){
			controller.newGame();
			setButtonsNormal();
			return;
		}
		if(source.getText().equalsIgnoreCase("quit"))
			System.exit(0);
		
		if(source.getText().equalsIgnoreCase("goto")){
			setGoTo1();
			return;
		}
		
		if(source.getText().equalsIgnoreCase("Rest")){
			controller.rest();
			printAll();
			return;
		}
		
		if(source.getText().equalsIgnoreCase("upgrade stats")){
			setUpgrade();
			printAll();
			return;
		}
		
		if(source.getText().equalsIgnoreCase("Strength")){
			controller.upgrade("Str");
			setButtonsNormal();
			printAll();
			return;
		}
		
		if(source.getText().equalsIgnoreCase("Dexterity")){
			controller.upgrade("dex");
			setButtonsNormal();
			printAll();
			return;
		}
		
		if(source.getText().equalsIgnoreCase("Intelligence")){
			controller.upgrade("int");
			setButtonsNormal();
			printAll();
			return;
		}
		
		if(source.getText().equalsIgnoreCase("Speed")){
			controller.upgrade("speed");
			setButtonsNormal();
			printAll();
			return;
		}
		
		if(source.getText().equalsIgnoreCase("hp")){
			controller.upgrade("hp");
			setButtonsNormal();
			printAll();
			return;
		}
		
		if(source.getText().equalsIgnoreCase("back")){
			setButtonsNormal();
			printAll();
			return;
		}
		
		if(source.getText().equalsIgnoreCase("Inspect")){
			controller.inspectLoot();
			printAll();
			return;
		}
		
		if(source.getText().equalsIgnoreCase("take")){
			setTake();
			printAll();
			return;
		}
		
		if(source.getText().equalsIgnoreCase("Weapon")){
			controller.takeWeapon();
			printAll();
			setButtonsNormal();
			return;
		}
		
		if(source.getText().equalsIgnoreCase("Armor")){
			controller.takeArmor();
			printAll();
			setButtonsNormal();
			return;
		}
		
		if(source.getText().equalsIgnoreCase("explore")){
			controller.explore();
			if(controller.activeBattle()){
				setBattle();
			}
			printAll();
			return;
		}
		
		if(source.getText().equalsIgnoreCase("attack")){
			controller.battleFight();
			printAll();
			if(!controller.activeBattle())
				setButtonsNormal();
			if(!controller.playerIsAlive())
				setStart();
			return;
		}
		
		if(source.getText().equalsIgnoreCase("flee")){
			controller.battleFlee();
			printAll();
			if(!controller.activeBattle())
				setButtonsNormal();
			return;
		}
		
		if(source.getText().equalsIgnoreCase("next")){
			setGoTo2();
			return;
		}
		
		if(source.getText().equalsIgnoreCase("prev")){
			setGoTo1();
			return;
		}
		
		if(source.getText().equalsIgnoreCase("Town")){
			controller.goTo("Town");
			setButtonsNormal();
			return;
		}
		
		if(source.getText().equalsIgnoreCase("Forest")){
			controller.goTo("Forest");
			setButtonsNormal();
			return;
		}
		
		if(source.getText().equalsIgnoreCase("River")){
			controller.goTo("River");
			setButtonsNormal();
			return;
		}
		
		if(source.getText().equalsIgnoreCase("Forest Cave")){
			controller.goTo("ForestCave");
			setButtonsNormal();
			return;
		}
		
		if(source.getText().equalsIgnoreCase("Shroom Cavern")){
			controller.goTo("GlimmeringShroomCavern");
			setButtonsNormal();
			return;
		}
		
		if(source.getText().equalsIgnoreCase("Magma Depths")){
			controller.goTo("MagmaDepths");
			setButtonsNormal();
			return;
		}
		
		if(source.getText().equalsIgnoreCase("Portal")){
			controller.goTo("Portal");
			setButtonsNormal();
			return;
		}
		
		if(source.getText().equalsIgnoreCase("Otherworld")){
			controller.goTo("Otherworld");
			setButtonsNormal();
			return;
		}
	}
	
	private void setBattle() {
		mainPanel.changeButtonText(1, "");
		mainPanel.changeButtonText(2, "");
		mainPanel.changeButtonText(3, "");
		mainPanel.changeButtonText(4, "");
		mainPanel.setButtonActive(1, false);
		mainPanel.setButtonActive(2, false);
		mainPanel.setButtonActive(3, false);
		mainPanel.setButtonActive(4, false);
		mainPanel.setButtonActive(5, true);
		mainPanel.changeButtonText(5, "Attack");
		mainPanel.setButtonActive(6, true);
		mainPanel.changeButtonText(6, "Flee");
	}

	private void printAll(){
		printStats();
		printText();
	}

	private void setGoTo1() {
		mainPanel.changeButtonText(1, "Town");
		mainPanel.changeButtonText(2, "Forest");
		mainPanel.setButtonActive(1, true);
		mainPanel.setButtonActive(2, true);
		if(!controller.discoveredRiver())
			mainPanel.setButtonActive(3, false);
		else
			mainPanel.setButtonActive(3, true);
		mainPanel.changeButtonText(3, "River");
		if(!controller.discoveredForestCave())
			mainPanel.setButtonActive(4, false);
		else
			mainPanel.setButtonActive(4, true);
		mainPanel.changeButtonText(4, "Forest Cave");
		mainPanel.setButtonActive(5, false);
		mainPanel.changeButtonText(5, "Prev");
		mainPanel.setButtonActive(6, true);
		mainPanel.changeButtonText(6, "Next");
	}
	

	private void setGoTo2() {
		if(!controller.discoveredGlimmeringShroomCavern())
			mainPanel.setButtonActive(1, false);
		else
			mainPanel.setButtonActive(1, true);
		mainPanel.changeButtonText(1, "Shroom Cavern");
		if(!controller.discoveredMagmaDepths())
			mainPanel.setButtonActive(2, false);
		else
			mainPanel.setButtonActive(2, true);
		mainPanel.changeButtonText(2, "Magma Depths");
		if(!controller.discoveredPortal())
			mainPanel.setButtonActive(3, false);
		else
			mainPanel.setButtonActive(3, true);
		mainPanel.changeButtonText(3, "Portal");
		if(!controller.discoveredOtherworld())
			mainPanel.setButtonActive(4, false);
		else
			mainPanel.setButtonActive(4, true);
		mainPanel.changeButtonText(4, "Otherworld");
		mainPanel.setButtonActive(5, true);
		mainPanel.changeButtonText(5, "Prev");
		mainPanel.setButtonActive(6, false);
		mainPanel.changeButtonText(6, "Next");
	}
	
	private void setButtonsNormal(){
		mainPanel.setButtonActive(1, true);
		mainPanel.changeButtonText(1, "Goto");
		mainPanel.setButtonActive(2, true);
		mainPanel.changeButtonText(2, "Explore");
		mainPanel.setButtonActive(3, true);
		mainPanel.changeButtonText(3, "Inspect");
		if(controller.lootAvailable())
			mainPanel.setButtonActive(4, true);
		else
			mainPanel.setButtonActive(4, false);
		mainPanel.changeButtonText(4, "Take");
		mainPanel.setButtonActive(5, true);
		mainPanel.changeButtonText(5, "Rest");
		if(controller.playerHasStats())
			mainPanel.setButtonActive(6, true);
		else
			mainPanel.setButtonActive(6, false);
		mainPanel.changeButtonText(6, "Upgrade Stats");
		printAll();
	}
	
	private void setTake(){
		mainPanel.setButtonActive(1, false);
		mainPanel.setButtonActive(2, false);
		mainPanel.setButtonActive(3, false);
		mainPanel.setButtonActive(4, false);
		mainPanel.setButtonActive(6, true);
		mainPanel.setButtonActive(5, true);
		mainPanel.changeButtonText(5, "Weapon");
		mainPanel.changeButtonText(6, "Armor");
	}
	
	private void setUpgrade(){
		mainPanel.setButtonActive(1, true);
		mainPanel.setButtonActive(2, true);
		mainPanel.setButtonActive(3, true);
		mainPanel.setButtonActive(4, true);
		mainPanel.setButtonActive(6, true);
		mainPanel.setButtonActive(5, true);
		mainPanel.changeButtonText(1, "Strength");
		mainPanel.changeButtonText(2, "Dexterity");
		mainPanel.changeButtonText(3, "Intelligence");
		mainPanel.changeButtonText(4, "Speed");
		mainPanel.changeButtonText(5, "HP");
		mainPanel.changeButtonText(6, "Back");
	}

}
