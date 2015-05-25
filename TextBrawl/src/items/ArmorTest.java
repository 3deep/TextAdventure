package items;

import static org.junit.Assert.*;

import org.junit.Test;

public class ArmorTest {

	@Test
	public void test() {
		fail("Not yet implemented");
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
