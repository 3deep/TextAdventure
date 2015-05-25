package chars;

import static org.junit.Assert.*;
import items.ArmorTest;
import items.Armor;
import items.ItemGeneration;
import items.Weapon;
import items.WeaponTest;

import org.junit.Test;

public class NPCTest {

	@Test
	public void test() {
		final int ZERO = 0;
		final int ONE = 1;
		NPC testNPC = new NPC(ZERO);
		Armor testArm = ItemGeneration.genNewArmor(ZERO);
		Weapon testWep = ItemGeneration.genNewWeapon(ZERO);
		Weapon testWepONE = ItemGeneration.genNewWeapon(ONE);
		assertFalse(testNPC.isFriendly());
		testNPC.setFriendly(true);
		assertTrue(testNPC.isFriendly());
		assertEquals(testNPC.typeGet(), ZERO);
		testNPC.typeSet(ONE);
		assertEquals(testNPC.typeGet(), ONE);
		assertEquals(testNPC.cintGet(), ZERO);
		assertEquals(testNPC.dexGet(), ZERO);
		assertEquals(testNPC.strGet(), ZERO);
		assertEquals(testNPC.speedGet(), ZERO);
		assertEquals(testNPC.currentHealthGet(), ZERO);
		assertEquals(testNPC.maxHealthGet(), ZERO);
		ArmorTest.assertArmorEquals(testNPC.armGet(), testArm);
		WeaponTest.assertWeaponEquals(testNPC.wepGet(), testWep);
		testNPC.allSet(ONE, ONE, ONE, ONE, ONE, ZERO, ONE);
		assertEquals(testNPC.cintGet(), ONE);
		assertEquals(testNPC.dexGet(), ONE);
		assertEquals(testNPC.strGet(), ONE);
		assertEquals(testNPC.speedGet(), ONE);
		assertEquals(testNPC.currentHealthGet(), ONE);
		assertEquals(testNPC.maxHealthGet(), ONE);
		WeaponTest.assertWeaponEquals(testNPC.wepGet(), testWepONE);
	}

}
