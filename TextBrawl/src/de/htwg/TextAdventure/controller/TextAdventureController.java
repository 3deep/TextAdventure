package de.htwg.TextAdventure.controller;

import de.htwg.TextAdventure.battle.Arena;
import de.htwg.TextAdventure.battle.IArena;
import de.htwg.TextAdventure.chars.IPlayer;
import de.htwg.TextAdventure.chars.NPC;
import de.htwg.TextAdventure.chars.Player;
import de.htwg.TextAdventure.items.IArmor;
import de.htwg.TextAdventure.items.IWeapon;
import de.htwg.TextAdventure.world.IWorld;
import de.htwg.util.observer.IObserver;
import de.htwg.util.observer.Observable;

public class TextAdventureController extends Observable implements IObserver{
	
	private IPlayer player;
	private IWorld world;
	private String statusMessage = "Welcome to TextAdventure";
	private IArena arena;
	private IWeapon lootW;
	private IArmor lootA;
	
	/**
	 * Creates the Controller
	 * @param p Player
	 * @param w World
	 */
	public TextAdventureController(IPlayer p, IWorld w) {
		player = p;
		world = w;
		arena = new Arena();
		arena.addObserver(this);
	}
	
	public void newGame(){
		player = new Player(3, 3, 3, 3, 3, 3, 3);
	}
	
	/**
	 * printPlayerStats
	 * @return String of player Stats
	 */
	public String printPlayerStats() {
		String s = "";
		s += "HP: " + player.currentHealthGet() + " out of " + player.maxHealthGet() + "\n";
		s += "Strength: " + player.strGet() + "\n";
		s += "Dexterity: " + player.dexGet() + "\n";
		s += "Intelligence: " + player.cintGet() + "\n";
		s += "Speed: " + player.speedGet() + "\n";
		s += "Weapon: " + player.wepGet().toString() + "\n";
		s += "Armor: " + player.armGet().toString() + "\n";
		s += "Times Won: " + player.battlesFoughtGet() + "\n";
		s+= player.getStatPoints() + " Statpoints";
		return s;
		
	}
	
	public void upgrade(String stat){
		if(player.getStatPoints() <= 0){
			setStatus("You don't have any Statpoints left.");
			return;
		}
		if(stat.equalsIgnoreCase("str")){
			player.incStr();
			setStatus("Increased your strength by one Point (now: " + player.strGet() + ").");
		}
		else if(stat.equalsIgnoreCase("dex")){
			player.incDex();
			setStatus("Increased your dexterity by one Point (now: " + player.dexGet() + ").");
		}
		else if(stat.equalsIgnoreCase("int")){
			player.inccint();
			setStatus("Increased your intelligence by one Point (now: " + player.cintGet() + ").");
		}
		else if(stat.equalsIgnoreCase("speed")){
			player.incSpeed();
			setStatus("Increased your speed by one Point (now: " + player.speedGet() + ").");
		}
		else if(stat.equalsIgnoreCase("hp")){
			player.incHP();
			setStatus("Increased your HP by two Points (now: " + player.maxHealthGet() + ").");
		}
		else
			setStatus("I don't know what you mean with " + stat + ".");
	}
	
	/**
	 * gives the statusMessage
	 * @return statusMessage
	 */
	public String getStatus() {
		return statusMessage;
	}
	
	/**
	 * sets the statusMessage
	 * @param statusMessage
	 */
	public void setStatus(String status){
		statusMessage = status;
	}
	
	/**
	 * explores the location where you are at
	 */
	public void explore() {
		setStatus(world.explore(player.playerPositionGet()));
		if(statusMessage.equalsIgnoreCase("a new encounter") && player.playerPositionGet() != 0)
			battleStart();
	}
	 /**
	  * fight fierce battle
	  */
	private void battleStart() {
		NPC enemy = new NPC(player.playerPositionGet());
		while(enemy.currentHealthGet() == 0)
			enemy = new NPC(player.playerPositionGet());
		arena.battle(player, enemy);
	}
	
	public boolean activeBattle(){
		return arena.inBattle();
	}
	
	public void battleEnd() {
		int result = arena.fightResult();
		if(result == 1){
			lootW = arena.lootW();
			lootA = arena.lootA();
			setStatus(arena.getFightStatus() + "\nYou managed to beat your foe.");
			player.battlesFoughtInc();
			if(player.battlesFoughtGet() % 2 == 0)
				player.incStatPoints();
		}
		else if(result == 0)
			setStatus("You ran from battle");
		else if(result == 2)
			setStatus(arena.getFightStatus() + "\nYou fall defeated in battle.\n\nGAME OVER");
	}
	
	/**
	 * Inspects the loot on the ground (if loot is there)
	 */
	public void inspectLoot() {
		String tmp = "";
		if(lootW != null && lootW.notFists() )
			tmp += lootW.toString() + "\n";
		if(lootA != null && lootA.notNoArmor() )
			tmp += lootA.toString() + "\n";
		if(!tmp.equals(""))
			setStatus("On the Ground you see:\n" + tmp);
		else
			setStatus("There is nothing here to be inspected!");
	}
	
	public boolean lootAvailable(){
		return((lootW != null && lootW.notFists()) || (lootA != null && lootA.notNoArmor()) );
	}
	
