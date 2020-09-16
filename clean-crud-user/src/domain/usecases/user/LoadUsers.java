package domain.usecases.user;

import java.util.List;

import domain.models.User;

public interface LoadUsers {
	List<User> load();
}
