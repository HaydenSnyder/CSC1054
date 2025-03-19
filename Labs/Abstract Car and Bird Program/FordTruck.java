public class FordTruck extends Car
{
   // Create its own private haulingCapacity only for ford truck
   private int haulingCapacity;
   
   // Create the FordTruck Method that takes in name, speed and haul
   public FordTruck(String carName, int carSpeed, int haul)
   {
      super(carName, carSpeed);
      haulingCapacity = haul;
   }
   
   // Override the abstract for drive so everytime you use drive method it increases speed by 1
   @Override
   public float drive()
   {
      return speed += 1;  
   }
   
   // Create a toString that prints out all information
   public String toString()
   {
   return "Name: " + name + "\n" 
         + "Speed: " + speed + "\n" 
         + "Hauling Capacity: " + haulingCapacity + "\n";
   }
}