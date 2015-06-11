package de.htwg.TextAdventure.items;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import de.htwg.TextAdventure.items.Armor;
import de.htwg.TextAdventure.items.Armor.AType;

public class ArmorTest {

	Armor testArm;
	Armor testArm_old;
	Armor testArm3k;
	Armor testArmrnd;
	final int ZERO = 0;
	final int ONE = 1;
	final int ONEK = 1111;
	final int THREE = 3;
	final int TWO = 2;
	final int FIVE = 5;
	
	@Before
	public void setUp() {
		testArm_old = new Armor(ZERO, ZERO, ZERO, ONE);
		testArm = new Armor(ONE, ONE, ONE, ONE);
		testArm3k = new Armor(ZERO, ZERO, ZERO, THREE);
		testArmrnd = new Armor(TWO, FIVE, THREE, ONE);
	}
	
	@Test
	public void testDmgBlockGet() {
		assertEquals(testArm.dmgBlockGet(), ONE);
	}
	
	@Test
	public void testReqIntGet() {
		assertEquals(testArm.reqIntGet(), ONE);
	}
	
	@Test
	public void testReqDexGet() {
		assertEquals(testArm.reqDexGet(), ONE);
	}
	
	@Test
	public void testReqStrGet() {
		assertEquals(testArm.reqStrGet(), ZERO);
	}
	
	@Test
	public void testTypeGet() {
		assertEquals(testArm.typeGet(), AType.CLOTH_ARMOR);
	}
	
	@Test
	public void testGiveArmor() {
		Armor tmp = new Armor(ONE, ONE, ONE, ONE);
		assertArmorEquals(tmp, testArm.giveArmor());
		assertFalse(tmp == testArm);
	}
	
	@Test
	public void testTypeSet() {
		testArm.typeSet(ZERO);
		assertEquals(testArm.typeGet(), AType.NO_ARMOR);
	}
	
	@Test
	public void testTypeToBonus() {
		Armor A0 = new Armor(1,1,1,0);
		Armor A1 = new Armor(1,1,1,1);
		Armor A2 = new Armor(1,1,1,2);
		Armor A3 = new Armor(1,1,1,3);
		Armor A4 = new Armor(1,1,1,4);
		Armor A5 = new Armor(1,1,1,5);
	}

	@Test
	public void testAssertArmorEquals() {
		assertArmorEquals(null, null);
		try{
			assertArmorEquals(null, testArm);
		} catch(AssertionError e) {	}
		try{
			assertArmorEquals(testArm, testArm);
		} catch(AssertionError e) {	}
		try{
			assertArmorEquals(testArm, testArm3k);
		} catch(AssertionError e) {	}
		try{
			assertArmorEquals(new Armor(0, 1, 1, 1), new Armor(1, 1, 1, 0));
		} catch(AssertionError e) {	}
		try{
			assertArmorEquals(new Armor(1, 0, 1, 1), new Armor(1, 1, 0, 1));
		} catch(AssertionError e) {	}
		try{
			assertArmorEquals(new Armor(1, 1, 0, 1), new Armor(1, 0, 1, 1));
		} catch(AssertionError e) {	}
		try{
			assertArmorEquals(new Armor(1, 1, 1, 0), new Armor(0, 1, 1, 1));
		} catch(AssertionError e) {	}
		
	}	
	
	
	/**
	 * tests if the Armors equal in everything dmgBlock,...
	 * @param a1 Armor one
	 * @param a2 Armor two
	 */
	static public void assertArmorEquals(Armor a1, Armor a2){
		if(a1 == null && a2 == null)
			/*throw new AssertionError("Armors are both null")*/
			return;
		if(a1 == null || a2 == null)
			throw new AssertionError("One of the Armors is null");
		if(a1 == a2)
			throw new AssertionError("Same Object");
		if(a1.dmgBlockGet() == a2.dmgBlockGet() &&
			a1.reqDexGet() == a2.reqDexGet() &&
			a1.reqIntGet() == a2.reqIntGet() &&
			a1.reqStrGet() == a2.reqStrGet() &&
			a1.typeGet() == a2.typeGet())
			return;
		else throw new AssertionError("Armors don't match");
		
	}
	
}