package chars;

import items.ItemGeneration;
import items.Armor;
import items.Weapon;

public abstract class Character {

	private int currentHealth;
	private int maxHealth;
	private int str;
	private int dex;
	private int cint;
	private int speed;
	private Armor arm;
	private Weapon wep;
	
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
	
	public Armor armGet(){
		return arm;
	}
	
	public Weapon wepGet(){
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
