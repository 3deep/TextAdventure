package chars;

public class NPC extends Character{
	
	private boolean friendly;
	private int type;
	
	public NPC(int roll){
		allSet(roll, roll, roll, roll, roll, roll, roll);
	}

	public boolean isFriendly() {
		return friendly;
	}

	public void setFriendly(boolean friendly) {
		this.friendly = friendly;
	}

	public int typeGet() {
		return type;
	}

	public void typeSet(int type) {
		this.type = type;
	}
	
	/*public String toString(){
		String s = "You see the ";
		//if(friendly)
		//	s = s + "friendly ";
		//else 
		//	s = s + "hostile "; // as you dont see hostiles outside of battles
		if(type == 1)
			s = s + "Goblin ";
		else if(type == 2)
			s = s + "Orc. ";
		else if(type == 2)
			s = s + "Lizzard. ";
		else if(type == 2)
			s = s + "Ghost. ";
		else
			s = s + "Human. ";
		if(!friendly){
			int h = maxHealth / currentHealth;
			if(h == 1)
				s = s + "He looks like new.";
			else if(h == 2)
				s = s + "He is breathing roughly.";
			else if(h == 3 || h == 4)
				s = s + "He is visibly bruised.";
			else
				s = s + "He is almost defeated!";
		}
		return s;
	}*/


}
