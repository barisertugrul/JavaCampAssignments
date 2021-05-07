package assignment5_1.entities.concretes;

import java.time.LocalDate;

import assignment5_1.entities.abstracts.Entity;

public class User implements Entity {
	private int id;
	private String email;
	private String password;
	private String firstName;
	private String lastName;
	private LocalDate registerDate;
	private String activationCode;
	private boolean activationComfirm;

	public User(String email, String password, String firstName, String lastName, LocalDate registerDate,
			String activationCode) {
		this.email = email;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.registerDate = registerDate;
		this.activationCode = activationCode;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public LocalDate getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(LocalDate registerDate) {
		this.registerDate = registerDate;
	}

	public String getActivationCode() {
		return activationCode;
	}

	public void setActivationCode(String activationCode) {
		this.activationCode = activationCode;
	}

	public boolean getActivationComfirm() {
		return activationComfirm;
	}

	public void setActivationComfirm(boolean activationComfirm) {
		this.activationComfirm = activationComfirm;
	}
}