	/**
	 * Replaces the characters Armor with the one on the Ground
	 */
	public void takeArmor() {
		if(player.cintGet() < lootA.reqIntGet() || player.dexGet() < lootA.reqDexGet() || player.strGet() < lootA.reqStrGet()) {
			setStatus("You can't equip that. You don't have the necessary Stats for that!");
			return;
		}
		else {
			player.giveArmor(lootA);
			setStatus("You equip your new " + lootA.getName() + ".");
			lootW = null;
			lootA = null;
		}
	}

	/**
	 * Replaces the characters Weapon with the one on the Ground
	 */
	public void takeWeapon() {
		if(player.cintGet() < lootW.reqIntGet() || player.dexGet() < lootW.reqDexGet() || player.strGet() < lootW.reqStrGet()) {
			setStatus("You can't equip that. You don't have the necessary Stats for that!");
			return;
		}
		else {
			player.giveWeapon(lootW);
			setStatus("You equip your new " + lootW.getName() + ".");
			lootW = null;
			lootA = null;
		}
	}
	
	/**
	 * Where the player is going
	 * @param location where to
	 */
	public void goTo(String location){
		if(location.equalsIgnoreCase("town")){
			player.playerPositionSet(0);
			setStatus("You head back to Town to rest.");
			return;
		}
		if(location.equalsIgnoreCase("forest")){
			player.playerPositionSet(4);
			setStatus("You arrive in a dark Forest. The villagers talked about Imps that infest the area.");
			return;
		}
		if(location.equalsIgnoreCase("forestcave")){
			if(world.discoveredForestCave()){
				player.playerPositionSet(6);
				setStatus("You come in through a huge hole in the Wall. The air smells odd.");
				return;
			}
		}
		if(location.equalsIgnoreCase("river")){
			if(world.discoveredRiver()){
				player.playerPositionSet(5);
				setStatus("You arrive at the River/Lake. Maybe you should try to relax here for a bit.");
				return;
			}
		}
		if(location.equalsIgnoreCase("glimmeringshroomcavern")){
			if(world.discoveredGlimmeringShroomCavern()){
				player.playerPositionSet(7);
				setStatus("Guided by the light of the mushrooms, you find your way into the Glimmering Shroom Cavern.");
				return;
			}
		}
		if(location.equalsIgnoreCase("magmadepths")){
			if(world.discoveredMagmaDepths()){
				player.playerPositionSet(8);
				setStatus("You really should be careful. The magma is burning red and one wrong step could lead to your demise.");
				return;
			}
		}
		if(location.equalsIgnoreCase("portal")){
			if(world.discoveredPortal()){
				player.playerPositionSet(9);
				setStatus("You marked the location of the portal on a map. In case you should need it again.");
				return;
			}
		}
		if(location.equalsIgnoreCase("otherworld")){
			if(world.discoveredOtherworld()){
				player.playerPositionSet(11);
				setStatus("You wonder, if you really want to be in this Otherworldly dimension. Everything here looks distorted.");
				return;
			}
		}
		setStatus("I don't know where " + location + " is. Just pick one of the discovered locations.");
	}
	
	/**
	 * Tells the player what he already discovered
	 */
	public void areas() {
		String s = "So far you have discovered: Town, Forest";
		if(world.discoveredForestCave())
			s += ", ForestCave";
		if(world.discoveredRiver())
			s += ", River";
		if(world.discoveredGlimmeringShroomCavern())
			s += ", GlimmeringShroomCavern";
		if(world.discoveredMagmaDepths())
			s += ", MagmaDepths";
		if(world.discoveredPortal())
			s += ", Portal";
		if(world.discoveredOtherworld())
			s += ", Otherworld";
		s +=".";
		setStatus(s);
	}
	
	/**
	 * Checks if you can rest at current position and heals the player if possible
	 */
	public void rest() {
		if(player.playerPositionGet() == 0 || player.playerPositionGet() == 5){
			player.rest();
			setStatus("You relax for a bit, Healing yourself back to full health.");
		}
		else
			setStatus("That is probably a stupid idea here.");
	}
	
	public boolean playerIsAlive() {
		return player.isAlive();
	}
	
	public boolean discoveredRiver(){
		return world.discoveredRiver();
	}
	
	public boolean discoveredForestCave(){
		return world.discoveredForestCave();
	}
	
	public boolean discoveredGlimmeringShroomCavern(){
		return world.discoveredGlimmeringShroomCavern();
	}
	
	public boolean discoveredMagmaDepths(){
		return world.discoveredMagmaDepths();
	}
	
	public boolean discoveredPortal(){
		return world.discoveredPortal();
	}
	
	public boolean discoveredOtherworld(){
		return world.discoveredOtherworld();
	}
	
	public boolean playerHasStats(){
		return(player.getStatPoints() > 0);
	}
	
	@Override
	public void update() {

		setStatus(arena.getFightStatus());
		notifyObservers();
	}

	public void battleFight() {
		arena.attack();
		if(arena.inBattle())
			setStatus(arena.getFightStatus());
		else
			battleEnd();
	}

	public void battleFlee() {
		arena.flee();
		if(arena.inBattle())
			setStatus(arena.getFightStatus());
		else
			battleEnd();
	}

}
