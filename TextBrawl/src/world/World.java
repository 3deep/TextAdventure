package world;

public class World {
		
	private boolean discoveredTown;
	private boolean discoveredForest;
	private boolean discoveredRiver;
	private boolean discoveredForestCave;
	private boolean discoveredGlimmeringShroomCavern;
	private boolean discoveredMagmaDepths;
	private boolean discoveredPortal;
	private boolean discoveredOtherworld;
	
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
		}
		
	}
	
	public boolean discoveredTown(){
		return discoveredTown;
	};
	public boolean discoveredForest(){
		return discoveredForest;
	};
	public boolean discoveredRiver(){
		return discoveredRiver;
	};
	public boolean discoveredForestCave(){
		return discoveredForestCave;
	};
	public boolean discoveredGlimmeringShroomCavern(){
		return discoveredGlimmeringShroomCavern;
	};
	public boolean discoveredMagmaDepths(){
		return discoveredMagmaDepths;
	};
	public boolean discoveredPortal(){
		return discoveredPortal;
	};
	public boolean discoveredOtherworld(){
		return discoveredOtherworld;
	};
	
	
}
