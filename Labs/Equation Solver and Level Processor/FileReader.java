import java.io.*;
import java.util.*;

public class FileReader
{
   public static void main(String[] args)
   {
      try
      {
         Level level = new Level("input.txt");
         System.out.println(level);
         
         level.addOne();
         
         System.out.println("Example file after output: \n" + level);
         
         level.writeFile("output.txt");
       } catch(IOException e)
       {
         System.out.println("Error reading or writing the file");
       }
    }
}