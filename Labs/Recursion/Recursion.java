public class Recursion
{
   public static int mystery(int num)
   {
      if(num <= 2)
      {
         return 1;
      }
      else
      {
         // If number is not greater than 2 or equal, create a mystery(#) which goes down after every number to 1. Which adds mystery(#) which goes down 2 numbers
         return mystery(num-1) + mystery(num-2);
      }
   }
   
   public static int iteratively(int num)
   {
      // If the num is less than or equal to two return 1.
      if(num <= 2)
      {
         return 1;
      }
      
      // Create a prev 1 and 2, as well as a result. It starts at 1 because Iterative(1) and (2) are 1
      int prev1 = 1;
      int prev2 = 1;
      int result = 0;
      
      // Create a for loop that starts at 3 because if it starts at 1 and 2 it will not work.
      for(int i = 3; i <= num; i++)
      {
         // result = prev 1 + prev2
         result = prev1 + prev2;
         
         // Once it adds to the result set prev 2 to prev1
         prev2 = prev1;
         
         // Then set prev1 = result
         prev1 = result;
      }
      
      // Return result
      return result;
   }
   
   public static void main(String[] args)
   {
      System.out.println(mystery(14));
      System.out.println(iteratively(12));
   }
}