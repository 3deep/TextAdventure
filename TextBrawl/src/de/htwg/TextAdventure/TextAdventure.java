package de.htwg.TextAdventure;

import org.apache.log4j.PropertyConfigurator;

import de.htwg.TextAdventure.UI.TUI;
import de.htwg.TextAdventure.chars.Player;
import de.htwg.TextAdventure.controller.TextAdventureController;
import de.htwg.TextAdventure.world.World;

final class TextAdventure {
		
	public static void main (final String args[]) throws InterruptedException{
		TUI tui = new TUI(new TextAdventureController(new Player(3, 3, 3, 3, 3, 3, 3), new World()));
		PropertyConfigurator.configure("C:\\Studium\\eclipse\\TextAdventure\\TextAdventure\\TextBrawl\\log4j.properties");
		while(true)
			tui.waitInput();
			
		//observer for loading and saving !
	}

}
	
