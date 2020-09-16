import java.sql.Connection;
import java.sql.DriverManager;

public class DataService {
	public static Connection getConnPostgres() {
		Connection conn = null;
		try {
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/clean-crud-user", "postgres", "xxwhe222");
		} catch(Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
}
