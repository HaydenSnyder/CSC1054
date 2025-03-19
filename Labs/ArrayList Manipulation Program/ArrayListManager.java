import java.util.*;

public class ArrayListManager
{
    public static void main(String[] args) 
    {
        // Declare ArrayList
        ArrayList<String> myStrings = new ArrayList<>();

        // Declare Scanner
        Scanner scan = new Scanner(System.in);
        
        
        
        System.out.println("Enter a list of strings followed by EXIT."); 
      
      // Loop Question
      while(true)
      {
         // UserInput is whatever the user puts on the line
         String userInputPart1 = scan.nextLine();
         
         
         // Create an if statement if the user enters exit, put it before adding words into arraylist so if user puts exit it will not put in arraylist
         if (userInputPart1.equalsIgnoreCase("exit")) 
         {
            // Ask the question of what index you want to remove
            System.out.println("What Index would you like to remove?");
            
            // Take in the number
            int numberScan = scan.nextInt();
            
            // Remove the number the user selected
            myStrings.remove(numberScan);
            
            
            // Print out the ArrayList
            for(String stringList : myStrings)
            {
               System.out.println(stringList);
            }
            
            break;
         }

         
         // Add userInput into the ArrayList
         myStrings.add(userInputPart1);
         
       
      }



        while (true) 
        {
            // Print Menu
            System.out.println("\nMenu:");
            System.out.println("1. Add to List");
            System.out.println("2. Remove from list (by index)");
            System.out.println("3. Clear List");
            System.out.println("4. Remove All of a Particular Name");
            System.out.println("5. Print List Out");
            System.out.println("6. Exit");

            // Get user input
            int userInput;
            
            // Create an if statement if the user enters a number 1 - 6
            if (scan.hasNextInt()) {
                userInput = scan.nextInt();
                scan.nextLine(); 
            } else {
                System.out.println("Invalid input! Please enter a number between 1 and 6.");
                scan.next(); 
                continue;
            }

            // Menu Options
            switch (userInput) {
                case 1:
                    // Add a string
                    System.out.print("What string would you like to add? ");
                    String userWord = scan.nextLine();
                    myStrings.add(userWord);
                    break;

                case 2:
                    // Remove by index
                    System.out.print("Enter the index of the string to remove: ");
                    if (scan.hasNextInt()) 
                    {
                        int index = scan.nextInt();
                        scan.nextLine();
                        
                        // Create an if statement for the size of the number, if it isnt in that size, enter a new number
                        if(index >= myStrings.size() && index <= myStrings.size())
                        {
                            myStrings.remove(index);
                        }
                        else
                        {
                        System.out.println("Please use a number within " + myStrings.size());
                        }
                        
                        
                    }   
                    break;

                case 3:
                    // Clear List
                    myStrings.clear();
                    break;

                case 4:
                    // Remove all occurrences of a particular name
                    System.out.print("What string do you want to remove? ");
                    
                    String nameToRemove = scan.nextLine();
                    
                    // Create a for loop to remove all the words
                    for(int i = myStrings.size(); i >= 0; i++)
                    {
                       {
                           myStrings.remove(nameToRemove);
                       }
                    }
                    
                    break;

                case 5:
                     // Print List Out
                     System.out.println("The List:");
                     for(String stringList : myStrings)
                     {
                        System.out.println(stringList);
                     }
                    break;

                case 6:
                    // Exit
                    scan.close();
                    return;

                default:
                    System.out.println("Invalid choice! Please enter a number between 1 and 6.");
            }
        }
    }
}