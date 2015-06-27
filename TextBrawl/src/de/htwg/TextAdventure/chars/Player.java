package de.htwg.TextAdventure.chars;

import de.htwg.TextAdventure.items.Armor;
import de.htwg.TextAdventure.items.IArmor;
import de.htwg.TextAdventure.items.IWeapon;
import de.htwg.TextAdventure.items.Weapon;

public class Player extends Character implements IPlayer {
	
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

	/* (non-Javadoc)
	 * @see de.htwg.TextAdventure.chars.IPlayer#battlesFoughtGet()
	 */
	@Override
	public int battlesFoughtGet() {
		return battlesFought;
	}

	/* (non-Javadoc)
	 * @see de.htwg.TextAdventure.chars.IPlayer#battlesFoughtSet(int)
	 */
	@Override
	public void battlesFoughtSet(int battlesFought) {
		this.battlesFought = battlesFought;
	}
	
	/* (non-Javadoc)
	 * @see de.htwg.TextAdventure.chars.IPlayer#battlesFoughtInc()
	 */
	@Override
	public void battlesFoughtInc() {
		this.battlesFought++;
	}
	
	/* (non-Javadoc)
	 * @see de.htwg.TextAdventure.chars.IPlayer#makeWeapon(int)
	 */
	@Override
	public IWeapon makeWeapon(int val){
		return new Weapon(this.strGet(), this.dexGet(), this.cintGet(), 0);
	}

	/* (non-Javadoc)
	 * @see de.htwg.TextAdventure.chars.IPlayer#makeArmor(int)
	 */
	@Override
	public IArmor makeArmor(int val){
		return new Armor(0, 0, 0, 1);
	}

	/* (non-Javadoc)
	 * @see de.htwg.TextAdventure.chars.IPlayer#playerPositionGet()
	 */
	@Override
	public int playerPositionGet() {
		return playerPosition;
	}

	/* (non-Javadoc)
	 * @see de.htwg.TextAdventure.chars.IPlayer#playerPositionSet(int)
	 */
	@Override
	public void playerPositionSet(int playerPosition) {
		this.playerPosition = playerPosition;
	}
	
	@Override
	public void giveArmor(IArmor armor){
		arm = armor;
	}
	
	@Override
	public void giveWeapon(IWeapon weapon){
		wep = weapon;
	}
	
	@Override
	public void rest() {
		currentHealth = maxHealth;
	}

	@Override
	public void incStr() {
		str++;
		
	}

	@Override
	public void inccint() {
		cint++;
		
	}

	@Override
	public void incDex() {
		dex++;
		
	}

	@Override
	public void incSpeed() {
		speed++;
		
	}

	@Override
	public void incHP() {
		maxHealth += 2;
		
	}

	
}
