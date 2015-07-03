package de.htwg.TextAdventure.model.impl;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ArenaTest {
	
	Arena aTest;
	Player p1;
	Player p2;
	Player p3;
	Player p4;
	NPC enemy1;
	NPC enemy2;
	NPC enemy3;

	@Before
	public void setUp() throws Exception {
		aTest = new Arena();
		p1 = new Player(0, 0, 0, 0, 0);
		p3 = new Player(0, 0, 0, 0, 0);
		p3.giveWeapon(new ItemFactory().newWeapon(0, 0, 0, 4));
		p2 = new Player(10, 10, 10, 10, 10);
		p2.giveArmor(new ItemFactory().newArmor(10, 10, 10, 4));
		p2.giveWeapon(new ItemFactory().newWeapon(10, 10, 10, 4));
		p4 = new Player(10, 0, 0, 0, 0);
		p4.giveArmor(new ItemFactory().newArmor(0, 0, 0, 4));
		p4.giveWeapon(new ItemFactory().newWeapon(0, 0, 0, 4));
		enemy1 = new NPC(1);
		enemy2 = new NPC(10);
		enemy3 = new NPC(1);
		enemy3.arm = new ItemFactory().newArmor(0, 0, 0, 4);
		enemy3.wep = new ItemFactory().newWeapon(0, 0, 0, 4);
	}

	@Test
	public void testBattle(){
		aTest.battle(p1, enemy2);
		aTest.attack();
		aTest.battle(p2, enemy1);
		aTest.attack();
		aTest.battle(p1, enemy1);
		aTest.attack();
		aTest.battle(p2, enemy2);
		aTest.attack();
		aTest.battle(p3, enemy1);
		aTest.attack();
		aTest.battle(p3, enemy2);
		aTest.attack();
		aTest.battle(p4, enemy1);
		aTest.attack();
		aTest.battle(p4, enemy2);
		aTest.attack();
		aTest.battle(p1, enemy3);
		aTest.attack();
		aTest.battle(p2, enemy3);
		aTest.attack();
		aTest.battle(p3, enemy3);
		aTest.attack();
		aTest.battle(p4, enemy3);
		aTest.attack();
	}

	@Test
	public void testAttack(){
		
	}

	@Test
	public void testFlee(){
		aTest.battle(p1, enemy2);
		aTest.flee();
		aTest.battle(p2, enemy1);
		aTest.flee();
		aTest.battle(p3, enemy2);
		aTest.flee();
		aTest.battle(p4, enemy1);
		aTest.flee();
		aTest.battle(p1, enemy1);
		aTest.flee();
		aTest.battle(p2, enemy2);
		aTest.flee();
		aTest.battle(p3, enemy1);
		aTest.flee();
		aTest.battle(p4, enemy2);
		aTest.flee();
		aTest.battle(p1, enemy3);
		aTest.flee();
		aTest.battle(p2, enemy3);
		aTest.flee();
		aTest.battle(p3, enemy3);
		aTest.flee();
		aTest.battle(p4, enemy3);
		aTest.flee();
	}

	@Test
	public void testAddObserver(){
		
	}

	@Test
	public void testGetFightStatus(){
		assertEquals(aTest.getFightStatus(), aTest.getFightStatus());
	}

	@Test
	public void testInBattle(){
		assertFalse(aTest.inBattle());
	}

	@Test
	public void testFightResult(){
		assertEquals(aTest.fightResult(), 0);
	}

	@Test
	public void testLootW(){
		assertEquals(aTest.lootW(), null);
	}

	@Test
	public void testLootA(){
		assertEquals(aTest.lootA(), null);
	}

}
