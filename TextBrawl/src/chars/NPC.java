package chars;

public class NPC extends Character{
	
	private boolean friendly;
	private int type;
	/**
	 * creates an NPC with the corresponding roll value
	 * @param roll
	 * contains information for region / strength (should be random based)
	 */
	public NPC(int roll){
		allSet(roll, roll, roll, roll, roll, roll, roll);
		friendly = false;
		type = roll;
	}

	/**
	 * Checks for friendliness of NPC (true => NPC is a shop)
	 * @return friendly
	 */
	public boolean isFriendly() {
		return friendly;
	}

	/**
	 * Set function for boolean friendly
	 * @param friendly
	 * true/false
	 */
	public void setFriendly(boolean friendly) {
		this.friendly = friendly;
	}

	/**
	 * Returns the type of NPC (TODO: implement different types of NPC / Characters)
	 * @return int => will probably become enum
	 */
	public int typeGet() {
		return type;
	}

	/**
	 * Set function for the type
	 * @param type
	 * type of NPC
	 */
	public void typeSet(int type) {
		this.type = type;
	}
	
}
