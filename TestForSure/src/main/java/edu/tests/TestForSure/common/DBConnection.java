package edu.tests.TestForSure.common;

import java.sql.*;
public class DBConnection {
	private static final String DATABASE_DRIVER = "com.mysql.jdbc.Driver";
	static String DATABASE_URL = "jdbc:mysql://"+System.getenv("DATABASE_HOST")+":"+System.getenv("DATABASE_PORT")+"/"+System.getenv("DATABASE_NAME");
	static String DATABASE_USERNAME = System.getenv("DATABASE_USERNAME");//"root";;
	static String DATABASE_PASSWORD = System.getenv("DATABASE_PASSWORD");//"root";;
	
	public static Connection getDBConnection() {

		try {
			try {
				Class.forName(DATABASE_DRIVER);
				//DATABASE_URL += System.getenv("DATABASE_HOST")+":"+System.getenv("DATABASE_PORT")+"/"+System.getenv("DATABASE_NAME");
				//DATABASE_USERNAME = System.getenv("DATABASE_USERNAME");//"root";
				//DATABASE_PASSWORD = System.getenv("DATABASE_PASSWORD");//"root";
			} catch (ClassNotFoundException e) {
				return null;
			}
			System.out.println(DATABASE_URL+"-----"+DATABASE_USERNAME+"-----"+DATABASE_PASSWORD);
			Connection connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME,
					DATABASE_PASSWORD);
			return connection;
		} catch (SQLException ex) {
			ex.printStackTrace();
			return null;
		}

	}
}
