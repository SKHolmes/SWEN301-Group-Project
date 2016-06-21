package events;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

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
	 * @return the weight
	 */
	public int getWeight() {
		return weight;
	}

	/**
	 * @param weight the weight to set
	 */
	public void setWeight(int weight) {
		this.weight = weight;
	}

	/**
	 * @return the volume
	 */
	public int getVolume() {
		return volume;
	}

	/**
	 * @param volume the volume to set
	 */
	public void setVolume(int volume) {
		this.volume = volume;
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

	@Override
	public Element toXML(Document d){

		Document doc = d;
		Element root = doc.createElement("mail");
		Element child = doc.createElement("day");
		child.appendChild(doc.createTextNode(this.day));
		root.appendChild(child);
		child = doc.createElement("to");
		child.appendChild(doc.createTextNode(this.to));
		root.appendChild(child);
		child = doc.createElement("from");
		child.appendChild(doc.createTextNode(this.from));
		root.appendChild(child);
		child = doc.createElement("weight");
		child.appendChild(doc.createTextNode(Integer.toString(this.weight)));
		root.appendChild(child);
		child = doc.createElement("volume");
		child.appendChild(doc.createTextNode(Integer.toString(this.volume)));
		root.appendChild(child);
		child = doc.createElement("priority");
		child.appendChild(doc.createTextNode(this.priority));
		root.appendChild(child);
		
		return root;
	}
	
	public String toString() {
		return "MailEvent"
				+ "/Day: " + day
				+ "/To: " + to
				+ "/From: " + from
				+ "/Weight: " + weight
				+ "/Volume: " + volume
				+ "/Priority: " + priority;
	}

}
