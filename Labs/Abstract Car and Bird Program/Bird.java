// Create a bird abstract class
public abstract class Bird
{
   // Create a private information you want to take in
   private String callsign;
   private boolean canSwim;
   private int mealsEaten;
   
   // Create Bird that takes in callsign, canSwim and meals eaten
   public Bird(String callsign, boolean canSwim, int mealsEaten)
   {
      this.callsign = callsign;
      this.canSwim = canSwim;
      this.mealsEaten = mealsEaten;
   }
   
   // Return the amount of meals 
   public int getMealsEaten()
   {
      return mealsEaten;   
   }
   
   // Increase the amount of meals eaten by one
   public void increaseMeals()
   {
      this.mealsEaten++;
   }
   
   // Set the name of the callSign
   public void setCallSign(String callsign)
   {
      this.callsign = callsign;
   }
   
   // Return call sign if they call it
   public String getCallSign()
   {
      return callsign;
   }
   
   // Create boolean for swim, return if they can swuim or not
   public boolean getcanSwim()
   {
      return canSwim;
   }
   
   
   // Create abstract Strings for what the birds can do
   public abstract String fly();
   public abstract String chirp();
   public abstract String eat();
   public abstract String swim();
   public abstract String tapDance();
}