package assignment3_2;

public class InstructorManager extends UserManager {
	
	@Override
	public int add(User user){
		/*
		 * Not: Açýklamalarý sadece kurs ödevi olmasý nedeniyle, inceleyecek arkadaþlar
		 * için yazdým Gerçek projelerde artýk açýklama ve yorumlardan mümkün olduðunca
		 * uzak duruyorum :) User ve instructor ekleme iþlemi sýkýntýlý Interface ve
		 * Generic class kullanýldýðýnda belki daha doðru bir kodlama yapýlabilir
		 *
		 * Instructor için base kýsmýn kaydý için yine BaseClasstaki metoddan
		 * yararlanýyoruz Test için ayrý bir user veriseti oluþturduðum için user
		 * örneðini de ayrý bir diziye kaydediyorum
		 */

		int userId = super.add(user);
		user.setId(userId);
		
		//Tip dönüþümü yapýp bu defa instructor verisini kaydediyoruz
		Instructor instructor = (Instructor) user;
		Database.getInstance().addInstructor(instructor);
		return userId;
	}
	
	public Instructor[] getAll() {
		return Database.getInstance().instructors;
	}
}
