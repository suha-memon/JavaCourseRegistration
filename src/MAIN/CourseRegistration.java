package MAIN;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import COURSE.Course;
import USER.Admin;
import USER.Student;

public class CourseRegistration {

	public static String getProjectDirectory() {
		String currentDirectory = System.getProperty("user.dir");
		System.setProperty("user.dir", currentDirectory);
		currentDirectory = System.getProperty("user.dir");
		return currentDirectory;
	}
	
	public static void serialize (ArrayList<Course> courseList){
		try {
			String path = getProjectDirectory() + "/src/DATA/CoursesSer.ser";
			FileOutputStream fos = new FileOutputStream(path);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(courseList);
			//Close both streams
			oos.close();
			fos.close();
//			System.out.println("Serialization complete");
		} 
		catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
	
	public static void serializeStudents (ArrayList<Student> studentsList){
		try {
			String path = getProjectDirectory() + "/src/DATA/StudentsSer.ser";
			FileOutputStream fos = new FileOutputStream("path");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(studentsList);
			//Close both streams
			oos.close();
			fos.close();
//			System.out.println("Serialization complete");
		} 
		catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
	
	public static void readSerialized(File filename, Admin adm) {
    	try (FileInputStream fis = new FileInputStream(filename);
    			ObjectInputStream ois = new ObjectInputStream(fis);) {
    		adm.setCourses((ArrayList) ois.readObject());
//    		for (Course c: adm.getCourses()) {
//    			System.out.println(c.toString());
//    		}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (ClassNotFoundException c) {
			System.out.println("Class not found");
			c.printStackTrace();
		}
	}
	
	public static void readSerialized(File filename, Student stu) {
    	try (FileInputStream fis = new FileInputStream(filename);
    			ObjectInputStream ois = new ObjectInputStream(fis);) {
    		stu.setCourses((ArrayList) ois.readObject());
//    		for (Course c: adm.getCourses()) {
//    			System.out.println(c.toString());
//    		}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (ClassNotFoundException c) {
			System.out.println("Class not found");
			c.printStackTrace();
		}
	}
		
	public static void readSerializedStudents(File filename, ArrayList<Student> studentList) {
    	try (FileInputStream fis = new FileInputStream(filename);
    			ObjectInputStream ois = new ObjectInputStream(fis);) {
    		studentList = (ArrayList) ois.readObject();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (ClassNotFoundException c) {
			System.out.println("Class not found");
			c.printStackTrace();
		}
	}
	
	public static void loadAndSerialize(Admin adm) {
		String coursePath = getProjectDirectory() + "/src/DATA/MyUniversityCourses.csv";
		String line = null;
		try (BufferedReader br = new BufferedReader(new FileReader(coursePath))) {
			br.readLine();
            while ((line = br.readLine()) != null) {
            	String[] values = line.split(",");
                Course course = new Course();
                course.setCourseName(values[0]);
                course.setCourseID(values[1]);
                course.setMaxRegistered(Integer.parseInt(values[2]));
                course.setCurrentRegistered(Integer.parseInt(values[3]));
                course.setInstructor(values[5]);
                course.setSectionNumber(Integer.parseInt(values[6]));
                course.setLocation(values[7]);
                adm.getCourses().add(course);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
		serialize(adm.getCourses());
	}
	
	public static void loadAndSerialize(Student stu) {
		String coursePath = getProjectDirectory() + "/src/DATA/MyUniversityCourses.csv";
		String line = null;
		try (BufferedReader br = new BufferedReader(new FileReader(coursePath))) {
			br.readLine();
            while ((line = br.readLine()) != null) {
            	String[] values = line.split(",");
                Course course = new Course();
                course.setCourseName(values[0]);
                course.setCourseID(values[1]);
                course.setMaxRegistered(Integer.parseInt(values[2]));
                course.setCurrentRegistered(Integer.parseInt(values[3]));
                course.setInstructor(values[5]);
                course.setSectionNumber(Integer.parseInt(values[6]));
                course.setLocation(values[7]);
                stu.getCourses().add(course);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
		serialize(stu.getCourses());
	}
	
	public static void adminMenu(BufferedReader reader, Admin adm, ArrayList<Student> studentList, String [] args) throws IOException {
		String choiceF = " ";
		String choiceS = " ";
		System.out.println("What would you like to do?");
		System.out.println("1. Course management\n2. Reports");
		choiceF = reader.readLine();
		
		if (choiceF.equals("1")) {	
			do { // print the options
				System.out.println("------- MENU -------");
				System.out.println("1. Create a new course");
				System.out.println("2. Delete a course");
				System.out.println("3. Edit a course");
				System.out.println("4. Display course");
				System.out.println("5. Register a student");
				System.out.println("6. Exit");
				choiceS = reader.readLine();
				// Prompt system to tell admin what to do
				if (choiceS.equals("1")) {
					adm.createNewCourse(reader);
				} else if (choiceS.equals("2")) {
					System.out.println("Enter the course ID for the course you wish to delete");
					String courseID = reader.readLine();
					System.out.println("Enter the course name for the course you wish to delete");
					String courseName = reader.readLine();
					adm.deleteCourse(courseID, courseName);
				} else if (choiceS.equals("3")) {
					System.out.println("Enter the course ID for the course you wish to edit");
					String courseID = reader.readLine();
					System.out.println("Enter the course name for the course you wish to edit");
					String courseName = reader.readLine();
					adm.editCourse(reader, courseID, courseName);
				} else if (choiceS.equals("4")) {
					System.out.println("Enter the course ID for the course you wish to view");
					String courseID = reader.readLine();
					System.out.println("Enter the course name for the course you wish to view");
					String courseName = reader.readLine();
					adm.displayCourseInfo(courseID, courseName);
				} else if (choiceS.equals("5")) {
					adm.registerStudent(reader, studentList);
					serializeStudents(studentList);
					for(Student s: studentList) {
						System.out.println(s.getUsername());
						System.out.println(s.getPassword());
					}
				}
			} while (!choiceS.equals("6"));
				if (choiceS.equals("6")) { // exit app
					System.out.println("\nThank you for using our app!");
					serialize(adm.getCourses());
					serializeStudents(studentList);
					main(args);
				}
		} else if(choiceF.equals("2")) {
			do { // print the options
				System.out.println("------- MENU -------");
				System.out.println("1. View all courses");
				System.out.println("2. View full courses");
				System.out.println("3. Write to a file the list of course that are full");
				System.out.println("4. View the names of the students being registered in a specific course");
				System.out.println("5. View the list of courses that a given student is being registered on");
				System.out.println("6. Sort courses based on the current number of student registers");
				System.out.println("7. Exit");
				choiceS = reader.readLine();
				
				if (choiceS.equals("1")) {
					adm.viewAllCourses();
				} else if (choiceS.equals("2")) {
					adm.viewFullCourses();
				} else if (choiceS.equals("3")) {
					adm.documentFullCourses();
				} else if (choiceS.equals("4")) {
					System.out.println("Enter the Course ID you are interested in: ");
					String courseID = reader.readLine();
					System.out.println("Enter the Course name you are interested in: ");
					String courseName = reader.readLine();
					adm.viewRegisteredStudents(courseID, courseName);
				} else if (choiceS.equals("5")) {
					System.out.println("Enter the student's username: ");
					String username = reader.readLine();
					adm.viewStudentCourses(studentList, username);
				} else if (choiceS.equals("6")) {
					adm.sortCourses();
				}
			} while (!choiceS.equals("7"));
				if (choiceS.equals("7")) { // exit app
					System.out.println("\nThank you for using our app!");
					serialize(adm.getCourses());
					main(args);
				}
			
		} else {
			System.out.println("You have selected the wrong choice");
			main(args);
		}
		
	}
	
	
	public static void studentMenu(BufferedReader reader, Student stu, ArrayList<Student> studentList, String [] args) throws IOException {
		String choice = " ";
		do { // print the options
			System.out.println("------- MENU -------");
			System.out.println("1. View all courses");
			System.out.println("2. View courses that are not full");
			System.out.println("3. Register in a course");
			System.out.println("4. Withdraw from a course");
			System.out.println("5. View courses that I am currently registered in");
			System.out.println("6. Exit");
			choice = reader.readLine();
			
			if (choice.equals("1")) {
				stu.viewAllCourses();
			} else if (choice.equals("2")) {
				stu.viewAvailableCourses();
			} else if (choice.equals("3")) {
				System.out.println("Enter your full name:");
				String fullName = reader.readLine();
				System.out.println("Enter the course ID:");
				String courseID = reader.readLine();
				System.out.println("Enter the course section number:");
				String sectionNumber = reader.readLine();
				stu.register(fullName, courseID, sectionNumber);
			} else if (choice.equals("4")) {
				System.out.println("Enter your full name:");
				String fullName = reader.readLine();
				System.out.println("Enter the course ID:");
				String courseID = reader.readLine();
//				System.out.println("Enter the course section number:");
//				String sectionNumber = reader.readLine();

				stu.withdraw(fullName, courseID);
			} else if (choice.equals("5")) {
				stu.viewAllRegisteredCourses();
			} else {
				System.out.println("You have selected the wrong choice");
				main(args);
			}
		} while (!choice.equals("7"));
			if (choice.equals("7")) { // exit app
				System.out.println("\nThank you for using our app!");
				serialize(stu.getCourses());
				serializeStudents(studentList);
				main(args);
			}
		
	}
	
	public static void main (String[] args) throws IOException {	
		// Create scanner object
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		// Asks user to input if they are a student or admin
		System.out.println("Welcome to NYU's course registration system. Are you a student or an admin?");
		// Changes input to lowecase to account for typing case
		String userInput = reader.readLine().toLowerCase();
		ArrayList<Student> studentList = new ArrayList <Student>();
		// check if students exist. If so, load them into the arraylist
//		String path = getProjectDirectory() + "/src/DATA/StudentsSer.ser";
		File studentsFile = new File((getProjectDirectory() + "/src/DATA/StudentsSer.ser"));
		if (studentsFile.exists()) {
			readSerializedStudents(studentsFile, studentList); // read serialized file
			for (Student s: studentList) {
				System.out.println(s.getUsername());
			}
		} else {
			System.out.println("No students exist");
		}
		// if users do not exist, create an arraylist of students
		
		if (userInput.equals("admin")) {
			
			System.out.println("Enter admin username:");
			String username = reader.readLine();
			System.out.println("Enter admin password:");
			String password = reader.readLine();
			
			if(username.equals("Admin") && password.equals("Admin001")) {
				// Create admin
				System.out.println("You are an admin");
				Admin adm1 = new Admin();
				
				// Check if serialized file exists
				
				String path = getProjectDirectory() + "/src/DATA/CoursesSer.ser";
				
				File courseFile = new File(path);
				if (courseFile.exists()) {
//					System.out.println("Serialized file exists");
					readSerialized(courseFile, adm1); // If the file exists, create an arraylist of courses in admin
				} else { // If does not exist, load the CSV file
//					System.out.println("Serialized file does not exist");
					loadAndSerialize(adm1);
		        }
				// Helper function for admin menu
				adminMenu(reader, adm1, studentList, args);
			} else {
				System.out.println("Username and password are incorrect");
			}
		} else if (userInput.equals("student")) {	
			System.out.println("Enter student username:");
			String username = reader.readLine();
			System.out.println("Enter student password:");
			String password = reader.readLine();	
			// Authenticate student2
			Boolean authenticated = false;
			for (int i = 0; i < studentList.size(); i++) {
				System.out.println(studentList.get(i).getUsername());
				System.out.println(studentList.get(i).getPassword());
				if (studentList.get(i).getUsername().equals(username) &&  studentList.get(i).getPassword().equals(password) ) {
					authenticated = true;
					// Check if serialized file exists
					
					String path = getProjectDirectory() + "/src/DATA/CoursesSer.ser";
					File courseFile = new File(path);
					if (courseFile.exists()) {
//						System.out.println("Serialized file exists");
						readSerialized(courseFile, studentList.get(i)); // If the file exists, create an arraylist of courses in admin
					} else { // If does not exist, load the CSV file
//						System.out.println("Serialized file does not exist");
						loadAndSerialize(studentList.get(i));
			        }
					// Helper function for admin menu
					studentMenu(reader, studentList.get(i), studentList, args);
				}
			}
			if (!authenticated) {
				System.out.println("Username or password is incorrect. Redirecting you to the main menu.");
				main(args);
			}	
		} else { // If user inputs something that is not "student" or "admin"
			System.out.println("You have indicated that you are neither a student nor an admin. Please try again.");
			System.out.println();
			main(args);
		}
	}
}