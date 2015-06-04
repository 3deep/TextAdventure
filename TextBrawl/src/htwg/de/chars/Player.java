package htwg.de.chars;

public class Player extends Character {

	private int battlesFought;
	
	/**
	 * creates the player with the corresponding roll value
	 * @param roll
	 * contains information from start screen (type, etc.)
	 */
	public Player(int roll){
		allSet(roll, roll, roll, roll, roll, roll, roll);
	}

	/**
	 * Gives the number of fought Battles
	 * @return int of fought battles (lvlup system?)
	 */
	public int battlesFoughtGet() {
		return battlesFought;
	}

	/**
	 * Set function for battles fought
	 * @param battlesFought
	 * maybe for load function
	 */
	public void battlesFoughtSet(int battlesFought) {
		this.battlesFought = battlesFought;
	}
	
	/**
	 * increments the battlesFought value => called after each battle
	 */
	public void battlesFoughtInc() {
		this.battlesFought++;
	}

	
}
