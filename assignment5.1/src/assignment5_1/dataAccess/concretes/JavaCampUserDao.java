package assignment5_1.dataAccess.concretes;

import java.util.List;

import assignment5_1.dataAccess.Database;
import assignment5_1.dataAccess.abtracts.UserDao;
import assignment5_1.entities.concretes.User;

public class JavaCampUserDao implements UserDao {

	@Override
	public int add(User user) {
		List<User> users = Database.getUsers();
		int lastId = Database.getUserId();
		lastId++;
		user.setId(lastId);
		if (users.add(user)) {
			Database.setUserId(lastId);
			return lastId;
		}

		lastId--;
		return 0;
	}

	@Override
	public boolean update(User user) {
		List<User> users = Database.getUsers();
		for (User userItem : users) {
			if (userItem.getId() == user.getId()) {
				int index = users.indexOf(userItem);
				users.set(index, user);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean delete(User user) {
		List<User> users = Database.getUsers();
		users.remove(user);
		return true;
	}

	@Override
	public List<User> getAll() {
		return Database.getUsers();
	}

	@Override
	public User getById(int id) {
		List<User> users = Database.getUsers();
		for (User userItem : users) {
			if (userItem.getId() == id) {
				return userItem;
			}
		}
		return null;
	}

	@Override
	public User getByEmail(String email) {
		List<User> users = Database.getUsers();
		for (User userItem : users) {
			if (userItem.getEmail().equals(email)) {
				return userItem;
			}
		}
		return null;
	}

	@Override
	public User getByLoginInfoComfirm(String email, String password) {
		List<User> users = Database.getUsers();
		for (User userItem : users) {
			if (userItem.getEmail().equals(email) && userItem.getPassword().equals(password)) {
				return userItem;
			}
		}
		return null;
	}

	@Override
	public User getByEmailAndActivationCode(String email, String activationCode) {
		List<User> users = Database.getUsers();
		for (User userItem : users) {
			if (userItem.getEmail().equals(email) && userItem.getActivationCode().equals(activationCode)) {
				return userItem;
			}
		}
		return null;
	}

}
