package de.htwg.TextAdventure.tuiDemo;

import java.util.Scanner;

import de.htwg.TextAdventure.controller.TextAdventureController;
import de.htwg.util.observer.IObserver;

public class TUI implements IObserver{
	
	public boolean quit = false;
	private TextAdventureController controller;
	Scanner sc = new Scanner(System.in);
	private boolean help = true;
	
	/**
	 * GUI for the Game
	 */
	public TUI(TextAdventureController controller){
		this.controller = controller;
		controller.addObserver(this);
	}
	
	public void printText() {
		System.out.println(controller.getStatus());
		controller.printPlayerStats(); //must be location
		if(help){
			System.out.println("To show your stats, type \"stats\", |to save your game, type \"save\", to load \"load\"| and to quit, type \"quit\""
					+ "\nTo explore the area you are currently in, type \"explore\", to go to an already explored Area, type \"goto\" and then the Area, list of discovered Areas is \"areas\""
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
			System.out.println("You decide to quit your Adventure..");
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
			System.out.println("Where do you want to go?");
			controller.areas();
			update();
			command = sc.nextLine();
			controller.goTo(command);
		} 
		else if(command.equalsIgnoreCase("areas"))
			controller.areas();
		else
			controller.setStatus("I don't know the command " + command + ".");
	}

	@Override
	public void update() {
		printText();
	}

}
