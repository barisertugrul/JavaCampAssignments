package assignment5_1.business.abstracts;

import java.util.List;

import assignment5_1.entities.concretes.User;

public interface UserService {
	User add(User user);

	void update(User user);

	void delete(User user);

	List<User> getAll();

	User get(int id);

	User getByEmail(String email);

	boolean setUserActivation(String email, String activationCode);

	User checkLoginInfo(String email, String password);

	boolean isComfirmActivation(String email);
}
