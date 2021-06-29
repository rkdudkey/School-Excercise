package Excercise;

//This file should not be changed except as necessary 
//to simplify testing.
public class Test
{
  //Main runs a set of tests on School.java
  public static void main(String[] args)
  {
      School school = new School();
      System.out.println("Doing enrollments!");

      school.enroll("ART 175", "Mohammed Grisi");
      school.enroll("CS 150", "Natalie Ha");
      school.enroll("LIT 250", "Natalie Ha");
      school.enroll("LIT 250", "Montero Green");
      school.enroll("PHYS 200", "Philip Duncan");
      school.enroll("LIT 250", "Natalie Ha");
      school.enroll("LIT 250", "Philip Duncan");
      school.enroll("BIO 100", "Peter Espinoza");
      school.enroll("CS 150", "Montero Green");
      school.enroll("ART 175", "Micha Gupta");
      school.enroll("CS 150", "Natalie Ha");
      school.enroll("CALC 200", "Nicole Doyle");
      school.enroll("BIO 100", "Maria Hong");
      school.enroll("CALC 200", "Philip Duncan");
      school.enroll("LIT 250", "Micha Gupta");
      school.enroll("ART 175", "Nicole Doyle");
      school.enroll("LIT 250", "Micha Gupta");
      school.enroll("PHYS 200", "Maria Hong");
      school.enroll("PHYS 200", "Mark Holtz");
      school.enroll("LIT 250", "Micha Gupta"); // This is a duplicate enrollment
      school.enroll("LIT 250", "Nicole Doyle");
      school.enroll("CALC 200", "Maria Hong");
      school.enroll("PHYS 200", "Natalie Ha");
      school.enroll("BIO 100", "Mathew Franzomi");
      school.enroll("CALC 200", "Mark Holtz");
      school.enroll("LIT 250", "Maria Hong");
      school.enroll("CALC 200", "Maria Hong");
      school.enroll("ART 175", "Mathew Franzomi");
      school.enroll("ART 175", "Montero Green");
      school.enroll("ART 175", "Philip Duncan");
      school.enroll("LIT 250", "Nicole Doyle");
      school.enroll("LIT 250", "Philip Duncan");
      school.enroll("ART 175", "Mark Holtz");
      school.enroll("BIO 100", "Mark Holtz");
      school.enroll("CALC 200", "Montero Green");
      school.enroll("BIO 100", "Maria Hong");
      school.enroll("LIT 250", "Maria Hong");
      school.enroll("LIT 250", "Nicole Doyle");
      school.enroll("ART 175", "Peter Espinoza");
      school.enroll("LIT 250", "Peter Espinoza");

      System.out.println("There should be 10 unique students listed after this:");
      System.out.println("Bonus: The number of classes the student is taking should be listed.");
      System.out.println("Bonus: They should be sorted.");
      System.out.println("===================================================");
      school.printAllStudents();
      System.out.println();

      System.out.println("There should be 6 unique courses listed after this:");
      System.out.println("Bonus: The number of students in each class should be listed.");
      System.out.println("Bonus: They should be sorted.");
      System.out.println("===================================================");
      school.printAllCourses();
      System.out.println();

      System.out.println("There should be 7 unique students listed as taking LIT 250:");
      System.out.println("Bonus: They should be sorted.");
      System.out.println("===================================================");
      school.printStudentsInCourse("LIT 250");
      System.out.println();

      System.out.println("There should be 2 classes listed as being taken by Micha Gupta:");
      System.out.println("Bonus: They should be sorted.");
      System.out.println("===================================================");
      school.printCoursesTakenByStudent("Micha Gupta");
      System.out.println();

      
      System.out.println("Testing course dropping:");
      school.drop("PHYS 200", "Mark Holtz");
      school.drop("CALC 200", "Mark Holtz");
      System.out.println("There should be 2 classes listed: ART 175, and BIO 100");
      System.out.println("===================================================");
      school.printCoursesTakenByStudent("Mark Holtz");
      System.out.println();

      System.out.println("Testing bad drops.. this should not trigger an error");
      System.out.println("===================================================");
      boolean successFlag = false;
      try
      {
          school.drop("XXX", "Nicole Doyle");
          school.drop("CALC 200", "XXXX");
          successFlag = true;
      }
      catch(Exception e)
      {
          System.out.println("Test failed, an error occured:");
          e.printStackTrace();
          System.out.println(e);
      }
      if(successFlag)
      {
          System.out.println("No error detected.");
      }
      System.out.println();

      System.out.println("BONUS: Testing if when a student has no courses, they disappear!");
      school.drop("ART 175", "Mark Holtz");
      school.drop("BIO 100", "Mark Holtz");
      school.drop("CALC 200", "Mark Holtz");

      System.out.println("Mark Holtz should not be listed:");
      System.out.println("===================================================");
      school.printAllStudents();
      System.out.println(); 

      System.out.println("BONUS: Testing if when a course has no students, it disappears!");
      school.drop("CS 150", "Natalie Ha");
      school.drop("CS 150", "Montero Green");
      System.out.println("CS 150 should not be listed:");
      System.out.println("===================================================");
      school.printAllCourses();
      System.out.println();

      successFlag = false;
      System.out.println("BONUS: Testing if printStudentsInCourse() displays an");
      System.out.println("empty list when course doesn't exist");
      System.out.println("===================================================");
      try
      {
          school.printStudentsInCourse("CS 150");
          successFlag = true;
      }
      catch(Exception e)
      {
          System.out.println("Bonus test failed, an error occured:");
          e.printStackTrace();
          System.out.println(e);
      }
      if(successFlag)
      {
          System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
          System.out.println("Ensure that empty/no list was printed for student that doesn't exist");
      }
      System.out.println();

      successFlag = false;
      System.out.println("BONUS: Testing if printCoursesTakenByStudent() displays an");
      System.out.println("empty list when student doesn't exist");
      System.out.println("===================================================");
      try
      {
          school.printCoursesTakenByStudent("Mark Holtz");
          successFlag = true;
      }
      catch(Exception e)
      {
          System.out.println("Bonus test failed, an error occured:");
          e.printStackTrace();
          System.out.println(e);
      }
      if(successFlag)
      {
          System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
          System.out.println("Ensure that empty/no list was printed for student that doesn't exist");
      }
      System.out.println();

  }

}