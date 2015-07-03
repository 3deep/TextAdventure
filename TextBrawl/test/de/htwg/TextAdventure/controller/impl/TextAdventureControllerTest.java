package de.htwg.TextAdventure.controller.impl;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import de.htwg.TextAdventure.model.IWeapon;
import de.htwg.TextAdventure.model.impl.Armor;
import de.htwg.TextAdventure.model.impl.NPC;
import de.htwg.TextAdventure.model.impl.Player;
import de.htwg.TextAdventure.model.impl.Weapon;
import de.htwg.TextAdventure.model.impl.World;

public class TextAdventureControllerTest {
	
	World world;
	Player player;
	NPC enemy;
	TextAdventureController controller;

	@Before
	public void setUp() throws Exception {
		world = new World();
		player = new Player(1,1,1,1, 1);
		controller = new TextAdventureController(player, world);
		enemy = new NPC(1);
	}

	@Test
	public void testNewGame(){
		controller.newGame();
		assertTrue(controller.playerIsAlive());
	};

	@Test
	public void testPrintPlayerStats(){
		controller.printPlayerStats();
	};

	@Test
	public void testUpgrade(){
		player.incStatPoints();
		player.incStatPoints();
		player.incStatPoints();
		player.incStatPoints();
		player.incStatPoints();
		controller = new TextAdventureController(player, world);
		controller.upgrade("asd");
		controller.upgrade("Str");
		controller.upgrade("dex");
		controller.upgrade("int");
		controller.upgrade("speed");
		controller.upgrade("hp");
		controller.upgrade("hp");
	};

	@Test
	public void testGetStatus(){
		assertTrue(controller.getStatus() != "");
	};

	@Test
	public void testSetStatus(){
		controller.setStatus("asd");
		assertTrue(controller.getStatus().equals("asd"));
	};

	@Test
	public void testExplore(){
		for(int i = 1; i < 20; i++)
			controller.explore();
		controller.goTo("forest");
		for(int i = 1; i < 20; i++)
			controller.explore();
		controller.goTo("town");
		for(int i = 1; i < 20; i++)
			controller.explore();
		controller.setStatus("town");
		controller.explore();
	};

	@Test
	public void testActiveBattle(){
		assertFalse(controller.activeBattle());
	};

	@Test
	public void testBattleEnd(){
		controller.goTo("forest");
		controller.battleStart();
		controller.battleEnd();
		controller.battleFlee();
		controller.battleEnd();
		controller.battleStart();
		controller.battleFight();
		controller.battleFight();
		controller.battleFight();
		controller.battleFight();
		controller.battleFight();
		controller.battleFight();
		controller.battleFight();
		controller.battleEnd();
		controller.battleStart();
		controller.battleFight();
		controller.battleFight();
		controller.battleFight();
		controller.battleFight();
		controller.battleFight();
		controller.battleFight();
		controller.battleFight();
		controller.battleEnd();
		controller.battleStart();
		controller.battleFight();
		controller.battleFight();
		controller.battleFight();
		controller.battleFight();
		controller.battleFight();
		controller.battleFight();
		controller.battleFight();
		controller.battleEnd();
		controller.battleStart();
		controller.battleFight();
		controller.battleFight();
		controller.battleFight();
		controller.battleFight();
		controller.battleFight();
		controller.battleFight();
		controller.battleFight();
		controller.battleEnd();
		controller.battleStart();
		controller.battleFight();
		controller.battleFight();
		controller.battleFight();
		controller.battleFight();
		controller.battleFight();
		controller.battleFight();
		controller.battleFight();
		controller.battleEnd();
		controller.battleStart();
		controller.battleFight();
		controller.battleFight();
		controller.battleFight();
		controller.battleFight();
		controller.battleFight();
		controller.battleFight();
		controller.battleFight();
		controller.battleEnd();
		controller.battleStart();
		controller.battleFight();
		controller.battleFight();
		controller.battleFight();
		controller.battleFight();
		controller.battleFight();
		controller.battleFight();
		controller.battleFight();
		controller.battleEnd();
		controller.battleStart();
		controller.battleFight();
		controller.battleFight();
		controller.battleFight();
		controller.battleFight();
		controller.battleFight();
		controller.battleFight();
		controller.battleFight();
		controller.battleEnd();
		controller.battleStart();
		controller.battleFight();
		controller.battleFight();
		controller.battleFight();
		controller.battleFight();
		controller.battleFight();
		controller.battleFight();
		controller.battleFight();
		controller.battleEnd();
	};

