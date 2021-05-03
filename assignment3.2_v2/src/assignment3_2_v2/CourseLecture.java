package assignment3_2_v2;

public class CourseLecture {
	int id;
	int courseId;
	String title;
	
	public CourseLecture() {
		
	}

	public CourseLecture(int id, int courseId, String title) {
		this( courseId, title );
		this.id = id;
	}

	public CourseLecture(int courseId, String title) {
		this.id = 0;
		this.courseId = courseId;
		this.title = title;
	}
}
