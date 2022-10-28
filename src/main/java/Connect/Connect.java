package Connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {

	public static Connection con = null;
	private static Connect instance = new Connect();

	public static Connect getInstance() {
		connect();
		return instance;
	}

	public static void connect() {
		String url = "jdbc:sqlserver://localhost:1433;databasename=QLKaraoke";
		String user = "sa";
		String password = "0123";
		try {
			con = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void disconnect() {
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static Connection getConnection() {

		return con;
	}
}
