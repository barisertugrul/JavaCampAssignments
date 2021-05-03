package assignment3_2_v2;

public class StudentManager extends UserManager {
	public StudentManager() {
		//Veritaban� tablosunu referans olarak iletmeye �al��t�m, ama ba�aramad�m
		super(Database.getInstance().students);
	}
	
	public Student[] getAll() {
		return Database.getInstance().students;
	}
}
