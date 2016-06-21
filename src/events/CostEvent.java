package events;

import org.w3c.dom.Document;
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
	
	@Override
		public String toString() {
			return "CostEvent"
					+ "/Company: " + company
					+ "/To: " + to
					+ "/From: " + from
					+ "/Type: " + type
					+ "/Weight Cost: " + weightCost
					+ "/Volume Cost: " + volumeCost
					+ "/Max Weight: " + maxWeight
					+ "/Max Volume: " + maxVolume
					+ "/Duration: " + duration
					+ "/Frequency: " + frequency
					+ "/Day: " + day;
	}
}
