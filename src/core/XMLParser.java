package core;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import events.CostEvent;
import events.DiscontinueEvent;
import events.Event;
import events.MailEvent;
import events.PriceEvent;
import events.TimeLimitEvent;
import routes.Route;

public class XMLParser {

	private String header;
	private Model model;

	public XMLParser(){
		model = new Model();

		try {
			BufferedReader reader = new BufferedReader(new FileReader("Database.xml"));
			String event;
			header = parseHeader(reader);
			while((event = reader.readLine()) != null)
		    {
				Event e = parseNextEvent(reader, event);
				if(e!=null){
					model.addEvent(e);
				}else{
					//System.out.println("event is null");
				}
		    }
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		model.printAllStats();
	}

	private Event parseNextEvent(BufferedReader reader, String event) throws IOException{
		String eventType = readEventType(event);
		switch (eventType){

		case "cost":
			return parseCostEvent(reader);

		case "mail":
			return parseMailEvent(reader);

		case "price":
			return parsePriceEvent(reader);

		case "timelimit":
			return parseTimeLimitEvent(reader);

		case "discontinue":
			return parseDiscontinueEvent(reader);

		case "/simulation":
			//System.out.println("End of file reached closing up.");
			break;
		default:
			System.out.println("New event - " + eventType);
			break;
		}
		return null;
	}

	private Event parseCostEvent(BufferedReader reader) throws IOException {
		String Company = stripXML(reader.readLine());
		String To = stripXML(reader.readLine());
		String From = stripXML(reader.readLine());
		String Type = stripXML(reader.readLine());
		int WeightCost = Integer.parseInt(stripXML(reader.readLine()));
		int VolumeCost = Integer.parseInt(stripXML(reader.readLine()));
		int MaxWeight = Integer.parseInt(stripXML(reader.readLine()));
		int MaxVolume = Integer.parseInt(stripXML(reader.readLine()));
		int Duration = Integer.parseInt(stripXML(reader.readLine()));
		int Frequency = Integer.parseInt(stripXML(reader.readLine()));
		String Day = stripXML(reader.readLine());

		if(!reader.readLine().equals("</cost>")){
			System.out.println("Error: parseCostEvent did not end with a </cost>");
		}

		return new CostEvent(Company, To, From, Type, WeightCost, VolumeCost,
				MaxWeight, MaxVolume, Duration, Frequency, Day);
	}

	private Event parseMailEvent(BufferedReader reader) throws IOException {
		String Day = stripXML(reader.readLine());
		String To = stripXML(reader.readLine());
		String From = stripXML(reader.readLine());
		int Weight = Integer.parseInt(stripXML(reader.readLine()));
		int Volume = Integer.parseInt(stripXML(reader.readLine()));
		String Priority = stripXML(reader.readLine());

		if(!reader.readLine().equals("</mail>")){
			System.out.println("Error: parseMailEvent did not end with a </mail>");
		}

		return new MailEvent(Day, To, From, Weight, Volume, Priority);
	}

	private Event parsePriceEvent(BufferedReader reader) throws IOException {
		String To = stripXML(reader.readLine());
		String From = stripXML(reader.readLine());
		String Priority = stripXML(reader.readLine());
		int WeightCost = Integer.parseInt(stripXML(reader.readLine()));
		int VolumeCost = Integer.parseInt(stripXML(reader.readLine()));

		if(!reader.readLine().equals("</price>")){
			System.out.println("Error: parsePriceEvent did not end with a </price>");
		}

		return new PriceEvent(To, From, Priority, WeightCost, VolumeCost);
	}

	private Event parseTimeLimitEvent(BufferedReader reader) throws IOException {
		String To = stripXML(reader.readLine());
		String From = stripXML(reader.readLine());
		String Priority = stripXML(reader.readLine());
		int MaxDeliveryTime = Integer.parseInt(stripXML(reader.readLine()));

		if(!reader.readLine().equals("</timelimit>")){
			System.out.println("Error: parseTimeLimitEvent did not end with a </timelimit>");
		}

		return new TimeLimitEvent(To, From, Priority, MaxDeliveryTime);
	}

	private Event parseDiscontinueEvent(BufferedReader reader) throws IOException {
		String Company = stripXML(reader.readLine());
		String To = stripXML(reader.readLine());
		String From = stripXML(reader.readLine());
		String Type = stripXML(reader.readLine());

		if(!reader.readLine().equals("</discontinue>")){
			System.out.println("Error: parseDiscontinueEvent did not end with a </discontinue>");
		}

		return new DiscontinueEvent(Company, To, From, Type);
	}

	private String readEventType(String event) throws IOException {
		StringBuilder sb = new StringBuilder(event);
		sb.deleteCharAt(0);
		sb.deleteCharAt(sb.length()-1);
		return sb.toString();
	}

	private String parseHeader(BufferedReader reader) throws IOException {
		return reader.readLine();
	}

	private String stripXML(String Line) {
		StringBuilder sb = new StringBuilder(Line);
		while(sb.charAt(0)!='>'){
			sb.deleteCharAt(0);
		}
		sb.deleteCharAt(0);
		while(sb.charAt(sb.length()-1)!='<'){
			sb.deleteCharAt(sb.length()-1);
		}
		sb.deleteCharAt(sb.length()-1);
		return sb.toString();
	}

	public String getHeader(){
		return header;
	}

	public void setHeader(String header){
		this.header = header;
	}

	public void addEvent(Event e){
		model.addEvent(e);
		//TODO Append to the Databse.xml file the information for the new event.
	}

	public ArrayList<Event> getEvents(){
		return model.getEvents();
	}
	
	public Model getModel(){
		return model;
	}
}
