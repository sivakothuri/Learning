package parsers.stax;

import java.io.Reader;
import java.io.StringReader;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.events.XMLEvent;

public class StAXReading {

	private static String XML_STRING = "<company>" + 
										"	<staff>" +
										"		<firstname>yong</firstname>"+ 
										"		<lastname>mook kim</lastname>" +
										"		<nickname>mkyong</nickname>" + 
										"		<salary>100000</salary>"+
										"	</staff>" +
										"	<staff>" +
										"		<firstname>low</firstname>"+
										"		<lastname>yin fong</lastname>"+
										"		<nickname>fong fong</nickname>" +
										"		<salary>200000</salary>" +
										"	</staff>" +
										"</company>";

	public static void main(String[] args) throws Exception {
		XMLInputFactory factory = XMLInputFactory.newInstance();

		Reader xmlReader = new StringReader(XML_STRING);
		XMLEventReader eventReader = factory.createXMLEventReader(xmlReader);

		while (eventReader.hasNext()) {
			XMLEvent event = eventReader.nextEvent();

			switch (event.getEventType()) {
			case XMLEvent.START_ELEMENT:
				System.out.print("<"+event.asStartElement().getName()+">");
				break;

			case XMLEvent.END_ELEMENT:
				System.out.println("</"+event.asEndElement().getName()+">");
				break;
			case XMLEvent.CHARACTERS:
				System.out.print(event.asCharacters().toString());
				break;
			default:
				break;
			}
		}

	}
}
