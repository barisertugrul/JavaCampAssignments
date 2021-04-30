package day2Assignment1;

import java.util.HashMap;
import java.util.Map;

public class Main {

	public static void main(String[] args) {
		
		UserManager userManager = new UserManager();
		
		Map<String,Boolean> preferences = new HashMap<String,Boolean>();
		preferences.put("EmailBildirimi", true);
		Student student1 = new Student("Bar��","Ertu�rul","barisertugrul@barisertugrul.com","12345","avatar.jpg",preferences);

		preferences.put("EmailBildirimi", false);
		preferences.put("SMSBildirimi", true);
		Student student2 = new Student("Kerem","Var��","kerem@kerem.com","12345","avatar-kerem.jpg",preferences);

		StudentManager studentManager = new StudentManager();
		studentManager.addStudent(student1);
		studentManager.addStudent(student2);
		
		String[] skills = {"C#", "Java", "Flutter", "Python"};
		String[] certificates = {"MCT", "PMP"};
		double salary = 6500;
		Instructor instructor1 = new Instructor("Engin","Demiro�","engin@engindemirog.com","12345","avatar-engin.jpg",skills, certificates,salary);
		
		
		InstructorManager instructorManager = new InstructorManager();
		instructorManager.addInstructor(instructor1);
		
		User[] users = userManager.getAll();
		Student[] students = studentManager.getAll();
		Instructor[] instructors = instructorManager.getAll();
		
		System.out.println("\n********************************************************************************");
		System.out.println("*  ================================= Users =================================  *");
		System.out.println("********************************************************************************\n");
		System.out.format("%6s%30s%35s", "No", "�sim-Soyisim", "E-Posta Adresi\n");
		System.out.format("%6s%30s%35s", "--", "------------", "--------------\n");
		for (User user : users) {
			System.out.format("%6s%30s%35s", user.id, user.firstName + " " + user.lastName, user.eMail + "\n");
		}

		
		System.out.println("\n********************************************************************************");
		System.out.println("*  ============================== Instructors ===============================  *");
		System.out.println("********************************************************************************\n");
		System.out.format("%6s%30s%35s%40s", "No", "�sim-Soyisim", "E-Posta Adresi", "Skills\n");
		System.out.format("%6s%30s%35s%40s", "--", "------------", "--------------", "------\n");
		for (Instructor instructor : instructors) {
			System.out.format("%6s%30s%35s%40s", instructor.id, instructor.firstName + " " + instructor.lastName, instructor.eMail, String.join(",", instructor.skills) + "\n");
		}

		
		System.out.println("\n********************************************************************************");
		System.out.println("*  ================================ Students ================================  *");
		System.out.println("********************************************************************************\n");
		System.out.format("%6s%30s%35s", "No", "�sim-Soyisim", "E-Posta Adresi\n");
		System.out.format("%6s%30s%35s", "--", "------------", "--------------\n");
		for (Student student : students) {
			System.out.format("%6s%30s%35s", student.id, student.firstName + " " + student.lastName, student.eMail + "\n");
			preferences = student.informationPreferences;
			if(preferences.containsKey("EmailBildirimi")) {
				System.out.println("++++Email Bildirimi: " + preferences.get("EmailBildirimi") + "\n");
			}
		}
		
		
		//Kurs, ders ve konu atamalar�
		Course course = new Course(1,1,"JAVA + REACT","javaKurs.jpg","Yaz�l�m Geli�tirici Yeti�tirme Kamp� (JAVA + REACT Kursu)");
		CourseManager courseManager = new CourseManager();
		courseManager.add(course);
		
		CourseLecture courseLecture1 = new CourseLecture(1,"1. G�n - 21 Nisan 2021");
		CourseLecture courseLecture2 = new CourseLecture(1,"2. G�n");
		CourseLecture courseLecture3 = new CourseLecture(1,"3. G�n");
		
		CourseLecture[] courseLectures = {courseLecture1, courseLecture2, courseLecture3};
		
		CourseLectureManager courseLectureManager = new CourseLectureManager();
		courseLectureManager.addMultiple(courseLectures);
	}

}
