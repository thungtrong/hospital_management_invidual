package com.hospitalmanagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DBConnection {
    private static Connection connection;
    
    static {
    	try {
    		Class.forName("oracle.jdbc.driver.OracleDrive");

    		ResourceBundle resourceBundle = ResourceBundle.getBundle("oracle"); 
    		String url = resourceBundle.getString("db.url");
    		String username = resourceBundle.getString("db.username");
    		String password = resourceBundle.getString("db.password");
			
    		connection = DriverManager.getConnection(url, username, password); 
    	} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public static Connection getConnection()
    {
    	return connection;
    }
}
