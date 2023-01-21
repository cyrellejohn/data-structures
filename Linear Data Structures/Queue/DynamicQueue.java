// Queue implementation using Linked List
public class DynamicQueue {
   LinkedList list = new LinkedList();
   
   // Basic Operations
   
   public void enqueue(Object item) {
      list.addLast(item);  
   }
   
   public Object dequeue() {
      if (isEmpty() == true) {
         throw new IndexOutOfBoundsException("Queue is Empty");
      }
      
      Object value = front();
      list.deleteFirst();
      
      return value;
   }
   
   // Supplementary Operations
   
   public Object front() {
      return list.getHead();
   }
   
   public boolean isEmpty() {
      return list.getSize() == 0;
   }
   
   public void print() {
      list.print();
   }
   
   public int size() {
      return list.getSize();
   }
}