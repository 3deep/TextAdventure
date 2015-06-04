package htwg.de.main;

import htwg.de.gui.GUI;

final class TextAdventure {
	
	/*
	 * private Player p;
	 * private NPC npc;
	 * private World world;
	 */
	
	private static GUI gui;
		
	public static void main (final String args[]){
		gui = new GUI();
		if(gui == null)
			throw new NullPointerException("No GUI found");
	}

}
