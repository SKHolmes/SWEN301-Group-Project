package events;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public interface Event {

	/** Returns an XML representation of the given event
	 *
	 * @return String
	 */

	public Element toXML(Document doc);


}
