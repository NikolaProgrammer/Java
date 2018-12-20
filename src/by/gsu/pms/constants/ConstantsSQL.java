package by.gsu.pms.constants;

public class ConstantsSQL {
	public static final String GET_CLIENT = "SELECT * FROM clients WHERE name LIKE ?";
	
	public static final String GET_PRODUCTS = "SELECT * FROM products";
	
	public static final String GET_ORDERS = "SELECT o.idOrder, c.name as 'client', c.address, c.phoneNumber, p.name as 'product', p.price \r\n" + 
											"FROM orders o\r\n" + 
											"JOIN clients c ON o.idClient = c.idClient\r\n" + 
											"JOIN products p ON o.idProduct = p.idProduct";
	public static final String MAKE_ORDER = "INSERT INTO orders (`idClient`, `idProduct`) VALUES (?, ?)";
}
