import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.List;

import by.gsu.pms.exceptions.NoSuchUserException;
import by.gsu.pms.helpers.DBHelper;
import by.gsu.pms.model.beans.Client;
import by.gsu.pms.model.beans.Order;
import by.gsu.pms.model.beans.Product;

public class Runner {

	public static void main(String[] args) {
		
		Client client = new Client();
		
		try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in));) {
			boolean isUserCorrect = false;
			System.out.println("======== Login ========");
			while(!isUserCorrect) {
				System.out.println("Name: ");
				String name = in.readLine();
				
				System.out.println("Password: ");
				String password = in.readLine();
				try {
					client = DBHelper.getClient(name, password);
					System.out.println("Client: " + client);
					isUserCorrect = true;
				} catch (NoSuchUserException e) {
					System.out.println("Incorrect parameters: " + e.getMessage());
				} 
			}
			
			if (client.isServiceAccount()) {
				System.out.println("======== Current Orders ========\n");
				List<Order> orders = DBHelper.getOrders();
				int orderIndex = 1;
				for (Order order : orders) {
					System.out.println(orderIndex++ + ". " + order);
				}
			} else {
				boolean isExit = false;
				while(!isExit) {
					System.out.println("======== Choose action ========\n");
					System.out.println("1. Show products");
					System.out.println("2. Make order");
					System.out.println("0. Exit");
					
					System.out.println("\nYour choice: ");
					
					int choice = Integer.parseInt(in.readLine().trim());
					
					switch (choice) {
					case 1:
						List<Product> products = DBHelper.getProducts();
						int productIndex = 1;
						for (Product product : products) {
							
							
							System.out.println(productIndex++ + ". " + product);
						}
						break;
					case 2:
						List<Product> productsToOrder = DBHelper.getProducts();
						System.out.println("Choose product");
						int productToOrderIndex = 1;
						for (Product product : productsToOrder) {
			
							System.out.println(productToOrderIndex++ + ". " + product);
						}
						System.out.println();
						int productChoise = Integer.parseInt(in.readLine().trim());
						
						boolean isSuccessfullOrder = DBHelper.makeOrder(client, productsToOrder.get(productChoise));
						System.out.println(isSuccessfullOrder ? "Success" : "Failure" );
						break;
					case 0:
						isExit = true;
						break;
					default:
						break;
					}
				}
			}
			
		} catch (IOException e) {
			System.err.println("Error while reading from console: " + e);
		} catch (SQLException e) {
			System.err.println("SQL Error: " + e);
		}
	}
}
