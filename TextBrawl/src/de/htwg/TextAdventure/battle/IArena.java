package de.htwg.TextAdventure.battle;

import de.htwg.TextAdventure.chars.INPC;
import de.htwg.TextAdventure.chars.IPlayer;

public interface IArena {

	public abstract boolean battle(IPlayer player, INPC enemy);

}