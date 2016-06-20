package events;

import java.util.ArrayList;

import routes.Route;

public class MailEvent implements Event{

	private String day;
	private String to;
	private String from;
	private int weight;
	private int volume;
	private String priority;

	public MailEvent(String day, String to, String from,
			int weight, int volume, String priority){

		this.setDay(day);
		this.setTo(to);
		this.setFrom(from);
		this.setWeight(weight);
		this.setVolume(volume);
		this.setPriority(priority);
	}

	public Route findRoute(ArrayList<Route> routes){
		for(Route r : routes){
			//System.out.println("this " + this.from + " to " + this.to + "  that: " + r.getOrigin() + " to " + r.getDestination());
			if(this.to.equals(r.getDestination()) && this.from.equals(r.getOrigin())){
				return r;
			}
		}
		return null;
	}

	public double calculateCost(ArrayList<Event> events, Route r){
		//TODO: cheapest route
		for(int i = events.size()-1; i > 0; i--){
			if(events.get(i) instanceof CostEvent && r != null){
				CostEvent e = (CostEvent)events.get(i);
				if(e.getFrom().equals(r.getOrigin()) && e.getTo().equals(r.getDestination())){
					if(e.isValidParcel(this)){
						System.out.println("Cost: " + e.calculateCost(this));
						return e.calculateCost(this);
					} else {
						System.out.println("Invalid parcel");
					}
				}
			}
		}
		//No route
		System.out.println("No route available for cost");
		return -1;
	}

	public double calculatePrice(ArrayList<Event> events, Route r){
		//TODO: cheapest route
		for(int i = events.size()-1; i > 0; i--){
			if(events.get(i) instanceof PriceEvent && r != null){
				PriceEvent e = (PriceEvent)events.get(i);
				if(e.getFrom().equals(r.getOrigin()) && e.getTo().equals(r.getDestination())){
					System.out.println("Price: " + e.calculatePrice(this));
					return e.calculatePrice(this);
				}
			}
		}
		//No route
		System.out.println("No route available for price");
		return -1;
	}

	////////////////////////////////
	// 		Getters & Setters 	  //
	////////////////////////////////
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public int getVolume() {
		return volume;
	}
	public void setVolume(int volume) {
		this.volume = volume;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}

	//We may need to specify linebreaks for XML interpretation
	@Override
	public String toXML() {
		String xml = "<mail><day>"+day+"</day>";
		xml.concat("<to>"+to+"</to>");
		xml.concat("<from>"+from+"</from>");
		xml.concat("<weight>"+weight+"</weight>");
		xml.concat("<volume>"+volume+"</volume>");
		xml.concat("<priority>"+priority+"</priority>");
		xml.concat("</mail>");
		return xml;
	}

}
