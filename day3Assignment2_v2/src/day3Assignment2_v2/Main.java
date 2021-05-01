package day3Assignment2_v2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		/*
		 * Version 2 üzerinde çalýþýlýyor
		 */
		
		UserManager userManager = new UserManager();
		
		Map<String,Boolean> preferences = new HashMap<String,Boolean>();
		preferences.put("EmailBildirimi", true);
		Student student1 = new Student("Barýþ","Ertuðrul","barisertugrul@barisertugrul.com","12345","avatar.jpg",preferences);

		preferences.put("EmailBildirimi", false);
		preferences.put("SMSBildirimi", true);
		Student student2 = new Student("Kerem","Varýþ","kerem@kerem.com","12345","avatar-kerem.jpg",preferences);

		StudentManager studentManager = new StudentManager();
		studentManager.add(student1);
		studentManager.add(student2);
		
		String[] skills1 = {"C#", "Java", "Flutter", "Python"};
		String[] certificates1 = {"MCT", "PMP"};
		double salary1 = 6500;
		Instructor instructor1 = new Instructor("Engin","Demiroð","engin@engindemirog.com","12345","avatar-engin.jpg",skills1, certificates1,salary1);
		
		
		InstructorManager instructorManager = new InstructorManager();
		instructorManager.add(instructor1);
		

		String[] skills2 = {"C#", "Java", "Flutter", "Python"};
		String[] certificates2 = {"MCT", "PMP"};
		double salary2 = 6500;
		Instructor instructor2 = new Instructor("Engin","Demiroð","engin@engindemirog.com","12345","avatar-engin.jpg",skills2, certificates2,salary2);
		
		instructorManager.add(instructor2);
		
		//Kullanýcý giriþ iþlemleri
		
		login();
		
		User[] users = userManager.getAll();
		Student[] students = studentManager.getAll();
		Instructor[] instructors = instructorManager.getAll();
		
		System.out.println("\n********************************************************************************");
		System.out.println("*  ================================= Users =================================  *");
		System.out.println("********************************************************************************\n");
		System.out.format("%6s%30s%35s", "No", "Ýsim-Soyisim", "E-Posta Adresi\n");
		System.out.format("%6s%30s%35s", "--", "------------", "--------------\n");
		for (User user : users) {
			System.out.format("%6s%30s%35s", user.getId(), user.getFirstName() + " " + user.getLastName(), user.geteMail() + "\n");
		}

		
		System.out.println("\n********************************************************************************");
		System.out.println("*  ============================== Instructors ===============================  *");
		System.out.println("********************************************************************************\n");
		System.out.format("%6s%30s%35s%40s", "No", "Ýsim-Soyisim", "E-Posta Adresi", "Skills\n");
		System.out.format("%6s%30s%35s%40s", "--", "------------", "--------------", "------\n");
		for (Instructor instructor : instructors) {
			System.out.format("%6s%30s%35s%40s", instructor.getId(), instructor.getFirstName() + " " + instructor.getLastName(), instructor.geteMail(), String.join(",", instructor.getSkills()) + "\n");
		}

		
		System.out.println("\n********************************************************************************");
		System.out.println("*  ================================ Students ================================  *");
		System.out.println("********************************************************************************\n");
		System.out.format("%6s%30s%35s", "No", "Ýsim-Soyisim", "E-Posta Adresi\n");
		System.out.format("%6s%30s%35s", "--", "------------", "--------------\n");
		for (Student student : students) {
			System.out.format("%6s%30s%35s", student.getId(), student.getFirstName() + " " + student.getLastName(), student.geteMail() + "\n");
			preferences = student._informationPreferences;
			if(preferences.containsKey("EmailBildirimi")) {
				System.out.println("++++Email Bildirimi: " + preferences.get("EmailBildirimi") + "\n");
			}
		}
		
		
		//Kurs, ders ve konu atamalarý
		Course course = new Course(1,1,"JAVA + REACT","javaKurs.jpg","Yazýlým Geliþtirici Yetiþtirme Kampý (JAVA + REACT Kursu)");
		CourseManager courseManager = new CourseManager();
		courseManager.add(course);
		
		CourseLecture courseLecture1 = new CourseLecture(1,"1. Gün - 21 Nisan 2021");
		CourseLecture courseLecture2 = new CourseLecture(1,"2. Gün");
		CourseLecture courseLecture3 = new CourseLecture(1,"3. Gün");
		
		CourseLecture[] courseLectures = {courseLecture1, courseLecture2, courseLecture3};
		
		CourseLectureManager courseLectureManager = new CourseLectureManager();
		courseLectureManager.addMultiple(courseLectures);
		
		LectureSubject subject1 = new LectureSubject(1,"program-icon.svg","Ders Programý", "Kurs sayfasý içeriði");
		LectureSubject subject2 = new LectureSubject(1,"ders-kaydi-icon.svg","1.Gün Sonu Kayýt", "Kurs sayfasý içeriði");
		LectureSubject subject3 = new LectureSubject(1,"odev-icon.svg","Ödev 1", "Kurs sayfasý içeriði");
		LectureSubject subject4 = new LectureSubject(1,"odev-icon.svg","Ödev 2", "Kurs sayfasý içeriði");
		LectureSubject subject5 = new LectureSubject(1,"odev-icon.svg","Ödev 3", "Kurs sayfasý içeriði");
		LectureSubject subject6 = new LectureSubject(1,"degerlendirme-icon.svg","Deðerlendirme", "Kurs sayfasý içeriði");
		

		LectureSubject subject7 = new LectureSubject(2,"program-icon.svg","Ders Programý", "Kurs sayfasý içeriði");
		LectureSubject subject8 = new LectureSubject(2,"ders-kaydi-icon.svg","2.Gün Sonu Kayýt", "Kurs sayfasý içeriði");
		LectureSubject subject9 = new LectureSubject(2,"odev-icon.svg","Ödev 1", "Kurs sayfasý içeriði");
		LectureSubject subject10 = new LectureSubject(2,"odev-icon.svg","Ödev 2", "Kurs sayfasý içeriði");
		LectureSubject subject11 = new LectureSubject(2,"degerlendirme-icon.svg","Deðerlendirme", "Kurs sayfasý içeriði");

		LectureSubject subject12 = new LectureSubject(3,"program-icon.svg","Ders Programý", "Kurs sayfasý içeriði");
		LectureSubject subject13 = new LectureSubject(3,"ders-kaydi-icon.svg","3.Gün Sonu Kayýt", "Kurs sayfasý içeriði");
		LectureSubject subject14 = new LectureSubject(3,"odev-icon.svg","Ödev 1", "Kurs sayfasý içeriði");
		LectureSubject subject15 = new LectureSubject(3,"odev-icon.svg","Ödev 2", "Kurs sayfasý içeriði");
		LectureSubject subject16 = new LectureSubject(3,"degerlendirme-icon.svg","Deðerlendirme", "Kurs sayfasý içeriði");
		
		LectureSubject[] subjects = {
				subject1, subject2,subject3,subject4,
				subject5,subject6,subject7,subject8,
				subject9,subject10,subject11,subject12,
				subject13,subject14,subject15,subject16
		};
		
		LectureSubjectManager lectureSubjectManager = new LectureSubjectManager();
		lectureSubjectManager.addMultiple(subjects);
		
		System.out.println("\n********************************************************************************");
		System.out.println("*  ================================ Courses ================================  *");
		System.out.println("********************************************************************************\n");
		
		Course[] courses = courseManager.getAll();
		for (Course courseItem : courses) {
			System.out.println(courseItem.name);
			System.out.println("[" + courseItem.description + "]");
			CourseLecture[] lectures = courseLectureManager.getByCourseId(courseItem.id);
			for (CourseLecture lecture : lectures) {
				System.out.println("     * DERS: " + lecture.title);
				subjects = lectureSubjectManager.getByLectureId(lecture.id);
				for (LectureSubject subject : subjects) {
					System.out.println("          " + subject.title);
				}
			}
		}
		studentManager.userCount();
		instructorManager.userCount();
		StudentManager studentManager2 = new StudentManager();
		studentManager2.userCount();
	}

	private static void login() {
		boolean logged = false;
		while (!logged) {
			Scanner kullaniciGirdisi = new Scanner(System.in);
			System.out.println("LOGIN: ");
			System.out.print("E-Posta adresinizi giriniz: ");
			String email = kullaniciGirdisi.next();
			kullaniciGirdisi.nextLine();
			System.out.print("Parolanýzý giriniz: ");
			String password = kullaniciGirdisi.next();
			kullaniciGirdisi.nextLine();
			UserManager userManager = new UserManager();
			logged = userManager.login(email, password);
			kullaniciGirdisi.close();
		}
		
		
	}

}
