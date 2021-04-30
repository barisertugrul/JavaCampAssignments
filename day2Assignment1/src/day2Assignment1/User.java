package day2Assignment1;

public class User {
	int id;
	String firstName;
	String lastName;
	String eMail;
	String password;
	String avatar;
	
	public User() {

	}

	public User(int id, String firstName, String lastName, String eMail, String password, String avatar) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.eMail = eMail;
		this.password = password;
		this.avatar = avatar;
	}

	public User(String firstName, String lastName, String eMail, String password, String avatar) {
		this.id = 0;
		this.firstName = firstName;
		this.lastName = lastName;
		this.eMail = eMail;
		this.password = password;
		this.avatar = avatar;
	}
}
