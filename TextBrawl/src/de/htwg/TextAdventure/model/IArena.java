package de.htwg.TextAdventure.model;

import de.htwg.util.observer.IObserver;

public interface IArena {

	public abstract void battle(IPlayer player, INPC enemy);
	
	public abstract void attack();
	
	public abstract void flee();
	
	public abstract void addObserver(IObserver s);
	
	public abstract String getFightStatus();
	
	public abstract boolean inBattle();
	
	public abstract int fightResult();
	
	public abstract IWeapon lootW();
	
	public abstract IArmor lootA();

}