package by.gsu.pms.model.beans;

public class Client {
	
	private int id;
	private String name;
	private String password;
	private String address;
	private String phoneNumber;
	private String email;
	private boolean isServiceAccount;
	
	
	public Client() {
		super();
	}

	public Client(int id, String name, String password, String phoneNumber, String address, String email, boolean isServiceAccount) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.setPhoneNumber(phoneNumber);
		this.address = address;
		this.email = email;
		this.isServiceAccount = isServiceAccount;
	}
	
	public Client(int id, String name, String password, String phoneNumber, String address, String email) {
		this(id, name, password, phoneNumber, address, email, false);
	}
	
	public Client(String name, String phoneNumber, String address) {
		this(0, name, null, phoneNumber, address, null);
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isServiceAccount() {
		return isServiceAccount;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	@Override
	public String toString() {
		return name + " ; " + address + " ; " + phoneNumber;
	}
}
