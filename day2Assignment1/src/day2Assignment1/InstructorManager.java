package day2Assignment1;

public class InstructorManager extends UserManager {
	
	@Override
	public int add(User user){
		int lastId = super.add(user);
		//User ve instructor ekleme iþlemi sýkýntýlý
		//Dönüþüm ve baþka fonksiyonlarla iletiþim gerekiyor þu durumda
		System.out.println("Added User: " + user.firstName + " " + user.lastName);
		return lastId;
	}
	
	public void addInstructor(Instructor instructor) {
		User user = new User(instructor.firstName,instructor.lastName, instructor.eMail,instructor.password,instructor.avatar);
		this.add(user);
		Instructor[] instructors = Database.getInstance().instructor;
		Instructor[] tempInstructors = instructors;
		instructors = new Instructor[instructors.length+1];
		
		for (int i = 0; i < tempInstructors.length; i++) {
			instructors[i] = tempInstructors[i];
		}
		
		int newId = Database.getInstance().userId;
		instructor.id = newId;
		
		instructors[instructors.length-1] = instructor;
		
		Database.getInstance().instructor = instructors;
		Database.getInstance().instructorId = newId;
	}
	
	public Instructor[] getAll() {
		return Database.getInstance().instructor;
	}
}
