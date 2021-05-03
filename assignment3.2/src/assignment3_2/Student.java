package assignment3_2;
import java.util.Map;

public class Student extends User {
	Map<String, Boolean> _informationPreferences;

	public Student() {
		super();
	}

	public Student(int id, String firstName, String lastName, String eMail, String password, String avatar, Map<String, Boolean> preferences) {
		super(id, firstName, lastName, eMail, password, avatar);
		_informationPreferences = preferences;
	}
	
	public Student(String firstName, String lastName, String eMail, String password, String avatar, Map<String, Boolean> preferences) {
		this(0, firstName, lastName, eMail, password, avatar, preferences);
	}

	public Map<String, Boolean> getInformationPreferences() {
		return _informationPreferences;
	}

	public void setInformationPreferences(Map<String, Boolean> informationPreferences) {
		_informationPreferences = informationPreferences;
	}
	
}