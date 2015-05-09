package items;

public class Armor {
	private int reqStr;
	private int reqDex;
	private int reqInt;
	private int dmgBlock;
	enum AType{
		NO_ARMOR("No Armor", 0), CLOTH_ARMOR("Cloth Armor", 1), LIGHT_ARMOR("Light Armor", 2), MEDIUM_ARMOR("Medium Armor", 3), HEAVY_ARMOR("Heavy Armor", 4);
		
		private String type;
		private int numVal;
		AType(String type, int numVal){
			this.type = type;
			this.numVal = numVal;
		}
		
		public String typeGet(){
			return type;
		}
		
		public int numValGet(){
			return numVal;
		}
		
		public AType typeFromVal(int numVal){
			for (AType atype: AType.values()){
				if(atype.numValGet() == numVal){
					return atype;}
			}
			
			return null;
		}
		
	};
	private AType type;
	
	public Armor(int roll){
		reqStr = roll;
		reqDex = roll;
		reqInt = roll;
		dmgBlock = roll;
		typeSet(roll);
	}
	
	public int reqStrGet(){
		return reqStr;
	}
	
	public int reqDexGet(){
		return reqDex;
	}
	
	public int reqIntGet(){
		return reqInt;
	}
	
	public int dmgBlockGet(){
		return dmgBlock;
	}
	
	public Armor giveArmor(){
		return this;
	}

	public AType typeGet() {
		return type;
	}

	public void typeSet(int type) {
		AType tmp = AType.NO_ARMOR;
		if (tmp.typeFromVal(type) != null){
			this.type = tmp.typeFromVal(type);}
		else {this.type = AType.NO_ARMOR;}
	}
	
}
