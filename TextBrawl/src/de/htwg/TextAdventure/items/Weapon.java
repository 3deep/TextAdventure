package de.htwg.TextAdventure.items;
//first concept
public class Weapon {
	private int reqStr;
	private int reqDex;
	private int reqInt;
	private int dmg;

	enum WType {
		W0("Fists", 0), W1("Dagger", 1), W2("Short Sword", 2), W3("Long Sword", 3), W4("Zweihander", 4), W5("Katana", 5), W6("Short Bow", 6), W7("Long Bow", 7), 
			W8("Composite Bow", 8), W9("Crossbow", 9), W10("Halberd", 10), W11("Axe", 11), W12("Hammer", 12), W13("Club", 13), W14("Magic Wand", 14);	
		private String type;
		private int numVal;

		/**
		 * Help function to distinguish which Weapon is used
		 * @param type
		 * @param numVal
		 */
		WType(String type, int numVal){
			this.type = type;
			this.numVal = numVal;
		}
		
		/**
		 * String of the type of Weapon
		 * @return type as String
		 */
		public String typeGet(){
			return type;
		}
		
		/**
		 * Gives the numerical Value of type
		 * @return type as numerical Value
		 */
		public int numValGet(){
			return numVal;
		}
		
		/**
		 * Gives the corresponding WType for the given numerical Value
		 * @param numVal
		 * @return WType
		 */
		public WType typeFromVal(int numVal){
			for (WType wtype: WType.values()){
				if(wtype.numValGet() == numVal){
					return wtype;}
			}
			
			return null;
		}
		
	}
	
	private WType type;
			
	/**
	 * Constructor for the Weapon
	 * @param roll
	 */
	public Weapon(int roll){
		reqStr = roll;
		reqDex = roll;
		reqInt = roll;
		dmg = roll;
		typeSet(roll);
		
	}

	/**
	 * Getter function for reqStr
	 * @return reqStr
	 */
	public int reqStrGet(){
		return reqStr;
	}

	/**
	 * Getter function for reqDex
	 * @return reqDex
	 */
	public int reqDexGet(){
		return reqDex;
	}

	/**
	 * Getter function for reqInt
	 * @return reqInt
	 */
	public int reqIntGet(){
		return reqInt;	
	}

	/**
	 * Getter function for dmg
	 * @return dmg
	 */
	public int dmgGet(){
		return dmg;
	}

	/**
	 * Getter function for weapon
	 * @return weapon (self)
	 */
	public Weapon giveWeapon(){
		return this;
	}

	/**
	 * Getter function for WType
	 * @return type
	 */
	public WType typeGet() {
		return type;
	}

	/**
	 * Sets the type to corresponding numerical Value
	 */
	public void typeSet(int type) {
		WType tmp = WType.W0;
		if (tmp.typeFromVal(type) != null){
			this.type = tmp.typeFromVal(type);}
		else {this.type = WType.W0;}
	}
	
}