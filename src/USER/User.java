package USER;

import java.util.ArrayList;

import COURSE.Course;

public abstract class User {

	// Private variables
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private ArrayList<Course> courses;
	
	
	// Constructors
	public User(){
		
	}
	
	public User(String username, String password, String firstName, String lastName) {
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.setCourses(new ArrayList <Course>());
	}
	
	// Getters and Setters
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public ArrayList<Course> getCourses() {
		return courses;
	}
	public void setCourses(ArrayList<Course> courses) {
		this.courses = courses;
	}
	
	public void viewAllCourses() {
		// TODO Auto-generated method stub
		for (Course c: this.getCourses()) {
			System.out.println(c.toString());
		}
	}
	
	
	
}
