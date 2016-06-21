package events;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import java.util.ArrayList;
import java.util.List;

import routes.Route;

import org.w3c.dom.Element;

public class CostEvent implements Event{

	private String company;
	private String to;
	private String from;
	private String type;
	private int weightCost;
	private int volumeCost;
	private int maxWeight;
	private int maxVolume;
	private int duration;
	private int frequency;
	private String day;

	public CostEvent (String company, String to, String from, String type,
			int weightCost, int volumeCost, int maxWeight, int maxVolume,
			int duration, int frequency, String day){

		this.company = company;
		this.to = to;
		this.from = from;
		this.type = type;
		this.weightCost = weightCost;
		this.volumeCost = volumeCost;
		this.maxWeight = maxWeight;
		this.maxVolume = maxVolume;
		this.duration = duration;
		this.frequency = frequency;
		this.day = day;
	}

	public double calculateCost(MailEvent e){
		//TODO: might wanna fine tune this calculation
		return e.getVolume()*this.volumeCost + e.getWeight()*this.weightCost;
	}

	public Route newRoute(ArrayList<Route> routes){
		Route tmpRoute = new Route(this.from, this.to, this.type, this.company);
		//check if route exists already
		for(Route r : routes){
			if(r.equals(tmpRoute)){
				//route exits
				return null;
			}
		}
		return tmpRoute;
	}

	public boolean isValidParcel(MailEvent e){
		return (e.getVolume() <= this.maxVolume && e.getWeight() <= this.maxWeight);
	}

	////////////////////////////////
	// 		Getters & Setters 	  //
	////////////////////////////////
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
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
	public int getMaxWeight() {
		return maxWeight;
	}
	public void setMaxWeight(int maxWeight) {
		this.maxWeight = maxWeight;
	}
	public int getMaxVolume() {
		return maxVolume;
	}
	public void setMaxVolume(int maxVolume) {
		this.maxVolume = maxVolume;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public int getFrequency() {
		return frequency;
	}
	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}


	@Override
	public Element toXML(Document d) {
		Document doc = d;
		Element root = doc.createElement("cost");
		Element child = doc.createElement("company");
		child.appendChild(doc.createTextNode(this.company));
		root.appendChild(child);
		child = doc.createElement("to");
		child.appendChild(doc.createTextNode(this.to));
		root.appendChild(child);
		child = doc.createElement("from");
		child.appendChild(doc.createTextNode(this.from));
		root.appendChild(child);
		child = doc.createElement("type");
		child.appendChild(doc.createTextNode(this.type));
		root.appendChild(child);
		child = doc.createElement("weightcost");
		child.appendChild(doc.createTextNode(Integer.toString(this.weightCost)));
		root.appendChild(child);
		child = doc.createElement("volumecost");
		child.appendChild(doc.createTextNode(Integer.toString(this.volumeCost)));
		root.appendChild(child);
		child = doc.createElement("maxWeight");
		child.appendChild(doc.createTextNode(Integer.toString(this.maxWeight)));
		root.appendChild(child);
		child = doc.createElement("maxVolume");
		child.appendChild(doc.createTextNode(Integer.toString(this.maxVolume)));
		root.appendChild(child);
		child = doc.createElement("duration");
		child.appendChild(doc.createTextNode(Integer.toString(this.duration)));
		root.appendChild(child);
		child = doc.createElement("frequency");
		child.appendChild(doc.createTextNode(Integer.toString(this.frequency)));
		root.appendChild(child);
		child = doc.createElement("day");
		child.appendChild(doc.createTextNode(this.day));
		root.appendChild(child);
		
		return root;
	}
}
