package de.htwg.TextAdventure.model.impl;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import de.htwg.TextAdventure.model.INPC;
import de.htwg.TextAdventure.model.impl.NPC;

public class NPCTest {


	final int ZERO = 0;
	final int ONE = 1;
	INPC testNPC;
	INPC testNPC2 = new NPC(2);
	
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
	
	@Test
	public void testDamage() {
		int tmp = testNPC2.currentHealthGet();
		testNPC2.damage(ONE);
		assertEquals(testNPC2.currentHealthGet(), tmp - ONE);
	}

}
