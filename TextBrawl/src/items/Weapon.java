package items;
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
		
		WType(String type, int numVal){
			this.type = type;
			this.numVal = numVal;
		}
		
		public String typeGet(){
			return type;
		}
		
		public int numValGet(){
			return numVal;
		}
		
		public WType typeFromVal(int numVal){
			for (WType wtype: WType.values()){
				if(wtype.numValGet() == numVal){
					return wtype;}
			}
			
			return null;
		}
		
	}
	
	private WType type;
			
	
	public Weapon(int roll){
		reqStr = roll;
		reqDex = roll;
		reqInt = roll;
		dmg = roll;
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
	
	public int dmgGet(){
		return dmg;
	}
	
	public Weapon giveWeapon(){
		return this;
	}

	public WType typeGet() {
		return type;
	}

	public void typeSet(int type) {
		WType tmp = WType.W0;
		if (tmp.typeFromVal(type) != null){
			this.type = tmp.typeFromVal(type);}
		else {this.type = WType.W0;}
	}
	
}