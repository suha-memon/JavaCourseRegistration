package COURSE;

import java.util.ArrayList;

public class Course implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	// Private variables
	private String courseName;
	private String courseID;
	private int maxRegistered;
	private int currentRegistered;
	
	private ArrayList<String> registeredStudents;
	
//	private String[] registeredStudents;
	private String instructor;
	private int sectionNumber;
	private String location;
	
	// Constructor(s)
	public Course() {
		// constructor
	}
	public Course(String courseName, String courseID) {
		// constructor
		this.registeredStudents = new ArrayList <String>();
		this.courseName = courseName;
		this.courseID = courseID;
	}
	
	// Getters and Setters
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getCourseID() {
		return courseID;
	}
	public void setCourseID(String courseID) {
		this.courseID = courseID;
	}
	public int getMaxRegistered() {
		return maxRegistered;
	}
	public void setMaxRegistered(int maxRegistered) {
		this.maxRegistered = maxRegistered;
	}
	public int getCurrentRegistered() {
		return currentRegistered;
	}
	public void setCurrentRegistered(int currentRegistered) {
		this.currentRegistered = currentRegistered;
	}
//	public String[] getRegisteredStudents() {
//		return registeredStudents;
//	}
//	public void setRegisteredStudents(String[] registeredStudents) {
//		this.registeredStudents = registeredStudents;
//	}
	public String getInstructor() {
		return instructor;
	}
	public ArrayList<String> getRegisteredStudents() {
		return registeredStudents;
	}
	public void setRegisteredStudents(ArrayList<String> registeredStudents) {
		this.registeredStudents = registeredStudents;
	}
	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}
	public int getSectionNumber() {
		return sectionNumber;
	}
	public void setSectionNumber(int sectionNumber) {
		this.sectionNumber = sectionNumber;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	@Override
	public String toString() {
		return "Course Name: " + courseName + 
				"\t\t Course ID: " + courseID + 
				"\t Max Students: " + maxRegistered + 
				"\t Current Students: " + currentRegistered + 
				"\t List of Students: " +  arrayListToString() + 
				"\t Instructor: " + instructor + 
				"\t Section Number: " + sectionNumber + 
				"\t Location: " + location;
	}
	
	public String arrayListToString() {
		try {
			if(!(this.getRegisteredStudents().isEmpty())) {
				for (String name : this.getRegisteredStudents()) {
		            return name + ", ";
				}
			}
			return "";
		} catch (Exception e) {
			return "";
		}
	}
}
