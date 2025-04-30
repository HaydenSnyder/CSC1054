public class Queues
{
    private Node normalHead, normalTail;
    private Node fastHead, fastTail;
    private int nextTurn;
    private Node head;
   
   // Create A Constructor
   public Queues()
   {
      fastHead = null;
      normalHead = null;
      normalTail = null;
      fastTail = null;
      nextTurn = 0;
   }
   
   // Add to the back of the lin
   public void enqueue(String name, int items)
   {
      Customer customer = new Customer(name, items);
      Node newNode = new Node(customer);

      // Create a fast track if the items are less than 15
      if (items <= 15) 
      {
         // if head is null set it as head
         if (fastHead == null)
         {
            fastHead = fastTail = newNode;
         }
         // Else than set it normally
         else
         {
            fastTail.setNext(newNode);
            fastTail = newNode;
         }
      // This is for the normal Line
      }
      else
      {
         // If head is null set it to head
         if (normalHead == null)
         {
            normalHead = normalTail = newNode;
         }
         // Else than set it normally
         else
         {
            normalTail.setNext(newNode);
            normalTail = newNode;
         }
      }

      // If both lists were empty before, set the first nextTurn
      if (nextTurn == 0)
      {
         if (items <= 15) 
         {
            nextTurn = 1; 
         }
         else 
         {
            nextTurn = 2; 
         }
      }
   }

   
   // Create a dequeue where it alternates between fast and normal line
   public void dequeue()
   {
      // If the list is empty say the line is empty
      if (isEmpty())
      {
         System.out.println("No one is in line to check out.");
         return;
      }
   
      // If the turn is equal to 1 and not null, Check out the fasthead and then set to next, then set next turn to 2
      if (nextTurn == 1 && fastHead != null)
      {
         System.out.println("Checking out: " + fastHead.getCustomer());
         fastHead = fastHead.getNext();
         nextTurn = (normalHead != null) ? 2 : 1;
      }
      // If the turn is equal to 2 and nromal head is not null, checkout the normalhead and then set to next, set turn to 1
      else if (nextTurn == 2 && normalHead != null)
      {
         System.out.println("Checking out: " + normalHead.getCustomer());
         normalHead = normalHead.getNext();
         nextTurn = (fastHead != null) ? 1 : 2;
      }
      // If fasthead is not null, checkout fasthead and set next
      else if (fastHead != null)
      {
         System.out.println("Checking out: " + fastHead.getCustomer());
         fastHead = fastHead.getNext();
      }
      // If normalhead is not null, checout normalhead and set next
      else if (normalHead != null)
      {
         System.out.println("Checking out: " + normalHead.getCustomer());
         normalHead = normalHead.getNext();
      }
   }

   
   // Check to see if the list are empty
   public boolean isEmpty()
   {
      return fastHead == null && normalHead == null;
   }
   
   // Create a to string that prints out the list of customers
   @Override
   public String toString()
   {
      if (isEmpty())
      {
         return "There is no one in line.";
      }
   
      StringBuilder sb = new StringBuilder();
      Node fastCurrent = fastHead;
      Node normalCurrent = normalHead;
      int turn = nextTurn;
   
      sb.append("Line:\n");

      while (fastCurrent != null || normalCurrent != null)
      {
         if (turn == 1 && fastCurrent != null)
         {
            sb.append(fastCurrent.getCustomer()).append("\n");
            fastCurrent = fastCurrent.getNext();
            turn = (normalCurrent != null) ? 2 : 1;
         }
         else if (turn == 2 && normalCurrent != null)
         {
            sb.append(normalCurrent.getCustomer()).append("\n");
            normalCurrent = normalCurrent.getNext();
            turn = (fastCurrent != null) ? 1 : 2;
         }
         else if (fastCurrent != null)
         {
            sb.append(fastCurrent.getCustomer()).append("\n");
            fastCurrent = fastCurrent.getNext();
         }
         else if (normalCurrent != null)
         {
            sb.append(normalCurrent.getCustomer()).append("\n");
            normalCurrent = normalCurrent.getNext();
         }
      }
   
      return sb.toString();
   }
   
     
}