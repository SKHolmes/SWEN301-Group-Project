package events;

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
	 * @return the priority
	 */
	public String getPriority() {
		return priority;
	}


	/**
	 * @param priority the priority to set
	 */
	public void setPriority(String priority) {
		this.priority = priority;
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
