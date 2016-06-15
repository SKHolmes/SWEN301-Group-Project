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
