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

	/**
	 * @return the company
	 */
	public String getCompany() {
		return company;
	}

	/**
	 * @param company the company to set
	 */
	public void setCompany(String company) {
		this.company = company;
	}

	/**
	 * @return the to
	 */
	public String getTo() {
		return to;
	}

	/**
	 * @param to the to to set
	 */
	public void setTo(String to) {
		this.to = to;
	}

	/**
	 * @return the from
	 */
	public String getFrom() {
		return from;
	}

	/**
	 * @param from the from to set
	 */
	public void setFrom(String from) {
		this.from = from;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
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

	/**
	 * @return the maxWeight
	 */
	public int getMaxWeight() {
		return maxWeight;
	}

	/**
	 * @param maxWeight the maxWeight to set
	 */
	public void setMaxWeight(int maxWeight) {
		this.maxWeight = maxWeight;
	}

	/**
	 * @return the maxVolume
	 */
	public int getMaxVolume() {
		return maxVolume;
	}

	/**
	 * @param maxVolume the maxVolume to set
	 */
	public void setMaxVolume(int maxVolume) {
		this.maxVolume = maxVolume;
	}

	/**
	 * @return the duration
	 */
	public int getDuration() {
		return duration;
	}

	/**
	 * @param duration the duration to set
	 */
	public void setDuration(int duration) {
		this.duration = duration;
	}

	/**
	 * @return the frequency
	 */
	public int getFrequency() {
		return frequency;
	}

	/**
	 * @param frequency the frequency to set
	 */
	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}

	/**
	 * @return the day
	 */
	public String getDay() {
		return day;
	}

	/**
	 * @param day the day to set
	 */
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
