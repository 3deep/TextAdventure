package items;

public class ItemGeneration {

	public static weapon genNewWeapon(int roll) {
		weapon wep = new weapon(roll);
		
		return wep;
	}
	
	public static armor genNewArmor(int roll) {
		armor arm = new armor(roll);
		
		return arm;
	}

}
