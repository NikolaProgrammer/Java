package edu.gsu.pms.lab;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class CurrencyParser extends DefaultHandler {
	private Currency currency = null;
	private boolean isCurrency = false;
	private String tempElement = null;
	
	private List<Currency> currencies = new ArrayList<>();

	public List<Currency> getCurrencies() {
		return currencies;
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		tempElement = localName;
		
		final int ID_INDEX = 0;
		
		if (tempElement.equals(Constants.CURRENCY)) {
			isCurrency = true;
			currency = new Currency();
			int id = Integer.parseInt(attributes.getValue(ID_INDEX));
			currency.setId(id);
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if (isCurrency) {
			isCurrency = false;
			currencies.add(currency);
		}
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		String string = new String(ch, start, length).replace("\n", "").trim();
		
		if (tempElement.equals(Constants.NAME) && !string.isEmpty()) {
			currency.setName(string);
		}
		
		if (tempElement.equals(Constants.CHAR_CODE) && !string.isEmpty()) {
			currency.setCharCode(string);
		}
		
		if (tempElement.equals(Constants.RATE) && !string.isEmpty()) {
			double rate =  Double.parseDouble(string);
			currency.setRate(rate);
		}
	}
		
}
