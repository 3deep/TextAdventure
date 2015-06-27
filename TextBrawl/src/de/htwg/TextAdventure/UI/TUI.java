package de.htwg.TextAdventure.UI;

import java.util.Scanner;

import org.apache.log4j.Logger;

import de.htwg.TextAdventure.controller.TextAdventureController;
import de.htwg.util.observer.IObserver;

public class TUI implements IObserver{
	
	public boolean quit = false;
	private TextAdventureController controller;
	Scanner sc = new Scanner(System.in);
	private boolean help = true;
	private Logger logger = Logger.getLogger("de.htwg.TextAdventure.UI.TUI");
	
	/**
	 * GUI for the Game
	 */
	public TUI(TextAdventureController controller){
		this.controller = controller;
		controller.addObserver(this);
	}
	
	public void printText() {
		logger.info(controller.getStatus());
		if(help){
			logger.info("To show your stats, type \"stats\", |to save your game, type \"save\", to load \"load\"| and to quit, type \"quit\""
					+ "\nTo explore the area you are currently in, type \"explore\", to go to an already explored Area, type \"goto\" and then the Area, list of discovered Areas is \"areas\""
					+ "\nIn battles attack the enemy with your current weapon with \"attack\" and flee by typing \"flee\"."
					+ "\nAfter a battle you may choose if you want to take the defeated enemies Weapon or Armor by taking one with \"take\", you can inspect them before with \"inspect\"."
					+ "\nHeal yourself with \"rest\", but only in Town or at the Lake/River"
					+ "\nTo show this Text (all available commands), type \"help\"");
			help = false;
		}
		
	}
	
	public void printStats() {
		controller.setStatus(controller.printPlayerStats());
	}
	
	public void waitInput() {
		printText();
		String command = sc.nextLine();
		if(command.equalsIgnoreCase("quit")){
			logger.info("You decide to quit your Adventure..");
			System.exit(0);
		}
		else if(command.equalsIgnoreCase("stats"))
			printStats();
		else if(command.equalsIgnoreCase("explore"))
			controller.explore();
		else if(command.equalsIgnoreCase("help")){
			this.help = true;
		}
		else if(command.equalsIgnoreCase("goto")) {
			logger.info("Where do you want to go?");
			controller.areas();
			update();
			command = sc.nextLine();
			controller.goTo(command);
		} 
		else if(command.equalsIgnoreCase("areas"))
			controller.areas();
		
		else if(command.equalsIgnoreCase("inspect"))
			controller.inspectLoot();
		
		else if(command.equalsIgnoreCase("take")){
			logger.info("What do you want to take?");
			command = sc.nextLine();
			if(command.equalsIgnoreCase("Armor"))
				controller.takeArmor();
			else if(command.equalsIgnoreCase("Weapon"))
				controller.takeWeapon();
			else
				logger.info("There is no such thing here.");
		}
		else if(command.equalsIgnoreCase("rest"))
			controller.rest();
		else
			controller.setStatus("I don't know the command " + command + ".");
	}

	@Override
	public void update() {
		printText();
	}

}
