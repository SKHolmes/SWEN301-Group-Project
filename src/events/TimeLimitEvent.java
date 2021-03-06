package events;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

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
		public Element toXML(Document d) {
			Document doc = d;
			Element root = doc.createElement("timelimit");
			Element child = doc.createElement("to");
			child.appendChild(doc.createTextNode(this.to));
			root.appendChild(child);
			child = doc.createElement("priority");
			child.appendChild(doc.createTextNode(this.priority));
			root.appendChild(child);
			child = doc.createElement("maxDeliveryTime");
			child.appendChild(doc.createTextNode(Integer.toString(this.maxDeliveryTime)));
			root.appendChild(child);
			
			return root;
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
