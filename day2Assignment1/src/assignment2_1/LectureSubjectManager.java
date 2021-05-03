package assignment2_1;

public class LectureSubjectManager {
	public void add(LectureSubject lectureSubject) {
		LectureSubject[] lectureSubjects = Database.getInstance().lectureSubjects;
		LectureSubject[] tempLectureSubjects = lectureSubjects;
		lectureSubjects = new LectureSubject[lectureSubjects.length+1];
		
		for (int i = 0; i < tempLectureSubjects.length; i++) {
			lectureSubjects[i] = tempLectureSubjects[i];
		}
		
		
		Database.getInstance().lectureSubjectId += 1;
		int newId = Database.getInstance().lectureSubjectId;
		lectureSubject.id = newId;
		
		lectureSubjects[lectureSubjects.length-1] = lectureSubject;
		
		Database.getInstance().lectureSubjects = lectureSubjects;
	}

	public void addMultiple(LectureSubject[] lectureSubjects) {
		for (LectureSubject lectureSubject : lectureSubjects) {
			add(lectureSubject);
		}
	}
	
	public LectureSubject[] getAll() {
		return Database.getInstance().lectureSubjects;
	}
	
	public LectureSubject[] getByLectureId(int lectureId) {
		LectureSubject[] filteredLectureSubjects = new LectureSubject[0];
		LectureSubject[] tempLectureSubjects;
		for (LectureSubject lectureSubject : Database.getInstance().lectureSubjects) {
			if(lectureSubject.lectureId == lectureId) {
				tempLectureSubjects = filteredLectureSubjects;
				filteredLectureSubjects = new LectureSubject[filteredLectureSubjects.length+1];
				for (int i = 0; i < tempLectureSubjects.length; i++) {
					filteredLectureSubjects[i] = tempLectureSubjects[i];
				}
				filteredLectureSubjects[filteredLectureSubjects.length-1] = lectureSubject;
			}
		}
		return filteredLectureSubjects;
	}
	
	public LectureSubject getById(int lectureSubjectId) {
		for (LectureSubject lectureSubject : Database.getInstance().lectureSubjects) {
			if(lectureSubject.id == lectureSubjectId) {
				return lectureSubject;
			}
		}
		return null;
	}
}
