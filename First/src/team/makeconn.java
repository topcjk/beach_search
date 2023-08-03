package team;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class makeconn {
	private Connection con;
	
	public Connection getConnection() {
		return con;

	}
	
	public makeconn() throws ClassNotFoundException,SQLException{
		
		
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		
		con=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:"
				+"1521:xe","hr","hr");	
	}
}
