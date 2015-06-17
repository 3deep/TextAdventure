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
		if(help)
			System.out.println("To show your stats, type \"stats\", to save your game, type \"save\", to load \"load\" and to quit, type \"quit\"");
		
	}
	
	public void printStats() {
		System.out.println(controller.printPlayerStats());
		controller.setStatus("");
	}
	
	public void waitInput() {
		printText();
		String command = sc.nextLine();
		if(command.equalsIgnoreCase("quit")){
			System.out.println("You decide to quit your Adventure..");
			System.exit(0);}
		if(command.equalsIgnoreCase("stats"))
			printStats();
		if(command.equalsIgnoreCase("explore")){
			controller.setStatus(controller.explore());
			
		}
		if(command.equalsIgnoreCase("disable"))
			this.help = false;
	}

	@Override
	public void update() {
		printText();
	}

}
