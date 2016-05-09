package map;

import java.util.ArrayList;
import java.util.Collection;

/** Stores data for current paths (as defined by cost tag) and logic for finding optimal route with the given paths
 *
 * @author Daniel Tait
 *
 */

public class Map {

	private ArrayList<Path> paths;
	private ArrayList<Route> potential;
	private Route curBest;

	public Map(){
		this.paths = new ArrayList<Path>();
	}

	/** Replaces all routes stored in this instance of map
	 *
	 * @param r - List of routes to store
	 */

	public void setInitRoutes(ArrayList<Path> p){
		this.paths = p;
	}

	public void addPath(Path p){
		this.paths.add(p);
	}

	public Path optimalPath(String from, String to){
		for(Path p : paths){
			if (p.getFrom().equals(from)){
	//			potential.addAll(solveRoutes(p));TODO
			}
		}
		return null;
	}

	//private ArrayList<Route> solveRoutes(Path p) {
	//	ArrayList<Route> temp = new ArrayList<Route>();


	//	return null;
	//}

}
