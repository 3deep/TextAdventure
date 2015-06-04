package de.htwg.TextAdventure.items;

public class Armor {
	private int reqStr;
	private int reqDex;
	private int reqInt;
	private int dmgBlock;
	enum AType{
		NO_ARMOR("No Armor", 0), CLOTH_ARMOR("Cloth Armor", 1), LIGHT_ARMOR("Light Armor", 2), MEDIUM_ARMOR("Medium Armor", 3), HEAVY_ARMOR("Heavy Armor", 4);
		
		private String type;
		private int numVal;
		/**
		 * Help function to distinguish which armor is used (randomized rolls, converting int to enum..)
		 * @param type
		 * String for the Type
		 * @param numVal
		 * Numerical Value for the Type
		 */
		AType(String type, int numVal){
			this.type = type;
			this.numVal = numVal;
		}
		
		/**
		 * Gives the Type as String
		 * @return type
		 * type as String
		 */
		public String typeGet(){
			return type;
		}
		
		/**
		 * Gives the Type as numerical Value
		 * @return numVal
		 * type as numerical Value
		 */
		public int numValGet(){
			return numVal;
		}
		
		/**
		 * Help function to get the AType from a numerical Value
		 * @param numVal
		 * @return AType
		 * AType with corresponding numVal
		 */
		public AType typeFromVal(int numVal){
			for (AType atype: AType.values()){
				if(atype.numValGet() == numVal){
					return atype;}
			}
			
			return null;
		}
		
	};
	private AType type;
	
	/**
	 * Constructor for the armor
	 * @param roll
	 * all information(str, etc.) should be stored in roll
	 */
	public Armor(int roll){
		reqStr = roll;
		reqDex = roll;
		reqInt = roll;
		dmgBlock = roll;
		typeSet(roll);
	}
	
	/**
	 * Getter function for str
	 * @return str
	 */
	public int reqStrGet(){
		return reqStr;
	}

	/**
	 * Getter function for dex
	 * @return dex
	 */
	public int reqDexGet(){
		return reqDex;
	}

	/**
	 * Getter function for int
	 * @return int
	 */
	public int reqIntGet(){
		return reqInt;
	}

	/**
	 * Getter function for dmgBlock
	 * @return dmgBlock
	 */
	public int dmgBlockGet(){
		return dmgBlock;
	}

	/**
	 * Getter function for the armor
	 * @return armor (self)
	 */
	public Armor giveArmor(){
		return this;
	}

	/**
	 * Getter function for AType
	 * @return type
	 */
	public AType typeGet() {
		return type;
	}

	/**
	 * Sets the type to corresponding numerical Value
	 */
	public void typeSet(int type) {
		AType tmp = AType.NO_ARMOR;
		if (tmp.typeFromVal(type) != null){
			this.type = tmp.typeFromVal(type);}
		else {this.type = AType.NO_ARMOR;}
	}
	
}
