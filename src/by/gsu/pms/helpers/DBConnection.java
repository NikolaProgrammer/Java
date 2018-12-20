package by.gsu.pms.helpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import by.gsu.pms.constants.Constants;
import by.gsu.pms.exceptions.ConnectionException;

public class DBConnection {

	public static Connection getConnection() throws ConnectionException {
		try {
			Connection con = DriverManager.getConnection(Constants.DB_URL, Constants.DB_USER, Constants.DB_PASSWORD);
			return con;
		} catch (SQLException e) {
			throw new ConnectionException(e);
		}
	}
}
