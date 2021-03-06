package de.htwg.TextAdventure.model.impl;

import java.util.Random;

import de.htwg.TextAdventure.model.INPC;

public class NPC extends Character implements INPC{
	
	private boolean friendly;
	private int type;
	/**
	 * creates an NPC with the corresponding roll value
	 * @param roll
	 * contains information for region / strength (should be random based)
	 */
	public NPC(int loc){
		Random rnd = new Random();
		allSet(rnd.nextInt(loc), rnd.nextInt(loc), rnd.nextInt(loc), rnd.nextInt(loc), rnd.nextInt(loc), loc, loc);
		if(loc == 1){
			friendly = true;}
		else {
			friendly = false;}
		type = rnd.nextInt(10);
	}

	/* (non-Javadoc)
	 * @see de.htwg.TextAdventure.chars.INPC#isFriendly()
	 */
	@Override
	public boolean isFriendly() {
		return friendly;
	}

	/* (non-Javadoc)
	 * @see de.htwg.TextAdventure.chars.INPC#setFriendly(boolean)
	 */
	@Override
	public void setFriendly(boolean friendly) {
		this.friendly = friendly;
	}

	/* (non-Javadoc)
	 * @see de.htwg.TextAdventure.chars.INPC#typeGet()
	 */
	@Override
	public int typeGet() {
		return type;
	}

	/* (non-Javadoc)
	 * @see de.htwg.TextAdventure.chars.INPC#typeSet(int)
	 */
	@Override
	public void typeSet(int type) {
		this.type = type;
	}
	
}
