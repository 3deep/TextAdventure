package de.htwg.TextAdventure.chars;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import de.htwg.TextAdventure.chars.Character;
import de.htwg.TextAdventure.items.Armor;
import de.htwg.TextAdventure.items.ArmorTest;
import de.htwg.TextAdventure.items.Weapon;
import de.htwg.TextAdventure.items.WeaponTest;

public class CharacterTest {

	final int ZERO = 0;
	final int ONE = 1;
	Character testChar = new Character();
	
	@Before
	public void setUp() {
		testChar.allSet(ONE, ONE, ONE, ONE, ONE, ONE, ONE);
	}
	
	@Test
	public void testAllSet() {
		testChar.allSet(ZERO, ZERO, ZERO, ZERO, ZERO, ZERO, ZERO);
		assertEquals(testChar.cintGet(), ZERO);
		assertEquals(testChar.strGet(), ZERO);
		assertEquals(testChar.dexGet(), ZERO);
		assertEquals(testChar.currentHealthGet(), ZERO);
		assertEquals(testChar.maxHealthGet(), ZERO);
		assertEquals(testChar.speedGet(), ZERO);
		ArmorTest.assertArmorEquals(testChar.armGet(), new Armor(ZERO));
		WeaponTest.assertWeaponEquals(testChar.wepGet(), new Weapon(ZERO));
	}
	
	@Test
	public void testArmGet() {
		ArmorTest.assertArmorEquals(testChar.armGet(), new Armor(ONE));
	}
	
	@Test
	public void testWepGet() {
		WeaponTest.assertWeaponEquals(testChar.wepGet(), new Weapon(ONE));
	}

	@Test
	public void testCintGet() {
		assertEquals(testChar.cintGet(), ONE);
	}

	@Test
	public void testDexGet() {
		assertEquals(testChar.dexGet(), ONE);
	}

	@Test
	public void testStrGet() {
		assertEquals(testChar.strGet(), ONE);
	}

	@Test
	public void testSpeedGet() {
		assertEquals(testChar.speedGet(), ONE);
	}

	@Test
	public void testMaxHealthGet() {
		assertEquals(testChar.maxHealthGet(), ONE);
	}

	@Test
	public void testCurrentHealthGet() {
		assertEquals(testChar.currentHealthGet(), ONE);
	}

}
