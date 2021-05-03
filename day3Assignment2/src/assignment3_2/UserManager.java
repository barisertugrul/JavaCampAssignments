package assignment3_2;

public class UserManager {
	
	public int add(User user) {
		return Database.getInstance().addUser(user);
	}
	
	public User[] getAll() {
		return Database.getInstance().users;
	}
	
	public boolean login(String email, String password) {
		//Password güvenliði/hashleme gözardý edildi
		User user = Database.getInstance().login(email, password);
		if(user != null) {
			System.out.println(user.getFirstName() + " " + user.getLastName() + " olarak giriþ yapýldý.");
			return true;
		}else {
			System.out.println("Eposta hesabý veya þifreniz hatalý!");
			return false;
		}
	}
}
