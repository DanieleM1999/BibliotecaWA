package it.dstech.accessodb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnessioneDB {

	public Connection con() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String pass = "dan123mr";
		String user = "root";
		String url = "jdbc:mysql://localhost:3306/biblioteca?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=UTC&createDatabaseIfNotExist=true&allowPublicKeyRetrieval=true&useSSL=false";
		Connection con = DriverManager.getConnection(url, user, pass);
		return con;
	}

}
