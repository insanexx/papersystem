package com.sus.papersystem.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionManager {
	private final static String url = "jdbc:mysql://localhost:3306/papersystem";
	private final static String name = "root";
	private final static String pwd = "root";
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.exit(0);
		}
	}
	
	public static Connection getJDBCConnection() {
		try {
			return DriverManager.getConnection(url, name, pwd);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
