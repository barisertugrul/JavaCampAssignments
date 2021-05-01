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
		
		//Ödev için örnek yazdýrma iþlemi, gelen verinin hangi sýnýfa ait olduðunun tespiti
		if(user.getClass().equals(Student.class)) {
			System.out.println("Eklenecek kullanýcý bir Student nesnesidir ve komut bir StudentManager tarafýndan yürütülmüþtür.");
		}else if(user.getClass().equals(Instructor.class)){
			System.out.println("Eklenecek kullanýcý bir Instructor nesnesidir ve komut bir InstructorManager tarafýndan yürütülmüþtür.");
		}else{
			System.out.println("Eklenecek kullanýcý bir User nesnesidir ve komut bir UserManager tarafýndan yürütülmüþtür.");
		}
		
		//Verisetine ekleme iþlemi
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
