package chars;

import items.ItemGeneration;

public class NPC extends Character{
	
	boolean friendly;
	int type;
	
	public NPC(int roll){
		maxHealth = 2;
		currentHealth = maxHealth;
		wep = ItemGeneration.genNewWeapon(0);
		arm = ItemGeneration.genNewArmor(0);
	}
	
	/*public String toString(){
		String s = "You see the ";
		//if(friendly)
		//	s = s + "friendly ";
		//else 
		//	s = s + "hostile "; // as you dont see hostiles outside of battles
		if(type == 1)
			s = s + "Goblin ";
		else if(type == 2)
			s = s + "Orc. ";
		else if(type == 2)
			s = s + "Lizzard. ";
		else if(type == 2)
			s = s + "Ghost. ";
		else
			s = s + "Human. ";
		if(!friendly){
			int h = maxHealth / currentHealth;
			if(h == 1)
				s = s + "He looks like new.";
			else if(h == 2)
				s = s + "He is breathing roughly.";
			else if(h == 3 || h == 4)
				s = s + "He is visibly bruised.";
			else
				s = s + "He is almost defeated!";
		}
		return s;
	}*/


}
