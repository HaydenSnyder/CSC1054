import java.util.*;

public class CurrnecyRun
{
   public static void main(String[] args)
   {
      Scanner scan = new Scanner(System.in);
      ArrayList<Currency> currencyHistory = new ArrayList<>();
      List<String> currencies = Arrays.asList("USD", "EUR", "JPY", "GBP", "AUD", "CAD", "CHF", "CHN", "HKD", "NZD");
      
      // Create a loop for users to enter in a choice
      while(true)
      {
         // Display the menu, where the user can input a number
         System.out.println(menu());
         int userChoice = scan.nextInt();
         scan.nextLine();
         
         // Create a switch from the users choice
         switch(userChoice)
         {
            // Case 1, Display the top 10 currencies the user can type in
            case 1:
               System.out.println("Currinecies You Can Choose From:");
               for (String c : currencies) 
               {
                  System.out.println(c);
               }
               System.out.println();
               break;
            
            // Case 2, Have the user enter the currency and the amount, Add the currency to the arraylist. Convert the currency entered and return the amount with the currency you have got
            case 2:
               System.out.println("Please Enter the Currency you have, and the amount!");
               String userCurrency = scan.next().toUpperCase();
               int userAmount = scan.nextInt();
               scan.nextLine();
               
               if(currencies.contains(userCurrency))
               {
                  Currency newCurrency = new Currency(userCurrency, userAmount);
                  currencyHistory.add(newCurrency);
               
               
                  newCurrency.currencySelection(scan);
                  double convertedAmount = newCurrency.convertCurrency();
                  System.out.println("Conversion Sucessfull!");
                  System.out.println(newCurrency.getConverted() + "\n");
               }
               else
               {
                  System.out.println("Please enter the right Currency");
                  break;
               }
               

               
               
               break;
            
            // Case 3, Display the past transaction History
            case 3:
               if(currencyHistory.isEmpty())
               {
                  System.out.println("No Transaction Yet!");
               }
               else
               {
                  for(Currency c : currencyHistory)
                  {
                     System.out.println(c.getCurrencyHistory());
                  }
                  System.out.println();
               }
               break;
            
            // End the program  
            case 4:
               System.out.println("Thank You For Using This Program!");
               scan.close();
               return;
         }
      }
      
      
   }
   
   // The display menu where the user can enter a choice
   public static String menu()
   {
      return "Please enter a choice: \n" + 
             "1. Currency Search \n" + 
             "2. Conversion Calculator \n" +
             "3. Transaction History \n" +  
             "4. Close Application";
   }
}