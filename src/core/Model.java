package core;

import java.util.ArrayList;

import events.CostEvent;
import events.DiscontinueEvent;
import events.Event;
import events.MailEvent;
import routes.Route;

public class Model {
	private ArrayList<Event> events;
	private ArrayList<Route> routes;
	private BusinessFigures businessFigures;
	private double revenue;
	private double expenditure;

	public Model(){
		events = new ArrayList<Event>();
		routes = new ArrayList<Route>();
		businessFigures = new BusinessFigures(this);
		revenue = 0;
		expenditure = 0;
	}

	public void addEvent(Event e){
		events.add(e);
		//add route to list of routes if it doesn't already exist
		if(e instanceof CostEvent){
			CostEvent costEvent = (CostEvent)e;
			Route r = costEvent.newRoute(routes);
			if(r != null){
				System.out.println("There is a new route: " + r.getOrigin() + " to " +
					 r.getDestination() + " via " + r.getType());
				routes.add(r);
			}
		}
		//remove corresponding Route object
		if(e instanceof DiscontinueEvent){
			DiscontinueEvent disEvent = (DiscontinueEvent)e;
			Route tmpRoute = new Route(disEvent.getFrom(),
					disEvent.getTo(), disEvent.getType(), disEvent.getCompany());
			routes.remove(tmpRoute);
		}

		if(e instanceof MailEvent){
			MailEvent mailEvent = (MailEvent)e;
			expenditure += mailEvent.calculateCost(events, mailEvent.findRoute(routes));
			revenue += mailEvent.calculatePrice(events, mailEvent.findRoute(routes)) - expenditure;
		}
	}

	public ArrayList<Event> getEvents(){
		return events;
	}

	public ArrayList<Route> getRoutes(){
		return routes;
	}

}
