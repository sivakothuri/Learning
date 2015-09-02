package parsers.sax;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAXReading {

	private static String XML_STRING = "<company>" + "	<staff>" + "		<firstname>yong</firstname>"
			+ "		<lastname>mook kim</lastname>" + "		<nickname>mkyong</nickname>" + "		<salary>100000</salary>"
			+ "	</staff>" + "	<staff>" + "		<firstname>low</firstname>" + "		<lastname>yin fong</lastname>"
			+ "		<nickname>fong fong</nickname>" + "		<salary>200000</salary>" + "	</staff>" + "</company>";

	private static DefaultHandler handler = new DefaultHandler() {

		boolean bfname = false;
		boolean blname = false;
		boolean bnname = false;
		boolean bsalary = false;

		public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

			System.out.println("Start Element :" + qName);

			if (qName.equalsIgnoreCase("FIRSTNAME")) {
				bfname = true;
			}

			if (qName.equalsIgnoreCase("LASTNAME")) {
				blname = true;
			}

			if (qName.equalsIgnoreCase("NICKNAME")) {
				bnname = true;
			}

			if (qName.equalsIgnoreCase("SALARY")) {
				bsalary = true;
			}

		}

		public void endElement(String uri, String localName, String qName) throws SAXException {

			System.out.println("End Element :" + qName);

		}

		public void characters(char ch[], int start, int length) throws SAXException {

			if (bfname) {
				System.out.println("First Name : " + new String(ch, start, length));
				bfname = false;
			}

			if (blname) {
				System.out.println("Last Name : " + new String(ch, start, length));
				blname = false;
			}

			if (bnname) {
				System.out.println("Nick Name : " + new String(ch, start, length));
				bnname = false;
			}

			if (bsalary) {
				System.out.println("Salary : " + new String(ch, start, length));
				bsalary = false;
			}

		}

	};

	public static void main(String[] args) throws Exception {

		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser saxParser = factory.newSAXParser();

		InputStream xmlStream = new ByteArrayInputStream(XML_STRING.getBytes());
		saxParser.parse(xmlStream, handler);
	}
}
