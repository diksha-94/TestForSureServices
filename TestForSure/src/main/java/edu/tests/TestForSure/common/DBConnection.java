package edu.tests.TestForSure.common;

import java.sql.*;
public class DBConnection {
	private static final String DATABASE_DRIVER = "com.mysql.jdbc.Driver";
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3307/testforsure";
	private static final String DATABASE_USERNAME = "root";
	private static final String DATABASE_PASSWORD = "root";
	
	public static Connection getDBConnection() {

		try {
			try {
				Class.forName(DATABASE_DRIVER);
			} catch (ClassNotFoundException e) {
				return null;
			}
			Connection connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME,
					DATABASE_PASSWORD);
			return connection;
		} catch (SQLException ex) {
			ex.printStackTrace();
			return null;
		}

	}
}
