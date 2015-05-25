package chars;

import static org.junit.Assert.*;
import items.Armor;
import items.ArmorTest;
import items.ItemGeneration;
import items.Weapon;
import items.WeaponTest;

import org.junit.Test;

public class PlayerTest {

	@Test
	public void test() {
		final int ZERO = 0;
		final int ONE = 1;
		Player testPlayer = new Player(ZERO);
		Armor testArm = ItemGeneration.genNewArmor(ZERO);
		Weapon testWep = ItemGeneration.genNewWeapon(ZERO);
		Weapon testWepONE = ItemGeneration.genNewWeapon(ONE);
		

		assertEquals(testPlayer.cintGet(), ZERO);
		assertEquals(testPlayer.dexGet(), ZERO);
		assertEquals(testPlayer.strGet(), ZERO);
		assertEquals(testPlayer.speedGet(), ZERO);
		assertEquals(testPlayer.currentHealthGet(), ZERO);
		assertEquals(testPlayer.maxHealthGet(), ZERO);
		ArmorTest.assertArmorEquals(testPlayer.armGet(), testArm);
		WeaponTest.assertWeaponEquals(testPlayer.wepGet(), testWep);
		testPlayer.allSet(ONE, ONE, ONE, ONE, ONE, ZERO, ONE);
		assertEquals(testPlayer.cintGet(), ONE);
		assertEquals(testPlayer.dexGet(), ONE);
		assertEquals(testPlayer.strGet(), ONE);
		assertEquals(testPlayer.speedGet(), ONE);
		assertEquals(testPlayer.currentHealthGet(), ONE);
		assertEquals(testPlayer.maxHealthGet(), ONE);
		WeaponTest.assertWeaponEquals(testPlayer.wepGet(), testWepONE);

		assertEquals(testPlayer.battlesFoughtGet(), ZERO);
		testPlayer.battlesFoughtInc();
		assertEquals(testPlayer.battlesFoughtGet(), ONE);
		testPlayer.battlesFoughtSet(ZERO);
		assertEquals(testPlayer.battlesFoughtGet(), ZERO);
	}

}
