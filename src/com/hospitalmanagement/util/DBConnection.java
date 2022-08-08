package com.hospitalmanagement.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DBConnection {
	private static Connection connection = null;
	
	public static Connection getConnection() throws SQLException, ClassNotFoundException
	{
		if (connection == null) {			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			ResourceBundle resourceBundle = ResourceBundle.getBundle("oracle");
			String url = resourceBundle.getString("db.url");
			String username = resourceBundle.getString("db.username");
			String password = resourceBundle.getString("db.password");
			System.out.println(url);
			System.out.println(username);
			connection = DriverManager.getConnection(url, username, password);
		}
		return connection;
	}
}
