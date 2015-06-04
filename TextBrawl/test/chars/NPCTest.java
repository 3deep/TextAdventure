package chars;

import static org.junit.Assert.*;
import org.junit.Test;

public class NPCTest {


	final int ZERO = 0;
	final int ONE = 1;
	NPC testNPC = new NPC(ZERO);
	
	@Test
	public void isFriendlyTest() {
		assertEquals(testNPC.isFriendly(), false);
	}
	
	@Test
	public void setFriendlyTest() {
		testNPC.setFriendly(true);
		assertEquals(testNPC.isFriendly(), true);
		testNPC.setFriendly(false);
	}
	
	@Test
	public void typeGetTest() {
		assertEquals(testNPC.typeGet(), ZERO);
	}
	
	@Test
	public void typeSetTest() {
		testNPC.typeSet(ONE);
		assertEquals(testNPC.typeGet(), ONE);
		testNPC.typeSet(ZERO);
	}

}
