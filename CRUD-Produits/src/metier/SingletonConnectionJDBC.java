package metier;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SingletonConnectionJDBC {
	
	public static Connection cnx;
	static {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				cnx = DriverManager.
						getConnection("jdbc:mysql://localhost:3306/Produit","root","");

			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}
	// ------ This how to get the connection of the Database Getter -----
	
	public static Connection getCnx() {
		return cnx;
	}
}
