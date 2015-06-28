package de.htwg.TextAdventure.battle;

import de.htwg.TextAdventure.chars.INPC;
import de.htwg.TextAdventure.chars.IPlayer;
import de.htwg.util.observer.IObserver;

public interface IArena {

	public abstract int battle(IPlayer player, INPC enemy);
	
	public abstract void addObserver(IObserver s);
	
	public abstract String getFightStatus();

}