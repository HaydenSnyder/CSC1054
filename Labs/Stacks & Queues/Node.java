public class Node 
{
   private Customer customer;
   private Node next;

   public Node(Customer customer) 
   {
      this.customer = customer;
      this.next = null;
   }

   public Customer getCustomer() 
   {
      return customer;
   }

   public Node getNext() 
   {
      return next;
   }

   public void setCustomer(Customer customer) 
   {
      this.customer = customer;
   }

   public void setNext(Node next) 
   {
      this.next = next;
   }
}