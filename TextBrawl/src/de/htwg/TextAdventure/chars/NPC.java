package de.htwg.TextAdventure.chars;

import java.util.Random;

import de.htwg.TextAdventure.items.Armor;
import de.htwg.TextAdventure.items.Weapon;

public class NPC extends Character{
	
	private boolean friendly;
	private int type;
	private Random rnd = new Random();
	/**
	 * creates an NPC with the corresponding roll value
	 * @param roll
	 * contains information for region / strength (should be random based)
	 */
	public NPC(int loc){
		Random rnd = new Random();
		allSet(rnd.nextInt(loc), rnd.nextInt(loc), rnd.nextInt(loc), rnd.nextInt(loc), rnd.nextInt(loc), loc, loc);
		if(loc == 1)
			friendly = true;
		else 
			friendly = false;
		type = rnd.nextInt(10);
	}

	/**
	 * Checks for friendliness of NPC (true => NPC is a shop)
	 * @return friendly
	 */
	public boolean isFriendly() {
		return friendly;
	}

	/**
	 * Set function for boolean friendly
	 * @param friendly
	 * true/false
	 */
	public void setFriendly(boolean friendly) {
		this.friendly = friendly;
	}

	/**
	 * Returns the type of NPC (TODO: implement different types of NPC / Characters)
	 * @return int => will probably become enum
	 */
	public int typeGet() {
		return type;
	}

	/**
	 * Set function for the type
	 * @param type
	 * type of NPC
	 */
	public void typeSet(int type) {
		this.type = type;
	}
	
	@Override
	public Armor makeArmor(int val){
		return new Armor(rnd.nextInt(4), rnd.nextInt(val), rnd.nextInt(val), rnd.nextInt(val));
	}
	
	@Override
	public Weapon makeWeapon(int val){
		return new Weapon(rnd.nextInt(15), rnd.nextInt(val), rnd.nextInt(val), rnd.nextInt(val));
	}
	
}
