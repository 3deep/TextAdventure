package de.htwg.TextAdventure.chars;

import static org.junit.Assert.*;

import org.junit.Test;

import de.htwg.TextAdventure.chars.NPC;

public class NPCTest {


	final int ZERO = 0;
	final int ONE = 1;
	NPC testNPC = new NPC(ZERO);
	
	@Test
	public void testIsFriendly() {
		assertEquals(testNPC.isFriendly(), false);
	}
	
	@Test
	public void testSetFriendly() {
		testNPC.setFriendly(true);
		assertEquals(testNPC.isFriendly(), true);
		testNPC.setFriendly(false);
	}
	
	@Test
	public void testTypeGet() {
		assertEquals(testNPC.typeGet(), ZERO);
	}
	
	@Test
	public void testTypeSet() {
		testNPC.typeSet(ONE);
		assertEquals(testNPC.typeGet(), ONE);
		testNPC.typeSet(ZERO);
	}

}
