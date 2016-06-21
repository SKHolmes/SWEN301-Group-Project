package routes;

import java.util.ArrayList;

public class Graph {
	

	private ArrayList<Node> nodes;
	
	public Graph(ArrayList<Route> routes){
		nodes = new ArrayList<Node>();
		fillNodes(routes);
		printNodes();
	}
	
	public Graph(ArrayList<Node> nodes, int fuckthis){
		this.nodes = nodes;
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
		Edge e = new Edge(newNode, new Node(r.getDestination()), r.getPrice(), r.getDuration(), r.);
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
	
	public void printNodes() {
		for(Node n : nodes){
			n.printEdges();
			System.out.println("-------------------------------------");
		}
		
	}
	
}

	