	@Test
	public void testInspectLoot(){
		controller.goTo("forest");
		for(int i = 1; i < 1000; i++){
			controller.newGame();
			controller.goTo("forest");
			controller.battleStart();
			controller.battleFight();
			controller.battleFight();
			controller.battleFight();
			controller.battleFight();
			controller.battleFight();
			controller.battleFight();
			controller.battleFight();
			controller.battleEnd();
			controller.inspectLoot();
			controller.lootAvailable();
		}
			
	};

	@Test
	public void testLootAvailable(){
		
	};

	@Test
	public void testTakeArmor(){
		controller.give(null, new Armor(1,1,1,0), new Weapon(1, 1, 1, 0));
		controller.takeArmor();
		controller.give(null, new Armor(10,0,0,0), new Weapon(10, 0, 0, 0));
		controller.takeArmor();
		controller.give(null, new Armor(0,10,0,0), new Weapon(0, 10, 0, 0));
		controller.takeArmor();
		controller.give(null, new Armor(0,0,10,0), new Weapon(0, 0, 10, 0));
		controller.takeArmor();
		controller.give(null, new Armor(0,10,0,0), new Weapon(0, 10, 0, 0));
		controller.takeWeapon();
		controller.give(null, new Armor(10,0,0,0), new Weapon(10, 0, 0, 0));
		controller.takeWeapon();
		controller.give(null, new Armor(1,1,1,0), new Weapon(1, 1, 1, 0));
		controller.takeWeapon();
		controller.give(null, new Armor(0,0,10,0), new Weapon(0, 0, 10, 0));
		controller.takeWeapon();
	};

	@Test
	public void testTakeWeapon(){
		
	};

	@Test
	public void testGoTo(){
		World tmp = new World();
		tmp.setAll();
		controller.goTo("river");
		controller.goTo("ForestCave");
		controller.goTo("glimmeringshroomcavern");
		controller.goTo("magmadepths");
		controller.goTo("portal");
		controller.goTo("otherworld");
		controller.give(tmp, null, null);
		controller.goTo("river");
		controller.goTo("ForestCave");
		controller.goTo("glimmeringshroomcavern");
		controller.goTo("magmadepths");
		controller.goTo("portal");
		controller.goTo("otherworld");
	};

	@Test
	public void testAreas(){
		
		controller.areas();

		World tmp = new World();
		tmp.setAll();
		controller.give(tmp, null, null);
		controller.areas();
	};

	@Test
	public void testRest(){

		controller.rest();
		controller.goTo("forest");
		controller.rest();
		World tmp = new World();
		tmp.setAll();
		controller.give(tmp, null, null);
		controller.goTo("river");
		controller.rest();
	};

	@Test
	public void testPlayerIsAlive(){
		
	};

	@Test
	public void testDiscoveredRiver(){
		assertFalse(controller.discoveredRiver());
	};

	@Test
	public void testDiscoveredForestCave(){

		assertFalse(controller.discoveredForestCave());
	};

	@Test
	public void testDiscoveredGlimmeringShroomCavern(){

		assertFalse(controller.discoveredGlimmeringShroomCavern());
	};

	@Test
	public void testDiscoveredMagmaDepths(){

		assertFalse(controller.discoveredMagmaDepths());
	};

	@Test
	public void testDiscoveredPortal(){

		assertFalse(controller.discoveredPortal());
	};

	@Test
	public void testDiscoveredOtherworld(){

		assertFalse(controller.discoveredOtherworld());
	};

	@Test
	public void testPlayerHasStats(){
		assertFalse(controller.playerHasStats());
		controller.give(null, null, null);
		assertTrue(controller.playerHasStats());
	};

	@Test
	public void testUpdate(){
		
	};

	@Test
	public void testBattleFight(){
		
	};

	@Test
	public void testBattleFlee(){
		controller.giveArena();
		controller.battleFlee();
	};

	@Test
	public void testBattleEnded(){
		controller.battleEnded();
		controller.battleEnd();
		controller.battleEnded();
	};

}
