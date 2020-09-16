package data.usecases.user.addUser;

import java.util.List;

import data.protocols.db.user.LoadUsersRepository;
import domain.models.User;
import domain.usecases.user.LoadUsers;

public class DbLoadUsers implements LoadUsers {
	private LoadUsersRepository loadUsersRepository;
	
	public DbLoadUsers(LoadUsersRepository loadUsersRepository) {
		this.loadUsersRepository = loadUsersRepository;
	}
	
	public List<User> load() {
		List<User> users = this.loadUsersRepository.loadAll();
		return users;
	}
}
