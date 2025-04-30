import java.util.*;

public class CustomerClient 
{
   public static void main(String[] args)
   {
      Scanner scan = new Scanner(System.in);
      
      // Create a Queue
      Queues line = new Queues();
      
      // Create a loop that keeps getting user choice
      while(true)
      {
         // take in user choice
         System.out.println(Menu());
         int userChoice = scan.nextInt();
         
         
         // Create a switch statement for the choices
         switch(userChoice)
         {
            // Add a person to the line
            case 1:
               System.out.println("Enter Customers Name and Number of Items:");
               String name = scan.next();
               int items = scan.nextInt();
               line.enqueue(name, items);
               break;
            // Take someone out of the line
            case 2:
               line.dequeue();
               break;
            // Print out the line
            case 3:
               System.out.println(line.toString());
               break;
            // Close the program
            case 4:
               scan.close();
               return;
            default:
               System.out.println("Please Enter a Choice Between 1-4");
         }  
      }
      
   }
   
   // Create the menu that displays after each task
   public static String Menu()
   {
      return "What would you like to do with the supermarket line? \n" 
            +"1 – have a customer line up \n" 
            +"2 – have a customer check out \n"
            +"3 – check who is in line \n"
            +"4 – quit \n";
   }
}