package items;

import static org.junit.Assert.*;
import items.Armor.AType;

import org.junit.Before;
import org.junit.Test;

public class ArmorTest {

	Armor testArm;
	final int ZERO = 0;
	final int ONE= 1;
	
	@Before
	public void setUp() {
		testArm = new Armor(ONE);
	}
	
	@Test
	public void dmgBlockGetTest() {
		assertEquals(testArm.dmgBlockGet(), ONE);
	}
	
	@Test
	public void reqIntGetTest() {
		assertEquals(testArm.reqIntGet(), ONE);
	}
	
	@Test
	public void reqDexGetTest() {
		assertEquals(testArm.reqDexGet(), ONE);
	}
	
	@Test
	public void reqStrGetTest() {
		assertEquals(testArm.reqStrGet(), ONE);
	}
	
	@Test
	public void typeGetTest() {
		assertEquals(testArm.typeGet(), AType.CLOTH_ARMOR);
	}
	
	@Test
	public void giveArmorTest() {
		Armor tmp = new Armor(ONE);
		assertArmorEquals(tmp, testArm.giveArmor());
		assertFalse(tmp == testArm);
	}
	
	@Test
	public void typeSetTest() {
		testArm.typeSet(ZERO);
		assertEquals(testArm.typeGet(), AType.NO_ARMOR);
	}
	
	/**
	 * tests if the Armors equal in everything dmgBlock,...
	 * @param a1 Armor one
	 * @param a2 Armor two
	 */
	static public void assertArmorEquals(Armor a1, Armor a2){
		if(a1 == null && a2 == null)
			return;
		if(a1 == a2)
			return;
		if(a1.dmgBlockGet() == a2.dmgBlockGet() &&
			a1.reqDexGet() == a2.reqDexGet() &&
			a1.reqIntGet() == a2.reqIntGet() &&
			a1.reqStrGet() == a2.reqStrGet() &&
			a1.typeGet() == a2.typeGet())
			return;
		else throw new AssertionError("Armors don't match");
		
	}

}
