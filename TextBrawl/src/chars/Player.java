package chars;

import items.ItemGeneration;

public class Player extends Character {

	int battlesFought;
	//int timesDefeated;
	int victories;
	
	public Player(){
		maxHealth = 10;
		currentHealth = 10;
		this.wep = ItemGeneration.genNewWeapon(0);
		this.arm = ItemGeneration.genNewArmor(0);
	}

	
}
