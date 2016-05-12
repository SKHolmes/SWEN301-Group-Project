package map;

/** Represents an edge as defined by cost tag in the business log
 *
 * @author Daniel Tait
 *
 */

public class Path {

	private boolean active;

	// May want to think about including unique ID's as identifiers moving forward.
	private String company;
	private String to;
	private String from;
	private int weightCost;
	private int volumeCost;
	private int maxWeight;
	private int maxVolume;
	private int duration;
	private int frequency;
	private Day day;

	/** Creates path object using values from tags within cost tag as parameters and stores these values.
	 * On path object creation active is the default and must be set to false to represent a Path which has been discontinued
	 *
	 */

	public Path(String c, String t, String f, int wc, int vc, int mw, int mv, int d, int fr, Day day){
		this.company = c;
		this.to = t;
		this.from = f;
		this.weightCost = wc;
		this.volumeCost = vc;
		this.maxWeight = mw;
		this.maxVolume = mv;
		this.duration = d;
		this.frequency = fr;
		this.day = day;

		this. active = true;
	}

	public void setActive(boolean b){
		this.active = b;
	}

	public String getTo(){
		return this.to;
	}

	public String getFrom(){
		return this.from;
	}
}
