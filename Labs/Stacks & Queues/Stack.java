public class Stack
{
   private IntNode head;
   
   // Create A Constructor
   public Stack()
   {
   
   }
   
   // Push
   public void push(int data)
   {
      IntNode theNode = new IntNode(data);
      theNode.setNext(head);
      head = theNode;
   }
   
   // Peek
   public void peek()
   {
      if(head == null) 
      {
         return;
      }  
      
      System.out.println(head.getData() + "\n");
   }
   
   
   // Pop
   public void pop()
   {
      if(head == null)
      {
         return;
      }
      
      head = head.getNext(); 
   } 
   
   // Print Node
   public void printList() 
   {
      IntNode current = head;
      
      while (current != null) 
      {
         System.out.print(current.getData() + " -> ");
         current = current.getNext();
      }
      System.out.println("null");
   }

   // ToString that prints out card and then the numbers added in order
   public String toString()
   {
      IntNode current = head;
      String result = "card: \n<top>\n";
   
      while(current != null)
      {
         result += current.getData() + "\n";
         current = current.getNext();
      }
      
      result += "<bottom> \n";
      return result;
   }

   
   public static void main(String[] args)
   {
      Stack myStack = new Stack();
      
      myStack.push(1);
      myStack.push(2);
      myStack.push(3);
      myStack.push(4);
      myStack.push(5);
      myStack.push(6);
      
      System.out.println(myStack.toString());
      
      myStack.pop();
      myStack.pop();
      myStack.pop();
      
      myStack.peek();
      
      myStack.push(7);
      myStack.push(8);
      myStack.push(9);
      
      System.out.println(myStack.toString());
   }
   
}  