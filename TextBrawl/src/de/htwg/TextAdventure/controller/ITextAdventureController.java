package de.htwg.TextAdventure.controller;

import com.google.inject.ImplementedBy;

import de.htwg.TextAdventure.controller.impl.TextAdventureController;

@ImplementedBy(TextAdventureController.class)
public interface ITextAdventureController {

	public abstract void newGame();

	/**
	 * printPlayerStats
	 * @return String of player Stats
	 */
	public abstract String printPlayerStats();

	/**
	 * upgrades chosen attribute
	 * @param stat
	 */
	public abstract void upgrade(String stat);

	/**
	 * gives the statusMessage
	 * @return statusMessage
	 */
	public abstract String getStatus();

	/**
	 * sets the statusMessage
	 * @param statusMessage
	 */
	public abstract void setStatus(String status);

	/**
	 * explores the location where you are at
	 */
	public abstract void explore();

	/**
	 * explore the worlds
	 * @return
	 */
	public abstract boolean activeBattle();

	/**
	 * battle comes to an end
	 */
	public abstract void battleEnd();

	/**
	 * Inspects the loot on the ground (if loot is there)
	 */
	public abstract void inspectLoot();

	/**
	 * checks if loot sis on the ground
	 * @return
	 */
	public abstract boolean lootAvailable();

	/**
	 * Replaces the characters Armor with the one on the Ground
	 */
	public abstract void takeArmor();

	/**
	 * Replaces the characters Weapon with the one on the Ground
	 */
	public abstract void takeWeapon();

	/**
	 * Where the player is going
	 * @param location where to
	 */
	public abstract void goTo(String location);

	/**
	 * Tells the player what he already discovered
	 */
	public abstract void areas();

	/**
	 * Checks if you can rest at current position and heals the player if possible
	 */
	public abstract void rest();

	/**
	 * checks if player is alive
	 * @return
	 */
	public abstract boolean playerIsAlive();

	/** 
	 * same as in world
	 * @return
	 */
	public abstract boolean discoveredRiver();

	/**
	 * saem as world
	 * @return
	 */
	public abstract boolean discoveredForestCave();

	/**
	 * same as world
	 * @return
	 */
	public abstract boolean discoveredGlimmeringShroomCavern();

	/**
	 * see world
	 * @return
	 */
	public abstract boolean discoveredMagmaDepths();

	/**
	 * wolrd
	 * @return
	 */
	public abstract boolean discoveredPortal();

	/**
	 * same as iworld
	 * @return
	 */
	public abstract boolean discoveredOtherworld();

	/**
	 * chekcs for statpoints
	 * @return
	 */
	public abstract boolean playerHasStats();

	/** 
	 * observer update
	 */
	public abstract void update();

	/**
	 * attack an eneym
	 */
	public abstract void battleFight();

	/**
	 * flee from batel
	 */
	public abstract void battleFlee();
	
	/**
	 * checks for ended battle
	 * @return
	 */
	public abstract boolean battleEnded();

}