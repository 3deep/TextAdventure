package de.htwg.TextAdventure.Gamestate;

import de.htwg.TextAdventure.controller.TextAdventureController;

public class GameStateExplore implements GameState {

	@Override
	public void switchStates(TextAdventureController controller) {
		controller.setState(new GameStateBattle());
		
	}

}
