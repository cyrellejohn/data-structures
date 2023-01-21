// Queue implementation using Linked List
public class DynamicQueue<T> {
   LinkedList<T> list = new LinkedList<T>();
   
   // Basic Operations
   
   public void enqueue(T item) {
      list.addLast(item);  
   }
   
   public T dequeue() {
      if (isEmpty() == true) {
         throw new IndexOutOfBoundsException("Queue is Empty");
      }
      
      T value = front();
      list.deleteFirst();
      
      return value;
   }
   
   // Supplementary Operations
   
   public T back() {
      return list.getTail();
   }
   
   public T front() {
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