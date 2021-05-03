package assignment3_2_v2;

public class User {
	private int _id;
	private String _firstName;
	private String _lastName;
	private String _eMail;
	private String _password;
	private String _avatar;
	
	public User() {

	}

	public User(int id, String firstName, String lastName, String eMail, String password, String avatar) {
		this(firstName, lastName, eMail, password, avatar);
		_id = id;
	}

	public User(String firstName, String lastName, String eMail, String password, String avatar) {
		_id = 0;
		_firstName = firstName;
		_lastName = lastName;
		_eMail = eMail;
		_password = password;
		_avatar = avatar;
	}

	public int getId() {
		return _id;
	}

	public void setId(int id) {
		_id = id;
	}

	public String getFirstName() {
		return _firstName;
	}

	public void setFirstName(String firstName) {
		_firstName = firstName;
	}

	public String getLastName() {
		return _lastName;
	}

	public void setLastName(String lastName) {
		_lastName = lastName;
	}

	public String geteMail() {
		return _eMail;
	}

	public void seteMail(String eMail) {
		_eMail = eMail;
	}

	public String getPassword() {
		return _password;
	}

	public void setPassword(String password) {
		_password = password;
	}

	public String getAvatar() {
		return _avatar;
	}

	public void setAvatar(String avatar) {
		_avatar = avatar;
	}
}
