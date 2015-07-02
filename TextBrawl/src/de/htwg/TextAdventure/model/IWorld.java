package de.htwg.TextAdventure.model;

public interface IWorld {

	/**
	 * Discover the different Parts of the World
	 * @param id
	 */
	public abstract String explore(int playerPosition);

	/**
	 * Getter for discoveredTown
	 * @return discoveredTown
	 */
	public abstract boolean discoveredTown();

	/**
	 * Getter for discoveredForest
	 * @return discoveredForest
	 */
	public abstract boolean discoveredForest();

	/**
	 * Getter for discoveredRiver
	 * @return discoveredRiver
	 */
	public abstract boolean discoveredRiver();

	/**
	 * Getter for discoveredForestCave
	 * @return discoveredForestCave
	 */
	public abstract boolean discoveredForestCave();

	/**
	 * Getter for discoveredGlimmeringShroomCavern
	 * @return discoveredGlimmeringShroomCavern
	 */
	public abstract boolean discoveredGlimmeringShroomCavern();

	/**
	 * Getter for discoveredMagmaDepths
	 * @return discoveredMagmaDepths
	 */
	public abstract boolean discoveredMagmaDepths();

	/**
	 * Getter for discoveredPortal
	 * @return discoveredPortal
	 */
	public abstract boolean discoveredPortal();

	/**
	 * Getter for discoveredOtherworld
	 * @return discoveredOtherworld
	 */
	public abstract boolean discoveredOtherworld();

}