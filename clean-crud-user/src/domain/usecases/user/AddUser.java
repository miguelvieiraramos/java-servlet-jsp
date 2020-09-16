package domain.usecases.user;

import domain.models.User;

public interface AddUser {
	User add(String name, String lastName);
}
