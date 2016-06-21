package routes;

import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

public class Map {

	//Storage
	public ArrayList<Route> routes; //All current routes
	public CopyOnWriteArrayList<PlaceNode> nodes;

	//Algorithm
	public ArrayList<Route>fringe;
	private PlaceNode origin;
	private PlaceNode dest;

	public Map(ArrayList<Route> r){
		this.routes = r;
		this.nodes = new CopyOnWriteArrayList<PlaceNode>();
	}

	public void findPath(String o, String d){
		this.origin = new PlaceNode(o);
		this.dest = new PlaceNode(d);

	}

	public void fillNodes(){
		PlaceNode temp1;
		PlaceNode temp2;
		boolean check;

		if(nodes.isEmpty()){
			PlaceNode t1 = new PlaceNode(routes.get(0).getOrigin());
			PlaceNode t2 = new PlaceNode(routes.get(0).getDestination());
			firstNode(t1,t2,routes.get(0));
		}

		for(Route r : routes){
			check = false;
			temp1 = new PlaceNode(r.getOrigin());
			temp2 = new PlaceNode(r.getDestination());

			for(PlaceNode p: nodes){
				check = addNode(temp1, temp2 ,p, r);
			}

		}
		//TODO
		printNodes();
	}

	private void firstNode(PlaceNode newO, PlaceNode newD, Route r) {
		newO.addChild(newD, r); //add destination to children of origin
		nodes.add(newO);		//add origin node to nodes
	}

	private void printNodes() {
		for(PlaceNode p: nodes){
			p.printNode();
		}

	}

	private boolean addNode(PlaceNode newO, PlaceNode newD , PlaceNode p, Route r) {

		if(newO.equals(p)){	//if the origin is already there
			if(newO.getChildren().containsKey(newD)){ //and the node to route mapping is already there
				return true;	//origin node present and destination exist within children map so exit
				}
			else{
				newO.addChild(newD, r);	//else origin exist with no dest child so add to map
			}
		}
		else {	//Origin node not present
			newO.addChild(newD, r); //add destination to children of origin
			nodes.add(newO);		//add origin node to nodes
		}
		return false;
	}



	public static void main(String[] args){
		ArrayList<Route> routes = new ArrayList<Route>();
		routes.add(new Route("place1", "place2", "lol", "c1"));
		routes.add(new Route("place1", "place3", "lol", "c2"));
		routes.add(new Route("place1", "place4", "lol", "c3"));
		routes.add(new Route("place2", "place3", "lol", "c4"));
		routes.add(new Route("place2", "place4", "lol", "c5"));

		Map map = new Map(routes);
		map.fillNodes();
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
