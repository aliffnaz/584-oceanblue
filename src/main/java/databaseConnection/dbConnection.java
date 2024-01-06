package databaseConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbConnection {

	static Connection con;
	private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
	private static final String DB_CONNECTION = "jdbc:mysql://localhost:3306/obchalet";
	private static final String DB_USER = "shawldb";
	private static final String DB_PASSWORD = "system";

	public static Connection getConnection() {

		try {
			// 1. load the driver
			Class.forName(DB_DRIVER);

			try {
				// 2. create connection
				con = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
				System.out.println("Connected");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return con;

	}
}
