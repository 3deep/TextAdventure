package items;

public final class ItemGeneration {

	public static Weapon genNewWeapon(int roll) {
		Weapon wep = new Weapon(roll);
		
		return wep;
	}
	
	public static Armor genNewArmor(int roll) {
		Armor arm = new Armor(roll);
		
		return arm;
	}

}
