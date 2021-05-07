package assignment5_1.dataAccess.abtracts;

import java.util.List;

import assignment5_1.entities.concretes.User;

public interface UserDao {
	int add(User user);

	boolean update(User user);

	boolean delete(User user);

	List<User> getAll();

	// getBy(filter) þeklinde kullanýlabilecek metotlar
	User getById(int id);

	User getByEmail(String email);

	User getByLoginInfoComfirm(String email, String password);

	User getByEmailAndActivationCode(String email, String activationCode);
}
