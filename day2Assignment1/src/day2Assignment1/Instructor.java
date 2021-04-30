package day2Assignment1;

public class Instructor extends User {
	String[] skills;
	String[] certificates;
	double salary;
	
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
}
