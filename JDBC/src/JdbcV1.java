import java.sql.*;

public class JdbcV1 {
	public static void main(String[] args) {
		// total 6 steps
		final String MYSQLURL = "jdbc:mysql://localhost:3306/knowitdb";
		String username = "root";
		String password = "root";

		Connection con = null;
		try {
			// STEP--I ==> Load driver in memory
			// This will load driver and execute static block
			// which in turn adds driver to DriverManger class which is present in java.sql
			Class.forName("com.mysql.cj.jdbc.Driver"); // throws ClassNotFoundException
			// DriverManager is utility class inside java.sql package having
			// getConnection() as static method with 3 overloads
			con = DriverManager.getConnection(MYSQLURL, username, password); // throw SQLException
			System.out.println("Connection established with mysql DB");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Driver not found 😓");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Could not connect to mysql DB");
			e.printStackTrace();
		} finally {
			try {
				System.out.println("Clearing Resources");
				if (con != null) {
					System.out.println("Clearing con");
					con.close();
				}
			} catch (SQLException e) {
				System.out.println("Error on clearing resources");
				e.printStackTrace();
			}
		}

	}

}
