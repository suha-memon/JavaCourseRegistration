package USER;

import java.util.ArrayList;

import COURSE.Course;
import INTERFACES.StudentMng;

public class Student extends User implements StudentMng, java.io.Serializable{

private static final long serialVersionUID = 1L;
	//	private String[] registeredCourses;
	private ArrayList<String> registeredCourses;
	private ArrayList<Course> courses;
	
	
//	public Student(String[] registeredCourses) {
//		super();
//		this.registeredCourses = registeredCourses;
//		this.courses = new ArrayList <Course>();
//	}
	
	public Student(String username, String password, String firstName, String lastName) {
		super(username, password, firstName, lastName);
		this.setUsername(username);
		this.setPassword(password);
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.registeredCourses = new ArrayList<String>();
		this.courses = new ArrayList <Course>();
	}

	public ArrayList<String> getRegisteredCourses() {
		return registeredCourses;
	}

	public void setRegisteredCourses(ArrayList<String> registeredCourses) {
		this.registeredCourses = registeredCourses;
	}

	public ArrayList<Course> getCourses() {
		return courses;
	}

	public void setCourses(ArrayList<Course> courses) {
		this.courses = courses;
	}
	
	@Override
	public void viewAllCourses() {
		super.viewAllCourses();
//		// TODO Auto-generated method stub
//		for (Course c: this.getCourses()) {
//			System.out.println(c.toString());
//		}
	}
	
	@Override
	public void viewAvailableCourses() {
		// TODO Auto-generated method stub
		for (Course c: this.getCourses()) {
			if (c.getCurrentRegistered() <= c.getMaxRegistered()) {
				System.out.println(c.toString());
			}
		}
	}

	@Override
	public void register(String courseID, String section, String fullName) {
		// TODO Auto-generated method stub
		
		// Add the course name to list of student courses
		for (Course c: this.getCourses()) {
			if (c.getCourseID().equals(courseID) && c.getSectionNumber() == Integer.parseInt(section)) {
				this.getRegisteredCourses().add(courseID);
			}
		}
		
		// add student name to courselist.course. where coursename and section  = input
		for (Course c: this.getCourses()) {
			if (c.getCourseID().equals(courseID)) {
				c.getRegisteredStudents().add(fullName);
			}
		}
	}

	@Override
	public void withdraw(String fullName, String courseID) {
		// TODO Auto-generated method stub
		
		// Remove the course name from the list of student courses
		for (int i = 0; i < this.getRegisteredCourses().size(); i++) {
			if (this.getRegisteredCourses().get(i).equals(courseID)) {
				this.getRegisteredCourses().remove(i);
			} else {
				System.out.println("Error: you are not registered in this course, so we cannot remove you from it.");
			}
		}
		// remove student name from courselist.course. where coursename and section  = input
		for (Course c: this.getCourses()) {
			if (c.getCourseID().equals(courseID)) {
				c.getRegisteredStudents().remove(fullName);
			}
		}
	}

	@Override
	public void viewAllRegisteredCourses() {
		// TODO Auto-generated method stub
		System.out.print("You are registered in the following courses: ");
		for(String course: this.getRegisteredCourses()) {
			System.out.print(course + ", ");
		}
	}

	@Override
	public void exit() {
		// TODO Auto-generated method stub
		
	}
}
