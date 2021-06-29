package Excercise;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* Welcome to an exercise to create a School enrollment system.
 * Go through the code in this file and read the comments to
 * see what is required....Everywhere there is a TODO!
 * comment you'll need to write some code.
 */

public class School {
	// We are going to make a School enrollment system!
	// To do that we are going to keep track of students,
	// which we'll represent by a String holding their name,
	// and courses, which will also be represented by a String
	// holding the courses name.

	// While dealing with enrollments, we are going to have to
	// 1. Look up by course, to get a list of all students taking a course.
	// 2. Look up by student, to get a list of all courses a student is taking.
	// We need to make data structures to make this possible.

	// We are going to define the enrollments as fields of School

	// Define and initialize an empty map variable called "courses" here where you
	// can lookup a course by it's name (key), and get a list of
	// students (value):
	// TODO!

	HashMap<String, LinkedList<String>> courses = new HashMap<String, LinkedList<String>>();

	// ^^^^^^^^^^^ Define "courses" above this line ^^^^^^^^^^^^^^^^^^^^^^^

	// Define and initialize a second empty map variable called "students"
	// where you can lookup a student by their name (key), and get a list of
	// courses (value) they are taking:
	// TODO!
	HashMap<String, LinkedList<String>> students = new HashMap<String, LinkedList<String>>();

	// ^^^^^^^^^^^ Define "students" above this line ^^^^^^^^^^^^^^^^^^^^^^^

	// You should be able to access the fields you just defined from anywhere
	// inside this class.

	// Next we are going to define an "enroll" method.
	public void enroll(String courseName, String studentName) {
		// Write code here to update the "courses" and "students"
		// map variables, based on a courseName and studentName
		// variable passed into the method. Add the student
		// to the course in 'courses', and add the course to the
		// to the student in 'students'.

		if (!courses.containsKey(courseName)) {
			courses.put(courseName, new LinkedList<String>());
		}

		LinkedList<String> courseStudents = courses.get(courseName);

		if (courseStudents.contains(studentName)) {
			return;
		}

		courseStudents.add(studentName);

		if (!students.containsKey(studentName)) {
			students.put(studentName, new LinkedList<String>());
		}

		LinkedList<String> studentCourses = students.get(studentName);

		studentCourses.add(courseName);

		// Note: when a student enrolls in a course twice, it should
		// detect this, and prevent duplicate enrollments.
		// TODO!
	}

	public void drop(String courseName, String studentName) {
		// Write code here to remove an enrollment,
		// undoing the changes that an enroll call does.

		// Note: silently ignore drops for students and courses
		// combinations that don't exist.

		// Bonus: if course enrollment drops to zero students
		// for a course, remove the course from
		// 'courses'.....
		// and
		// if a student now has zero courses they are
		// taking, drop the student from 'students'
		// TODO!
		
		if(courses.containsKey(courseName)) {
			LinkedList<String> myList =courses.get(courseName);
			myList.remove(studentName);
			if(myList.isEmpty()) {
				courses.remove(courseName);
			}
		}
		
		if(students.containsKey(studentName)) {
			LinkedList<String> myList = students.get(studentName);
			myList.remove(courseName);	
			
			if(myList.isEmpty()) {
				students.remove(studentName);
			}
		}
			
	}

	public void printAllCourses() {
		// Write code to print all courses. You can get them from
		// the keys of the 'courses' variable.
		//
		// You'll want to lookup how to get all the keys of a Map.

		// Bonus: When you display each course, display the number
		// of students in it.

		// Bonus: alphabetize the courses. (Look up Collections in\
		// the java documentation)
		// TODO!

		courses.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(System.out::println);

	}

	public void printAllStudents() {
		// Write code to print all the students.
		// Bonus: When you display each student, display the number
		// of courses the student is taking.
		// Bonus: alphabetize the student names.
		students.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(System.out::println);

	}

	public void printStudentsInCourse(String course) {
		// Write code to print all the students taking the course.
		// Bonus: alphabetize the student names.
		// Bonus: Print nothing, rather than having an error
		// if course does not exist
		// TODO!

		// loop through the hash map and return each key/value pair

		// loop through the hash map and return each key/value pair
		if (courses.containsKey(course)) {
			
			List<String> studentList = courses.get(course);
			Collections.sort(studentList);
			System.out.println(studentList);

		} else {
			System.out.println("error");
		}

	}

	public void printCoursesTakenByStudent(String student) {
		// Write code to print all the courses taken by a particular
		// student.
		// Bonus: alphabetize the student names.
		// Bonus: Print nothing, rather than having an error
		// if student does not exist
		// TODO!
		if(students.containsKey(student)) {
			List <String> courseByStudent = students.get(student);
			Collections.sort(courseByStudent);
			System.out.println(courseByStudent);
		}
	}

	// You won't need a main method, Test has a main method that calls
	// all the methods in this. Run Test.java as Java Application to
	// test your code.
}
