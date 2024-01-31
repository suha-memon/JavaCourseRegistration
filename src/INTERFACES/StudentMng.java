package INTERFACES;

public interface StudentMng {

	// Course Management
	
	public void viewAllCourses();
	// View all courses (in USER)
	
	public void viewAvailableCourses();
	// View all courses that are not FULL
	
	public void register(String courseID, String section, String fullName);
	// Register for a course (in this case the student must enter the course name, section, and student full name, the name will be added to the appropriate course) 
	
	public void withdraw(String fullName, String courseID);
	// Withdraw from a course (in this case the student will be asked to enter her/his student name and the course, then the name of the student will be taken off from the given course’ list)
	
	public void viewAllRegisteredCourses();
	//	View all courses that the current student is being registered in
	
	public void exit();
	// Exit
	
}
