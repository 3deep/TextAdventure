package de.htwg.TextAdventure.model;


public interface IItemFactory {

	public abstract IArmor newArmor(int reqStr, int reqInt, int reqDex, int type);

	public abstract IWeapon newWeapon(int reqStr, int reqInt, int reqDex, int type);

	public abstract IArmor newRandomArmor(int roll);

	public abstract IWeapon newRandomWeapon(int roll);

}