public class TrainSystem
{
   private Train trainX;
   private Train trainY;
   private boolean isXTurn;

   //Create the positions
   public TrainSystem()
   {    
      trainX = new Train(3);
      trainY = new Train(8);
      isXTurn = true;
   }
   
   // Move Train back and forth
   public void moveTrain(int direction)
   {
      // If its X turn move the train X in direction
      if(isXTurn == true)
      {
         trainX.move(direction);
      }
      // Else move train Y in direction
      else
      {
         trainY.move(direction);
      }
      
      // Alternate turns
      isXTurn = !isXTurn;
   }
   
   // Two Trains collide
   public boolean areTrainsCollided()
   {
      return trainX.equals(trainY);
   }
   
   //toString
   public String toString() 
   {
      StringBuilder track = new StringBuilder("---------------");
      track.setCharAt(trainX.getPosition(), 'X');
      track.setCharAt(trainY.getPosition(), 'Y');
      
      return "===============\n" 
             + track.toString() 
         + "\n===============";
    }

   
   

}