import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import edu.gsu.pms.lab.Constants;
import edu.gsu.pms.lab.Currency;

public class Runner2 {

	public static void main(String[] args) {
		
		List<Currency> currencies = new ArrayList<Currency>();
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(Constants.FILENAME);
			
			doc.getDocumentElement().normalize();
			
			NodeList list = doc.getElementsByTagName(Constants.CURRENCY);
			
			for (int i = 0; i < list.getLength(); i++) {
				Node node = list.item(i);
				
				if (node.getNodeType() == Node.ELEMENT_NODE) {

					Element element = (Element) node;
					
					int id = Integer.parseInt(element.getAttribute(Constants.ID));
					String name = element.getElementsByTagName(Constants.NAME).item(0).getTextContent();
					String charCode = element.getElementsByTagName(Constants.CHAR_CODE).item(0).getTextContent();
					double rate = Double.parseDouble(element.getElementsByTagName(Constants.RATE).item(0).getTextContent());
					
					Currency currency = new Currency(id, charCode, name, rate);
					currencies.add(currency);
				}
			}
			
			for (Currency currency : currencies) {
				System.out.println(currency);
			}
			
		} catch (ParserConfigurationException | SAXException | IOException e) {
			System.err.println(e);
		}
		
	}

}
