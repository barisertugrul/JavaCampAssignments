package assignment2_1;

public class UserManager {

	public int add(User user) {
		return Database.getInstance().addUser(user);
	}
	
	public User[] getAll() {
		return Database.getInstance().users;
	}
}
