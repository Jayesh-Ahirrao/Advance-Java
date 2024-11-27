package Assignment_03;

import java.sql.*;

public class JdbcV3 {
	public static void main(String[] args) {
		Connection con = null;
		Statement statM = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/knowitdb", "root", "root");
			System.out.println("Conneciton Established");
			statM = con.createStatement();
			System.out.println("Statment created");

			String updateQuery = "UPDATE emp SET sal = 9999.99 WHERE mgr = 7698";
			int res = statM.executeUpdate(updateQuery);

			System.out.println("Number of records updated : " + res);

		} catch (ClassNotFoundException e) {
			System.out.println("Driver not found");
		} catch (SQLException e) {
			System.out.println("Conneciton rejected");
		} finally {
			System.out.println("Clearing resources");
			try {
				if (statM != null) {
					statM.close();
					System.out.println("Statment closed");
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
