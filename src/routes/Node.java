package routes;

import java.util.ArrayList;

public class Node {

	private String name;
	
	private boolean visited;
	private ArrayList<Edge> edges;
	
	
	public Node(String n){
		this.name = n;
		edges = new ArrayList<Edge>();
	}
	
	public boolean equals(Node other){
		return this.name.equals(other.getName());
	}
	
	public String getName(){
		return this.name;
	}
	
	public void addEdge(Edge e){
		edges.add(e);
	}
	
	public void printEdges(){
		System.out.println("Node: "+name);
		for(Edge e : edges){
			System.out.println(e.toString());
		}
	}
	
	public void setVisited(boolean b){
		visited = b;
	}
	
	public boolean getVisited(){
		return visited;
	}
}
