package htwg.de.chars;

import static org.junit.Assert.*;
import htwg.de.chars.Player;

import org.junit.Test;

public class PlayerTest {

	final int ZERO = 0;
	final int ONE = 1;
	Player testPlayer = new Player(ZERO);
	
	@Test
	public void testBattlesFoughtGet() {
		assertEquals(testPlayer.battlesFoughtGet(), ZERO);
	}
	
	@Test
	public void testBattlesFoughtInc() {
		int x = testPlayer.battlesFoughtGet() + 1;
		testPlayer.battlesFoughtInc();
		assertEquals(x, testPlayer.battlesFoughtGet());
	}
	
	@Test
	public void testBattlesFoughtSet() {
		testPlayer.battlesFoughtSet(ONE);
		assertEquals(testPlayer.battlesFoughtGet(), ONE);
		testPlayer.battlesFoughtSet(ZERO);
		assertEquals(testPlayer.battlesFoughtGet(), ZERO);
	}

}
