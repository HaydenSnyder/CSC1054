public abstract class Car
{
   // Create a protected speed and name
   protected float speed;
   protected String name;
   
   // Create the Car method that takes in carName and carSpeed
   public Car(String carName, float carSpeed)
   {
      name = carName;
      speed = carSpeed;
      
   }
   
   // Create a abstract that can drive
   public abstract float drive();
}