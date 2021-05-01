package day3Assignment2_v2;

public class UserManager {
	
	private User[] _users;

	public UserManager() {
		this(Database.getInstance().users);
	}
	
	public UserManager(User[] users) {
		_users = users;
	}
	
	public int add(User user) {
		//return Database.getInstance().addUser(user);
		return Database.getInstance().addUser(user,_users);
	}
	
	public void update(User user) {
		Database.getInstance().update(user);
	}
	
	public void delete(User user) {
		Database.getInstance().delete(user);
	}
	
	public User[] getAll() {
		return Database.getInstance().users;
	}
	
	public User getById(int userId) {
		return Database.getInstance().getUserById(userId);
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
