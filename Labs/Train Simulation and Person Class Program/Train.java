public class Train
{
   private int position;
   private static int count = 0;
   
   // Create Train constructor
   public Train(int initialPosition)
   {
      setPosition(initialPosition);
   }
   
   // Get the position of Train
   public int getPosition()
   {
      return position; 
   }
   
   // Set Train position
   public void setPosition(int newPosition) 
   {
      // If the new position is less than 0, make the position 14
      if (newPosition < 0) 
      {
         this.position = 14;
      } 
      // If newPosition is greater than 14 make it 0
      else if (newPosition > 14) 
      {
         this.position = 0;
      } 
      else 
      {
         this.position = newPosition;
      }
        count++;
    }
   
   // Check if trains collided
   public boolean equals(Object o)
   {
      if(o instanceof Train)
      {
         Train otherTrain = (Train) o;
         
         if(otherTrain.position == position)
         {
            return true;
         }
      }
      return false;
   }
   
   // Move trains in direction
   public void move(int direction) 
   {
      setPosition(this.position + direction);
      count++;
   }
   
   // Get number of moves
   public static int getNumberOfMoves()
   {
      return count;
   }

   
   
   
}