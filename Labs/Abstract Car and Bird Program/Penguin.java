public class Penguin extends Bird
{
   // Create the name for penguin
   private String name = "Penguin";
   private String callSign;
   
   // Create the method to call, which will take in call sign and meals eatehn
   public Penguin(String callSign, int mealsEaten)
   {
      super(callSign, true, mealsEaten);
      this.callSign = callSign;
   }
   
   public String getCallSign()
   {
      return callSign;
   }
   
   // Return the name 
   public String getName()
   {
      return name;
   }
   
   // Return that the bird can swim
   public String swim()
   {
      return "Swimming " + name;
   }
   
   // Return that the penguin cant fly
   public String fly()
   {
      return name + "s cannot fly!";
   }
   
   // Return that the penguin can chirp
   public String chirp()
   {
      return name + " chirps!";
   }
   
   // Increase the meals eaten by 3, and print out nom nom
   public String eat()
   {
      increaseMeals();
      increaseMeals();
      increaseMeals();
      return "nom nom nom";
   }
   
   // Penguins can tap dance
   public String tapDance()
   {
      return "Tap Dancing Penguin!";
   }
  
   // Create a ToString that prints out all information
   @Override
   public String toString()
   {
      return "Name: " + name + "\n"
            +"Meals Eaten: " + getMealsEaten() + "\n"
            +"Can Swim: " + getcanSwim() + " \n"
            +"Call Sign: " + getCallSign() + "\n";
   }  
}