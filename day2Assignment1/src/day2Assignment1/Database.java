package day2Assignment1;

public class Database {
	private static Database instance;
	User[] users;
	Instructor[] instructor;
	Student[] students;
	Course[] courses;
	CourseCategory[] courseCategories;
	CourseLecture[] courseLectures;
	LectureSubject[] lectureSubjects;
	SubjectCompletion[] subjectCompletions;
	Comment[] comments;
	CommentImage[] commentImages;
	Membership[] memberships;
	
	//Otomatik artan ID simülasyonu için
	int userId = 0;
	int instructorId = 0;
	int studentId = 0;
	int courseId = 0;
	int courseCategoryId = 0;
	int courseLectureId = 0;
	int lectureSubjectId = 0;
	int subjectCompletionId = 0;
	int commentId  =0;
	int commentImageId = 0;
	int membershipId = 0;


    public static Database getInstance() {
        if (instance == null) {
            instance = new Database();
            instance.users = new User[0];
            instance.students = new Student[0];
            instance.instructor = new Instructor[0];

            instance.courses = new Course[0];
            instance.courseCategories = new CourseCategory[]{new CourseCategory(1,"Yazýlým"), new CourseCategory(2,"Grafik Tasarým")};
            instance.courseLectures = new CourseLecture[0];
            instance.lectureSubjects = new LectureSubject[0];
            instance.subjectCompletions = new SubjectCompletion[0];
            instance.comments = new Comment[0];
            instance.commentImages = new CommentImage[0];
            instance.memberships = new Membership[0];
        }
        return instance;
    }
    
}
