package assignment2_1;

public class Membership {
	int id;
	int courseId;
	int studentId;
	
	public Membership(int id, int courseId, int studentId) {
		this.id = id;
		this.courseId = courseId;
		this.studentId = studentId;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public int getId() {
		return id;
	}
}
