package de.htwg.TextAdventure.chars;

import de.htwg.TextAdventure.items.IArmor;
import de.htwg.TextAdventure.items.IWeapon;

public interface ICharacter {

	/**
	 * retruns the entitiy's currentHealth
	 * @return returns currentHealth as int
	 */
	public abstract int currentHealthGet();

	/**
	 * retruns the entitiy's maxHealth
	 * @return returns maxHealth as int
	 */
	public abstract int maxHealthGet();

	/**
	 * retruns required str
	 * @return returns str as int
	 */
	public abstract int strGet();

	/**
	 * retruns required str
	 * @return returns str as int
	 */
	public abstract int dexGet();

	/**
	 * retruns required str
	 * @return returns str as int
	 */
	public abstract int cintGet();

	/**
	 * retruns required str
	 * @return returns str as int
	 */
	public abstract int speedGet();

	/**
	 * retruns required str
	 * @return returns str as int
	 */
	public abstract IArmor armGet();

	/**
	 * retruns required str
	 * @return returns str as int
	 */
	public abstract IWeapon wepGet();

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
	public abstract void allSet(int maxH, int str, int dex, int cint,
			int speed, int armorRoll, int wepRoll);

	/**
	 * Dummy function for overwrite
	 * @param val likely the locationId or player creation token
	 * @return Armor for this character
	 */
	public abstract IArmor makeArmor(int val);

	/**
	 * Dummy function for overwrite
	 * @param val likely the locationId or player creation token
	 * @return Weapon for this character
	 */
	public abstract IWeapon makeWeapon(int val);

}