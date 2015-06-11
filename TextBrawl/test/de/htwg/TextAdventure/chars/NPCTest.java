package de.htwg.TextAdventure.chars;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import de.htwg.TextAdventure.chars.NPC;

public class NPCTest {


	final int ZERO = 0;
	final int ONE = 1;
	NPC testNPC;
	NPC testNPC2 = new NPC(2);
	
	@Before
	public void setUp() {
		testNPC = new NPC(1);
	}
	
	@Test
	public void testIsFriendly() {
		assertEquals(testNPC.isFriendly(), true);
		assertEquals(testNPC2.isFriendly(), false);
	}
	
	@Test
	public void testSetFriendly() {
		testNPC.setFriendly(true);
		assertEquals(testNPC.isFriendly(), true);
		testNPC.setFriendly(false);
	}
	
	@Test
	public void testTypeGet() {
		assertEquals(testNPC.typeGet(), testNPC.typeGet());
	}
	
	@Test
	public void testTypeSet() {
		testNPC.typeSet(ONE);
		assertEquals(testNPC.typeGet(), ONE);
		testNPC.typeSet(ZERO);
	}

}
