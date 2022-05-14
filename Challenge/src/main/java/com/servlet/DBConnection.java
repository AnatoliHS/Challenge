package com.servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	// Database Schema and table creation
	
	public static Connection getConnectionToDatabase() {
		
		Connection connection = null;
		
		System.out.println("getConnectionToDatabase");
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver Registered");
			
			connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/CarApp?useUnicode=true&useJDBCCompliantTimeZoneShift=true&useLegactDatetimeCode=false&ServerTimeZone=UTC",
					"root", "");
			
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}if(connection != null) {
			System.out.println("Connection made");
		}
		return connection;
		
	}

}
