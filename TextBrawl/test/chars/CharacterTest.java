package chars;

import static org.junit.Assert.*;
import items.Armor;
import items.ArmorTest;
import items.Weapon;
import items.WeaponTest;

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
	public void allSetTest() {
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
	public void armGetTest() {
		ArmorTest.assertArmorEquals(testChar.armGet(), new Armor(ONE));
	}
	
	@Test
	public void wepGetTest() {
		WeaponTest.assertWeaponEquals(testChar.wepGet(), new Weapon(ONE));
	}

	@Test
	public void cintGetTest() {
		assertEquals(testChar.cintGet(), ONE);
	}

	@Test
	public void dexGetTest() {
		assertEquals(testChar.dexGet(), ONE);
	}

	@Test
	public void strGetTest() {
		assertEquals(testChar.strGet(), ONE);
	}

	@Test
	public void speedGetTest() {
		assertEquals(testChar.speedGet(), ONE);
	}

	@Test
	public void maxHealthGetTest() {
		assertEquals(testChar.maxHealthGet(), ONE);
	}

	@Test
	public void currentHealthGetTest() {
		assertEquals(testChar.currentHealthGet(), ONE);
	}

}
