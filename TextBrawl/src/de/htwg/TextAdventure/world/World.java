package de.htwg.TextAdventure.world;

import java.util.Random;

public class World {
		
	private boolean discoveredTown;
	private boolean discoveredForest;
	private boolean discoveredRiver;
	private boolean discoveredForestCave;
	private boolean discoveredGlimmeringShroomCavern;
	private boolean discoveredMagmaDepths;
	private boolean discoveredPortal;
	private boolean discoveredOtherworld;
	private Random rnd;
	
	/**
	 * creates a new World
	 */
	public World(){
		discoveredTown = true;
		discoveredForest = true;
		discoveredRiver = false;
		discoveredForestCave = false;
		discoveredGlimmeringShroomCavern = false;
		discoveredMagmaDepths = false;
		discoveredPortal = false;
		discoveredOtherworld = false;
		rnd = new Random();
	}
	
	/**
	 * Discover the different Parts of the World
	 * @param id
	 */
	public String explore(int playerPosition){
		String s = "";
		int tmp = rnd.nextInt(10);
		switch(tmp){
			case 0:
			case 1:
			case 2:
			case 3:
			case 4:
			case 5:
				s += "A new encounter";
				break;
			case 6:
			case 7:
			case 8:
				s += "You didnt find anything";
				break;
			case 9:
				s += "You discovered ";
				if(playerPosition == 0){
					s = "You explore the town, yet you don't find anything new. Maybe you should head outside into the Forest to have an Adventure.";
					break;
				}
				else if (playerPosition == 1){
					if(discoveredForestCave && discoveredRiver)
						break;
					else if(discoveredForestCave){
						discoveredRiver = true;
						s += "a Lake with a River";
					}
					else if(discoveredRiver){
						discoveredForestCave = true;
						s+= "a Forest Cave. Strange sounds are coming out of it.";
					}
					else {
						int tmp2 = rnd.nextInt(2);
						if(tmp2 == 0){
							discoveredForestCave = true;
							s+= "a Forest Cave. Strange sounds are coming out of it.";
						}
						else{
							discoveredRiver = true;
							s += "a Lake with a River";
						}
					}
				} else if(playerPosition == 2){
					discoveredGlimmeringShroomCavern = true;
					s += "a Cavern full of glowing Shrooms. You start to get an odd feeling about this Cave.";
				} else if (playerPosition == 4){
					if(discoveredPortal && discoveredMagmaDepths){
						s += "nothing. You already know everything here.";
						break;
					}
					else if(discoveredPortal){
						discoveredMagmaDepths = true;
						s += "a stream of Magma deep under the Cavern with the glowing shrooms.";
					}
					else if(discoveredMagmaDepths){
						discoveredPortal = true;
						s+= "a Portal. You can feel Otherworldy presences, tearing at Reality.\nYou are somehow convinced, that your quest is almost over";
					}
					else {
						int tmp2 = rnd.nextInt(2);
						if(tmp2 == 0){
							discoveredMagmaDepths = true;
							s += "a stream of Magma deep under the Cavern with the glowing shrooms.";
						}
						else{
							discoveredPortal = true;
							s+= "a Portal. You can feel Otherworldy presences, tearing at Reality.\nYou are somehow convinced, that your quest is almost over";
						}
					}
				} else if(playerPosition == 6){
					discoveredOtherworld = true;
					s = "By accident you tumble into the Portal. A short time later, you awaken in a distorted Landspace.\nYou can feel the strong presence of demons.";
				} else {
					s += "nothing. You already know all the places to go from here.";
				}
				break;
				
			default:
				break;
				
		}
					
		return s;
	}
	
	/**
	 * Getter for discoveredTown
	 * @return discoveredTown
	 */
	public boolean discoveredTown(){
		return discoveredTown;
	};
	/**
	 * Getter for discoveredForest
	 * @return discoveredForest
	 */
	public boolean discoveredForest(){
		return discoveredForest;
	};
	/**
	 * Getter for discoveredRiver
	 * @return discoveredRiver
	 */
	public boolean discoveredRiver(){
		return discoveredRiver;
	};
	/**
	 * Getter for discoveredForestCave
	 * @return discoveredForestCave
	 */
	public boolean discoveredForestCave(){
		return discoveredForestCave;
	};
	/**
	 * Getter for discoveredGlimmeringShroomCavern
	 * @return discoveredGlimmeringShroomCavern
	 */
	public boolean discoveredGlimmeringShroomCavern(){
		return discoveredGlimmeringShroomCavern;
	};
	/**
	 * Getter for discoveredMagmaDepths
	 * @return discoveredMagmaDepths
	 */
	public boolean discoveredMagmaDepths(){
		return discoveredMagmaDepths;
	};
	/**
	 * Getter for discoveredPortal
	 * @return discoveredPortal
	 */
	public boolean discoveredPortal(){
		return discoveredPortal;
	};
	/**
	 * Getter for discoveredOtherworld
	 * @return discoveredOtherworld
	 */
	public boolean discoveredOtherworld(){
		return discoveredOtherworld;
	};
	
	
}
