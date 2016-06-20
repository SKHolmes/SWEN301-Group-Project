package routes;

public class Route {
	private String origin;
	private String destination;
	private String type;
	private String company;
	private double totalCost;
	private double totalPrice;
	private int count;


	public Route(String origin, String dest, String type, String company){
		this.setOrigin(origin);
		this.setDestination(dest);
		this.setType(type);
		this.setCompany(company);

		totalCost = 0;
		totalPrice = 0;
	}

	public void addToTotalCost(double c){
		this.totalCost += c;
	}

	public void addToTotalPrice(double c){
		this.totalPrice += c;
	}

	public boolean isEqual(Route r){
		return(this.origin.equals(r.origin)
				&& this.destination.equals(r.destination)
				&& this.type.equals(r.type)
				&& this.company.equals(r.company));
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
	public String getCompany(){
		return this.company;
	}
	public void setCompany(String company){
		this.company = company;
	}
}
