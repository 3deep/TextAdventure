package htwg.de.chars;

import static org.junit.Assert.*;
import htwg.de.chars.Character;
import htwg.de.items.Armor;
import htwg.de.items.ArmorTest;
import htwg.de.items.Weapon;
import htwg.de.items.WeaponTest;

import org.junit.Before;
import org.junit.Test;

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
