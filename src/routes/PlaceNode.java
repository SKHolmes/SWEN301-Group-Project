package routes;

import java.util.ArrayList;
import java.util.HashMap;

public class PlaceNode {

	private String name;
	private HashMap<PlaceNode,Route> edges;
	private boolean visited;

	public PlaceNode(String n){
		this.name = n;
		this.edges = new HashMap<PlaceNode, Route>();
	}

	public void addChild(PlaceNode p, Route r){
		edges.put(p, r);
	}

	public String getName() {
		return this.name;
	}

	public HashMap<PlaceNode,Route> getChildren(){
		return edges;
	}

	public void printNode(){
		System.out.println(name+": ");
		for(PlaceNode p : edges.keySet()){
			System.out.println("   ->"+p.name);
			System.out.println(edges.get(p).toString());
		}
	}
}
