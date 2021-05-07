package assignment5_1.entities.concretes;

import java.util.List;

public class UserForExternalResults {
	private String email;
	private String password;
	private String firstName;
	private String lastName;
	private List additionalInformation;

	public UserForExternalResults(String email, String password, String firstName, String lastName,
			List additionalInformation) {
		super();
		this.email = email;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.additionalInformation = additionalInformation;
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

	public List getAdditionalInformation() {
		return additionalInformation;
	}

	public void setAdditionalInformation(List additionalInformation) {
		this.additionalInformation = additionalInformation;
	}
}
