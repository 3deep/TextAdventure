package chars;

public class Player extends Character {

	private int battlesFought;
	
	public Player(int roll){
		allSet(roll, roll, roll, roll, roll, roll, roll);
	}

	public int battlesFoughtGet() {
		return battlesFought;
	}

	public void battlesFoughtSet(int battlesFought) {
		this.battlesFought = battlesFought;
	}
	
	public void battlesFoughtInc() {
		this.battlesFought++;
	}

	
}
