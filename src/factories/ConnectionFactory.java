package factories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	public static Connection getConnection() throws Exception {
		
		var host = "jdbc:postgresql://localhost:5436/estoquebd";
		var user = "usuario";
		var pass = "coti";
		
		return DriverManager.getConnection(host,user,pass);
	}

}
;