package aAssignment3_2_v2;
import java.util.Map;

public class Student extends User {
	private int _userId;
	private Map<String, Boolean> _informationPreferences;

	public Student() {
		super();
	}

	public Student(int id, int userId, String firstName, String lastName, String eMail, String password, String avatar, Map<String, Boolean> preferences) {
		super(id, firstName, lastName, eMail, password, avatar);
		this.setUserId(userId);
		this.setInformationPreferences(preferences);
	}
	
	public Student(String firstName, String lastName, String eMail, String password, String avatar, Map<String, Boolean> preferences) {
		this(0, 0, firstName, lastName, eMail, password, avatar, preferences);
	}

	public int getUserId() {
		return _userId;
	}

	public void setUserId(int userId) {
		this._userId = userId;
	}

	public Map<String, Boolean> getInformationPreferences() {
		return _informationPreferences;
	}

	public void setInformationPreferences(Map<String, Boolean> informationPreferences) {
		_informationPreferences = informationPreferences;
	}
	
}