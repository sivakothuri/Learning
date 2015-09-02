package parsers.dom;

import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Node;
import org.w3c.dom.bootstrap.DOMImplementationRegistry;
import org.w3c.dom.ls.DOMImplementationLS;
import org.w3c.dom.ls.LSSerializer;
import org.xml.sax.InputSource;

public class ParseXML {
	public static void main(String[] args) throws Exception {
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Node root = dBuilder.parse(new InputSource(new StringReader("<TEMP>temp</TEMP>"))).getDocumentElement();
		System.out.println(toString(root.getFirstChild()));
	}
	
	static String toString(Node node) throws Exception
	{
		DOMImplementationRegistry registry =  DOMImplementationRegistry.newInstance();
		DOMImplementationLS domImplementationls = (DOMImplementationLS) registry.getDOMImplementation("LS");
		LSSerializer lsSerializer = domImplementationls.createLSSerializer();
		return lsSerializer.writeToString(node);
	}

}
