package Assignment_02;

import java.sql.*;

public class JdbcV2 {
	public static void main(String[] args) {
		Connection con = null;
		// con will give statement
		Statement statM = null;

		// on executing the statM we get ResultSet
		ResultSet rs = null;

		try {
			// Step-1 load class
			// loads class + static block + add to DriverManager
			Class.forName("com.mysql.cj.jdbc.Driver"); // classNotFound
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/knowitdb", "root", "root"); // sqlexception

			// Step-II ==> creating connection
			System.out.println("Connection established with mysql DB");

			// now getting data ei executing queries
			// we need statment and resultset references

			// STEP-III ==> creating statements
			statM = con.createStatement();

			// STEP-IV ==> execture statement
			rs = statM.executeQuery("SELECT * FROM emp");

			// STEP-V ==> Read data
			while (rs.next()) {
				int index = 1;
				System.out.print(rs.getInt("empno") + " : ");
				index++;
				System.out.print(rs.getString(index++) + " : ");
				System.out.print(rs.getString(index++) + " : ");
				System.out.print(rs.getInt(index++) + " : ");
				System.out.print(rs.getDate(index++) + " : ");
				System.out.print(rs.getFloat(index++) + " : ");
				System.out.print(rs.getFloat(index++) + " : ");
				System.out.print(rs.getInt(index++) + " ;");
				System.out.println();
			}

		} catch (ClassNotFoundException e) {
			System.out.println("Driver not found");
		} catch (SQLException e) {
			System.out.println("Connection Rejected");
		} finally {
			System.out.println("Clearing resources");
			try {
				if (rs != null) {
					rs.close();
					System.out.println("Result Set closed");
				}
				if (statM != null) {
					statM.close();
					System.out.println("Statement closed");
				}
				if (con != null) {
					con.close();
					System.out.println("DB connection closed");
				}
			} catch (SQLException e) {
				System.out.println("Error while clearing resources");
			}
		}

	}
}
