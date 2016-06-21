package routes;

import java.util.ArrayList;

public class Map {

	public ArrayList<Route> routes; //All current routes
	public ArrayList<PlaceNode> nodes;
	public ArrayList<Route>fringe;

	private PlaceNode origin;
	private PlaceNode dest;

	public Map(ArrayList<Route> r){
		initialize(r);
	}

	public void initialize(ArrayList<Route> r) {
		this.routes = r;
		this.nodes = new ArrayList<PlaceNode>();

		PlaceNode p;
		for(Route route: routes){
			for(PlaceNode n: this.nodes){
				if(n.getName().equals(route.getOrigin()));
				updateEdge(n,route);
			}
		}
	}

	private void updateEdge(PlaceNode n, Route r) {
		boolean check = false;
		ArrayList<PlaceNode> children = n.getChildren();
		for(PlaceNode c: children){
			if(c.getName().equals(r.getDestination()));
				check = true;
		}
		if(check) return;
		else{
			n.addChild(new PlaceNode());
		}
	}


	/**
	Given: a graph with weighted edges.
	• Initialise fringe to be a set containing start node
	start.pathlength ← 0
	• Initialise path length of all other nodes to 
	• Repeat until visited contains all nodes:
	– Choose an unvisited node from the fringe with minimum path
	length (ie, length from start to node)
	– Record the path to the current node
	– Add unvisited neighbours of current node to fringe
	– Add the current node to visited
	*/
}
