package routes;

public class Edge {

	private Node from;
	private Node to;
	private double price;
	private double duration;
	private int weightCost;
	private int volumeCost;

	public Edge(Node f, Node t, double p, double d){
		this.from = f;
		this.to= t;
		this.price = p;
		this.duration = d;
	}

	public String toString(){
		return "From: "+from.getName()+" To: "+to.getName()+" Price: "+price+" Duration: "+duration;
	}

	public Node getFrom(){
		return from;
	}

	public Node getTo(){
		return to;
	}

	public int getPrice(){
		return (int) price;
	}

	public int getDuration(){
		return (int) duration;
	}

	/**
	 * @return the weightCost
	 */
	public int getWeightCost() {
		return weightCost;
	}

	/**
	 * @param weightCost the weightCost to set
	 */
	public void setWeightCost(int weightCost) {
		this.weightCost = weightCost;
	}

	/**
	 * @return the volumeCost
	 */
	public int getVolumeCost() {
		return volumeCost;
	}

	/**
	 * @param volumeCost the volumeCost to set
	 */
	public void setVolumeCost(int volumeCost) {
		this.volumeCost = volumeCost;
	}
}
