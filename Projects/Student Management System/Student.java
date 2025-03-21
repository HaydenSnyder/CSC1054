import java.util.*;

public class Student
{
   private String firstName;
   private String lastName;
   private String year;
   private String studentID;
   private static int id = 1000;
   private int currentYear = 2025;
   private int costOfCourse = 600;
   private int tuitionBalance;
   private int yearNum = 0;
   private List<String> courses = new ArrayList<>();
   
   public Student(String firstName, String lastName)
   {
      this.firstName = firstName;
      this.lastName = lastName;
      this.year = setYearGraduated();
      
      id++;
      
      this.studentID = setStudentID();
      

   }
   
   public String getFirstName()
   {
      return firstName;
   }
   
   public String getLastName()
   {
      return lastName;
   }
   
   
   public String setYearGraduated()
   {
      System.out.println("Please enter 1-4 for the Year they graduated \n"
                         + "1. Freshman \n"
                         + "2. Sophmore \n"
                         + "3. Junior \n"
                         + "4. Senior");
      Scanner scan = new Scanner(System.in);
      
      while(true)
      {
         if(scan.hasNextInt())
         {
            yearNum = scan.nextInt();
            scan.nextLine();
            
            if(yearNum >= 1 && yearNum <= 4)
            {
              switch(yearNum)
              {
                  case 1: 
                     return "Freshman";
                  case 2:
                     return "Sophmore";
                  case 3:
                     return "Junior";
                  case 4: 
                     return "Senior";
                  default:
                     return "Unknown";
               }
            }
            else
            {
               scan.next();
            }
            System.out.println("Invalid Iput. Please enter 1-4");
            

         }
      }
  }
   
   public String getYearGraduated()
   {
      return year;
   }
   
   
   // Generate an id
   private String setStudentID()
   {
      return yearNum + "" + id;
   }
   
   // Get courses
   public List<String> getCourses()
   {
      return courses;
   }
   
   // Enrollment
   public void enrollInCourses(Scanner scan)
   {
      scan.nextLine();  
  
      while(true)
      {
         System.out.println("Please enter the classes you wish to enroll in, type exit to quit");
         System.out.println("HIS \n" +
                            "Mathematics \n" +
                            "Chemistry \n" +
                            "Computer Science");
         
         String course = scan.nextLine().trim();
         
         List<String> validCourses = Arrays.asList("HIS", "Mathematics", "Chemistry", "Computer Science"); 
         
         if(course.equalsIgnoreCase("exit"))
         {
            System.out.println("Exiting enrollment...");
            break;
         } 
         else if(validCourses.contains(course))
         {
            if(!courses.contains(course))
            {
               courses.add(course);
               tuitionBalance += costOfCourse;
               System.out.println(course + " added successfully!");
            }
            else
            {
               System.out.println("Not a valid class!");
            }
         }
         
      }
   }

   // Balance
   public int getBalance()
   {
      return tuitionBalance;
   }
   
   // String to see status
   @Override
   public String toString()
   {
      return "Student: " + firstName + " " + lastName + "\n"
             + "Year: " + year + "\n"
             + "Student ID: " + studentID + "\n"
             + "Courses Enrolled: " + courses + "\n"
             + "Tuition Balance $" + tuitionBalance + "\n";
   }
}