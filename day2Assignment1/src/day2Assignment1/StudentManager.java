package day2Assignment1;

public class StudentManager extends UserManager {
	
	@Override
	public int add(User user){
		int lastId = super.add(user);
		//User ve student ekleme işlemi sıkıntılı
		//Dönüşüm ve başka fonksiyonlarla iletişim gerekiyor şu durumda
		System.out.println("Added User: " + user.firstName + " " + user.lastName);
		return lastId;
	}
	
	public void addStudent(Student student) {
		User user = new User(student.firstName,student.lastName, student.eMail,student.password,student.avatar);
		this.add(user);
		Student[] students = Database.getInstance().students;
		Student[] tempStudents = students;
		students = new Student[students.length+1];
		
		for (int i = 0; i < tempStudents.length; i++) {
			students[i] = tempStudents[i];
		}
		

		int newId = Database.getInstance().userId;
		student.id = newId;
		
		students[students.length-1] = student;
		
		Database.getInstance().students = students;
		Database.getInstance().studentId = newId;
	}
	
	public Student[] getAll() {
		return Database.getInstance().students;
	}
}
