package de.htwg.TextAdventure;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;

import de.htwg.TextAdventure.controller.ITextAdventureController;
import de.htwg.TextAdventure.model.IPlayer;
import de.htwg.TextAdventure.model.IWorld;

public final class TextAdventureModule extends AbstractModule {


	/*@Override
	public void configure(Binder binder) {

		binder.bind(ITextAdventureController.class).to(de.htwg.TextAdventure.controller.impl.TextAdventureController.class);
		
	}*/

	@Override
	protected void configure() {

		bind(ITextAdventureController.class).to(de.htwg.TextAdventure.controller.impl.TextAdventureController.class).in(Singleton.class);
		bind(IPlayer.class).to(de.htwg.TextAdventure.model.impl.Player.class);
		bind(IWorld.class).to(de.htwg.TextAdventure.model.impl.World.class);
		
	}

}
