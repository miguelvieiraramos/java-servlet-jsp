package data.usecases.user.addUser;

import data.protocols.db.user.AddUserRepository;
import data.protocols.db.user.LoadUserByNameAndLastNameRepository;
import domain.models.User;
import domain.usecases.user.AddUser;

public class DbAddUser implements AddUser {
	private AddUserRepository addUserRepository;
	private LoadUserByNameAndLastNameRepository loadUserByNameAndLastNameRepository;
	
	public DbAddUser(AddUserRepository addUserRepository, LoadUserByNameAndLastNameRepository loadUserRepository) {
		this.addUserRepository = addUserRepository;
		this.loadUserByNameAndLastNameRepository = loadUserRepository;
	}
	
	public User add(String name, String lastName) {
		User user = this.loadUserByNameAndLastNameRepository.load(name, lastName);
		if(user == null) {
			User newUser = this.addUserRepository.add(name, lastName);
			if(newUser != null) {
				return newUser;
			}
		}
		return null;
	}
}
