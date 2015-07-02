package de.htwg.TextAdventure.model.impl;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class WorldTest {

	final int ZERO = 0;
	final int FOUR = 4;
	final int SIX = 6;
	final int SEVEN = 7;
	final int NINE = 9;
	World werld;
	@Before
	public void setUp() throws Exception {
		werld = new World();
	}

	@Test
	public void testExplore(){
		for(int i = 1; i < 50; i++)
			werld.explore(ZERO);
		for(int i = 1; i < 100; i++)
			werld.explore(FOUR);
		for(int i = 1; i < 50; i++)
			werld.explore(SIX);
		for(int i = 1; i < 100; i++)
			werld.explore(SEVEN);
		for(int i = 1; i < 50; i++)
			werld.explore(NINE);
	}

	@Test
	public void testDiscoveredTown(){
		assertTrue(werld.discoveredTown());
	}

	@Test
	public void testDiscoveredForest(){
		assertTrue(werld.discoveredForest());
	}

	@Test
	public void testDiscoveredRiver(){
		assertFalse(werld.discoveredRiver());
	}

	@Test
	public void testDiscoveredForestCave(){
		assertFalse(werld.discoveredForestCave());
	}

	@Test
	public void testDiscoveredGlimmeringShroomCavern(){
		assertFalse(werld.discoveredGlimmeringShroomCavern());
	}

	@Test
	public void testDiscoveredMagmaDepths(){
		assertFalse(werld.discoveredMagmaDepths());
	}

	@Test
	public void testDiscoveredPortal(){
		assertFalse(werld.discoveredPortal());
	}

	@Test
	public void testDiscoveredOtherworld(){
		assertFalse(werld.discoveredOtherworld());
	}

}
