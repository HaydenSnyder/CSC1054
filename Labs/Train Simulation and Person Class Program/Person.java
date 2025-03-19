public class Person
{
   private String name;
   private int age;
   private int id;
   private static int count = 0;
   
   // Create the person object
   public Person(int personAge, String personName, int personId)
   {
      age = personAge;
      name = personName;
      id = personId;
      count++;
   
   }
   
   // Create the .equals to check if two people are equal
   public boolean equals(Object o)
   {
      if(o instanceof Person)
      {
         Person otherPerson = (Person) o;
         
         // If age, name, and id are equal return true
         if(otherPerson.age == age &&
            otherPerson.name == name &&
            otherPerson.id == id)
         {
            return true;
         }
      }
      // Else return false
      return false;
   }
   
   // Create a toString to print out the people
   String toReturn = "";
   public String toString()
   {
      toReturn += "Age: " + age + "\n";
      toReturn += "Name: " + name + "\n";
      toReturn += "ID: " + id + "\n";
      
      return toReturn;
   }
   
   // Get the personCount
   public static int getPersonCount()
   {
      return count;
   }
   
}