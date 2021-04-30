package day3Assignment2;

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
		this(categoryId, instructorId, name, imagePath, description);
		this.id = id;
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
