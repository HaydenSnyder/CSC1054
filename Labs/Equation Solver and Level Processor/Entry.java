public class Entry
{
   private int x;
   private int y;
   private String name;
   
   public Entry(int x, int y, String name)
   {
      this.x = x;
      this.y = y;
      this.name = name;
   }
   
   // Get the X
   public int getX()
   {
      return x;
   }
   
   // Get the Y
   public int getY()
   {
      return y;
   }
   
   // Return the name
   public String getName()
   {
      return name;
   }
   
   // Print out x y and name
   public String toString()
   {
      return x + " " + y + " " + name;
   }
}