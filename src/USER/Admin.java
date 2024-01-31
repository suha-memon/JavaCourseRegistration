package USER;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import COURSE.Course;
import INTERFACES.AdminMng;

public class Admin extends User implements AdminMng{

	private ArrayList<Course> courses;
	private ArrayList<Student> students;
	
	public Admin() {
		super();
		this.courses = new ArrayList <Course>();
		this.students = new ArrayList <Student> ();
	}
	
	public ArrayList<Student> getStudents() {
		return students;
	}
	
	public void setStudents(ArrayList<Student> students) {
		this.students = students;
	}

	public ArrayList<Course> getCourses() {
		return courses;
	}
	
	public void setCourses(ArrayList<Course> courses) {
		this.courses = courses;
	}

	@Override
	public void createNewCourse(BufferedReader reader) throws IOException {
		/* Elements:
		 * Course name
		 * Course ID
		 * Course Instructor
		 * Section Number
		 * Location
		 */
		Course c = new Course();
		System.out.println("Enter the course name: ");
		String name = reader.readLine();
		System.out.println("Enter the course ID: ");
		String id = reader.readLine();
		System.out.println("Enter the maximum number of students that can register in the course: ");
		int maxreg = Integer.parseInt(reader.readLine());
		System.out.println("Enter the name of the course instructor: ");
		String instName = reader.readLine();
		System.out.println("Enter the section number: ");
		int sectNum = Integer.parseInt(reader.readLine());
		System.out.println("Enter the course location: ");
		String location = reader.readLine();
		
		c.setCourseName(name);
		c.setCourseID(id);
		c.setMaxRegistered(maxreg);
		c.setInstructor(instName);
		c.setSectionNumber(sectNum);
		c.setLocation(location);
		
		this.getCourses().add(c);
		
		// TODO Auto-generated method stub
	}

	@Override
	public void deleteCourse(String courseID, String courseName) {
		// TODO Auto-generated method stub
		for (int i = 0; i < this.getCourses().size(); i++) {
			if (this.getCourses().get(i).getCourseID().equals(courseID)) {
				this.getCourses().remove(i);
				System.out.println("Course " + courseID + " has been removed.\n");
			}
		}
	}

	@Override
	public void editCourse(BufferedReader reader, String courseID, String courseName) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("What do you want to edit about course " + courseID + "?");
		System.out.println("1. Maximum students registered in the course");
		System.out.println("2. Course instructor");
		System.out.println("3. Course section number");
		System.out.println("4. Course location");
		System.out.println("5. Exit");
		
		String selection = reader.readLine();
		
		// Find the course of interest
		
