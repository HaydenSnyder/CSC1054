import java.util.*;
import java.util.ArrayList;

public class StudentDataBase
{

   
   public static void main(String[] args)
   {
      int count = 0;
      Scanner scan = new Scanner(System.in);
      ArrayList<Student> studentList = new ArrayList<>();
      
      while(true)
      {
         System.out.println(menu());
         int userInput = scan.nextInt();
         
         switch(userInput)
         {
            case 1: 
               System.out.println("Please enter student first and last name");               
               String firstName = scan.next();
               String lastName = scan.next();
               
               Student newStudent = new Student(firstName, lastName);
               String year = newStudent.getYearGraduated();
               

               if(!studentExists(studentList, firstName, lastName, year))
               {
                  studentList.add(newStudent);

                  System.out.println("Student added Successfully: ");
                  count++;
                }
                else
                {
                  if(studentList.isEmpty())
                  {
                     System.out.println("No students in the database!");
                  }
                  else
                  {
                     System.out.println("Student already exists!");
                  }
                }
                break;
            case 2:
               for(Student s : studentList)
               {
                  System.out.println(s);
               }
               break;
             case 3:
               System.out.println("Please enter Student First, Last, and Graduation Year you wish to enroll in classes");
               
               String firstNameEnrollment = scan.next();
               String lastNameEnrollment = scan.next();
               String gradYearEnrollment = scan.next();
               
               Student student = findStudent(studentList, firstNameEnrollment, lastNameEnrollment,gradYearEnrollment);
               
               if(student != null)
               {
                  System.out.println("Which course would you like to add to " + firstNameEnrollment + " " + lastNameEnrollment);
                  student.enrollInCourses(scan);
               }
               else
               {
                  System.out.println("Student not found!");
               }
               break;
            case 4:
               System.out.println("Exiting program...");
               scan.close();
            default:
               System.out.println("Invalid Choice");
               
          }
      }
   }
   
   private static String menu()
   {
      return "Welcome to the Studnet Database: \n" 
             + "1. Add a student \n"
             + "2. Display student info \n"
             + "3. Enroll Student in class";
      
   }
   
   private static boolean studentExists(ArrayList<Student> studentList, String firstName, String lastName, String year)
   {
      for(Student s : studentList)
      {
         if(s.getFirstName().equalsIgnoreCase(firstName) &&
            s.getLastName().equalsIgnoreCase(lastName) &&
            s.getYearGraduated().equalsIgnoreCase(year))
            {
               return true;
            }
      }
      return false;
   }
   
   private static Student findStudent(ArrayList<Student> studentList, String firstNameEnrollment, String lastNameEnrollment, String gradYearEnrollment)
   {
      for(Student s : studentList)
      {
         if(s.getFirstName().equalsIgnoreCase(firstNameEnrollment) &&
            s.getLastName().equalsIgnoreCase(lastNameEnrollment) &&
            s.getYearGraduated().equalsIgnoreCase(gradYearEnrollment))
            {
               return s;
            }
      }
      return null;
   }

}