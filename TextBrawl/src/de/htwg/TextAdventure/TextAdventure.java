package de.htwg.TextAdventure;

import de.htwg.TextAdventure.chars.Player;
import de.htwg.TextAdventure.controller.TextAdventureController;
import de.htwg.TextAdventure.tuiDemo.TUI;

final class TextAdventure {
	
	/*
	 * private Player p;
	 * private NPC npc;
	 * private World world;
	 */
		
	public static void main (final String args[]) throws InterruptedException{
		TUI tui = new TUI(new TextAdventureController(new Player(3, 3, 3, 3, 3, 3, 3)));
		while(true)
			tui.waitInput();
	}

}
	