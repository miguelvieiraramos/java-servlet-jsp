package data.protocols.db.user;

import domain.models.User;

public interface AddUserRepository {
	User add(String name, String lastName);
}
