package day3Assignment2_v2;

public class Database {
	/*
	 * Database simülasyonu
	 * Diziler veri seti
	 * Classslar içinde gereksiz kod karmaþasý olmamasý için
	 * CRUD metotlarýný da buraya ekledim.
	 * Sonuçta bu gerçek bir yapý deðil
	*/
	
	private static Database instance;
	User[] users;
	Instructor[] instructors;
	Student[] students;
	Course[] courses;
	CourseCategory[] courseCategories;
	CourseLecture[] courseLectures;
	LectureSubject[] lectureSubjects;
	SubjectCompletion[] subjectCompletions;
	Comment[] comments;
	CommentImage[] commentImages;
	Membership[] memberships;
	
	//Otomatik artan ID simülasyonu için
	int userId = 0;
	//int instructorId = 0;
	//int studentId = 0;
	int courseId = 0;
	int courseCategoryId = 0;
	int courseLectureId = 0;
	int lectureSubjectId = 0;
	int subjectCompletionId = 0;
	int commentId  =0;
	int commentImageId = 0;
	int membershipId = 0;


    public static Database getInstance() {
        if (instance == null) {
            instance = new Database();
            instance.users = new User[0];
            instance.students = new Student[0];
            instance.instructors = new Instructor[0];

            instance.courses = new Course[0];
            instance.courseCategories = new CourseCategory[]{new CourseCategory(1,"Yazýlým"), new CourseCategory(2,"Grafik Tasarým")};
            instance.courseLectures = new CourseLecture[0];
            instance.lectureSubjects = new LectureSubject[0];
            instance.subjectCompletions = new SubjectCompletion[0];
            instance.comments = new Comment[0];
            instance.commentImages = new CommentImage[0];
            instance.memberships = new Membership[0];
        }
        return instance;
    }
    
    public int addUser(User user, User[] userDB) {
    	
    	//Kötü kod: userDB'yi referans olarak alamadýðým için
    	//user nesnesinin gerçek classýna göre
    	//veritabaný temsili tablosunu seçtiriyorum
    	//Test için her durumda gelen user bilgisini users tablosuna ekliyorum
    	int lastId = addBaseUser(user);
    	user.setId(lastId);
    	if(user.getClass().equals(User.class)) {
			  return lastId;
		}else if(user.getClass().equals(Student.class)) {
			  return addStudent((Student) user);
		}else if(user.getClass().equals(Instructor.class)){
			  return addInstructor((Instructor) user);
		}else{
			  return 0;
		}
		  /*
		   * User[] tempUsers = userDB;
		   * userDB = new User[userList.length+1];
			 * 
			 * for (int i = 0; i < tempUsers.length; i++) {
			 *  userDB[i] = tempUsers[i]; 
			 *  }
			 * 
			 * this.userId += 1;
			 * int newId = this.userId;
			 * user.setId(newId);
			 * 
			 * userDB[userDB.length-1] = user;
			 * 
			 * return newId;
		   */
    }
    
    public void update(User user) {
    	if(user.getClass().equals(Student.class)) {
			  updateStudent((Student) user);
		}
    	if(user.getClass().equals(Instructor.class)){
			  updateInstructor((Instructor) user);
		}
    	updateUser(user);
    }
    
    public void delete(User user) {
    	if(user.getClass().equals(Student.class)) {
			deleteStudent((Student) user);
    	}
		if(user.getClass().equals(Instructor.class)){
			deleteInstructor((Instructor) user);
		}
			deleteUser(user);
    }
    
	private void deleteUser(User user) {
    	User[] tempUsers = new User[this.users.length-1];
    	int i = 0;
    	for (User userItem : this.users) {
			if(userItem.getId() != user.getId()) {
				tempUsers[i] = userItem;
				i++;
			}
		}
    	this.users = tempUsers;
	}

