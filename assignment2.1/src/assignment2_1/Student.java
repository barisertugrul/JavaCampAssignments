package assignment2_1;
import java.util.Map;

public class Student extends User {
	Map<String, Boolean> informationPreferences;

	public Student() {
		super();
	}

	public Student(int id, String firstName, String lastName, String eMail, String password, String avatar, Map<String, Boolean> preferences) {
		super(id, firstName, lastName, eMail, password, avatar);
		this.informationPreferences = preferences;
	}
	
	public Student(String firstName, String lastName, String eMail, String password, String avatar, Map<String, Boolean> preferences) {
		super(firstName, lastName, eMail, password, avatar);
		this.informationPreferences = preferences;
	}
	
}