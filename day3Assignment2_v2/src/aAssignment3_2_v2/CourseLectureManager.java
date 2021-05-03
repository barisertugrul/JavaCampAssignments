package aAssignment3_2_v2;

public class CourseLectureManager {

	public void add(CourseLecture courseLecture) {
		CourseLecture[] courseLectures = Database.getInstance().courseLectures;
		CourseLecture[] tempCourseLectures = courseLectures;
		courseLectures = new CourseLecture[courseLectures.length+1];
		
		for (int i = 0; i < tempCourseLectures.length; i++) {
			courseLectures[i] = tempCourseLectures[i];
		}
		
		
		Database.getInstance().courseLectureId += 1;
		int newId = Database.getInstance().courseLectureId;
		courseLecture.id = newId;
		
		courseLectures[courseLectures.length-1] = courseLecture;
		
		Database.getInstance().courseLectures = courseLectures;
	}
	
	public CourseLecture[] getAll() {
		return Database.getInstance().courseLectures;
	}

	public void addMultiple(CourseLecture[] courseLectures) {
		for (CourseLecture courseLecture : courseLectures) {
			add(courseLecture);
		}
	}
	
	public CourseLecture[] getByCourseId(int courseId) {
		CourseLecture[] filteredCourseLectures = new CourseLecture[0];
		CourseLecture[] tempCourseLectures;
		for (CourseLecture courseLecture : Database.getInstance().courseLectures) {
			if(courseLecture.courseId == courseId) {
				tempCourseLectures = filteredCourseLectures;
				filteredCourseLectures = new CourseLecture[filteredCourseLectures.length+1];
				for (int i = 0; i < tempCourseLectures.length; i++) {
					filteredCourseLectures[i] = tempCourseLectures[i];
				}
				filteredCourseLectures[filteredCourseLectures.length-1] = courseLecture;
			}
		}
		return filteredCourseLectures;
	}
	
	public CourseLecture getById(int courseLectureId) {
		for (CourseLecture courseLecture : Database.getInstance().courseLectures) {
			if(courseLecture.id == courseLectureId) {
				return courseLecture;
			}
		}
		return null;
	}
}
