package de.htwg.TextAdventure.chars;

import de.htwg.TextAdventure.items.Armor;
import de.htwg.TextAdventure.items.ItemGeneration;
import de.htwg.TextAdventure.items.Weapon;

public class Character {

	private int currentHealth;
	private int maxHealth;
	private int str;
	private int dex;
	private int cint;
	private int speed;
	private Armor arm;
	private Weapon wep;

	/**
	 * retruns the entitiy's currentHealth
	 * @return returns currentHealth as int
	 */
	public int currentHealthGet(){
		return currentHealth;
	}

	/**
	 * retruns the entitiy's maxHealth
	 * @return returns maxHealth as int
	 */
	public int maxHealthGet(){
		return maxHealth;
	}
	
	/**
	 * retruns required str
	 * @return returns str as int
	 */
	public int strGet(){
		return str;
	}

	/**
	 * retruns required str
	 * @return returns str as int
	 */
	public int dexGet(){
		return dex;
	}

	/**
	 * retruns required str
	 * @return returns str as int
	 */
	public int cintGet(){
		return cint;
	}

	/**
	 * retruns required str
	 * @return returns str as int
	 */
	public int speedGet(){
		return speed;
	}

	/**
	 * retruns required str
	 * @return returns str as int
	 */
	public Armor armGet(){
		return arm;
	}

	/**
	 * retruns required str
	 * @return returns str as int
	 */
	public Weapon wepGet(){
		return wep;
	}

	/**
	 * set the whole character class based on the parameters
	 * @param maxH
	 * maximum Health
	 * @param str
	 * gives str
	 * @param dex
	 * gives dex
	 * @param cint
	 * gives int
	 * @param speed
	 * gives speed
	 * @param armorRoll
	 * roll value for the Armor
	 * @param wepRoll
	 * roll value for the Weapon
	 */
	public void allSet(int maxH, int str, int dex, int cint, int speed, int armorRoll, int wepRoll){
		maxHealth = maxH;
		currentHealth = maxH;
		this.str = str;
		this.dex = dex;
		this.cint = cint;
		this.speed = speed;
		arm = ItemGeneration.genNewArmor(armorRoll);
		wep = ItemGeneration.genNewWeapon(wepRoll);
	}
	
}
