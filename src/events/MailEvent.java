package events;

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

	////////////////////////////////
	// 		Getters & Setters 	  //
	////////////////////////////////
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
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
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public int getVolume() {
		return volume;
	}
	public void setVolume(int volume) {
		this.volume = volume;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}

	//We may need to specify linebreaks for XML interpretation
	@Override
	public String toXML() {
		String xml = "<mail><day>"+day+"</day>";
		xml.concat("<to>"+to+"</to>");
		xml.concat("<from>"+from+"</from>");
		xml.concat("<weight>"+weight+"</weight>");
		xml.concat("<volume>"+volume+"</volume>");
		xml.concat("<priority>"+priority+"</priority>");
		xml.concat("</mail>");
		return xml;
	}

}
