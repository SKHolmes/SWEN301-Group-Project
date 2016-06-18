package routes;

public class Route {
	private String origin;
	private String destination;
	private String type;
	private double totalCost;
	private double totalPrice;
	private int count;


	public Route(String origin, String dest, String type){
		this.setOrigin(origin);
		this.setDestination(dest);
		this.setType(type);

		totalCost = 0;
		totalPrice = 0;
	}

	public void addToTotalCost(double c){
		this.totalCost += c;
	}

	public void addToTotalPrice(double c){
		this.totalPrice += c;
	}

	//helper for business figures
	public double getAverageCost(){
		return totalCost/count;
	}

	public double getAveragePrice(){
		return totalPrice/count;
	}

	/////////////////////////////
	//    Getters & Setters    //
	/////////////////////////////
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}
