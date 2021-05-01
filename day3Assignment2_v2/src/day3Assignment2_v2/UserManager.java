package day3Assignment2_v2;

public class UserManager {
	
	private User[] _users;

	public UserManager() {
		this(Database.getInstance().users);
	}
	
	public UserManager(User[] users) {
		_users = users;
		userCount();
	}
	
	public int addTest(User user) {
		System.out.println("Test user �d: " + user.getFirstName());
		return Database.getInstance().addUserTest(user,_users);
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
	
	public void userCount() {
		System.out.println(_users.toString() + "****" + _users.length);
	}
}
