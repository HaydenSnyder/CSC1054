public class Customer
{
   private String name;
   private int items;
   
   public Customer(String name, int items)
   {
      this.name = name;
      this.items = items;
   }
   
   public String getName()
   {
      return name;
   }
   
   public void setName(String name)
   {
      this.name = name;
   }
   
   public int getItems()
   {
      return items;
   }
   
   public void setItems(int items)
   {
      this.items = items;
   }
   
   @Override
   public String toString() 
   {
      return "Name: " + name + " / Items: " + items;
   }
 
  
}