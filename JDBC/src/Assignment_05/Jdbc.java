package Assignment_05;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Jdbc {
	public static void main(String [] args) throws ClassNotFoundException{
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/knowitdb");
			stmt = con.createStatement();
			String query = "";
			stmt.executeQuery(query);
		}catch(ClassNotFoundException e) {
			System.out.println("Driver not found");
		}catch(SQLException e) { 
			System.out.println("Could not connect to DB");
		}
		
		
	}

}