		if (selection.equals("1")) {
			for (int i = 0; i < this.getCourses().size(); i++) {
				if (this.getCourses().get(i).getCourseID().equals(courseID) && this.getCourses().get(i).getCourseName().equals(courseName)) {
					System.out.println("Enter the new maximum students that can register in course " + courseID + ":");
					int newMaxStudents = Integer.parseInt(reader.readLine());
					this.getCourses().get(i).setMaxRegistered(newMaxStudents);
				} else {
					System.out.println("Error: there is no course with that course ID");
				}
			}
		} else if (selection.equals("2")) {
			for (int i = 0; i < this.getCourses().size(); i++) {
				if (this.getCourses().get(i).getCourseID().equals(courseID) && this.getCourses().get(i).getCourseName().equals(courseName)) {
					System.out.println("Enter the name of the new course instructor for " + courseID + ":");
					String newName = reader.readLine();
					this.getCourses().get(i).setInstructor(newName);
				} else {
					System.out.println("Error: there is no course with that course ID");
				}
			}
		} else if (selection.equals("3")) {
			for (int i = 0; i < this.getCourses().size(); i++) {
				if (this.getCourses().get(i).getCourseID().equals(courseID) && this.getCourses().get(i).getCourseName().equals(courseName)) {
					System.out.println("Enter the new section number for course " + courseID + ":");
					int newSectionNum = Integer.parseInt(reader.readLine());
					this.getCourses().get(i).setSectionNumber(newSectionNum);
				} else {
					System.out.println("Error: there is no course with that course ID");
				}
			}
		} else if (selection.equals("4")) {
			for (int i = 0; i < this.getCourses().size(); i++) {
				if (this.getCourses().get(i).getCourseID().equals(courseID) && this.getCourses().get(i).getCourseName().equals(courseName)) {
					System.out.println("Enter the new maximum students that can register in course " + courseID + ":");
					String newLocation = reader.readLine();
					this.getCourses().get(i).setLocation(newLocation);
				} else {
					System.out.println("Error: there is no course with that course ID");
				}
			}
		} else if (selection.equals("5")) {
			return;
		} else {
			System.out.println("Error. You have selected an invalid option.");
		}
	}

	@Override
	public void displayCourseInfo(String courseID, String courseName) {
		// TODO Auto-generated method stub
		for (int i = 0; i < this.getCourses().size(); i++) {
			if (this.getCourses().get(i).getCourseID().equals(courseID) && this.getCourses().get(i).getCourseName().equals(courseName)) {
				System.out.println(this.getCourses().get(i).toString());
			}
		}
	}

	@Override
	public void registerStudent(BufferedReader reader, ArrayList<Student> studentList) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("Enter the student's first name: ");
		String first = reader.readLine();
		
		System.out.println("Enter the student's last name: ");
		String last = reader.readLine();
		
		System.out.println("Enter the student's username: ");
		String username = reader.readLine();
		System.out.println(username);
		System.out.println("Enter the student's password: ");
		String password = reader.readLine();
		System.out.println(password);
		Student c = new Student (username, password, first, last);
		studentList.add(c);
	}
	
	@Override
	public void exit() {
		// TODO Auto-generated method stub
		
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
	public void viewFullCourses() {
		for (Course c: this.courses) {
			if (c.getCurrentRegistered() == c.getMaxRegistered()) {
				System.out.println(c.toString());
			}
		}
		// TODO Auto-generated method stub
		
	}

	@Override
	public void documentFullCourses() {
		// TODO Auto-generated method stub
		try {
            FileWriter writer = new FileWriter("/Users/suhamemon/Documents/Suha/School/NYU/CSCI 102/CourseRegistration/src/DATA/FullCourses.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            for (Course c: this.courses) {
    			if (c.getCurrentRegistered() == c.getMaxRegistered()) {
    				bufferedWriter.write(c.toString() + "\n");
    			}
            } 
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}

	@Override
	public void viewRegisteredStudents(String courseID, String courseName) {
		for (Course c: this.courses) {
			if (c.getCourseID().equals(courseID) && c.getCourseName().equals(courseName)) {
				ArrayList<String> students = c.getRegisteredStudents();
				for (String student: students) {
					System.out.print(student + ", ");
				}
				System.out.println();
			}
		}
		// TODO Auto-generated method stub	
	}

	@Override
	public void viewStudentCourses(ArrayList<Student> studentsList, String username) {
		for (Student s: studentsList) {
			if(s.getUsername().equals(username)) {
				ArrayList<String> registeredCourses = s.getRegisteredCourses();
				for(String course: registeredCourses) {
					System.out.print(course + "\t");
				}
				System.out.println();
			}
		}
		// TODO Auto-generated method stub
	}

	@Override
	public void sortCourses() {
		
		Collections.sort(courses, new Comparator<Course>() {
			@Override
			public int compare(Course c1, Course c2) {
				return Integer.compare(c1.getCurrentRegistered(), c2.getCurrentRegistered());
				}
			});
		    for (Course c : courses) {
		      System.out.println(c.getCourseName() + ": " + c.getCurrentRegistered());
		    }
		
		
		// TODO Auto-generated method stub
		
	}
}
