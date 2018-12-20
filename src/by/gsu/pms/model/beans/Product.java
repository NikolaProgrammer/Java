package by.gsu.pms.model.beans;

public class Product {
	private int id;
	private String name;
	private Byn price;
	
	public Product(int id, String name, Byn price) {
		super();
		
		this.id = id;
		this.name = name;
		this.price = price;
	}
	
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Byn getPrice() {
		return price;
	}
	public void setPrice(Byn price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return name + " - " + price + " BYN";
	}
	
}
