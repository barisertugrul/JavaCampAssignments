package day2Assignment1;

public class UserManager {

	public int add(User user) {
		User[] users = Database.getInstance().users;
		User[] tempUsers = users;
		users = new User[users.length+1];
		
		for (int i = 0; i < tempUsers.length; i++) {
			users[i] = tempUsers[i];
		}
		
		
		Database.getInstance().userId += 1;
		int newId = Database.getInstance().userId;
		user.id = newId;
		
		users[users.length-1] = user;
		
		Database.getInstance().users = users;
		
		return newId;
	}
}
