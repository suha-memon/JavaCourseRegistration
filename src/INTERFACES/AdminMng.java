package INTERFACES;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

import USER.Student;

public interface AdminMng {

	// COURSE MANAGEMENT
	public void createNewCourse(BufferedReader reader) throws IOException ;
	// allows admin to create a new course
	
	public void deleteCourse(String courseID, String courseName);
	// allows admin to delete course
	
	public void editCourse(BufferedReader reader, String courseID, String courseName) throws IOException;
	// allows admin to edit course information except the courseID and courseName
	
	public void displayCourseInfo(String courseID, String courseName);
	// allows admin to display information for a given course (by course ID)
	
	public void registerStudent(BufferedReader reader, ArrayList<Student> studentList) throws IOException;
	// allows admin to add a student without assigning to a coursed
	// check Req 11 for student’s information 
	// Hint: You might need to have an ArrayList of Students where you store Student objects)
	
	public void exit();
	
	
	// REPORTS
	public void viewAllCourses();
	// for every course the admin should be able to see the list of 
	// - course name
	// - course id
	// - number of students registered
	// - the maximum number of students allowed to be registered)
	
	public void viewFullCourses();
	// View all courses that are FULL (reached the maximum number of students)
	
	public void documentFullCourses();
	// Write to a file the list of course that are Full
	
	public void viewRegisteredStudents(String courseID, String courseName);
	// View the names of the students being registered in a specific course
	
	public void viewStudentCourses(ArrayList<Student> studentsList, String username);
	// View the list of courses that a given student is being registered on 
	// (given a student first name and last name the system shall display all the courses that students is being registered in)
				
	public void sortCourses();
	// Sort courses based on the current number of student registers
}
