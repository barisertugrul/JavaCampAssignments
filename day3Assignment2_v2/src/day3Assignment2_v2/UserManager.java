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
		
		//�dev i�in �rnek yazd�rma i�lemi, gelen verinin hangi s�n�fa ait oldu�unun tespiti
		if(user.getClass().equals(Student.class)) {
			System.out.println("Eklenecek kullan�c� bir Student nesnesidir ve komut bir StudentManager taraf�ndan y�r�t�lm��t�r.");
		}else if(user.getClass().equals(Instructor.class)){
			System.out.println("Eklenecek kullan�c� bir Instructor nesnesidir ve komut bir InstructorManager taraf�ndan y�r�t�lm��t�r.");
		}else{
			System.out.println("Eklenecek kullan�c� bir User nesnesidir ve komut bir UserManager taraf�ndan y�r�t�lm��t�r.");
		}
		
		//Verisetine ekleme i�lemi
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
