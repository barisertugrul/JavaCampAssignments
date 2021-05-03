package assignment3_2_v2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		/*
		 * Version 2 üzerinde çalýþýlýyor
		 * Constructor aracýlýðý ile kayýt tablosuna ait
		 * diziyi kullandýrtmaya çalýþýyorum sisteme
		 */
		
		System.out.println("3.GÜN 2.ÖDEV VERSION 2 ÇALIÞIYOR\n");
		
		UserManager userManager = new UserManager(Database.getInstance().users);
		
		User guncellenecekUser = new User("Güncellenecek","Kullanýcý","barisertugrul@barisertugrul.com","12345","avatar.jpg");
		userManager.add(guncellenecekUser);

		/*
		 * Öðrencilerin eklenmesi
		 */
		Map<String,Boolean> preferences1 = new HashMap<String,Boolean>();
		preferences1.put("EmailBildirimi", true);
		Student student1 = new Student("Barýþ","Ertuðrul","barisertugrul@barisertugrul.com","12345","avatar.jpg",preferences1);

		Map<String,Boolean> preferences2 = new HashMap<String,Boolean>();
		preferences2.put("EmailBildirimi", false);
		preferences2.put("SMSBildirimi", true);
		Student student2 = new Student("Kerem","Varýþ","kerem@kerem.com","12345","avatar-kerem.jpg",preferences2);

		Student silinecekStudent = new Student("Silinecek","Student","barisertugrul@barisertugrul.com","12345","avatar.jpg",preferences1);

		StudentManager studentManager = new StudentManager();
		studentManager.add(student1);
		studentManager.add(student2);
		studentManager.add(silinecekStudent);
		
		/*
		 * Eðitimcilerin eklenmesi
		 */
		String[] skills1 = {"C#", "Java", "Flutter", "Python"};
		String[] certificates1 = {"MCT", "PMP"};
		double salary1 = 6500;
		Instructor instructor1 = new Instructor("Engin","Demiroð","engin@engindemirog.com","12345","avatar-engin.jpg",skills1, certificates1,salary1);
		
		String[] skills2 = {"Hint Ýngilizcesi", "C#", "Java"};
		String[] certificates2 = {"MCT", "PMP"};
		double salary2 = 7500;
		Instructor instructor2 = new Instructor("Engin-2","Demiroð","engin2@engindemirog.com","12345","avatar-engin-2.jpg",skills2, certificates2,salary2);
		

		String[] skills3 = {"Yok"};
		String[] certificates3 = {"Bu da yok"};
		double salary3 = 1500;
		Instructor silinecekInstructor = new Instructor("Silinecek","Eðitimci","silinecek@egitimci.com","12345","avatar-default.jpg",skills3, certificates3,salary3);
		
		InstructorManager instructorManager = new InstructorManager();
		instructorManager.add(instructor1);
		instructorManager.add(instructor2);
		instructorManager.add(silinecekInstructor);
		
		//Kullanýcý giriþ iþlemleri
		
		login();
		
		/*
		 * Listelerin yazdýrýlmasý
		 */
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
		System.out.format("%6s%30s%35s%40s", "No", "Ýsim-Soyisim", "E-Posta Adresi", "Tercihler\n");
		System.out.format("%6s%30s%35s%40s", "--", "------------", "--------------","---------\n");
		
		for (Student student : students) {
			Map<String,Boolean> preferences = student.getInformationPreferences();
			System.out.format("%6s%30s%35s%40s", student.getId(), student.getFirstName() + " " + student.getLastName(), student.geteMail(), "++++Email Bildirimi: " + preferences.get("EmailBildirimi") + "\n");
			
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
		
		/*
		 * Ek iþlemler
		 */
		//Güncelleme
		User updatableUser = userManager.getById(1);
		updatableUser.setFirstName("Silinecek");
		userManager.update(updatableUser);
		System.out.println("\n1 nolu kullanýcýnýn ismi güncellendi.");
		users = userManager.getAll();
		for (User user : users) {
			System.out.format("%6s%30s%35s", user.getId(), user.getFirstName() + " " + user.getLastName(), user.geteMail() + "\n");
		}
		
		//Silme
		User deleteUser = userManager.getById(1);
		userManager.delete(deleteUser);
		System.out.println("\n1 nolu kullanýcý silindi.");

		User deleteInstructor = instructorManager.getById(3);
		instructorManager.delete(deleteInstructor);
		System.out.println("\n3 nolu instructor silindi.");
		
		User deleteStudent = studentManager.getById(3);
		studentManager.delete(deleteStudent);
		System.out.println("\n3 nolu student silindi.");

		System.out.println("\n== Tüm Kullanýcýlar ================");
		users = userManager.getAll();
		for (User user : users) {
			System.out.format("%6s%30s%35s", user.getId(), user.getFirstName() + " " + user.getLastName(), user.geteMail() + "\n");
		}

		System.out.println("\n== Eðitimciler ================");
		instructors = instructorManager.getAll();
		for (User instructor : instructors) {
			System.out.format("%6s%30s%35s", instructor.getId(), instructor.getFirstName() + " " + instructor.getLastName(), instructor.geteMail() + "\n");
		}

		System.out.println("\n== Öðrenciler ================");
		students = studentManager.getAll();
		for (User student : students) {
			System.out.format("%6s%30s%35s", student.getId(), student.getFirstName() + " " + student.getLastName(), student.geteMail() + "\n");
		}
		
	}

	private static void login() {
		boolean logged = false;
		Scanner kullaniciGirdisi = new Scanner(System.in);
		while (!logged) {
			System.out.println("LOGIN: ");
			System.out.print("E-Posta adresinizi giriniz: ");
			String email = kullaniciGirdisi.next();
			kullaniciGirdisi.nextLine();
			System.out.print("Parolanýzý giriniz: ");
			String password = kullaniciGirdisi.next();
			kullaniciGirdisi.nextLine();
			UserManager userManager = new UserManager();
			logged = userManager.login(email, password);
		}
		kullaniciGirdisi.close();

	}

}
