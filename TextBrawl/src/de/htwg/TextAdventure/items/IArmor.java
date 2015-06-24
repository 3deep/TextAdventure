package de.htwg.TextAdventure.items;

import de.htwg.TextAdventure.items.Armor.AType;

public interface IArmor {

	/**
	 * Getter function for str
	 * @return str
	 */
	public abstract int reqStrGet();

	/**
	 * Getter function for dex
	 * @return dex
	 */
	public abstract int reqDexGet();

	/**
	 * Getter function for int
	 * @return int
	 */
	public abstract int reqIntGet();

	/**
	 * Getter function for dmgBlock
	 * @return dmgBlock
	 */
	public abstract int dmgBlockGet();

	/**
	 * Getter function for the armor
	 * @return armor (self)
	 */
	public abstract IArmor giveArmor();

	/**
	 * Getter function for AType
	 * @return type
	 */
	public abstract AType typeGet();

	/**
	 * Sets the type to corresponding numerical Value
	 */
	public abstract void typeSet(int type);

	public abstract String toString();

}