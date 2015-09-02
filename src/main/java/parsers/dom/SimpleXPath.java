package parsers.dom;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

public class SimpleXPath {

	private DocumentBuilder builder;
	private final String EMP_NS = "http://employee";
	private final String XML_STRING = "<Employee xmlns=\"" + EMP_NS + "\"><Name>XYZ</Name><Dept><Name xmlns=\"test.com\">IT</Name></Dept><Id>101</Id></Employee>";

	public static void main(String[] args) throws Exception {
		new SimpleXPath().process();
	}

	void process() throws Exception {
		Element employee = getNode();
	
		XPath xPath =  XPathFactory.newInstance().newXPath();
		//read an xml node using xpath
		Node node = (Node) xPath.compile(".//Name").evaluate(employee, XPathConstants.NODE);
		System.out.println(node);
		System.out.println(node.getTextContent());

	}

	Element getNode() throws ParserConfigurationException, SAXException, IOException {
		InputStream stream = new ByteArrayInputStream(XML_STRING.getBytes(StandardCharsets.UTF_8));
		return getDocumentBuilder().parse(stream).getDocumentElement();
	}

	DocumentBuilder getDocumentBuilder() throws ParserConfigurationException {
		if (builder == null) {
			builder =  DocumentBuilderFactory.newInstance().newDocumentBuilder();
		}
		return builder;
	}
}
