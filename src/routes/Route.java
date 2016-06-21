package routes;

public class Route {
	private String origin;
	private String destination;
	private String type;
	private String company;
	private double totalCost;
	private double totalPrice;
	private double totalWeight;
	private double totalVolume;
	private double totalMailCount;
	private double duration;


	public Route(String origin, String dest, String type, String company){
		this.setOrigin(origin);
		this.setDestination(dest);
		this.setType(type);
		this.setCompany(company);

		totalCost = 0;
		totalPrice = 0;
		totalWeight = 0;
		totalVolume = 0;
		totalMailCount = 0;
		duration = 0;
	}
	//helper for business figures
	public double getAverageCost(){
		return totalCost/(double)totalMailCount;
	}
	public double getAveragePrice(){
		return totalPrice/(double)totalMailCount;
	}
	public double getAverageWeight(){
		return totalWeight/(double)totalMailCount;
	}
	public double getAverageVolume(){
		return totalVolume/(double)totalMailCount;
	}
	public double getAverageDuration(){
		return duration/(double)totalMailCount;
	}

	public boolean isEqual(Route r){
		return(this.origin.equals(r.origin)
				&& this.destination.equals(r.destination)
				&& this.type.equals(r.type)
				&& this.company.equals(r.company));
	}

	public void addToTotalCost(double c){
		this.totalCost += c;
	}
	public void addToTotalPrice(double c){
		this.totalPrice += c;
	}
	public void addToTotalWeight(double w){
		this.totalWeight += w;
	}
	public void addToTotalVolume(double v){
		this.totalVolume += v;
	}
	public void addToTotalMailCount(){
		this.totalMailCount++;
	}
	public void addToDuration(double d){
		this.duration += d;
	}
	public String toString(){
		return "[r: "+this.origin+"->"+this.destination+" c:"+this.company+"]";
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
	public double getTotalWeight() {
		return totalWeight;
	}
	public double getTotalVolume() {
		return totalVolume;
	}
	public double getTotalMailCount() {
		return totalMailCount;
	}
	public boolean equals(Route r){
		return this.origin.equals(r.getOrigin()) && this.destination.equals(r.getDestination());
	}
}
