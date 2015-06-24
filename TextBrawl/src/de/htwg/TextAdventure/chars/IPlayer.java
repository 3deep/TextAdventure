package de.htwg.TextAdventure.chars;

import de.htwg.TextAdventure.items.IArmor;
import de.htwg.TextAdventure.items.IWeapon;

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

	public abstract IWeapon makeWeapon(int val);

	public abstract IArmor makeArmor(int val);

	public abstract int playerPositionGet();

	public abstract void playerPositionSet(int playerPosition);

}