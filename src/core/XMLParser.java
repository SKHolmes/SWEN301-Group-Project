package core;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import events.Event;

public class XMLParser {

	private String header;
	private ArrayList<Event> events;

	public XMLParser(){
		try {
			BufferedReader reader = new BufferedReader(new FileReader("Database.xml"));
			String event;
			header = parseHeader(reader);
			System.out.println(header);
			while((event = reader.readLine()) != "</simulation>")
		    {
				String next = parseNextEvent();
		    }

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private String parseNextEvent() {
		// TODO Auto-generated method stub
		return null;
	}

	private String parseHeader(BufferedReader reader) throws IOException {
		return reader.readLine();
	}


}