	private void deleteInstructor(Instructor instructor) {
    	Instructor[] tempInstructors = new Instructor[this.instructors.length-1];
    	int i = 0;
    	for (Instructor instructorItem : this.instructors) {
			if(instructorItem.getId() != instructor.getId()) {
				tempInstructors[i] = instructorItem;
				i++;
			}
		}
    	this.instructors = tempInstructors;
	}

	private void deleteStudent(Student student) {
    	Student[] tempStudents = new Student[this.students.length-1];
    	int i = 0;
    	for (Student studentItem : this.students) {
			if(studentItem.getId() != student.getId()) {
				tempStudents[i] = studentItem;
				i++;
			}
		}
    	this.students = tempStudents;
	}

	/*
	 * public int addUser(User user) { User[] userList = this.users; User[]
	 * tempUsers = userList; userList = new User[userList.length+1];
	 * 
	 * for (int i = 0; i < tempUsers.length; i++) { userList[i] = tempUsers[i]; }
	 * 
	 * 
	 * this.userId += 1; int newId = this.userId; user.setId(newId);
	 * 
	 * userList[userList.length-1] = user;
	 * 
	 * this.users = userList;
	 * 
	 * return newId; }
	 */
    
    private int addBaseUser(User user) {
    	User[] userList = this.users;
		User[] tempUsers = userList;
		userList = new User[userList.length+1];
		
		for (int i = 0; i < tempUsers.length; i++) {
			userList[i] = tempUsers[i];
		}
		
		
		this.userId += 1;
		int newId = this.userId;
		user.setId(newId);
		
		userList[userList.length-1] = user;
		
		this.users = userList;
		
		return newId;
    }
    
    private int addInstructor(Instructor instructor) {
    	Instructor[] instructors = this.instructors;
		Instructor[] tempInstructors = instructors;
		instructors = new Instructor[instructors.length+1];
		
		for (int i = 0; i < tempInstructors.length; i++) {
			instructors[i] = tempInstructors[i];
		}
		
		instructors[instructors.length-1] = instructor;
		
		this.instructors = instructors;
		return instructor.getId();
    }
    
    private int addStudent(Student student) {
    	Student[] students = this.students;
		Student[] tempStudents = students;
		students = new Student[students.length+1];
		
		for (int i = 0; i < tempStudents.length; i++) {
			students[i] = tempStudents[i];
		}
		
		students[students.length-1] = student;
		
		this.students = students;
		return student.getId();
    }
    
    private void updateUser(User user) {
    	User updatedUser = new User();
    	for (User userItem : this.users) {
			if(userItem.getId() == user.getId()) {
				updatedUser = userItem;
				break;
			}
		}
    	if(updatedUser != null) {
    		updatedUser = user;
    	}
    }
    
    private void updateInstructor(Instructor instructor) {
    	Instructor updatedInstructor = new Instructor();
    	for (Instructor instructorItem : this.instructors) {
			if(instructorItem.getId() == instructor.getId()) {
				updatedInstructor = instructorItem;
				break;
			}
		}
    	if(updatedInstructor != null) {
    		updatedInstructor = instructor;
    	}
    }
    
    private void updateStudent(Student student) {
    	Student updatedStudent = new Student();
    	for (Student studentItem : this.students) {
			if(studentItem.getId() == student.getId()) {
				updatedStudent = studentItem;
				break;
			}
		}
    	if(updatedStudent != null) {
    		updatedStudent = student;
    	}
    }
    
    public User getUserById(int userId) {
    	for (User user : users) {
			if(user.getId() == userId) {
				return user;
			}
		}
    	return null;
    }
    
    public Instructor getInstructorById(int instructorId) {
    	for (Instructor instructor : instructors) {
			if(instructor.getId() == instructorId) {
				return instructor;
			}
		}
    	return null;
    }
    
    public Student getStudentById(int studentId) {
    	for (Student student : students) {
			if(student.getId() == studentId) {
				return student;
			}
		}
    	return null;
    }
    
    
    public User login(String email, String password) {
    	for (User user : users) {
			if(user.geteMail().equals(email) && user.getPassword().equals(password)) {
				return user;
			}
		}
    	return null;
    }
}
