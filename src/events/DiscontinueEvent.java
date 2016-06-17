package events;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

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

	@Override
	public Element toXML(){
		
		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.newDocument();
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
			
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
