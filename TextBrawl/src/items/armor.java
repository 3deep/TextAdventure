package items;

public class armor {
	public int reqStr;
	public int reqDex;
	public int reqInt;
	public int dmgBlock;
	enum AType{
		NO_ARMOR, CLOTH_ARMOR, LIGHT_ARMOR, MEDIUM_ARMOR, HEAVY_ARMOR
	};
	public AType type;
	
	public armor(){
		;
	}
	
	public armor giveArmor(){
		return this;
	}
	
	/*public String toString(){
		String s;
		if(type == 0)
			s = "No Armor";
		else if(type == 1)
			s = "Light Armor";
		else if(type == 2)
			s = "Medium Armor";
		else
			s = "Heavy Armor";
		return s;
	}*/

}
