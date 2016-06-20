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
		CostEvent cost = getCostEvent(events, r);
		if(cost != null){
			return cost.calculateCost(this);
		}
		return 0;
	}

	public CostEvent getCostEvent(ArrayList<Event> events, Route r){
		//TODO: cheapest route
		for(int i = events.size()-1; i > 0; i--){
			if(events.get(i) instanceof CostEvent && r != null){
				CostEvent e = (CostEvent)events.get(i);
				//System.out.println("this " + e.getFrom() + " to " + e.getTo() + "  that: " + r.getOrigin() + " to " + r.getDestination());
				if(e.getFrom().equals(r.getOrigin()) && e.getTo().equals(r.getDestination())){
					if(e.isValidParcel(this)){
						return e;
					}
				}
			}
		}
		return null;
	}

	public double calculatePrice(ArrayList<Event> events, Route r){
		//TODO: cheapest route
		//TODO: by priority
		for(int i = events.size()-1; i > 0; i--){
			if(events.get(i) instanceof PriceEvent && r != null){
				PriceEvent e = (PriceEvent)events.get(i);
				String origin = r.getOrigin();
				String destination = r.getDestination();
				//check origin/destination is in NZ
				if(isInNZ(r.getOrigin())) origin = "New Zealand";
				if(isInNZ(r.getDestination())) destination = "New Zealand";

				if(e.getFrom().equals(origin) && e.getTo().equals(destination)){
					return e.calculatePrice(this);
				}
			}
		}
		//No route
		System.out.println("No route available for price");
		return -1;
	}

	//helper to calculate price
	public boolean isInNZ(String s){
		return (s.equals("Auckland") || s.equals("Hamilton") || s.equals("Wellington")
			|| s.equals("Christchurch"));
	}

	public void updateRouteStats(ArrayList<Event> events, Route r){
		if(r != null){
			r.addToTotalCost(calculateCost(events, r));
			r.addToTotalPrice(calculatePrice(events, r));
			r.addToTotalVolume((double)this.getVolume());
			r.addToTotalWeight((double)this.getWeight());
			r.addToTotalMailCount();
			CostEvent c = getCostEvent(events, r);
			if(c != null) {
				r.addToDuration(c.getDuration());
				System.out.println("Price: " + calculatePrice(events, r) + "\tCost: " + calculateCost(events,r));
			}
		}
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
