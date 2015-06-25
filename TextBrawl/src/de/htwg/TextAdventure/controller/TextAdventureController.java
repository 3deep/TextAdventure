package de.htwg.TextAdventure.controller;

import de.htwg.TextAdventure.battle.Arena;
import de.htwg.TextAdventure.battle.IArena;
import de.htwg.TextAdventure.chars.IPlayer;
import de.htwg.TextAdventure.chars.NPC;
import de.htwg.TextAdventure.world.IWorld;
import de.htwg.util.observer.Observable;

public class TextAdventureController extends Observable{
	
	private IPlayer player;
	private IWorld world;
	private String statusMessage = "Welcome to TextAdventure";
	private IArena arena;
	
	/**
	 * Creates the Controller
	 * @param p Player
	 * @param w World
	 */
	public TextAdventureController(IPlayer p, IWorld w) {
		player = p;
		world = w;
		arena = new Arena();
	}
	
	/**
	 * printPlayerStats
	 * @return String of player Stats
	 */
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
	
	/**
	 * gives the statusMessage
	 * @return statusMessage
	 */
	public String getStatus() {
		return statusMessage;
	}
	
	/**
	 * sets the statusMessage
	 * @param statusMessage
	 */
	public void setStatus(String status){
		statusMessage = status;
	}
	
	/**
	 * explores the location where you are at
	 */
	public void explore() {
		setStatus(world.explore(player.playerPositionGet()));
		if(statusMessage.equalsIgnoreCase("a new encounter") && player.playerPositionGet() != 0)
			battle();
	}
	 /**
	  * fight fierce battle
	  */
	private void battle() {
		if(arena.battle(player, new NPC(player.playerPositionGet())))
			setStatus("You managed to beat your foe.");
		else
			setStatus("You ran from battle");
	}
	
	
	public void goTo(String location){
		if(location.equalsIgnoreCase("town")){
			player.playerPositionSet(0);
			setStatus("You head back to Town to rest.");
			return;
		}
		if(location.equalsIgnoreCase("forest")){
			player.playerPositionSet(4);
			setStatus("You arrive in a dark Forest. The villagers talked about Imps that infest the area.");
			return;
		}
		if(location.equalsIgnoreCase("forestcave")){
			if(world.discoveredForestCave()){
				player.playerPositionSet(6);
				setStatus("You come in through a huge hole in the Wall. The air smells odd.");
				return;
			}
		}
		if(location.equalsIgnoreCase("river")){
			if(world.discoveredRiver()){
				player.playerPositionSet(5);
				setStatus("You arrive at the River/Lake. Maybe you should try to relax here for a bit.");
				return;
			}
		}
		if(location.equalsIgnoreCase("glimmeringshroomcavern")){
			if(world.discoveredGlimmeringShroomCavern()){
				player.playerPositionSet(7);
				setStatus("Guided by the light of the mushrooms, you find your way into the Glimmering Shroom Cavern.");
				return;
			}
		}
		if(location.equalsIgnoreCase("magmadepths")){
			if(world.discoveredMagmaDepths()){
				player.playerPositionSet(8);
				setStatus("You really should be careful. The magma is burning red and one wrong step could lead to your demise.");
				return;
			}
		}
		if(location.equalsIgnoreCase("portal")){
			if(world.discoveredPortal()){
				player.playerPositionSet(9);
				setStatus("You marked the location of the portal on a map. In case you should need it again.");
				return;
			}
		}
		if(location.equalsIgnoreCase("otherworld")){
			if(world.discoveredOtherworld()){
				player.playerPositionSet(11);
				setStatus("You wonder, if you really want to be in this Otherworldly dimension. Everything here looks distorted.");
				return;
			}
		}
		setStatus("I don't know where " + location + " is. Just pick one of the discovered locations.");
	}
	
	/*
	 * Tells the player what he already discovered
	 */
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
