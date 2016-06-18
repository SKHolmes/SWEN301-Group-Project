package core;

import java.util.ArrayList;
import java.util.List;

import routes.Route;

public class BusinessFigures {

	private List<events.Event> events;

	//TODO: Should be able to view business figures during a specific time frame
	public BusinessFigures(List<events.Event>  events){
		this.setEvents(events);
	}

	public void setEvents(List<events.Event>  e){
		this.events = e;
	}

	public int calcAmountOfMail(){
		int n = 0;
		return n;
	}

	public double calcAverageDeliveryTime(){
		double t = 0;
		return t;
	}

	public List<Route> calcCriticalRoutes(){
		List<Route> r = new ArrayList<Route>();
		return r;
	}

	public double calcExpenditure(){
		double ex = 0;
		return ex;
	}

	public int calcNumEvents(){
		return events.size();
	}

	public double calcRevenue(){
		double rev = 0;
		return rev;
	}


}
