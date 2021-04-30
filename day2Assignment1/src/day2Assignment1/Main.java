package day2Assignment1;

import java.util.HashMap;

public class Main {

	public static void main(String[] args) {
		
		Student student = new Student();
		student.informationPreferences = new HashMap<String,Boolean>();
		student.informationPreferences.put("EmailBildirimi", true);
		
		
		StudentManager studentManager = new StudentManager();
		studentManager.add(student);
		
	}

}
