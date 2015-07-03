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

	public abstract boolean activeBattle();

	public abstract void battleEnd();

	/**
	 * Inspects the loot on the ground (if loot is there)
	 */
	public abstract void inspectLoot();

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

	public abstract boolean playerIsAlive();

	public abstract boolean discoveredRiver();

	public abstract boolean discoveredForestCave();

	public abstract boolean discoveredGlimmeringShroomCavern();

	public abstract boolean discoveredMagmaDepths();

	public abstract boolean discoveredPortal();

	public abstract boolean discoveredOtherworld();

	public abstract boolean playerHasStats();

	public abstract void update();

	public abstract void battleFight();

	public abstract void battleFlee();
	
	public abstract boolean battleEnded();

}