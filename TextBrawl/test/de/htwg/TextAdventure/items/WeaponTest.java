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
		testWep = new Weapon(ONE, ONE, ONE, ONE);
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
		Weapon tmp = new Weapon(ONE, ONE, ONE, ONE);
		assertWeaponEquals(tmp, testWep.giveWeapon());
		assertFalse(tmp == testWep);
	}
	
	@Test
	public void testTypeToBonus() {
		new Weapon(1, 1, 1, 0);
		new Weapon(1, 1, 1, 1);
		new Weapon(1, 1, 1, 2);
		new Weapon(1, 1, 1, 3);
		new Weapon(1, 1, 1, 4);
		new Weapon(1, 1, 1, 5);
		new Weapon(1, 1, 1, 6);
		new Weapon(1, 1, 1, 7);
		new Weapon(1, 1, 1, 8);
		new Weapon(1, 1, 1, 9);
		new Weapon(1, 1, 1, 10);
		new Weapon(1, 1, 1, 11);
		new Weapon(1, 1, 1, 12);
		new Weapon(1, 1, 1, 13);
		new Weapon(1, 1, 1, 14);
	}

	/**
	 * tests if the Weapons equal in everything dmg,...
	 * @param w1 Weapon one
	 * @param w2 Weapon two
	 */
	static public void assertWeaponEquals(Weapon w1, Weapon w2){
		if(w1 == null && w2 == null)
			/*throw new AssertionError("Both Objects are null")*/
			return;
		if(w1 == null || w2 == null)
			throw new AssertionError("one of the weapons is null");
		if(w1 == w2)
			throw new AssertionError("Same Object");
		if(w1.dmgGet() == w2.dmgGet() &&
			w1.reqDexGet() == w2.reqDexGet() &&
			w1.reqIntGet() == w2.reqIntGet() &&
			w1.reqStrGet() == w2.reqStrGet() &&
			w1.typeGet() == w2.typeGet())
			return;
		else throw new AssertionError("Weapons don't match");
	}
	
	@Test
	public void testAssertWeaponEquals() {		
		assertWeaponEquals(null, null);
	try{
		assertWeaponEquals(null, testWep);
	} catch(AssertionError e) {	}
	try{
		assertWeaponEquals(testWep, testWep);
	} catch(AssertionError e) {	}
	try{
		assertWeaponEquals(testWep, new Weapon(2, 3, 5, 6));
	} catch(AssertionError e) {	}
	try{
		assertWeaponEquals(new Weapon(0, 1, 1, 1), new Weapon(1, 1, 1, 0));
	} catch(AssertionError e) {	}
	try{
		assertWeaponEquals(new Weapon(1, 0, 1, 1), new Weapon(1, 1, 0, 1));
	} catch(AssertionError e) {	}
	try{
		assertWeaponEquals(new Weapon(1, 1, 0, 1), new Weapon(1, 0, 1, 1));
	} catch(AssertionError e) {	}
	try{
		assertWeaponEquals(new Weapon(1, 1, 1, 0), new Weapon(0, 1, 1, 1));
	} catch(AssertionError e) {	}
	
}	
}
