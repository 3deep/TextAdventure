package de.htwg.TextAdventure.items;
//first concept
public class Weapon implements IWeapon {
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
	 * 
	 * @param reqStr required Str for Weapon
	 * @param reqDex required Dex for Weapon
	 * @param reqInt required Int for Weapon
	 * @param type type of weapon
	 */
	public Weapon(int reqStr, int reqDex, int reqInt, int type){
		this.reqStr = reqStr;
		this.reqDex = reqDex;
		this.reqInt = reqInt;
		typeSet(type);
		typeToBonus();
		
	}

	
	/* (non-Javadoc)
	 * @see de.htwg.TextAdventure.items.IWeapon#reqStrGet()
	 */
	@Override
	public int reqStrGet(){
		return reqStr;
	}

	/* (non-Javadoc)
	 * @see de.htwg.TextAdventure.items.IWeapon#reqDexGet()
	 */
	@Override
	public int reqDexGet(){
		return reqDex;
	}

	/* (non-Javadoc)
	 * @see de.htwg.TextAdventure.items.IWeapon#reqIntGet()
	 */
	@Override
	public int reqIntGet(){
		return reqInt;	
	}

	/* (non-Javadoc)
	 * @see de.htwg.TextAdventure.items.IWeapon#dmgGet()
	 */
	@Override
	public int dmgGet(){
		return dmg;
	}

	/* (non-Javadoc)
	 * @see de.htwg.TextAdventure.items.IWeapon#giveWeapon()
	 */
	@Override
	public IWeapon giveWeapon(){
		return this;
	}

	/* (non-Javadoc)
	 * @see de.htwg.TextAdventure.items.IWeapon#typeGet()
	 */
	@Override
	public WType typeGet() {
		return type;
	}

	/* (non-Javadoc)
	 * @see de.htwg.TextAdventure.items.IWeapon#typeSet(int)
	 */
	@Override
	public void typeSet(int type) {
		WType tmp = WType.W0;
		if (tmp.typeFromVal(type) != null){
			this.type = tmp.typeFromVal(type);}
		else {this.type = WType.W0;}
	}
	
	/**
	 * Gives appropriate bonus to weapons
	 * 
	 */
	private void typeToBonus() {

		if(type == WType.W0){
			this.dmg = (int)(0.8 * (double)reqStr + 0.3 * (double)reqDex);
		}
		if(type == WType.W1){
			this.dmg = (int)(0.8 * (double)reqStr + 0.7 * (double)reqDex + 0.1 * (double)reqInt);
		}
		if(type == WType.W2){
			this.dmg = (int)(0.8 * (double)reqStr + 0.8 * (double)reqDex + 0.1 * (double)reqInt);
		}
		if(type == WType.W3){
			this.dmg = (int)(1 * (double)reqStr + 0.7 * (double)reqDex + 0.1 * (double)reqInt);
		}
		if(type == WType.W4){
			this.dmg = (int)(1.4 * (double)reqStr + 1 * (double)reqDex + 0.1 * (double)reqInt);
		}
		if(type == WType.W5){
			this.dmg = (int)(0.5 * (double)reqStr + 1.5 * (double)reqDex + 0.1 * (double)reqInt);
		}
		if(type == WType.W6){
			this.dmg = (int)(0.5 * (double)reqStr + 1.1 * (double)reqDex + 0.1 * (double)reqInt);
		}
		if(type == WType.W7){
			this.dmg = (int)(0.7 * (double)reqStr + 1.2 * (double)reqDex + 0.1 * (double)reqInt);
		}
		if(type == WType.W8){
			this.dmg = (int)(1 * (double)reqStr + 1.2 * (double)reqDex + 0.1 * (double)reqInt);
		}
		if(type == WType.W9){
			this.dmg = (int)(1.2 * (double)reqStr + 1 * (double)reqDex + 0.1 * (double)reqInt);
		}
		if(type == WType.W10){
			this.dmg = (int)(1.3 * (double)reqStr + 1 * (double)reqDex + 0.1 * (double)reqInt);
		}
		if(type == WType.W11){
			this.dmg = (int)(1.2 * (double)reqStr + 0.8 * (double)reqDex + 0.1 * (double)reqInt);
		}
		if(type == WType.W12){
			this.dmg = (int)(1.7 * (double)reqStr + 0.6 * (double)reqDex + 0.1 * (double)reqInt);
		}
		if(type == WType.W13){
			this.dmg = (int)(2 * (double)reqStr + 0.5 * (double)reqDex);
		}
		if(type == WType.W14){
			this.dmg = (int)(0.1 * (double)reqStr + 0.1 * (double)reqDex + 3 * (double)reqInt);
		}	
	}
	
	/* (non-Javadoc)
	 * @see de.htwg.TextAdventure.items.IWeapon#toString()
	 */
	@Override
	public String toString() {
		
		return this.type.typeGet() + " with a Damage potential of " + dmgGet();
	}
}