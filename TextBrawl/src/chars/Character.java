package chars;

import items.ItemGeneration;
import items.armor;
import items.weapon;

public abstract class Character {

	private int currentHealth;
	private int maxHealth;
	private int str;
	private int dex;
	private int cint;
	private int speed;
	private armor arm;
	private weapon wep;
	
	public int currentHealthGet(){
		return currentHealth;
	}
	
	public int maxHealthGet(){
		return maxHealth;
	}
	
	public int strGet(){
		return str;
	}
	
	public int dexGet(){
		return dex;
	}
	
	public int cintGet(){
		return cint;
	}
	
	public int speedGet(){
		return speed;
	}
	
	public armor armGet(){
		return arm;
	}
	
	public weapon wepGet(){
		return wep;
	}
	
	public void allSet(int maxH, int str, int dex, int cint, int speed, int armorRoll, int wepRoll){
		maxHealth = maxH;
		currentHealth = maxH;
		this.str = str;
		this.dex = dex;
		this.cint = cint;
		this.speed = speed;
		arm = ItemGeneration.genNewArmor(armorRoll);
		wep = ItemGeneration.genNewWeapon(wepRoll);
	}
	
}
