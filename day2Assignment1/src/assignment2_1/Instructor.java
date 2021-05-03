package assignment2_1;

public class Instructor extends User {
	private String[] skills;
	private String[] certificates;
	private double salary;
	
	public Instructor() {
		super();
	}

	public Instructor(int id, String firstName, String lastName, String eMail, String password, String avatar,String[] skills, String[] certificates, double salary) {
		super(id, firstName, lastName, eMail, password, avatar);
		this.skills = skills;
		this.certificates = certificates;
		this.salary = salary;
	}

	public Instructor(String firstName, String lastName, String eMail, String password, String avatar,String[] skills, String[] certificates, double salary) {	
		super(firstName, lastName, eMail, password, avatar);
		this.skills = skills;
		this.certificates = certificates;
		this.salary = salary;
	}

	public Instructor(String[] skills, String[] certificates, double salary) {
		this.skills = skills;
		this.certificates = certificates;
		this.salary = salary;
	}

	public String[] getSkills() {
		return skills;
	}

	public void setSkills(String[] skills) {
		this.skills = skills;
	}

	public String[] getCertificates() {
		return certificates;
	}

	public void setCertificates(String[] certificates) {
		this.certificates = certificates;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
}
