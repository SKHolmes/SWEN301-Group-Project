package routes;

import java.util.ArrayList;
import java.util.Collections;


public class Djikstra {
	
	private ArrayList<Node> graph;
	
	//Testing done here.
	/*public static void main(String[] args){
		Node a = new Node("A");
		Node b = new Node("B");
		Node c = new Node("C");
		Node d = new Node("D");
		Node e = new Node("E");
		a.addEdge(new Edge(a, b, 6, 6));
		a.addEdge(new Edge(a, c, 5, 5));
		b.addEdge(new Edge(b, e, 5, 5));
		b.addEdge(new Edge(b, d, 1, 1));
		c.addEdge(new Edge(c, d, 10, 10));
		d.addEdge(new Edge(d, e, 5, 5));
		ArrayList<Node> n = new ArrayList<Node>();
		n.add(a);
		n.add(b);
		n.add(c);
		n.add(d);
		n.add(e);
		Graph g = new Graph(n, 0);
		g.printNodes();
		Djikstra dj = new Djikstra(n);
		ArrayList<Node> result = dj.findShortestPathWithPrice(a, e);
		for(Node node: result){
			System.out.println(node.getName() + ",");
		}
	}*/
	
	public Djikstra(ArrayList<Node> graph){
		this.graph = graph;		
	}
	
	public ArrayList<Node> findShortestPathWithPrice(Node start, Node goal){
		for(Node n: graph){
			n.setDistance(Integer.MAX_VALUE);
			n.setPrevious(null);
		}
		start.setDistance(0);
		ArrayList<Node> unvisited = new ArrayList<Node>();
		unvisited.addAll(graph);
		
		
		while(!unvisited.isEmpty()){											//While there are still nodes to search.
			Node closest = unvisited.get(0);									//Take the first node.
			for(Node n: unvisited){												//For each of the unvisited node.
				if(n.getDistance() < closest.getDistance()){					//Compare distances to make sure the closest remains true.
					closest = n;
				}
			}
			unvisited.remove(closest);
			if(closest == goal){//We are done
				ArrayList<Node> path = new ArrayList<Node>();
				path.add(closest);
				while(closest.getPrevious() != null){
					Node next = closest.getPrevious();
					path.add(next);
					closest = next;
				}
				Collections.reverse(path);
				return path;
			}else{
				for(Edge e: closest.getEdges()){
					Node toNode = e.getTo();
					if(unvisited.contains(toNode)){
						int cost = closest.getDistance() + e.getPrice();
						if(cost < toNode.getDistance()){
							toNode.setDistance(cost);
							toNode.setPrevious(closest);
						}
					}
				}
			}			
		}
		System.out.println("Failed to find shortest path returning null.");;
		return null;		
	}
	

	public ArrayList<Node> findShortestPathWithDuration(Node start, Node goal){
		for(Node n: graph){
			n.setDistance(Integer.MAX_VALUE);
			n.setPrevious(null);
		}
		start.setDistance(0);
		ArrayList<Node> unvisited = new ArrayList<Node>();
		unvisited.addAll(graph);
		
		
		while(!unvisited.isEmpty()){											//While there are still nodes to search.
			Node closest = unvisited.get(0);									//Take the first node.
			for(Node n: unvisited){												//For each of the unvisited node.
				if(n.getDistance() < closest.getDistance()){					//Compare distances to make sure the closest remains true.
					closest = n;
				}
			}
			unvisited.remove(closest);
			if(closest == goal){//We are done
				ArrayList<Node> path = new ArrayList<Node>();
				path.add(closest);
				while(closest.getPrevious() != null){
					Node next = closest.getPrevious();
					path.add(next);
					closest = next;
				}
				Collections.reverse(path);
				return path;
			}else{
				for(Edge e: closest.getEdges()){
					Node toNode = e.getTo();
					if(unvisited.contains(toNode)){
						int cost = closest.getDistance() + e.getDuration();
						if(cost < toNode.getDistance()){
							toNode.setDistance(cost);
							toNode.setPrevious(closest);
						}
					}
				}
			}			
		}
		System.out.println("Failed to find shortest path returning null.");;
		return null;		
	}
}
