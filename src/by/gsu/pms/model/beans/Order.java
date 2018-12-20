package by.gsu.pms.model.beans;

public class Order {
	private int id;
	private Client client;
	private Product product;
	
	public Order(int id, Client client, Product product) {
		super();
		this.id = id;
		this.client = client;
		this.product = product;
	}
	
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return  "Client: " + client + " ; Product: " + product;
	}
	
	
}
