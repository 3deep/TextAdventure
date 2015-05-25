package items;

import static org.junit.Assert.*;

import org.junit.Test;

public class WeaponTest {

	@Test
	public void test() {
		fail("Not yet implemented");
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
