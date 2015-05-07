package test;
import world.World;
import chars.NPC;
import chars.Player;
import gui.GUI;
import items.*;

public class Test {
	public static void main(final String args[]){
	
		weapon wep = ItemGeneration.genNewWeapon(0);
		armor arm = ItemGeneration.genNewArmor(0);
		NPC npc = new NPC(0);
		Player p = new Player();
		World world = new World();
		GUI gui = new GUI();
		System.out.println(wep);
		System.out.println(arm);
		System.out.println(npc);
		System.out.println(p);
		
	}
}
