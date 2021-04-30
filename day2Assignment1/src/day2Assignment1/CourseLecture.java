package day2Assignment1;

public class CourseLecture {
	int id;
	int courseId;
	String title;
	
	public CourseLecture() {
		
	}

	public CourseLecture(int id, int courseId, String title) {
		this.id = id;
		this.courseId = courseId;
		this.title = title;
	}

	public CourseLecture(int courseId, String title) {
		this.id = 0;
		this.courseId = courseId;
		this.title = title;
	}
	
}
