package world;

public class World {
		
	boolean discoveredTown;
	boolean discoveredForest;
	boolean discoveredRiver;
	boolean discoveredForestCave;
	boolean discoveredGlimmeringShroomCavern;
	boolean discoveredMagmaDepths;
	boolean discoveredPortal;
	boolean discoveredOtherworld;
	
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
	
	public void discover(int id){
		switch (id){
		case 1:
			discoveredRiver = true;
			break;
			
		case 2:
			discoveredForestCave = true;
			break;
			
		case 3:
			discoveredGlimmeringShroomCavern = true;
			break;
			
		case 4:
			discoveredMagmaDepths = true;
			break;
			
		case 5:
			discoveredPortal = true;
			break;
			
		case 6:
			discoveredOtherworld = true;
			break;
			
		default:
			break;
		}
		
	}
	
	
	
}
