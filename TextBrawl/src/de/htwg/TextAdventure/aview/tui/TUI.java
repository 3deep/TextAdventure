package de.htwg.TextAdventure.aview.tui;

import java.util.Scanner;

import org.apache.log4j.Logger;

import de.htwg.TextAdventure.controller.ITextAdventureController;
import de.htwg.util.observer.IObserver;
import de.htwg.util.observer.Observable;

public class TUI implements IObserver{
	
	public boolean quit = false;
	private ITextAdventureController controller;
	Scanner sc = new Scanner(System.in);
	private boolean help = true;
	private Logger logger = Logger.getLogger("de.htwg.TextAdventure.UI.TUI");
	/**
	 * GUI for the Game
	 */
	public TUI(ITextAdventureController controller){
		logger.info("To start a new Game, tpye \"newGame\"");
		this.controller = controller;
		((Observable) controller).addObserver(this);
	}
	
	public void printText() {
		logger.info(controller.getStatus());
		if(help){
			logger.info("To show your stats, type \"stats\", |to save your game, type \"save\", to load \"load\"| and to quit, type \"quit\""
					+ "\nTo explore the area you are currently in, type \"explore\", to go to an already explored Area, type \"goto\" and then the Area, list of discovered Areas is \"areas\""
					+ "\nIn battles attack the enemy with your current weapon with \"attack\" and flee by typing \"flee\"."
					+ "\nAfter a battle you may choose if you want to take the defeated enemies Weapon or Armor by taking one with \"take\", you can inspect them before with \"inspect\"."
					+ "\nIf you have any unspent Skillpoints (see in stats) you can upgrade your stats with \"upgrade\" (HP gives you 2 HP per point)."
					+ "\nHeal yourself with \"rest\", but only in Town or at the Lake/River"
					+ "\nTo show this Text (all available commands), type \"help\"");
			help = false;
		}
		
	}
	
	public void printStats() {
		controller.setStatus(controller.printPlayerStats());
	}
	
	public void waitInput() {
		if(controller.playerIsAlive()){
			String command = sc.nextLine();
			if(command.equalsIgnoreCase("newgame")){
				controller.newGame();
				controller.setStatus("You decide to start a new Adventure!");
			}
			else if(command.equalsIgnoreCase("quit")){
				logger.info("You decide to quit your Adventure..");
				System.exit(0);
			}
			else if(command.equalsIgnoreCase("stats") && !controller.activeBattle())
				printStats();
			else if(command.equalsIgnoreCase("attack")){
				if(controller.activeBattle())
					controller.battleFight();
				else
					controller.setStatus("Who do you want to fight?");
			}
			else if(command.equalsIgnoreCase("flee")){
				if(controller.activeBattle())
					controller.battleFlee();
				else
					controller.setStatus("Where do you want to flee from?");
			}
			else if(command.equalsIgnoreCase("explore") && !controller.activeBattle())
				controller.explore();
			else if(command.equalsIgnoreCase("help")){
				this.help = true;
			}
			else if(command.equalsIgnoreCase("goto") && !controller.activeBattle()) {
				logger.info("Where do you want to go?");
				controller.areas();
				command = sc.nextLine();
				controller.goTo(command);
			} 
			else if(command.equalsIgnoreCase("areas") && !controller.activeBattle())
				controller.areas();

			else if(command.equalsIgnoreCase("inspect") && !controller.activeBattle())
				controller.inspectLoot();

			else if(command.equalsIgnoreCase("take") && !controller.activeBattle()){
				logger.info("What do you want to take?");
				command = sc.nextLine();
				if(command.equalsIgnoreCase("Armor"))
					controller.takeArmor();
				else if(command.equalsIgnoreCase("Weapon"))
					controller.takeWeapon();
				else
					logger.info("There is no such thing here.");
			}
			else if(command.equalsIgnoreCase("rest") && !controller.activeBattle())
				controller.rest();
			else if(command.equalsIgnoreCase("upgrade") && !controller.activeBattle()){
				logger.info("Which Stat do you want to upgrade? Str, Dex, Int, Speed or HP?");
				command = sc.nextLine();
				controller.upgrade(command);
			}
			else
				controller.setStatus("I don't know the command " + command + ".");
		}
		else{
			controller.setStatus("You can only quit or start over now.");
			String command = sc.nextLine();
			if(command.equalsIgnoreCase("new game")){
				controller.newGame();
				controller.setStatus("You decide to start a new Adventure!");
			}
			else if(command.equalsIgnoreCase("quit")){
				logger.info("You decide to quit your Adventure..");
				System.exit(0);
			}
			else
				controller.setStatus("You can only quit or start over now.");
		}
			
	}

	@Override
	public void update() {
		printText();
	}

}
