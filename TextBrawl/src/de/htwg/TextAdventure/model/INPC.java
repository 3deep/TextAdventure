package de.htwg.TextAdventure.model;


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
	
	public abstract int currentHealthGet();

	public abstract int maxHealthGet();

	public abstract int strGet();

	public abstract int dexGet();

	public abstract int cintGet();

	public abstract int speedGet();

	public abstract IWeapon wepGet();

	public abstract IArmor armGet();
	
	public abstract boolean checkHealth();
	
	public abstract void damage(int dmg);

}