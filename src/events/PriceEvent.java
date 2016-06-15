package events;

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

	//We may need to specify linebreaks for XML interpretation
	@Override
	public String toXML() {
		String xml = "<price><to>"+to+"</to>";
		xml.concat("<from>"+from+"</from>");
		xml.concat("<priority>"+priority+"</priority>");
		xml.concat("<weightcost>"+weightCost+"</weightcost>");
		xml.concat("<volumecost>"+volumeCost+"</volumecost>");
		xml.concat("</price>");

		return xml;
	}

}
