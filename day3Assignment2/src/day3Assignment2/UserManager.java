package day3Assignment2;

import java.util.ArrayList;

public class UserManager {

	public UserManager() {
		
	}
	public int add(User user) {
		return Database.getInstance().addUser(user);
	}
	
	public User[] getAll() {
		return Database.getInstance().users;
	}
	
	public boolean login(String email, String password) {
		//Password g�venli�i/hashleme g�zard� edildi
		User user = Database.getInstance().login(email, password);
		if(user != null) {
			System.out.println(user.getFirstName() + " " + user.getLastName() + " olarak giri� yap�ld�.");
			return true;
		}else {
			System.out.println("Eposta hesab� veya �ifreniz hatal�!");
			return false;
		}
	}
}
