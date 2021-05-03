package aAssignment3_2_v2;

public class CourseManager {

	public void add(Course course) {
		Course[] courses = Database.getInstance().courses;
		Course[] tempCourses = courses;
		courses = new Course[courses.length+1];
		
		for (int i = 0; i < tempCourses.length; i++) {
			courses[i] = tempCourses[i];
		}
		
		
		Database.getInstance().courseId += 1;
		int newId = Database.getInstance().courseId;
		course.id = newId;
		
		courses[courses.length-1] = course;
		
		Database.getInstance().courses = courses;
	}
	
	public Course[] getAll() {
		return Database.getInstance().courses;
	}
	
	public Course[] getByCategoryId(int categoryId) {
		Course[] filteredCourses = new Course[0];
		Course[] tempCourses;
		for (Course course : Database.getInstance().courses) {
			if(course.categoryId == categoryId) {
				tempCourses = filteredCourses;
				filteredCourses = new Course[filteredCourses.length+1];
				for (int i = 0; i < tempCourses.length; i++) {
					filteredCourses[i] = tempCourses[i];
				}
				filteredCourses[filteredCourses.length-1] = course;
			}
		}
		return filteredCourses;
	}
	
	public Course getById(int courseId) {
		for (Course course : Database.getInstance().courses) {
			if(course.id == courseId) {
				return course;
			}
		}
		return null;
	}
}
