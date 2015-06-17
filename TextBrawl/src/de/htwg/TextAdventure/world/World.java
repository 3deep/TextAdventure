package de.htwg.TextAdventure.world;

public class World {
		
	private boolean discoveredTown;
	private boolean discoveredForest;
	private boolean discoveredRiver;
	private boolean discoveredForestCave;
	private boolean discoveredGlimmeringShroomCavern;
	private boolean discoveredMagmaDepths;
	private boolean discoveredPortal;
	private boolean discoveredOtherworld;
	
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
	}
	
	/**
	 * Discover the different Parts of the World
	 * @param id
	 */
	public String explore(){
		String s = "tester";
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
