import java.util.*;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.FileNotFoundException;

public class FlashCards
{
   private String term;
   private String definition;
   private static int numberOfTerms;
   private String fileName;
   
   // Create the constructor for flashcards that takes in term and definition
   public FlashCards(String term, String definition)
   {
      this.term = term;
      this.definition = definition;  
      
      numberOfTerms++;
   }
   
   // Get the term
   public String getTerm()
   {
      return term;
   }
   
   // Get the defininition
   public String getDefinition()
   {
      return definition;
   }
   
   // Get the number of terms
   public int getNumberOfTerms()
   {
      return numberOfTerms;
   }
   
   // Get Info where it displays as term -> definition
   public String getInfo()
   {
      return term + " -> " + definition;
   }
   
   // Save Term Method
   public void saveTerms(String fileName)
   {
      try
      {
         // Open file output stream in append mode
         FileOutputStream fos = new FileOutputStream(fileName, true);
         
         // Create PrintWriter to write to the file
         PrintWriter pw = new PrintWriter(fos);
         
         pw.print(term + " -> " + definition);
         System.out.println("System saved successfully!");
         
         // Close the PrintWriter to save the file
         pw.close();
      }
      catch(FileNotFoundException fnfe)
      { 
         System.out.println("File does not exist!");
      }
   }  
}