# JavaCourseRegistration


## Overview
This project is a course registration system that was created following OOP principles in Java. 


To create this course registration system, I went about many steps to create my design. First, I separated my code into multiple packages -- one for each element of my organizational design: COURSE, DATA, INTERFACES, MAIN, USER. I wanted to run everything from a main class, almost serving as an app. I chose this to be CourseRegistration.Java. Everything is run through this class. First, I start by serializing my course file and students/reading from the serialized files and populating arraylists. Afterward, I ask the user if they are a student or an admin. Based on their response, I authenticate them and then let them into the system. For the admin, I show the menus as indicated on the assignment. I do the same for student. Pretty much everywhere in my code, I try to authenticate the user as best as I can and allow the user to navigate the registration as best as they can. Using a do-while loop, I constantly bring up the menu every time they finish their old request. When the user enters an incorrect value, I prompt them to retry (almost everywhere). I utilized the concepts of method overloading and overriding in this main class. I also heavily used encapsulation everywhere in my code, since only my admin class and student classes can access courses. Below, I have indicated further specifications of my code. 

## Details/Specifications:
### COURSE:
Inside COURSE, I have my Course.java file. This is a serializable class that contains all of my variables and methods that pertain to creating, editing, deleting, and adding a course.
- Abstract Data Types: 
  - I have an ArrayList of registered students
### DATA:
All of the data that I create/access/modify goes into this package, including MyUniversityCourses.csv and the serializable files that I create.

## INTERFACES:
These interfaces have no methods defined and are simply signatures. 
### AdminMng: 
This is the interface for my admin class. Here, I have defined all of my admin methods
### StudentMng: 
This is my interface for my student class (similar to AdminMng)

## MAIN:
### CourseRegistration.Java
This is the main controller of my program. I have many helper methods within this class. My main method first loads serialized files if they exist, and populates all that it needs to. Then, it asks the user if they are a student or an admin. It authenticates them and then proceeds. 
- Method overloading
  - readSerialized()
    - Parameters can be either admin or student
    - This reads the pre-existing .ser file and creates an arraylist of courses
  - loadAndSerialize
    - Parameters can be either admin or student
    - This loads the CSV file and serializes it 
- Encapsulation:
  - I used encapsulation heavily in this class. Almost every method calls the admin or student class and alters the arraylists
  - studentList.getUsername()
  - adm.deleteCourse()
    
In addition, all of the methods alter courses in a similar way
- USER:
  - User.java: User is an abstract class
  - Admin.Java: Admin inherits from User, taking all of its constructors and methods
  - Student.Java: Student inherits from User, taking all of its constructors and methods
  - Method overriding: ViewAllCourses();
