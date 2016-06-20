package events;

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

	//We may need to specify linebreaks for XML interpretation
	@Override
	public String toXML() {
		String xml = "<discontinue><company>"+company+"</company>";
		xml.concat("<to>"+to+"</to>");
		xml.concat("<from>"+from+"</from>");
		xml.concat("<type>"+type+"</type>");
		xml.concat("</discontinue>");

		return xml;
	}

}
