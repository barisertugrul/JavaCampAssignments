package day3Assignment2;

import java.util.Date;

public class Comment {
	private int id;
	private int lectureSubjectId;
	private int userId;
	private Date date;
	private String content;

	public Comment() {

	}

	public Comment(int lectureSubjectId, int userId, Date date, String content) {
		this.id = 0;
		this.lectureSubjectId = lectureSubjectId;
		this.userId = userId;
		this.date = date;
		this.content = content;
	}

	public Comment(int id, int lectureSubjectId, int userId, Date date, String content) {
		
		this(lectureSubjectId, userId, date, content);
		this.id = id;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getLectureSubjectId() {
		return lectureSubjectId;
	}

	public void setLectureSubjectId(int lectureSubjectId) {
		this.lectureSubjectId = lectureSubjectId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
