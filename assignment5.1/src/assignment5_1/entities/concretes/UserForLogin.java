package assignment5_1.entities.concretes;

import assignment5_1.entities.abstracts.Entity;

public class UserForLogin implements Entity {
	private String email;
	private String password;

	public UserForLogin(String email, String password) {
		this.email = email;
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
