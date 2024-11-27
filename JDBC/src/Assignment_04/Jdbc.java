package Assignment_04;

import java.sql.*;
import java.util.Properties;

public class Jdbc {
	public static void main(String[] args) {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String mysqlURL = "jdbc:mysql://localhost:3306/knowitdb";
			Properties props = new Properties();
			props.setProperty("user", "root");
			props.setProperty("password", "root");
			
			con = DriverManager.getConnection(mysqlURL, props);
			System.out.println("Connection established");

		} catch (ClassNotFoundException e) {
			System.out.println("Driver not found");
		} catch (SQLException e) {
			System.out.println("Connection refused");
			e.printStackTrace();
			
		}
	}

}
