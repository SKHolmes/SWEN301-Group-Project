package events;

import java.util.ArrayList;

import routes.Route;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

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

	@Override
	public Element toXML(Document d) {
		Document doc = d;
		Element root = doc.createElement("price");
		Element child = doc.createElement("to");
		child.appendChild(doc.createTextNode(this.to));
		root.appendChild(child);
		child = doc.createElement("from");
		child.appendChild(doc.createTextNode(this.from));
		root.appendChild(child);
		child = doc.createElement("priority");
		child.appendChild(doc.createTextNode(this.priority));
		root.appendChild(child);
		child = doc.createElement("weightcost");
		child.appendChild(doc.createTextNode(Integer.toString(this.weightCost)));
		root.appendChild(child);
		child = doc.createElement("volumecost");
		child.appendChild(doc.createTextNode(Integer.toString(this.volumeCost)));
		root.appendChild(child);
		
		return root;
	}
	
	@Override
	public String toString() {
		return "PriceEvent"
				+ "/To: " + to
				+ "/From: " + from
				+ "/Priority: " + priority
				+ "/Weight Cost: " + weightCost
				+ "/Volume Cost: " + volumeCost;
	}

}
