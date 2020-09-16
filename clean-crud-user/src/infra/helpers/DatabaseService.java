package infra.helpers;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseService {
	public static Connection getConnPostgres() {
		Connection conn = null;
		try {
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/clean-crud-user", "postgres", "xxwhe222");
		} catch(Exception e) {
			System.err.println(e);
		}
		return conn;
	}
}
