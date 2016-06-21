package routes;

import java.util.ArrayList;

public class PlaceNode {

	private String name;
	private ArrayList<PlaceNode> children;
	private boolean visited;

	public PlaceNode(String n){
		this.name = n;
	}

	public void addChild(PlaceNode p){
		children.add(p);
	}

	public String getName() {
		return this.name;
	}

	public ArrayList<PlaceNode> getChildren(){
		return children;
	}
}
