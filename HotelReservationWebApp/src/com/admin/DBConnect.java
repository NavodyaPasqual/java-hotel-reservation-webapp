package com.admin;

import java.sql.Connection;
import java.sql.DriverManager;

//This class will connect to the database
public class DBConnect {
	
	private static String url = "jdbc:mysql://localhost:3306/online_hotel_reservation";
	private static String userName = "root";
	private static String password = "nTp2525g";
	private static Connection con;

	public static Connection getConnection() {
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
			con = DriverManager.getConnection(url, userName, password);
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return con;
	}
}
