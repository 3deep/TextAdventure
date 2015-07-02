package de.htwg.TextAdventure.model.impl;

import java.util.Random;

import de.htwg.TextAdventure.model.IArmor;
import de.htwg.TextAdventure.model.IItemFactory;
import de.htwg.TextAdventure.model.IWeapon;

public class ItemFactory implements IItemFactory {
	
	private Random rnd;
	
	public ItemFactory(){
		rnd = new Random();
	}
	
	/* (non-Javadoc)
	 * @see de.htwg.TextAdventure.items.IItemFactory#newArmor(int)
	 */
	@Override
	public IArmor newArmor(int reqStr, int reqInt, int reqDex, int type){
		return new Armor(reqStr, reqDex, reqInt, type);
	}
	
	/* (non-Javadoc)
	 * @see de.htwg.TextAdventure.items.IItemFactory#newWeapon(int)
	 */
	@Override
	public IWeapon newWeapon(int reqStr, int reqInt, int reqDex, int type){
		return new Weapon(reqStr, reqInt, reqDex, type);
	}

	@Override
	public IArmor newRandomArmor(int roll) {
		return new Armor(rnd.nextInt(roll), rnd.nextInt(roll), rnd.nextInt(roll), rnd.nextInt(roll));
	}

	@Override
	public IWeapon newRandomWeapon(int roll) {
		return new Weapon(rnd.nextInt(roll), rnd.nextInt(roll), rnd.nextInt(roll), rnd.nextInt(roll));
	}

}
