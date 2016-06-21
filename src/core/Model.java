package core;

import java.util.ArrayList;
import java.util.List;

import events.CostEvent;
import events.DiscontinueEvent;
import events.Event;
import events.MailEvent;
import routes.Route;

public class Model {
	private ArrayList<Event> events;
	private ArrayList<Route> routes;
	//private BusinessFigures businessFigures;
	private double revenue;
	private double expenditure;

	public Model(){
		events = new ArrayList<Event>();
		routes = new ArrayList<Route>();
		//businessFigures = new BusinessFigures(events, routes);
		revenue = 0;
		expenditure = 0;
	}

	public Model(List<Event> eventsToAdd){
		events = new ArrayList<Event>();
		routes = new ArrayList<Route>();
		revenue = 0;
		expenditure = 0;

		for(Event e : eventsToAdd){
			addEvent(e);
		}
	}

	public void printAllStats(){
		System.out.println();
		System.out.println("**********************");
		System.out.println("*  Business Figures  *");
		System.out.println("**********************");
		System.out.println();
		System.out.println("Total revenue: " + this.getRevenue());
		System.out.println("Total expenditure: " + this.getExpenditure());
		System.out.println("Total number of events: " + this.getNumberOfEvents());
		System.out.println();

		System.out.println("Amount of Mail: \n" + this.calcAmountOfMail() + "\n");
		System.out.println("Average Delivery Time: \n" + this.calcAverageDeliveryTime() + "\n");
		System.out.println("Critical Routes: ");
		System.out.println(this.criticalRoutesToString(this.calcCriticalRoutes()));
	}

	public void addEvent(Event e){
		events.add(e);
		//add route to list of routes if it doesn't already exist
		if(e instanceof CostEvent){
			CostEvent costEvent = (CostEvent)e;
			Route r = costEvent.newRoute(routes);
			if(r != null){
				System.out.println("There is a new route: " + r.toString());
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
			mailEvent.updateRouteStats(events, mailEvent.findRoute(routes));
			if(mailEvent.calculateCost(events, mailEvent.findRoute(routes)) != 0){
				expenditure += mailEvent.calculateCost(events, mailEvent.findRoute(routes));
				revenue += mailEvent.calculatePrice(events, mailEvent.findRoute(routes)) - expenditure;
			}
		}
	}

	public String calcAmountOfMail(){
		String s = "";
		for(Route r : routes){
			s += " * Route: " + r.toString()
				+ "/    Volume: " + r.getTotalVolume()
				+ " Weight: " + r.getTotalWeight()
				+ " # of Items: " + r.getTotalMailCount() + "/";
		}
		return s;
	}

	public String calcAverageDeliveryTime(){
		String s = "";
		for(Route r : routes){
			if(r.getTotalMailCount() > 0){
				s += " * Route: " + r.toString()
					+ "/    Average Delivery Time: " + r.getAverageDuration() + "/";
			}
		}
		return s;
	}

	public List<Route> calcCriticalRoutes(){
		List<Route> criticalRoutes = new ArrayList<Route>();
		for(Route r : routes){
			if(r.getAverageCost() > r.getAveragePrice()){
				criticalRoutes.add(r);
			}
		}
		return criticalRoutes;
	}

	public String criticalRoutesToString(List<Route> routes){
		String s = "";
		for(Route r : routes){
			s+= " * " + r.toString() + "   Loss: $" + (r.getAveragePrice() - r.getAverageCost()) * -1 + "/";
		}

		return s;
	}

	public double getExpenditure(){
		return this.expenditure;
	}

	public double getRevenue(){
		return this.revenue;
	}

	public int getNumberOfEvents(){
		return events.size();
	}

	public ArrayList<Event> getEvents(){
		return events;
	}

	public ArrayList<Route> getRoutes(){
		return routes;
	}

}
