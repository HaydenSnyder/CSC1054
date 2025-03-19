public class HummingBird extends Bird
{
   // Create a private string for humming bird name
   private String name;
   private String callSign;
   
   // Create the method to call for HummingBird which will take in name, call sign, and meals eaten
   public HummingBird(String name, String callSign, int mealsEaten)
   {
      super(name, false, mealsEaten);
      this.name = name;
      this.callSign = callSign;
      
   }
   
   public String getCallSign()
   {
      return callSign;
   }
   
   // Return the name of Humming Bird
   public String getName()
   {
      return name;
   }
   
   // Rerturn that the Hummingbird can fly
   public String fly()
   {
      return name + " is flying high!";
   }
   
   // Return that the hummingBird can chirp
   public String chirp()
   {
      return name + " chirps!";
   }
   
   // Increase the meals eaten by one and print out yum
   public String eat()
   {
      increaseMeals();
      return "yum";
   }
  
   // Return that hummingbirds cant swim
   public String swim()
   {
      return "HummingBirds cannot Swim!";
   }
   
   // Rerturn nothing for tapDancing
   public String tapDance()
   {
      return "";
   }
   
   // Create a toString that prints out all information
   @Override
   public String toString()
   {
      return "Name: " + name + "\n"
            +"Meals Eaten: " + getMealsEaten() + "\n"
            +"Can Swim: " + getcanSwim() + " \n"
            +"Call Sign: " + getCallSign() + "\n";
   }  
}