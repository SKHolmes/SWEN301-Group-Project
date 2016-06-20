package events;

import java.util.ArrayList;
import java.util.List;

import routes.Route;

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

	public Route newRoute(ArrayList<Route> routes){
		Route tmpRoute = new Route(this.from, this.to, this.type, this.company);
		//check if route exists already
		for(Route r : routes){
			if(r.equals(tmpRoute)){
				//route exits
				return null;
			}
		}
		routes.add(tmpRoute);
		return tmpRoute;
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


	//We may need to specify linebreaks for XML interpretation
	@Override
	public String toXML() {
		String xml = "<cost><company>"+company+"</company>";
		xml.concat("<to>"+to+"</to>");
		xml.concat("<from>"+from+"</from>");
		xml.concat("<type>"+type+"</type>");
		xml.concat("<weightcost>"+weightCost+"</weightcost>");
		xml.concat("<volumecost>"+volumeCost+"</volumecost>");
		xml.concat("<maxWeight>"+maxWeight+"</maxWeight>");
		xml.concat("<maxVolume>"+maxVolume+"</maxVolume>");
		xml.concat("<duration>"+duration+"</duration>");
		xml.concat("<frequency>"+frequency+"</frequency>");
		xml.concat("<day>"+day+"</day>");
		xml.concat("</cost>");

		return xml;
	}

}
