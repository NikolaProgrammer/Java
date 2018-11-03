import java.io.IOException;
import java.util.List;

import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import edu.gsu.pms.lab.Constants;
import edu.gsu.pms.lab.Currency;
import edu.gsu.pms.lab.CurrencyParser;


public class Runner {

	public static void main(String[] args) {
		try {
			XMLReader reader = XMLReaderFactory.createXMLReader();
			CurrencyParser parser = new CurrencyParser();
			reader.setContentHandler(parser);
			reader.parse(Constants.FILENAME);

			List<Currency> currencies = parser.getCurrencies();
			
			for (Currency currency : currencies) {
				System.out.println(currency);
			}
			
		} catch (SAXException e) {
			System.err.println("ошибка SAX парсера: " + e);
		} catch (IOException e) {
			System.err.println("ошибка I/O потока: " + e);
		}

	}

}
