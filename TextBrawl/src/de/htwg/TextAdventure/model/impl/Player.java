package de.htwg.TextAdventure.model.impl;

import de.htwg.TextAdventure.model.IArmor;
import de.htwg.TextAdventure.model.IPlayer;
import de.htwg.TextAdventure.model.IWeapon;

public class Player extends Character implements IPlayer {
	
	private int playerPosition;

	private int battlesFought;
	
	private int statPoints;
	
	private boolean alive;
	
	/**
	 * creates the player with the corresponding roll value
	 * @param roll
	 * contains information from start screen (type, etc.)
	 */
	public Player(int maxH, int str, int dex, int cint, int speed, int armorRoll, int wepRoll){
		allSet(maxH, str, dex, cint, speed, armorRoll, wepRoll);
		playerPosition = 0;
		statPoints = 0;
		alive = true;
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
	public void allSet(int maxH, int str, int dex, int cint, int speed, int armorRoll, int wepRoll){
		maxHealth = maxH;
		currentHealth = maxH;
		this.str = str;
		this.dex = dex;
		this.cint = cint;
		this.speed = speed;
		arm = factor.newArmor(0, 0, 0, 1);
		wep = factor.newWeapon(3, 3, 3, 0);
		//arm = makeArmor(armorRoll);
		//wep = makeWeapon(wepRoll);
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
		statPoints--;
	}

	@Override
	public void inccint() {
		cint++;
		statPoints--;
	}

	@Override
	public void incDex() {
		dex++;
		statPoints--;
	}

	@Override
	public void incSpeed() {
		speed++;
		statPoints--;
	}

	@Override
	public void incHP() {
		maxHealth += 2;
		statPoints--;
	}

	public int getStatPoints() {
		return statPoints;
	}
	
	public void incStatPoints(){
		statPoints++;
	}
	
	public boolean isAlive() {
		return alive;
	}
	
	public void dead() {
		this.alive = false;
	}
	
	@Override
	public void damage(int dmg){
		currentHealth = currentHealth - dmg;
		if(currentHealth <= 0)
			dead();
	}
}
