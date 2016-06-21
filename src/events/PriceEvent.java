package events;

import java.util.ArrayList;

import routes.Route;

public class PriceEvent implements Event{

	private String to;
	private String from;
	private String priority;
	private int weightCost;
	private int volumeCost;


	public PriceEvent(String to, String from, String priority, int weightCost,
			int volumeCost){
		this.to = to;
		this.from = from;
		this.priority = priority;
		this.weightCost = weightCost;
		this.volumeCost = volumeCost;
	}

	public double calculatePrice(MailEvent e){
		return e.getVolume()*this.volumeCost + e.getWeight()*this.weightCost + getPriorityCost(this.priority);
	}

	public int getPriorityCost(String s){
		if(s.equals("International Air")) return 20;
		else if(s.equals("International Standard")) return 10;
		else if(s.equals("Domestic Air")) return 5;
		else return 0;
	}

	////////////////////////////////
	// 		Getters & Setters 	  //
	////////////////////////////////
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
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	public int getWeightCost() {
		return weightCost;
	}
	public void setWeightCost(int weightCost) {
		this.weightCost = weightCost;
	}
	public int getVolumeCost() {
		return volumeCost;
	}
	public void setVolumeCost(int volumeCost) {
		this.volumeCost = volumeCost;
	}

	//We may need to specify linebreaks for XML interpretation
	@Override
	public String toXML() {
		String xml = "<price><to>"+to+"</to>";
		xml.concat("<from>"+from+"</from>");
		xml.concat("<priority>"+priority+"</priority>");
		xml.concat("<weightcost>"+weightCost+"</weightcost>");
		xml.concat("<volumecost>"+volumeCost+"</volumecost>");
		xml.concat("</price>");

		return xml;
	}

}
