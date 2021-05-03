package assignment3_2_v2;

public class StudentManager extends UserManager {
	public StudentManager() {
		//Veritabanı tablosunu referans olarak iletmeye çalıştım, ama başaramadım
		super(Database.getInstance().students);
	}
	
	public Student[] getAll() {
		return Database.getInstance().students;
	}
}
