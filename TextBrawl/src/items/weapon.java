package items;
//first concept
public class weapon {
	public int reqStr;
	public int reqDex;
	public int reqInt;
	public int dmg;
	public int dmgType;
	enum WType {
		FISTS, DAGGER, SHORT_SWORD, LONG_SWORD, ZWEIHANDER, KATANA, SHORT_BOW, LONG_BOW, COMPOSITE_BOW, XBOW, HALBERD, AXE, HAMMER, CLUB, MAGIC_WAND
			}
	public WType type;
			
	
	public weapon(){
		//type = Type.Fists;
		;
	}
	
	public weapon giveWeapon(){
		return this;
	}
	
	/*public String toString(){
		String s = "";
		if(magic){
			if(ranged){
				if(type == 1)
					s = "Magic Stick";
				else if(type == 2)
					s = "Caster Gauntlets";
				else
					s = "Crystall Ball";
			} else {
				if(type == 1)
					s = "Magic Staff";
				else if(type == 2)
					s = "Enchanted Gauntlets";
				else
					s = "Magic Dagger";
			}
		} else {
			if(ranged){
				if(type == 1)
					s = "Bow";
				else if(type == 2)
					s = "Crossbow";
				else
					s = "Throwing Stars";
			} else {
				if(type == 0)
					s = "Fists";
				else if(type == 1)
					s = "Sword";
				else if(type == 2)
					s = "Axe";
				else
					s = "Mace";
			}
		}
		return s;
	}*/
}