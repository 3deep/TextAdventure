package de.htwg.TextAdventure.items;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import de.htwg.TextAdventure.items.Weapon;
import de.htwg.TextAdventure.items.Weapon.WType;

public class WeaponTest {
	
	final int ZERO = 0;
	final int ONE = 1;
	Weapon testWep;
	
	@Before
	public void setUp() {
		testWep = new Weapon(ONE);
	}
	
	@Test
	public void testDmgGet() {
		assertEquals(testWep.dmgGet(), ONE);
	}
	
	@Test
	public void testReqDexGet() {
		assertEquals(testWep.reqDexGet(), ONE);
	}
	
	@Test
	public void testReqIntGet() {
		assertEquals(testWep.reqIntGet(), ONE);
	}
	
	@Test
	public void testReqStrGet() {
		assertEquals(testWep.reqStrGet(), ONE);
	}
	
	@Test
	public void testTypeGet() {
		assertEquals(testWep.typeGet(), WType.W1);
	}
	
	@Test
	public void testTypeSet() {
		testWep.typeSet(ZERO);
		assertEquals(testWep.typeGet(), WType.W0);
	}
	
	@Test
	public void testGiveWeapon() {
		Weapon tmp = new Weapon(ONE);
		assertWeaponEquals(tmp, testWep.giveWeapon());
		assertFalse(tmp == testWep);
	}

	/**
	 * tests if the Weapons equal in everything dmg,...
	 * @param w1 Weapon one
	 * @param w2 Weapon two
	 */
	static public void assertWeaponEquals(Weapon w1, Weapon w2){
		if(w1 == null && w2 == null)
			return;
		if(w1 == w2)
			return;
		if(w1.dmgGet() == w2.dmgGet() &&
			w1.reqDexGet() == w2.reqDexGet() &&
			w1.reqIntGet() == w2.reqIntGet() &&
			w1.reqStrGet() == w2.reqStrGet() &&
			w1.typeGet() == w2.typeGet())
			return;
		else throw new AssertionError("Weapons don't match");
	}
}
