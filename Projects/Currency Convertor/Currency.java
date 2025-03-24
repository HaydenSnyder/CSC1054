import java.util.*;


public class Currency
{
   private String typeOfCurrency;
   private int amount;
   private List<String> currency = new ArrayList<>();
   private Scanner scan = new Scanner(System.in);
   private String currencyInput;
   private static List<String> currencies = Arrays.asList("USD", "EUR", "JPY", "GBP", "AUD", "CAD", "CHF", "CHN", "HKD", "NZD");
   private static final Map<String, Double> rates = Map.of(
        "USD", 1.0, "EUR", 0.92, "JPY", 150.0, "GBP", 0.78, "AUD", 1.55, 
        "CAD", 1.36, "CHF", 0.91, "CHN", 7.1, "HKD", 7.8, "NZD", 1.6);

   
   public Currency(String typeOfCurrency, int amount)
   {
      this.typeOfCurrency = typeOfCurrency;
      this.amount = amount;
   }
   
   // Create a method where the user can enter in a currency to convert
   public void currencySelection(Scanner scan)
   {
      while(true)
      {
         System.out.println("Please Enter A Currency, If You Would Like To Quit Please Type \"exit\"");
         currencyInput = scan.nextLine();
         
         if(currencyInput.equalsIgnoreCase("exit"))
         {
            System.out.println("Exiting Currency Selection...");
            break;
         } 
         else if(currencies.contains(currencyInput))
         {
            currencyInput = currencyInput;
            break;
         }
         else
         {
            System.out.println("Not a valid Currency!");
         }
      }
   }
   
   // The actual math to convert the currency
   public double convertCurrency()
   {
      double amountInUSD = amount / rates.get(typeOfCurrency);
      
      double convertedAmount = amountInUSD * rates.get(currencyInput);
      
      return convertedAmount;
   }
   
   // return the converted currenct
   public String getConverted()
   {
      double convertedAmount = convertCurrency();
      return convertedAmount + " " + currencyInput;
   }
   
   // Outprint the Transaction History
   public String getCurrencyHistory()
   {
      double convertedAmount = convertCurrency();
      return typeOfCurrency + " " + amount + "->" + currencyInput + " " + convertedAmount;
   }
} 