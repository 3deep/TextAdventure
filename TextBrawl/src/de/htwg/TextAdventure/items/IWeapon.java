package de.htwg.TextAdventure.items;

import de.htwg.TextAdventure.items.Weapon.WType;

public interface IWeapon {

	/**
	 * Getter function for reqStr
	 * @return reqStr
	 */
	public abstract int reqStrGet();

	/**
	 * Getter function for reqDex
	 * @return reqDex
	 */
	public abstract int reqDexGet();

	/**
	 * Getter function for reqInt
	 * @return reqInt
	 */
	public abstract int reqIntGet();

	/**
	 * Getter function for dmg
	 * @return dmg
	 */
	public abstract int dmgGet();

	/**
	 * Getter function for weapon
	 * @return weapon (self)
	 */
	public abstract IWeapon giveWeapon();

	/**
	 * Getter function for WType
	 * @return type
	 */
	public abstract WType typeGet();

	/**
	 * Sets the type to corresponding numerical Value
	 */
	public abstract void typeSet(int type);

	public abstract String toString();

}