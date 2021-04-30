package day2Assignment1;

public class Course {
	int id;
	int categoryId;
	int instructorId;
	String name;
	String imagePath;
	String description;
	int starsCount = 0;
	
	public Course() {
		
	}
	
	public Course(int id, int categoryId, int instructorId, String name, String imagePath, String description) {
		this.id = id;
		this.categoryId = categoryId;
		this.instructorId = instructorId;
		this.name = name;
		this.imagePath = imagePath;
		this.description = description;
		this.starsCount = 0;
	}
	
	public Course(int categoryId, int instructorId, String name, String imagePath, String description) {
		this.id = 0;
		this.categoryId = categoryId;
		this.instructorId = instructorId;
		this.name = name;
		this.imagePath = imagePath;
		this.description = description;
		this.starsCount = 0;
	}
}
