package de.htwg.TextAdventure;

import java.awt.Component;

import javax.swing.JOptionPane;

import org.apache.log4j.PropertyConfigurator;

import de.htwg.TextAdventure.UI.GUI;
import de.htwg.TextAdventure.UI.TUI;
import de.htwg.TextAdventure.chars.Player;
import de.htwg.TextAdventure.controller.TextAdventureController;
import de.htwg.TextAdventure.world.World;

final class TextAdventure {
		
	public static void main (final String args[]) throws InterruptedException{
		Object[] options = {"GUI",
                			"TUI"};
		Component frame = null;
		int n = JOptionPane.showOptionDialog(frame,
				"Start GUI or TUI",
						"Startup",
						JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE,
						null,
						options,
						options[1]);
		if(n == 1){
			TUI tui = new TUI(new TextAdventureController(new Player(3, 3, 3, 3, 3, 3, 3), new World()));
			PropertyConfigurator.configure("C:\\Studium\\eclipse\\TextAdventure\\TextAdventure\\TextBrawl\\log4j.properties");
			while(true)
				tui.waitInput();
			
			//observer for loading and saving !
		}
		else {
			GUI gui = new GUI(new TextAdventureController(new Player(3, 3, 3, 3, 3, 3, 3), new World()));
		}
	}

}
	
