package de.htwg.TextAdventure.battle;

import java.util.Random;
import de.htwg.TextAdventure.chars.INPC;
import de.htwg.TextAdventure.chars.IPlayer;
import de.htwg.TextAdventure.items.IArmor;
import de.htwg.TextAdventure.items.IWeapon;
import de.htwg.util.observer.Observable;

public class Arena extends Observable implements IArena {
	
	private String fightStatus;
	private boolean inBattle = false;
	private int fightResult = 0;
	private IPlayer player;
	private INPC enemy;
	private IArmor lootA;
	private IWeapon lootW;
	
	public Arena(){
		;
	}
	
	/* (non-Javadoc)
	 * @see de.htwg.TextAdventure.battle.IArena#battle(de.htwg.TextAdventure.chars.IPlayer, de.htwg.TextAdventure.chars.INPC)
	 */
	@Override
	public void battle(IPlayer p, INPC e) {
		this.player = p;
		this.enemy = e;
		lootW = enemy.wepGet();
		lootA = enemy.armGet();
		inBattle = true;
		fightStatus = "The Battle starts!\n";
		fightStatus += "You ready your " + player.wepGet().getName() + ".\n";
		fightStatus += "Your enemy wields a " + enemy.wepGet().getName() + " and is wearing a " + enemy.armGet().getName() + ".\n";
		fightStatus += "You are on " + player.currentHealthGet() + " out of " + player.maxHealthGet() + " health points.\n";
		fightStatus += "Your enemy has " + enemy.currentHealthGet() + " out of " + enemy.maxHealthGet() + " health points.\n";
		fightStatus += "Now what are you going to do? Attack or Flee?";
				notifyObservers();
			if(!player.checkHealth()){
				fightStatus += "You have fallen in valiant battle.\n\nGAME OVER";
				notifyObservers();
				player.dead();
				inBattle = false;
			}
		notifyObservers();
	}
	
	public void flee() {
		if(player.speedGet() > enemy.speedGet()){
			inBattle = false;
			fightResult = 0;
		}
		else
			fightStatus = "You were too slow. The enemy denies you any chance at escape.";
	}
	
	public void attack() {
		Random rnd = new Random();
		int dmg;
		int atPlayer;
		int atEnemy;
		int blockPlayer;
		int blockEnemy;
		if(player.wepGet().dmgGet() == 0)
			atPlayer = 0;
		else
			atPlayer = rnd.nextInt(player.wepGet().dmgGet());
		if(enemy.wepGet().dmgGet() == 0)
			atEnemy = 0;
		else
			atEnemy = rnd.nextInt(enemy.wepGet().dmgGet());
		if(player.armGet().dmgBlockGet() == 0)
			blockPlayer = 0;
		else 
			blockPlayer = rnd.nextInt(player.armGet().dmgBlockGet());
		if(enemy.armGet().dmgBlockGet() == 0)
			blockEnemy = 0;
		else 
			blockEnemy = rnd.nextInt(enemy.armGet().dmgBlockGet());
		if(enemy.speedGet() <= player.speedGet()){
			dmg = (atPlayer) - (blockEnemy);
			fightStatus = "(" + player.wepGet().dmgGet() + "-" + atPlayer + ")" + "You swing your " + player.wepGet().getName() + " ";
			fightStatus += "(" + enemy.armGet().dmgBlockGet() + "-" + blockEnemy + ")";
			if(dmg > 0){
				enemy.damage(dmg);
				fightStatus += "and did " + dmg + " points of Damage.\n";
			}
			else
				fightStatus +="but couldn't do any damage.\n";
			if(!enemy.checkHealth()){
				inBattle = false;
				fightResult = 1;
				return;
			}
			dmg = (atEnemy) - (blockPlayer);
			fightStatus += "(" + enemy.wepGet().dmgGet() + "-" + atEnemy + ")" + "The enemy swings their " + enemy.wepGet().getName() + " ";
			fightStatus += "(" + player.armGet().dmgBlockGet() + "-" + blockPlayer + ")";
			if(dmg > 0){
				player.damage(dmg);
				fightStatus += "and did " + dmg + " points of Damage.\n";
			}
			else
				fightStatus += "but couldn't do any damage.\n";
		}
		else {
			dmg = (atEnemy) - (atPlayer);
			fightStatus = "(" + enemy.wepGet().dmgGet() + "-" + atEnemy + ")" + "The enemy swings their " + enemy.wepGet().getName() + " ";
			fightStatus += "(" + player.armGet().dmgBlockGet() + "-" + blockPlayer + ")";
			if(dmg > 0){
				player.damage(dmg);
				fightStatus += "and did " + dmg + " points of Damage.\n";
			}
			else
				fightStatus += "but couldn't do any damage.\n";
			if(!player.checkHealth()){
				inBattle = false;
				fightResult = 2;
				return;
			}
			dmg = (atPlayer) - (blockEnemy);
			fightStatus += "(" + player.wepGet().dmgGet() + "-" + atPlayer + ")" + "You swing your " + player.wepGet().getName() + " ";
			fightStatus += "(" + enemy.armGet().dmgBlockGet() + "-" + blockEnemy + ")";
			if(dmg > 0){
				enemy.damage(dmg);
				fightStatus += "and did " + dmg + " points of Damage.\n";
			}
			else
				fightStatus +="but couldn't do any damage.\n";
		}
		fightStatus += "You are on " + player.currentHealthGet() + " out of " + player.maxHealthGet() + " health points.\n";
		fightStatus += "Your enemy has " + enemy.currentHealthGet() + " out of " + enemy.maxHealthGet() + " health points.\n";
		if(!enemy.checkHealth() || !player.checkHealth()){
			inBattle = false;
			if(player.checkHealth())
				fightResult = 1;
			else
				fightResult = 2;
		}
		
	}
	
	public String getFightStatus() {
		return fightStatus;
	}
	
	public boolean inBattle(){
		return inBattle;
	}
	
	public int fightResult(){
		return fightResult;
	}
	
	public IArmor lootA(){
		return lootA;
	}
	
	public IWeapon lootW(){
		return lootW;
	}


}
