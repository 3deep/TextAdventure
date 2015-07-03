package de.htwg.TextAdventure;

import org.apache.log4j.*;

import com.google.inject.Guice;
import com.google.inject.Injector;

import de.htwg.TextAdventure.aview.gui.GUI;
import de.htwg.TextAdventure.aview.tui.TUI;
import de.htwg.TextAdventure.controller.ITextAdventureController;
import de.htwg.TextAdventure.controller.impl.TextAdventureController;
import de.htwg.TextAdventure.model.impl.Player;
import de.htwg.TextAdventure.model.impl.World;

final class TextAdventure {
	
	private static ITextAdventureController controller;
		
	@SuppressWarnings("unused")
	public static void main (final String args[]) throws InterruptedException{
		
		Injector injector = Guice.createInjector(new TextAdventureModule());
		
		//controller = new TextAdventureController(new Player(3, 3, 3, 3, 3, 3, 3), new World());
		controller = injector.getInstance(ITextAdventureController.class);

		PropertyConfigurator.configure("-source \\..\\log4j.properties");
		
		GUI gui = new GUI(controller);
		TUI tui = new TUI(controller);
		while(true)
			tui.waitInput();
	}

}