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
	
}
