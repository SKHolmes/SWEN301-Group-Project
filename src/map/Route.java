package map;

import java.util.ArrayList;

/** Contains multiple path instances and represents a route from location to destination.
 *
 * @author taitdani1
 *
 */

public class Route {

	private ArrayList<Path> paths;
	public String curDest;
	public String targetDest;
	public int totalCost;

	public Route(Path init, String dest){
		this.paths = new ArrayList<Path>();
		this.paths.add(init);
		this.targetDest = dest;
		this.curDest = init.getTo();
	}
}
