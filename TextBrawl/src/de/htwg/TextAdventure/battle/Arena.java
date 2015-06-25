package de.htwg.TextAdventure.battle;

import java.util.Random;
import java.util.Scanner;

import de.htwg.TextAdventure.chars.INPC;
import de.htwg.TextAdventure.chars.IPlayer;

public class Arena implements IArena {
	
	public Arena(){
		;
	}
	
	/* (non-Javadoc)
	 * @see de.htwg.TextAdventure.battle.IArena#battle(de.htwg.TextAdventure.chars.IPlayer, de.htwg.TextAdventure.chars.INPC)
	 */
	@Override
	public boolean battle(IPlayer player, INPC enemy) {
		System.out.println("The Battle starts!");
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		while(player.checkHealth() && enemy.checkHealth()){
			System.out.println("You are on " + player.currentHealthGet() + " out of " + player.maxHealthGet() + "health points");
			System.out.println("Your enemy has " + enemy.currentHealthGet() + " out of " + enemy.maxHealthGet() + " health points");
			while(true){
				System.out.println("Now what are you going to do? Attack or Flee?");
				String tmp = scan.nextLine();
					if(tmp.equalsIgnoreCase("attack")){
						attack(player, enemy);
						break;
					}
					else if(tmp.equalsIgnoreCase("flee")){
						if(player.speedGet() > enemy.speedGet()){
							return false;
						}
						else
							System.out.println("You were too slow. The enemy denies you any chance at escape.");
					}
					else 
						System.out.println("I don't understand the command " + tmp);
			}
			if(!player.checkHealth()){
				System.out.println("You have fallen in valiant battle.\n\nGAME OVER");
				System.exit(0);
			}
		}
		return true;
	}

	private void attack(IPlayer player, INPC enemy) {
		Random rnd = new Random();
		int dmg;
		if(enemy.speedGet() <= player.speedGet()){
			if(enemy.armGet().dmgBlockGet() != 0)
				dmg = (rnd.nextInt(player.wepGet().dmgGet())) - (rnd.nextInt(enemy.armGet().dmgBlockGet()));
			else
				dmg = rnd.nextInt(player.wepGet().dmgGet());
			if(dmg > 0){
				enemy.damage(dmg);
				System.out.println("You did " + dmg + " points of Damage.");
			}
			else
				System.out.println("You couldn't do any damage.");
			if(!enemy.checkHealth())
				return;
			if(player.armGet().dmgBlockGet() != 0)
				dmg = (rnd.nextInt(enemy.wepGet().dmgGet())) - (rnd.nextInt(player.armGet().dmgBlockGet()));
			else
				dmg = rnd.nextInt(player.wepGet().dmgGet());
			if(dmg > 0){
				player.damage(dmg);
				System.out.println("The enemy did " + dmg + " points of Damage.");
			}
			else
				System.out.println("The enemy couldn't do any damage.");
		}
		else {
			if(player.armGet().dmgBlockGet() != 0)
				dmg = (rnd.nextInt(enemy.wepGet().dmgGet())) - (rnd.nextInt(player.armGet().dmgBlockGet()));
			else
				dmg = rnd.nextInt(enemy.wepGet().dmgGet());
			if(dmg > 0){
				player.damage(dmg);
				System.out.println("The enemy did " + dmg + " points of Damage.");
			}
			else
				System.out.println("The enemy couldn't do any damage.");
			if(!player.checkHealth())
				return;
			if(enemy.armGet().dmgBlockGet() != 0)
				dmg = (rnd.nextInt(player.wepGet().dmgGet())) - (rnd.nextInt(enemy.armGet().dmgBlockGet()));
			else
				dmg = rnd.nextInt(player.wepGet().dmgGet());
			if(dmg > 0){
				enemy.damage(dmg);
				System.out.println("You did " + dmg + " points of Damage.");
			}
			else
				System.out.println("You couldn't do any damage.");
		}
	}


}
