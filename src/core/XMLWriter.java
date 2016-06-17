package core;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;

public class XMLWriter {

	private Document XMLdoc;
	private File XMLfile;
	private Element root;
	
	public XMLWriter(){
		reinitialize();
	}
	
	private void reinitialize(){

		try {
			File f = new File("Database.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(f);
			Element rootElement = doc.getDocumentElement();
			this.XMLdoc = doc;
			this.XMLfile = f;
			this.root = rootElement;
		
		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}
	}
	
	public void appendEvent(Element e){
		try {
			root.appendChild(e);
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(XMLdoc);
			StreamResult result = new StreamResult(XMLfile);
			transformer.transform(source, result);

		} catch (TransformerException e1) {
			e1.printStackTrace();
		}
	}
	
	public Document getDoc(){
		return this.XMLdoc;
	}
}
