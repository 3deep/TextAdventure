package de.htwg.TextAdventure.controller;

import de.htwg.TextAdventure.chars.Player;
import de.htwg.TextAdventure.world.IWorld;
import de.htwg.util.observer.Observable;

public class TextAdventureController extends Observable{
	
	private Player player;
	private IWorld world;
	private String statusMessage = "Welcome to TextAdventure";
	
	public TextAdventureController(Player p, IWorld w) {
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
	
	public void explore() {
		setStatus(world.explore(player.playerPositionGet()));
	}
	
	public void goTo(String location){
		if(location.equalsIgnoreCase("town")){
			player.playerPositionSet(0);
			setStatus("You head back to Town to rest.");
			return;
		}
		if(location.equalsIgnoreCase("forest")){
			player.playerPositionSet(1);
			setStatus("You arrive in a dark Forest. The villagers talked about Imps that infest the area.");
			return;
		}
		if(location.equalsIgnoreCase("forestcave")){
			if(world.discoveredForestCave()){
				player.playerPositionSet(2);
				setStatus("You come in through a huge hole in the Wall. The air smells odd.");
				return;
			}
		}
		if(location.equalsIgnoreCase("river")){
			if(world.discoveredRiver()){
				player.playerPositionSet(3);
				setStatus("You arrive at the River/Lake. Maybe you should try to relax here for a bit.");
				return;
			}
		}
		if(location.equalsIgnoreCase("glimmeringshroomcavern")){
			if(world.discoveredGlimmeringShroomCavern()){
				player.playerPositionSet(4);
				setStatus("Guided by the light of the mushrooms, you find your way into the Glimmering Shroom Cavern.");
				return;
			}
		}
		if(location.equalsIgnoreCase("magmadepths")){
			if(world.discoveredMagmaDepths()){
				player.playerPositionSet(5);
				setStatus("You really should be careful. The magma is burning red and one wrong step could lead to your demise.");
				return;
			}
		}
		if(location.equalsIgnoreCase("portal")){
			if(world.discoveredPortal()){
				player.playerPositionSet(6);
				setStatus("You marked the location of the portal on a map. In case you should need it again.");
				return;
			}
		}
		if(location.equalsIgnoreCase("otherworld")){
			if(world.discoveredOtherworld()){
				player.playerPositionSet(7);
				setStatus("You wonder, if you really want to be in this Otherworldly dimension. Everything here looks distorted.");
				return;
			}
		}
		setStatus("I don't know where " + location + " is. Just pick one of the discovered locations.");
	}
	
	public void areas() {
		String s = "So far you have discovered: Town, Forest";
		if(world.discoveredForestCave())
			s += ", ForestCave";
		if(world.discoveredRiver())
			s += ", River";
		if(world.discoveredGlimmeringShroomCavern())
			s += ", GlimmeringShroomCavern";
		if(world.discoveredMagmaDepths())
			s += ", MagmaDepths";
		if(world.discoveredPortal())
			s += ", Portal";
		if(world.discoveredOtherworld())
			s += ", Otherworld";
		s +=".";
		setStatus(s);
	}

}
