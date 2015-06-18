package de.htwg.TextAdventure.chars;

import de.htwg.TextAdventure.items.Armor;
import de.htwg.TextAdventure.items.Weapon;

public class Player extends Character {
	
	private int playerPosition;

	private int battlesFought;
	
	/**
	 * creates the player with the corresponding roll value
	 * @param roll
	 * contains information from start screen (type, etc.)
	 */
	public Player(int maxH, int str, int dex, int cint, int speed, int armorRoll, int wepRoll){
		allSet(maxH, str, dex, cint, speed, armorRoll, wepRoll);
		playerPosition = 0;
	}

	/**
	 * Gives the number of fought Battles
	 * @return int of fought battles (lvlup system?)
	 */
	public int battlesFoughtGet() {
		return battlesFought;
	}

	/**
	 * Set function for battles fought
	 * @param battlesFought
	 * maybe for load function
	 */
	public void battlesFoughtSet(int battlesFought) {
		this.battlesFought = battlesFought;
	}
	
	/**
	 * increments the battlesFought value => called after each battle
	 */
	public void battlesFoughtInc() {
		this.battlesFought++;
	}
	
	@Override
	public Weapon makeWeapon(int val){
		return new Weapon(this.strGet(), this.dexGet(), this.cintGet(), 0);
	}

	@Override
	public Armor makeArmor(int val){
		return new Armor(0, 0, 0, 1);
	}

	public int playerPositionGet() {
		return playerPosition;
	}

	public void playerPositionSet(int playerPosition) {
		this.playerPosition = playerPosition;
	}

	
}
