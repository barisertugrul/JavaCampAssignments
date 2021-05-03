package aAssignment3_2_v2;

public class InstructorManager extends UserManager {
	
	public InstructorManager() {
		//Veritaban� tablosunu referans olarak iletmeye �al��t�m, ama ba�aramad�m
		super(Database.getInstance().instructors);
	}
	
	public Instructor[] getAll() {
		return Database.getInstance().instructors;
	}
}
