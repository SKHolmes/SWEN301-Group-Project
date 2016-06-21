package events;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class DiscontinueEvent implements Event{

	private String company;
	private String to;
	private String from;
	private String type;

	public DiscontinueEvent(String company, String to, String from, String type){

		this.company = company;
		this.to = to;
		this.from = from;
		this.type = type;
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

	@Override
	public Element toXML(Document d){
		Document doc = d;
		Element root = doc.createElement("discontinue");
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
		
		return root;
	}
	
	@Override
	public String toString() {
		return "DiscontinueEvent"
				+ "/Company: " + company
				+ "/To: " + to
				+ "/From: " + from
				+ "/Type: " + type;
	}

}
