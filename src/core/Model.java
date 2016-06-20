package core;

import java.util.ArrayList;

import events.CostEvent;
import events.DiscontinueEvent;
import events.Event;
import routes.Route;

public class Model {
	private ArrayList<Event> events;
	private ArrayList<Route> routes;

	public Model(){
		events = new ArrayList<Event>();
		routes = new ArrayList<Route>();
	}

	public void addEvent(Event e){
		events.add(e);
		//check for new routes
		if(e instanceof CostEvent){
			e = (CostEvent)e;
			Route r = ((CostEvent) e).newRoute(routes);
			if(r != null){
				System.out.println("There is a new route: " + r.getOrigin() + " to " +
					 r.getDestination() + " via " + r.getType());
				routes.add(r);
			}
		}
		if(e instanceof DiscontinueEvent){
			e = (DiscontinueEvent)e;
			Route tmpRoute = new Route(((DiscontinueEvent) e).getFrom(),
					((DiscontinueEvent) e).getTo(), ((DiscontinueEvent) e).getType(), ((DiscontinueEvent) e).getCompany());
			routes.remove(tmpRoute);
		}
	}
	
	public ArrayList<Event> getEvents(){
		return events;
	}

	public ArrayList<Route> getRoutes(){
		return routes;
	}

}
