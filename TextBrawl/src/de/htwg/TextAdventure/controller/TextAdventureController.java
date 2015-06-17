package de.htwg.TextAdventure.controller;

import de.htwg.TextAdventure.chars.Player;
import de.htwg.TextAdventure.world.World;
import de.htwg.util.observer.Observable;

public class TextAdventureController extends Observable{
	
	private Player player;
	private World world;
	private String statusMessage = "Welcome to TextAdventure";
	
	public TextAdventureController(Player p, World w) {
		player = p;
		world = w;
		
	}
	
	public String printPlayerStats() {
		String s = "";
		s += "You have " + player.currentHealthGet() + " out of " + player.maxHealthGet() + " HP\n";
		s += "Strength: " + player.strGet() + "\n";
		s += "Dexterity: " + player.dexGet() + "\n";
		s += "Intelligence: " + player.cintGet() + "\n";
		s += "Speed: " + player.speedGet() + "\n";
		s += "Armor: " + player.wepGet().toString() + "\n";
		s += "Weapon: " + player.armGet().toString() + "\n";
		s += "On your journey you defeated " + player.battlesFoughtGet() + " foes!";
		return s;
		
	}
	
	public String getStatus() {
		return statusMessage;
	}
	
	public void setStatus(String status){
		statusMessage = status;
	}
	
	public void checkHealth() {
		if(player.currentHealthGet() <= 0)
			//TODO GAME OVER
			;
		
	}
	
	public String explore() {
		return world.explore();
	}

}
