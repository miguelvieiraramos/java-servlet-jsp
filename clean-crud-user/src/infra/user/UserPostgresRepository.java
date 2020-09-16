package infra.user;

import data.protocols.db.user.AddUserRepository;
import data.protocols.db.user.LoadUserByNameAndLastNameRepository;
import data.protocols.db.user.LoadUsersRepository;
import domain.models.User;
import domain.usecases.user.LoadUsers;
import infra.helpers.DatabaseService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserPostgresRepository implements AddUserRepository, LoadUserByNameAndLastNameRepository, LoadUsersRepository {
	public User add(String name, String lastName) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DatabaseService.getConnPostgres();
			ps = conn.prepareStatement("INSERT INTO public.\"user\"(name, last_name) VALUES (?, ?)");
			ps.setString(1, name);
			ps.setString(2, lastName);
			ps.execute();
			return new User(name, lastName);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(ps != null) {
					ps.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public User load(String name, String lastName) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = DatabaseService.getConnPostgres();
			ps = conn.prepareStatement("SELECT name, last_name FROM public.user WHERE name = ? AND last_name = ?");
			ps.setString(1, name);
			ps.setString(2, lastName);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				name = rs.getString(1);
				lastName = rs.getString(2);
				return new User(name, lastName);
			}
		} catch (Exception e) {
			System.err.println(e);
		} finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(ps != null) {
					ps.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public List<User> loadAll() {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			conn = DatabaseService.getConnPostgres();
			st = conn.createStatement();
			rs = st.executeQuery("SELECT name, last_name FROM public.user");
			List<User> users = new ArrayList<User>();
			
			while(rs.next()) {
				String name = rs.getString(1);
				String lastName = rs.getString(2);
				User newUser = new User(name, lastName);
				users.add(newUser);
			}
			return users;
		} catch (Exception e) {
			System.err.println(e);
		} finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(st != null) {
					st.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}
}
