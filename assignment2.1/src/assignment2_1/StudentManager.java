package assignment2_1;

public class StudentManager extends UserManager {
	@Override
	public int add(User user){
		/*
		 * Not: Açıklamaları sadece kurs ödevi olması nedeniyle, inceleyecek arkadaşlar
		 * için yazdım Gerçek projelerde artık açıklama ve yorumlardan mümkün olduğunca
		 * User ve student ekleme işlemi sıkıntılı Interface ve Generic class
		 * kullanıldığında belki daha doğru bir kodlama yapılabilir
		 * 
		 * 
		 * Student için base kısmın kaydı için yine BaseClasstaki metoddan
		 * yararlanıyoruz Test için ayrı bir user veri seti oluşturduğum için user
		 * örneğini de ayrı bir diziye kaydediyorum
		 */

		int userId = super.add(user);
		user.setId(userId);
		
		//Tip dönüşümü yapıp bu defa student verisini kaydediyoruz
		Student student = (Student) user;
		Database.getInstance().addStudent(student);
		return userId;
	}
	
	
	public Student[] getAll() {
		return Database.getInstance().students;
	}
}
