package data.protocols.db.user;

import domain.models.User;

public interface LoadUserByNameAndLastNameRepository {
	User load(String name, String lastName);
}
