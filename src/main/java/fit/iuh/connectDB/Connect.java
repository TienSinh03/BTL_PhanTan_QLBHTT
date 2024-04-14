package fit.iuh.connectDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
	public static Connection con = null;
	public static Connect instance = new Connect();
	public static Connect getInstance() {
		return instance;
	}
	
	public void connect() throws SQLException {	
		String url = "jdbc:sqlserver://localhost:1433;databasename = DB_QLBH_PT;encrypt=true;trustServerCertificate=true";

		String user ="sa";
		String password ="sapassword";
		con = DriverManager.getConnection(url, user, password);
		
	}
	public void disconnect() {
		if(con!= null) {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}
	public static Connection getConnection() {
		return con;
		
	}
	
}
