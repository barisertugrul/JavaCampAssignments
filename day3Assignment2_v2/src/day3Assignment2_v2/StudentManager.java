package day3Assignment2_v2;

public class StudentManager extends UserManager {
	public StudentManager() {
		super(Database.getInstance().students);
		// TODO Auto-generated constructor stub
	}


	@Override
	public int add(User user){
		int testUserId = super.addTest(user);
		System.out.println("Test user �d: " + testUserId);
		/*
		 * Not: A��klamalar� sadece kurs �devi olmas� nedeniyle, inceleyecek arkada�lar
		 * i�in yazd�m Ger�ek projelerde art�k a��klama ve yorumlardan m�mk�n oldu�unca
		 * User ve student ekleme i�lemi s�k�nt�l� Interface ve Generic class
		 * kullan�ld���nda belki daha do�ru bir kodlama yap�labilir
		 * 
		 * 
		 * Student i�in base k�sm�n kayd� i�in yine BaseClasstaki metoddan
		 * yararlan�yoruz Test i�in ayr� bir user veri seti olu�turdu�um i�in user
		 * �rne�ini de ayr� bir diziye kaydediyorum
		 */

		int userId = super.add(user);
		user.setId(userId);
		
		//Tip d�n���m� yap�p bu defa student verisini kaydediyoruz
		Student student = (Student) user;
		Database.getInstance().addStudent(student);
		return userId;
	}
	
	
	public Student[] getAll() {
		return Database.getInstance().students;
	}
}
