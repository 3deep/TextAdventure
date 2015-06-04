package htwg.de.items;

public final class ItemGeneration {

	/**
	 * Generates a Weapon from the roll
	 * @param roll
	 * @return weapon
	 */
	public static Weapon genNewWeapon(int roll) {
		Weapon wep = new Weapon(roll);
		
		return wep;
	}
	
	/**
	 * Same as Weapon only as armor
	 * @param roll
	 * @return armor
	 */
	public static Armor genNewArmor(int roll) {
		Armor arm = new Armor(roll);
		
		return arm;
	}

}
