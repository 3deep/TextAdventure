package de.htwg.TextAdventure.model.impl;

import static org.junit.Assert.*;

import org.junit.Test;

import de.htwg.TextAdventure.model.IArmor;
import de.htwg.TextAdventure.model.IItemFactory;
import de.htwg.TextAdventure.model.IWeapon;
import de.htwg.TextAdventure.model.impl.Player;
import de.htwg.TextAdventure.model.impl.WeaponTest;
import de.htwg.TextAdventure.model.impl.ArmorTest;

public class PlayerTest {

	final int ZERO = 0;
	final int ONE = 1;
	Player testPlayer = new Player(ONE, ZERO, ZERO, ZERO, ZERO);
	IItemFactory factory = new ItemFactory();
	
	@Test
	public void testBattlesFoughtGet() {
		assertEquals(testPlayer.battlesFoughtGet(), ZERO);
	}
	
	@Test
	public void testBattlesFoughtInc() {
		int x = testPlayer.battlesFoughtGet() + 1;
		testPlayer.battlesFoughtInc();
		assertEquals(x, testPlayer.battlesFoughtGet());
	}
	
	@Test
	public void testBattlesFoughtSet() {
		testPlayer.battlesFoughtSet(ONE);
		assertEquals(testPlayer.battlesFoughtGet(), ONE);
		testPlayer.battlesFoughtSet(ZERO);
		assertEquals(testPlayer.battlesFoughtGet(), ZERO);
	}

	@Test
	public  void testPlayerPositionGet(){
		assertEquals(testPlayer.playerPositionGet(), ZERO);
	};

	@Test
	public  void testPlayerPositionSet(){
		assertEquals(testPlayer.playerPositionGet(), ZERO);
		testPlayer.playerPositionSet(ONE);
		assertEquals(testPlayer.playerPositionGet(), ONE);
	};

	@Test
	public void testCurrentHealthGet(){
		assertEquals(testPlayer.currentHealthGet(), ONE);
	};

	@Test
	public  void testMaxHealthGet(){
		assertEquals(testPlayer.maxHealthGet(), ONE);
	};

	@Test
	public  void testStrGet(){
		assertEquals(testPlayer.strGet(), ZERO);
	};

	@Test
	public  void testDexGet(){
		assertEquals(testPlayer.dexGet(), ZERO);
	};

	@Test
	public  void testCintGet(){
		assertEquals(testPlayer.cintGet(), ZERO);
	};

	@Test
	public  void testSpeedGet(){
		assertEquals(testPlayer.speedGet(), ZERO);
	};

	@Test
	public  void testWepGet(){
		WeaponTest.assertWeaponEquals(testPlayer.wepGet(), factory.newWeapon(3, 3, 3, 0));
	};

	@Test
	public  void testArmGet(){
		ArmorTest.assertArmorEquals(testPlayer.armGet(), factory.newArmor(0, 0, 0, 1));
	};

	@Test
	public  void testCheckHealth(){
		assertTrue(testPlayer.checkHealth());
	};

	@Test
	public  void testDamage(){
		testPlayer.damage(ONE);
		assertFalse(testPlayer.checkHealth());
	};

	@Test
	public  void testGiveArmor(){
		IArmor tmp = factory.newArmor(5, 5, 5, 1);
		IArmor tmp2 = factory.newArmor(5, 5, 5, 1);
		testPlayer.giveArmor(tmp);
		ArmorTest.assertArmorEquals(tmp2, testPlayer.armGet());
	};

	@Test
	public  void testGiveWeapon(){
		IWeapon tmp = factory.newWeapon(5, 5, 5, 1);
		IWeapon tmp2 = factory.newWeapon(5, 5, 5, 1);
		testPlayer.giveWeapon(tmp);
		WeaponTest.assertWeaponEquals(tmp2, testPlayer.wepGet());
	};

	@Test
	public  void testRest(){
		testPlayer.damage(ONE);
		assertFalse(testPlayer.checkHealth());
		testPlayer.rest();
		assertTrue(testPlayer.checkHealth());
	};

	@Test
	public  void testIncStr(){
		testPlayer.incStr();
		assertEquals(testPlayer.strGet(), ONE);
	};

	@Test
	public  void testInccint(){
		testPlayer.inccint();
		assertEquals(testPlayer.cintGet(), ONE);
	};

	@Test
	public  void testIncDex(){
		testPlayer.incDex();
		assertEquals(testPlayer.dexGet(), ONE);
	};

	@Test
	public  void testIncSpeed(){
		testPlayer.incSpeed();
		assertEquals(testPlayer.speedGet(), ONE);
	};

	@Test
	public void testIncHP(){
		testPlayer.incHP();
		assertEquals(testPlayer.maxHealthGet(), ONE + ONE + ONE);
	};

	@Test
	public void testGetStatPoints(){
		assertEquals(testPlayer.getStatPoints(), ZERO);
	};

	@Test
	public void testIncStatPoints(){
		testPlayer.incStatPoints();
		assertEquals(testPlayer.getStatPoints(), ONE);
	};

	@Test
	public void testIsAlive(){
		assertTrue(testPlayer.isAlive());
	};

	@Test
	public void testDead(){
		testPlayer.dead();
		assertFalse(testPlayer.isAlive());
	};

}
