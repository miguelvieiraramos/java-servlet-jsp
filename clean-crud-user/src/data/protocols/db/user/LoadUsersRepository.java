package data.protocols.db.user;

import java.util.List;

import domain.models.User;

public interface LoadUsersRepository {
	List<User> loadAll();
}
