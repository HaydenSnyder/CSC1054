import java.util.ArrayList;
import java.util.*;

public class ZooClient
{
   public static void main(String[] args)
   {
      // Create Array list
      ArrayList<Bird> birdList = new ArrayList<>();
      
      // Create a scanner and userInput
      Scanner scan = new Scanner(System.in);
      int userInput;
      
      // Create a while loop that will repeat if true
      while(true)
      {  
         // Print out menu and take in user input
         System.out.println(Menu());
         userInput = scan.nextInt();
         scan.nextLine();

         // Create a switch for all the choice user can select 
         switch(userInput)
         {
         // Add a new bird 
         case 0:
            System.out.println("Which would you like to add (P = Penguin and H = HummingBird)");
            // Take in what userInputs
            String birdInput = scan.nextLine().toUpperCase();
            
            // If its letter P create a penguin
            if(birdInput.equals("P"))
            {
               System.out.println("Enter in a callsign and the number of meals previously eaten");
               String penguinName = scan.next();
               int penguinMeals = scan.nextInt();
               scan.nextLine();
               
               // Create the penguin and add to arraylist
               Penguin newPenguin = new Penguin(penguinName, penguinMeals);
               birdList.add(newPenguin);        
            }
            
            // If the letter is H create a HummingBird
            else if(birdInput.equals("H"))
            {
               System.out.println("Enter in a name, callsign, and the number of meals previously eaten");
               String hummingName = scan.next();
               String hummingCallSign = scan.next();
               int hummingMeals = scan.nextInt();
               scan.nextLine();
               
               // Create humming bird and add to arraylist
               HummingBird newHummingBird = new HummingBird(hummingName, hummingCallSign, hummingMeals);
               birdList.add(newHummingBird);
            }
            break;
         
         // Clear the list
         case 1:
            System.out.println("Which bird Call Sign would you like to remove?");
            String removeCallSign = scan.next();
            scan.nextLine();
            
            for(int i = 0; i < birdList.size(); i++)
            {
               if(birdList.get(i).getCallSign().equals(removeCallSign))
               {
                  
                  birdList.remove(i);
                  i--;
                  
               }
            }
            
            System.out.println("You have removed call sign: " + removeCallSign + " successfully \n");
            break;
            
         // Print out arraylist
         case 2:
            for (Bird bird : birdList) 
            {
               System.out.println(bird);
            }
            break;
         
         // Print out flying birds
         case 3:
            for (Bird bird : birdList) 
            {
               System.out.println(bird.fly());  
            }
            break;
         
         // Print out birds that can chirp
         case 4:
            for (Bird bird : birdList)
            {
               System.out.println(bird.chirp());
            }
            break; 
         
         // Print out birds that can eat 
         case 5:
            for(Bird bird : birdList)
            {
               System.out.println(bird.eat());
            }
            break;
            
         // Print out birds that can swim
         case 6:
            for(Bird bird : birdList)
            {
               System.out.println(bird.swim());
            }
            break;
            
         // Print out birds that can tap dance
         case 7:
            for(Bird bird : birdList)
            {
               System.out.println(bird.tapDance());
            }
            break;
            
         // Exit the scanner 
         case 8:
            scan.close(); 
            return; 
         }
      
      }
   }
   
   
   // Menu for the questions
   public static String Menu()
   {
   return "Which option do you wish to select? \n"
           + "0 – add new bird \n"
           + "1 – remove based on a call sign \n"
           + "2 – print all birds \n"
           + "3 - fly \n"
           + "4 - chirp \n"
           + "5 - eat \n"
           + "6 - swim \n"
           + "7 – tap dance penguins \n"
           + "8 - quit \n";
   }
}

