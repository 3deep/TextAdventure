package chars;

import static org.junit.Assert.*;
import org.junit.Test;

public class PlayerTest {

	final int ZERO = 0;
	final int ONE = 1;
	Player testPlayer = new Player(ZERO);
	
	@Test
	public void battlesFoughtGetTest() {
		assertEquals(testPlayer.battlesFoughtGet(), ZERO);
	}
	
	@Test
	public void battlesFoughtIncTest() {
		int x = testPlayer.battlesFoughtGet() + 1;
		testPlayer.battlesFoughtInc();
		assertEquals(x, testPlayer.battlesFoughtGet());
	}
	
	@Test
	public void battlesFoughtSetTest() {
		testPlayer.battlesFoughtSet(ONE);
		assertEquals(testPlayer.battlesFoughtGet(), ONE);
		testPlayer.battlesFoughtSet(ZERO);
		assertEquals(testPlayer.battlesFoughtGet(), ZERO);
	}

}
