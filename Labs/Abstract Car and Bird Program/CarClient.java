import java.util.ArrayList;

public class CarClient
{
   public static void main(String[] args)
   {
   FordTruck truck = new FordTruck("Explorer", 0, 100);
   
   truck.drive();
   truck.drive();
   truck.drive();

   
   System.out.println(truck.toString());
   
   truck.drive();
   
   System.out.println(truck.toString());
   }
}