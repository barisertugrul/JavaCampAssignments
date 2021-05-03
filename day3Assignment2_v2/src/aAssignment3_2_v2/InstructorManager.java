package aAssignment3_2_v2;

public class InstructorManager extends UserManager {
	
	public InstructorManager() {
		//Veritabanı tablosunu referans olarak iletmeye çalıştım, ama başaramadım
		super(Database.getInstance().instructors);
	}
	
	public Instructor[] getAll() {
		return Database.getInstance().instructors;
	}
}
