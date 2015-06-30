package de.htwg.TextAdventure.battle;

import de.htwg.TextAdventure.chars.INPC;
import de.htwg.TextAdventure.chars.IPlayer;
import de.htwg.TextAdventure.items.IArmor;
import de.htwg.TextAdventure.items.IWeapon;
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