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
	
	public int addStudent(Student student) {
		User user = new User();
		User[] users = Database.getInstance().users;
		User[] tempUsers = users;
		users = new User[users.length+1];
		
		for (int i = 0; i < tempUsers.length; i++) {
			users[i] = tempUsers[i];
		}
		
		
		Database.getInstance().userId += 1;
		int newId = Database.getInstance().userId;
		user.id = newId;
		
		users[users.length-1] = user;
		
		Database.getInstance().users = users;
		
		return newId;
	}
}
