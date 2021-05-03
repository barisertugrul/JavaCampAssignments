package assignment3_2_v2;

public class LectureSubject {
	int id;
	int lectureId;
	String icon;
	String title;
	String content;

	public LectureSubject() {
		
	}
	
	public LectureSubject(int id, int lectureId, String icon, String title, String content) {
		this(lectureId, icon, title, content);
		this.id = id;
	}
	
	public LectureSubject(int lectureId, String icon, String title, String content) {
		this.id = 0;
		this.lectureId = lectureId;
		this.icon = icon;
		this.title = title;
		this.content = content;
	}
	
}
