package test;
import world.World;
import chars.NPC;
import chars.Player;
import gui.GUI;
import items.*;

public class Test {
	public static void main(final String args[]){
	
		Weapon wep = ItemGeneration.genNewWeapon(0);
		Armor arm = ItemGeneration.genNewArmor(0);
		NPC npc = new NPC(1);
		Player p = new Player(2);
		System.out.println(p.dexGet());
		System.out.println(npc.cintGet());
		World world = new World();
		GUI gui = new GUI();
		System.out.println(wep);
		System.out.println(arm);
		System.out.println(npc);
		System.out.println(p);
		
	}
}
