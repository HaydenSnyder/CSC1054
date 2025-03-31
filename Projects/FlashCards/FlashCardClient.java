import java.net.*;
import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.geometry.*;
import javafx.scene.paint.*;
import javafx.scene.control.*;
import javafx.scene.image.*;
import java.util.*;
import javafx.event.*;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.io.*;

public class FlashCardClient
{ 
      
   public static void main(String[] args)
   {
      Scanner scan = new Scanner(System.in);
      
      ArrayList<FlashCards> cardList = new ArrayList<>();
      
      // Create a while loop so it automatically runs
      while(true)
      {
         // Print out menu and take in a choice
         System.out.println(menu());
         int userChoice = scan.nextInt();
         scan.nextLine();
         
         // Create a switch statement for the choices
         switch(userChoice)
         {
            // Case 1: Adding a term
            case 1:
               System.out.println("Please Enter The Term, You Wish To Add");
               String term = scan.nextLine();
               
               System.out.println("Please Enter the Definiton for " + term);
               String definition = scan.nextLine();
                              
               // If user enters exit it closes else add the term
               if(term.equalsIgnoreCase("exit"))
               {
                  break;
               }
               
               FlashCards newCard = new FlashCards(term, definition);
               cardList.add(newCard);
               System.out.println("Term Added! \n");
               break;
            
            // Case 2: Find Terms
            case 2:
               // If there is no terms say there is none
               if(cardList.isEmpty())
               {
                  System.out.println("There Is No Current Term!");
               }
               // Else loop through all to printout
               else
               {
                  for(int i = 0; i < cardList.size(); i++)
                  {
                     for(FlashCards f : cardList)
                     {
                        System.out.println(i + " " + f.getInfo());
                     }     
                  }
                  System.out.println();
               }  
               break;
               
            // Case 3: Finding a file  
            case 3:
               System.out.println("Please Enter The File You Wish to open");
               String scanFileName = scan.nextLine();
               
               // if the name doesnt have .txt add it
               if(!scanFileName.endsWith(".txt"))
               {
                  scanFileName += ".txt"; 
               }
                  // Create a try and catch to find the file
                  try
                  {
                     Scanner fileScan = new Scanner(new File(scanFileName));
                     
                     // Create a while loop to seperate the terms and definitions and add to flashcards array
                     while(fileScan.hasNextLine())
                     {
                        String line = fileScan.nextLine();
                        String[] parts = line.split("->");
                        
                        if(parts.length == 2)
                        {
                           cardList.add(new FlashCards(parts[0], parts[1]));
                        }

                     }
                     fileScan.close();
                     System.out.println("File Loaded Successfully!");
                  } 
                  catch(Exception e)
                  {
                     System.out.println("Cant Find File!");
                  }
               break;
            
            // Case 4: Saving a document 
            case 4:
               // If the arraylist is empty then save no terms 
               if(cardList.isEmpty())
               {
                  System.out.println("There are no terms to save!");
                  break;
               }
                  // Else take in a file name, if it doesnt have .txt then add it
                  System.out.println("Please Enter the File Name You Want To Save It As, Please Dont Use Spaces!");
                  String fileName = scan.nextLine();
                  
               if(!fileName.endsWith(".txt"))
               {
                  fileName += ".txt";
               }
               
               for(FlashCards card : cardList)
               {
                  card.saveTerms(fileName);
               }
               break;
            
            // Case 5: Study The Term   
            case 5:
               // Create a while loop for options to study
               while(true)
               {
                  // Display the options and then take in the user choice
                  System.out.println(studyMenu());
                  userChoice = scan.nextInt();
                  scan.nextLine();
                  
                  // Create a switch statement for userChoice
                  switch(userChoice)
                  {
                     // Case 1: Display the current terms they can study from
                     case 1:
                        for(FlashCards c : cardList)
                        {
                           System.out.println(c.getTerm());
                        }
                        System.out.println();
                     
                     // Case 2: Study the term
                     case 2:
                        // Enter in the term and definition
                        System.out.println("Please Enter The Term!");
                        String userTerm = scan.nextLine();
                        
                        System.out.println("Enter The Definition for " + userTerm);
                        String userDefinition = scan.nextLine();
                        
                        // Create a for loop where it find the terms, if it right send correct, if its exit go back to main loop, if its help print out definition
                        for(FlashCards c : cardList)
                        {
                           if(userDefinition.equalsIgnoreCase("exit"))
                           {
                              return;
                           } 
                           else if(userDefinition.equalsIgnoreCase("help")) 
                           {
                              System.out.println(c.getInfo());
                           } 
                           else if(userDefinition.equals(c.getDefinition()))
                           {
                              System.out.println("Correct!");
                           }
                           else
                           {
                              System.out.println("Retry! Please Enter Exit If You Want To Quit, or Help For Definition");
                           }
                        }
                        break;
                     // Case 3: Goes back to main loop
                     case 3:
                        return;
                  }

               }
            
            // Case 6: Closes the program   
            case 6:
               System.out.println("Thank You For Using This Program!");
               return;
         }
      }
   }
   
   public static String menu()
   {
      return "1. Enter In Term To Study \n" 
            +"2. View Current Terms \n"
            +"3. Open A Previous File \n"
            +"4. Save The Program \n"
            +"5. Study The Terms \n"
            +"6. Close The Program";
   } 
   
   public static String studyMenu()
   {
      return "1. Find Current Terms \n"
           + "2. Study Term \n"
           + "3. Exit \n";
   }
}