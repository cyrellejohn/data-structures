// Stack implementation using Singly Linked List 
public class DynamicStack {
   LinkedList list = new LinkedList();
   
   // Basic Operations
   
   public void push(Object item) {
      list.addLast(item);
   }
   
   public Object pop() {
      Object value = peek();
      list.deleteLast();
      
      return value;
   }
   
   // Supplementary Operations
   
   public boolean isEmpty() {
      return list.getSize() == 0;
   }
   
   public Object peek() {
      return list.getTail();
   }
   
   public int size() {
      return list.getSize();
   }
   
   public void print() {
      list.print();
   }
}