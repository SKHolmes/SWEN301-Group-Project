package events;

public class TimeLimitEvent implements Event{

	private String to;
	private String from;
	private String priority;
	private int maxDeliveryTime;

		public TimeLimitEvent(String to, String from, String priority, int maxDeliveryTime){
			this.to = to;
			this.from = from;
			this.priority = priority;
			this.maxDeliveryTime = maxDeliveryTime;
		}

		////////////////////////////////
		// 		Getters & Setters 	  //
		////////////////////////////////
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
		public String getPriority() {
			return priority;
		}
		public void setPriority(String priority) {
			this.priority = priority;
		}
		public int getMaxDeliveryTime() {
			return maxDeliveryTime;
		}
		public void setMaxDeliveryTime(int maxDeliveryTime) {
			this.maxDeliveryTime = maxDeliveryTime;
		}

		@Override
		public String toXML() {
			String xml = "<timelimit><to>"+to+"</to>";
			xml.concat("<from>"+from+"</from>");
			xml.concat("<priority>"+priority+"</priority>");
			xml.concat("<maxDeliveryTime>"+maxDeliveryTime+"</maxDeliveryTime>");
			xml.concat("</timelimit>");

			return xml;
		}


}
