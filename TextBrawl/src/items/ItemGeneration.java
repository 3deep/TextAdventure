package items;

import items.armor.AType;
import items.weapon.WType;

public class ItemGeneration {

	public static weapon genNewWeapon(int roll) {
		weapon wep = new weapon();
		
		if(roll == 0){
			wep.dmg = 1;
			wep.type = WType.FISTS;
			return wep;
		}
		

		// TODO still need generation from random seed
		
		return wep;
	}
	
	public static armor genNewArmor(int roll) {
		armor arm = new armor();
		
		if(roll == 0){
			arm.dmgBlock = 1;
			arm.type = AType.NO_ARMOR;
			return arm;
		}
		
		// TODO still need generation from random seed
		
		return arm;
	}

}
