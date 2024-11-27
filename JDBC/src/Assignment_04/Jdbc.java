package Assignment_04;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Jdbc {

	public static void main(String[] args) {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			/*
			 * MySQL-specific Properties:
			 * 
			 * useSSL: true or false to enable or disable SSL encryption. useUnicode: true
			 * or false to enable or disable Unicode character set support.
			 * characterEncoding: Specify the character encoding, such as UTF-8, UTF-16, or
			 * GBK. zeroDateTimeBehavior: convertToNull or exception to determine how zero
			 * date-time values are handled. serverTimezone: Specify the server time zone,
			 * such as UTC, EST, or PST. Generic JDBC Properties:
			 * 
			 * user: The database username. password: The database password.
			 * autoReconnect:true or false to enable or disable automatic reconnection.
			 * maxReconnects: A positive integer specifying the maximum number of
			 * reconnection attempts. reconnectInterval: A positive integer specifying the
			 * interval (in milliseconds) between reconnection attempts.
			 */
			Class.forName("com.mysql.cj.jdbc.Driver");
			String mysqlURL = "jdbc:mysql://localhost:3306/knowitdb";
			Properties props = new Properties();
			props.setProperty("user", "root");
			props.setProperty("password", "root");
			con = DriverManager.getConnection(mysqlURL, props);
			System.out.println("Connection established");

			// TODO: get emp ordered by sal in decreasing order
			// create statement
			stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			String query = "SELECT * FROM emp ORDER BY sal DESC";
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				System.out.println("EMPNO-" + rs.getInt(1) + " : " + rs.getString(2));
			}

		} catch (ClassNotFoundException e) {
			System.out.println("Driver not found");
		} catch (SQLException e) {
			System.out.println("Connection refused");
			e.printStackTrace();

		} finally {
			System.out.println("Clearing resources");
			try {
				if (rs != null) {
					rs.close();
					System.out.println("Result Set closed");
				}
				if (stmt != null) {
					stmt.close();
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
