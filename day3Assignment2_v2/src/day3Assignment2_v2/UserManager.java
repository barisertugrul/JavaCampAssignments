package day3Assignment2_v2;

public class UserManager {
	
	private User[] _users;

	public UserManager() {
		this(Database.getInstance().users1);
	}
	
	public UserManager(User[] users) {
		_users = users;
	}
	
	public int add(User user) {
		//return Database.getInstance().addUser(user);
		return Database.getInstance().addUserTest(user,_users);
	}
	
	public User[] getAll() {
		return Database.getInstance().users;
	}
	
	public boolean login(String email, String password) {
		//Password güvenliği/hashleme gözardı edildi
		User user = Database.getInstance().login(email, password);
		if(user != null) {
			System.out.println(user.getFirstName() + " " + user.getLastName() + " olarak giriş yapıldı.");
			return true;
		}else {
			System.out.println("Eposta hesabı veya şifreniz hatalı!");
			return false;
		}
	}
}
