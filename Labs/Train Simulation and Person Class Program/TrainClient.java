import java.util.Scanner;

public class TrainClient
{
   public static void main(String[] args) 
   {
      Scanner scan = new Scanner(System.in);
      int moves = Train.getNumberOfMoves();
      
      // Create train system
      TrainSystem system = new TrainSystem();
      
      // Loop to ask user for input 
      while(true)
      {
         // Print out Train
         System.out.println(system);
         
         // Take in User input
         System.out.println("Enter Direction: L for left R for right");
         char directionInput = scan.next().toUpperCase().charAt(0);
         
         // If User enter L make it move left, if User enter R make it move right. If neither selected set number to 0
         int direction = (directionInput == 'L') ? -1 : (directionInput == 'R') ? 1 : 0;
         
         // If neither L or R was input, have them re enter something
         if(direction == 0)
         {
            System.out.println("Invalid Direction, Please Re Enter");
            continue;
         }
      
         // Move Train in direcion
         system.moveTrain(direction);
         
         // Add 1 when someone moves
         moves++;
      
         // Check if trains collided
         if(system.areTrainsCollided())
         {
            System.out.println("The Trains Have Crashed!");
            System.out.println("Total Moves: " + moves);
            break;
         }
      
      
      
      }
   
   }
}