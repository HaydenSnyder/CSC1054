import java.util.Scanner;

public class CalculatingAEquation 
{
    public static void main(String[] args) 
    {
      int result;
      Scanner scan = new Scanner(System.in);

      while(true)
      {
         try 
         {
            System.out.println("Enter two numbers and an operator:");
            int firstNumber = scan.nextInt();
            int secondNumber = scan.nextInt();
            String operation = scan.next();
            
            // Check if the operator is invalid
            if (!operation.equals("/") && !operation.equals("*")) 
            {
               throw new MathOperatorException("Invalid operator! Cannot convert.");
               
            }
   
   
            if (operation.equals("/")) 
            {
               if (secondNumber != 0) 
               {
                  result = firstNumber / secondNumber;
                  System.out.println("Result: " + result);
                  break;
               } 
               else 
               {
                  throw new MathOperatorException("Cannot divide by 0.");
               }
            } 
            else if (operation.equals("*")) 
            {
               result = firstNumber * secondNumber;
               System.out.println("Result: " + result);
               break;
            }
   
         } 
         catch (MathOperatorException e) 
         {
            System.out.println(e.getMessage());
         } 
         catch (Exception e) 
         {
            System.out.println("An unexpected error occurred.");
            scan.nextLine();
         }
      } 
      
      scan.close(); 
   }
}  