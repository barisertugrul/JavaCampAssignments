package assignment5_1.dataAccess;

import java.util.ArrayList;
import java.util.List;

import assignment5_1.entities.concretes.User;

public class Database {

	private static Database instance;
	private static List<User> users;
	private static int userId = 0;

	public static Database getInstance() {
		if (instance == null) {
			instance = new Database();
		}
		return instance;
	}

	public static List<User> getUsers() {
		if (users == null) {
			users = new ArrayList<User>();
		}
		return users;
	}

	public static int getUserId() {
		return userId;
	}

	public static void setUserId(int userId) {
		Database.userId = userId;
	}

}
