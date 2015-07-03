package de.htwg.TextAdventure.model;


public interface IPlayer {

	/**
	 * Gives the number of fought Battles
	 * @return int of fought battles (lvlup system?)
	 */
	public abstract int battlesFoughtGet();

	/**
	 * Set function for battles fought
	 * @param battlesFought
	 * maybe for load function
	 */
	public abstract void battlesFoughtSet(int battlesFought);

	/**
	 * increments the battlesFought value => called after each battle
	 */
	public abstract void battlesFoughtInc();

	/**
	 * retruns player position
	 * @return
	 */
	public abstract int playerPositionGet();

	/**
	 * sets Player position
	 * @param playerPosition
	 */
	public abstract void playerPositionSet(int playerPosition);

	
/**
 * returns current healhth
 * @return
 */
	public abstract int currentHealthGet();

	/**
	 * retruns maxmium health
	 * @return
	 */
	public abstract int maxHealthGet();

	/**
	 * returns strhenght
	 * @return
	 */
	public abstract int strGet();

	/**
	 * retrunds dex
	 * @return
	 */
	public abstract int dexGet();

	/**
	 * returns cint
	 * @return
	 */
	public abstract int cintGet();

	/**
	 * returns speed
	 * @return
	 */
	public abstract int speedGet();

	/**
	 * gives the weapon
	 * @return
	 */
	public abstract IWeapon wepGet();

	/**
	 * gives the armor
	 * @return
	 */
	public abstract IArmor armGet();
	
	/**
	 * if dead or alive
	 * @return
	 */
	public abstract boolean checkHealth();
	
	/**
	 * damagese the target
	 * @param dmg
	 */
	public abstract void damage(int dmg);

	/**
	 * gives the armor
	 * @param armor
	 */
	public abstract void giveArmor(IArmor armor);

	/**
	 * gives the weapon
	 * @param weapon
	 */
	public abstract void giveWeapon(IWeapon weapon);
	
	/**
	 * heal
	 */
	public abstract void rest();
	
	/**
	 * increase str
	 */
	public abstract void incStr();
	
	/**
	 * increase cint
	 */
	public abstract void inccint();
	
	/**
	 * increase dex
	 */
	public abstract void incDex();
	
	/**
	 * increase speed
	 */
	public abstract void incSpeed();
	
	/**
	 * increse hp
	 */
	public abstract void incHP();
	
	/**
	 * gets iof player has stat points
	 * @return
	 */
	public abstract int getStatPoints();
	
	/**
	 * increses statpoints
	 */
	public abstract void incStatPoints();
	
	/**
	 * if palyer is alive
	 * @return
	 */
	public abstract boolean isAlive();
	
	/**
	 * sets alive to false
	 */
	public abstract void dead();

}