package edu.gsu.pms.lab;

public class Currency {
	private int id;
	private String charCode;
	private String name;
	private double rate;

	public Currency() {
		super();
	}

	public Currency(int id, String charCode, String name, double rate) {
		super();
		this.id = id;
		this.charCode = charCode;
		this.name = name;
		this.rate = rate;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCharCode() {
		return charCode;
	}
	public void setCharCode(String charCode) {
		this.charCode = charCode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getRate() {
		return rate;
	}
	public void setRate(double rate) {
		this.rate = rate;
	}
	
	@Override
	public String toString() {
		return "[id = " + id + ", charCode = " + charCode + ", name = " + name + ", rate = " + rate + "]";
	}
	
}
