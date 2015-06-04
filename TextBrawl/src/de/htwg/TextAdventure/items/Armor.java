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
		int tmp = (int) Math.floor(((double)(roll / 1000)));
		int tmp2;
		typeSet(tmp);
		tmp2 = roll - (tmp * 1000);
		tmp = (int) Math.floor(((double)(tmp2 / 100)));
		reqStr = tmp;
		tmp2 = tmp2 - (tmp * 100);
		tmp = (int) Math.floor(((double)(tmp2 / 10)));
		reqDex = tmp;
		tmp2 = tmp2 - (tmp * 10);
		tmp = (int) Math.floor(((double)(tmp2 / 1)));
		reqInt = tmp;
		dmgBlock = (int)(0.6 * ((double)reqStr + (double)reqDex + (0.8 * (double)reqInt)));
		typeToBonus();
	}
	
	/**
	 * Calculating Bonus to Armors
	 */
	private void typeToBonus() {
		if(type == AType.NO_ARMOR){
			reqStr = 0;
			reqDex = 0;
			reqInt = 0;
			dmgBlock = (int) Math.round((double)dmgBlock * 0.7);
			return;
		}
		
		if(type == AType.CLOTH_ARMOR){
			reqStr = (int)Math.round((double)reqStr * 0.3);
			reqDex = (int)Math.round((double)reqDex * 0.7);
			reqInt = (int)Math.round((double)reqInt * 1);
			dmgBlock = (int)Math.round((double)dmgBlock * 1);
			return;
		}

		if(type == AType.LIGHT_ARMOR){
			reqStr = (int)Math.round((double)reqStr * 0.5);
			reqDex = (int)Math.round((double)reqDex * 1);
			reqInt = (int)Math.round((double)reqInt * 0.8);
			dmgBlock = (int)Math.round((double)dmgBlock * 1.2);
			return;
		}

		if(type == AType.MEDIUM_ARMOR){
			reqStr = (int)Math.round((double)reqStr * 1);
			reqDex = (int)Math.round((double)reqDex * 1);
			reqInt = (int)Math.round((double)reqInt * 0.2);
			dmgBlock = (int)Math.round((double)dmgBlock * 1.5);
			return;
		}

		if(type == AType.HEAVY_ARMOR){
			reqStr = (int)Math.round((double)reqStr * 1.4);
			reqDex = (int)Math.round((double)reqDex * 0.9);
			reqInt = (int)Math.round((double)reqInt * 0.2);
			dmgBlock = (int)Math.round((double)dmgBlock * 2);
		}
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
