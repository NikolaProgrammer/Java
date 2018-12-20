package by.gsu.pms.helpers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import by.gsu.pms.constants.Constants;
import by.gsu.pms.constants.ConstantsSQL;
import by.gsu.pms.exceptions.ConnectionException;
import by.gsu.pms.exceptions.NoSuchUserException;
import by.gsu.pms.model.beans.Byn;
import by.gsu.pms.model.beans.Client;
import by.gsu.pms.model.beans.Order;
import by.gsu.pms.model.beans.Product;

public class DBHelper {
	
	public static List<Order> getOrders() throws SQLException {
		final int ID_INDEX = 1;
		final int CLIENT_INDEX = 2;
		final int ADDRESS_INDEX = 3;
		final int PHONE_INDEX = 4;
		final int PRODUCT_INDEX = 5;
		final int PRICE_INDEX = 6;
		
		List<Order> orders = new ArrayList<>();
		
		try(Connection con = DBConnection.getConnection();
				Statement statement = con.createStatement();
				ResultSet rs = statement.executeQuery(ConstantsSQL.GET_ORDERS)){
			
			while(rs.next()) {
				String clientName = rs.getString(CLIENT_INDEX);
				String phoneNumber = rs.getString(PHONE_INDEX);
				String address = rs.getString(ADDRESS_INDEX);
				Client client = new Client(clientName, phoneNumber, address);
				
				String productName = rs.getString(PRODUCT_INDEX);
				Byn price = new Byn(rs.getInt(PRICE_INDEX));
				Product product = new Product(0, productName, price);
				
				int id = rs.getInt(ID_INDEX);
				Order order = new Order(id, client, product);
				orders.add(order);
			}
			
			return orders;
		} catch (SQLException | ConnectionException e) {
			throw new SQLException(e);
		}
	}
	
	public static boolean makeOrder(Client client, Product product) {
		final int CLIENT_INDEX = 1;
		final int PRODUCT_INDEX = 2;
		
		try(Connection con = DBConnection.getConnection();
				PreparedStatement statement = con.prepareStatement(ConstantsSQL.MAKE_ORDER)) {
			
			statement.setInt(CLIENT_INDEX, client.getId());
			statement.setInt(PRODUCT_INDEX, product.getId());
			
			statement.executeUpdate();
			
			return true;
		} catch (SQLException | ConnectionException e) {
			System.err.println(e);
			return false;
		}
		
	}
	
	public static Client getClient(String name, String password) throws NoSuchUserException, SQLException {
		final int NAME_SELECT_INDEX = 1;

		final int ID_INDEX = 1;
		final int NAME_INDEX = 2;
		final int PASSWORD_INDEX = 3;
		final int ADDRESS_INDEX = 4;
		final int EMAIL_INDEX = 5;
		final int PHONE_NUMBER_INDEX = 6;
		final int IS_SERVICE_ACC_INDEX = 7;
		
		try(Connection con = DBConnection.getConnection();
				PreparedStatement statement = con.prepareStatement(ConstantsSQL.GET_CLIENT)){
			statement.setString(NAME_SELECT_INDEX, name);
			
			try(ResultSet rs = statement.executeQuery()) {
				if (rs.next()) {
					int id = rs.getInt(ID_INDEX);
					String resultName = rs.getString(NAME_INDEX);
					String resultPassword = rs.getString(PASSWORD_INDEX);
					if(!resultPassword.equals(password)) {
						throw new NoSuchUserException(Constants.INVALID_PASSORD_EXCEPTION);
					}
					String address = rs.getString(ADDRESS_INDEX);
					String email = rs.getString(EMAIL_INDEX);
					String phoneNumber = rs.getString(PHONE_NUMBER_INDEX);
					int isServiceAccount = rs.getInt(IS_SERVICE_ACC_INDEX);
					
					Client client = new Client(id, resultName, resultPassword, phoneNumber, address, email, isServiceAccount == 0 ? false : true);
					
					return client;
				} else {
					throw new NoSuchUserException(Constants.NO_SUCH_USER_EXCEPTION);
				}
			}
			
		} catch (SQLException | ConnectionException e) {
			throw new SQLException(e);
		}
	}
	
	public static List<Product> getProducts() throws SQLException {
		final int ID_INDEX = 1;
		final int NAME_INDEX = 2;
		final int PRICE_INDEX = 3;
		
		List<Product> products = new ArrayList<Product>();
		
		try(Connection con = DBConnection.getConnection();
				Statement statement = con.createStatement();
				ResultSet rs = statement.executeQuery(ConstantsSQL.GET_PRODUCTS)) {
			while(rs.next()) {
				int id = rs.getInt(ID_INDEX);
				String name = rs.getString(NAME_INDEX);
				Byn price = new Byn(rs.getInt(PRICE_INDEX));
				
				Product product = new Product(id, name, price);
				products.add(product);
			}
			
			return products;
		} catch (SQLException | ConnectionException e) {
			throw new SQLException(e);
		}
	}
}

