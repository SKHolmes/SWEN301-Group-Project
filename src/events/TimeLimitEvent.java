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
		 * @return the maxDeliveryTime
		 */
		public int getMaxDeliveryTime() {
			return maxDeliveryTime;
		}

		/**
		 * @param maxDeliveryTime the maxDeliveryTime to set
		 */
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
		
		@Override
		public String toString() {
			return "TimelimitEvent" 
					+ "/To: " + to
					+ "/From: " + from
					+ "/Priority: " + priority
					+ "/Max DeliveryTime: " + maxDeliveryTime;
		}


}
