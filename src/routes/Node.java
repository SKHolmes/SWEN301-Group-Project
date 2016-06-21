package routes;

import java.util.ArrayList;

public class Node {

	private String name;
	
	private ArrayList<Edge> edges;
	private int distance;
	private Node previous;
	private Edge previousEdge;
	
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

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public Node getPrevious() {
		return previous;
	}

	public void setPrevious(Node previous) {
		this.previous = previous;
	}
	
	public ArrayList<Edge> getEdges(){
		return edges;
	}

	public void setPreviousEdge(Edge e) {
		this.previousEdge = e;		
	}
	
	public Edge getPreviousEdge(){
		return previousEdge;
	}
}
