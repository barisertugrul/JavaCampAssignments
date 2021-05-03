package assignment3_2;

public class InstructorManager extends UserManager {
	
	@Override
	public int add(User user){
		/*
		 * Not: A��klamalar� sadece kurs �devi olmas� nedeniyle, inceleyecek arkada�lar
		 * i�in yazd�m Ger�ek projelerde art�k a��klama ve yorumlardan m�mk�n oldu�unca
		 * uzak duruyorum :) User ve instructor ekleme i�lemi s�k�nt�l� Interface ve
		 * Generic class kullan�ld���nda belki daha do�ru bir kodlama yap�labilir
		 *
		 * Instructor i�in base k�sm�n kayd� i�in yine BaseClasstaki metoddan
		 * yararlan�yoruz Test i�in ayr� bir user veriseti olu�turdu�um i�in user
		 * �rne�ini de ayr� bir diziye kaydediyorum
		 */

		int userId = super.add(user);
		user.setId(userId);
		
		//Tip d�n���m� yap�p bu defa instructor verisini kaydediyoruz
		Instructor instructor = (Instructor) user;
		Database.getInstance().addInstructor(instructor);
		return userId;
	}
	
	public Instructor[] getAll() {
		return Database.getInstance().instructors;
	}
}
