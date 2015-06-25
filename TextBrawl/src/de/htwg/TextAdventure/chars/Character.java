package de.htwg.TextAdventure.chars;

import de.htwg.TextAdventure.items.IArmor;
import de.htwg.TextAdventure.items.IWeapon;

public abstract class Character {

	private int currentHealth;
	private int maxHealth;
	private int str;
	private int dex;
	private int cint;
	private int speed;
	private IArmor arm;
	private IWeapon wep;

	/* (non-Javadoc)
	 * @see de.htwg.TextAdventure.chars.ICharacter#currentHealthGet()
	 */
	public int currentHealthGet(){
		return currentHealth;
	}

	/* (non-Javadoc)
	 * @see de.htwg.TextAdventure.chars.ICharacter#maxHealthGet()
	 */
	public int maxHealthGet(){
		return maxHealth;
	}
	
	/* (non-Javadoc)
	 * @see de.htwg.TextAdventure.chars.ICharacter#strGet()
	 */
	public int strGet(){
		return str;
	}

	/* (non-Javadoc)
	 * @see de.htwg.TextAdventure.chars.ICharacter#dexGet()
	 */
	public int dexGet(){
		return dex;
	}

	/* (non-Javadoc)
	 * @see de.htwg.TextAdventure.chars.ICharacter#cintGet()
	 */
	public int cintGet(){
		return cint;
	}

	/* (non-Javadoc)
	 * @see de.htwg.TextAdventure.chars.ICharacter#speedGet()
	 */
	public int speedGet(){
		return speed;
	}

	/* (non-Javadoc)
	 * @see de.htwg.TextAdventure.chars.ICharacter#armGet()
	 */
	public IArmor armGet(){
		return arm;
	}

	/* (non-Javadoc)
	 * @see de.htwg.TextAdventure.chars.ICharacter#wepGet()
	 */
	public IWeapon wepGet(){
		return wep;
	}

	/* (non-Javadoc)
	 * @see de.htwg.TextAdventure.chars.ICharacter#allSet(int, int, int, int, int, int, int)
	 */
	public void allSet(int maxH, int str, int dex, int cint, int speed, int armorRoll, int wepRoll){
		maxHealth = maxH;
		currentHealth = maxH;
		this.str = str;
		this.dex = dex;
		this.cint = cint;
		this.speed = speed;
		arm = makeArmor(armorRoll);
		wep = makeWeapon(wepRoll);
	}
	
	/* (non-Javadoc)
	 * @see de.htwg.TextAdventure.chars.ICharacter#makeArmor(int)
	 */
	public IArmor makeArmor(int val){
		return null;
	}
	
	/* (non-Javadoc)
	 * @see de.htwg.TextAdventure.chars.ICharacter#makeWeapon(int)
	 */
	public IWeapon makeWeapon(int val){
		return null;
	}
	
	
	/**
	 * checks if player health =< 0
	 * @return true if above
	 */
	public boolean checkHealth() {
		return (currentHealth > 0);
	}	
	
	/**
	 * checks if player health =< 0
	 * @return true if above
	 */
	public void damage(int dmg) {
		currentHealth = currentHealth - dmg;
	}
	
}
