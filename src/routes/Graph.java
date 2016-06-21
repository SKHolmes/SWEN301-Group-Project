package routes;

import java.util.ArrayList;

public class Graph {
	

	private ArrayList<Node> nodes;
	
	public Graph(ArrayList<Route> routes){
		nodes = new ArrayList<Node>();
		fillNodes(routes);
		printNodes();
	}

	private void fillNodes(ArrayList<Route> routes) {
		for(Route r : routes){
			Node newNode = new Node (r.getOrigin());
			if (isPresent(newNode)){
				addEdge(newNode, r);
			}
			else{
				addNode(newNode, r);
			}
		}
	}

	private void addNode(Node newNode, Route r) {
		Edge e = new Edge(newNode, new Node(r.getDestination()), r.getPrice(), r.getDuration());
		newNode.addEdge(e);
		nodes.add(newNode);
	}

	private void addEdge(Node newNode, Route r) {
		for(Node n : nodes){
			if(newNode.equals(n)){
				n.addEdge(new Edge(newNode, new Node(r.getDestination()), r.getPrice(), r.getDuration()));
			}
		}
	}

	private boolean isPresent(Node newNode) {
		for(Node n : nodes){
			if(newNode.equals(n)){
				return true;
			}
		}
		return false;
	}
	
	private void printNodes() {
		for(Node n : nodes){
			n.printEdges();
			System.out.println("-------------------------------------");
		}
		
	}
	
	public static void main(String[] args){
		ArrayList<Route> routes = new ArrayList<Route>();
		routes.add(new Route("A", "B", "some type", "Air Company"));
		routes.add(new Route("B", "C", "some type", "Air Company"));
		routes.add(new Route("C", "D", "some type", "Air Company"));
		routes.add(new Route("B", "D", "some type", "Air Company"));
		routes.add(new Route("D", "A", "some type", "Air Company"));
		
		Graph g = new Graph(routes);
	}
}

	