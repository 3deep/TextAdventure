package de.htwg.TextAdventure.chars;

import de.htwg.TextAdventure.items.IArmor;
import de.htwg.TextAdventure.items.IWeapon;

public interface INPC {

	/**
	 * Checks for friendliness of NPC (true => NPC is a shop)
	 * @return friendly
	 */
	public abstract boolean isFriendly();

	/**
	 * Set function for boolean friendly
	 * @param friendly
	 * true/false
	 */
	public abstract void setFriendly(boolean friendly);

	/**
	 * Returns the type of NPC (TODO: implement different types of NPC / Characters)
	 * @return int => will probably become enum
	 */
	public abstract int typeGet();

	/**
	 * Set function for the type
	 * @param type
	 * type of NPC
	 */
	public abstract void typeSet(int type);

	public abstract IArmor makeArmor(int val);

	public abstract IWeapon makeWeapon(int val);

}