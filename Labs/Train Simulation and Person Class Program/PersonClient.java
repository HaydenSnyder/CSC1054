public class PersonClient
{
   public static void main(String[] args) 
   {
      // Create the objects
      Person person1 = new Person(19, "Lauren", 1001);
      Person person2 = new Person(18, "Matthew", 1002);
      Person person3 = new Person(18, "Matthew", 1002);
      Person person4;
      Person person5 = new Person(18, "Matthew", 1002);

      
      // Equal person4 to person3
      person4 = person3;
      
      // Print out the number of people create
      System.out.println("Number of People: " + Person.getPersonCount() + "\n");
      
      // Print out the people
      System.out.println(person1);
      System.out.println(person2);
      System.out.println(person3);
      
      // Check if they are equal
      if(person1.equals(person2))
      {
         System.out.println("p1 and p2 are .equals");
      }
      else if(person5.equals(person3))
      {
         System.out.println("p5 and p3 are .equals");
      }
      else if(person3.equals(person4))
      {
         System.out.println("p2 and p3 are .equals");
      }
      
      
      // Check if ==
      if(person1 == person2)
      {
         System.out.println("p1 and p2 are ==");
      }
      else if(person2 == person3)
      {
         System.out.println("p2 and p3 are ==");
      }
      else if(person3 == person4)
      {
         System.out.println("p3 and p4 are ==");
      }

                              
      
      

      
   }
}