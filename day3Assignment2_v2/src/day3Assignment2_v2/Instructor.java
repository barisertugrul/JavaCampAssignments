package day3Assignment2_v2;

public class Instructor extends User {
	private String[] _skills;
	private String[] _certificates;
	private double _salary;
	
	public Instructor() {
		super();
	}

	public Instructor(int id, String firstName, String lastName, String eMail, String password, String avatar,String[] skills, String[] certificates, double salary) {
		super(id, firstName, lastName, eMail, password, avatar);
		_skills = skills;
		_certificates = certificates;
		_salary = salary;
	}

	public Instructor(String firstName, String lastName, String eMail, String password, String avatar,String[] skills, String[] certificates, double salary) {	
		this(0, firstName, lastName, eMail, password, avatar, skills, certificates, salary);
	}

	public String[] getSkills() {
		return _skills;
	}

	public void setSkills(String[] skills) {
		_skills = skills;
	}

	public String[] getCertificates() {
		return _certificates;
	}

	public void setCertificates(String[] certificates) {
		_certificates = certificates;
	}

	public double getSalary() {
		return _salary;
	}

	public void setSalary(double salary) {
		_salary = salary;
	}
}
