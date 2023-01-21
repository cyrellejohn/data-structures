// Queue implementation using Array
public class ArrayQueue {
   private static Object[] array;
   private static int back;
   private static int arraySize;
   private static int countElements;
   private static int front;
   
   public ArrayQueue() {
      arraySize = 8;
      array = new Object[arraySize];
      
      back = -1;
      front = 0;
   }
   
   // Option to change the size of the Array
   public ArrayQueue(int newSize) {
      arraySize = newSize;
      array = new Object[arraySize];
      
      back = -1;
      front = 0;
   }
   
   // Basic Operations
   
   public void enqueue(Object item) {
      if (isFull() == true) {
         throw new IndexOutOfBoundsException("Queue is Full");
      }
      
      back++;
      countElements++;
      array[back] = item;
   }
   
   public Object dequeue() {
      if (isEmpty() == true) {
         throw new IndexOutOfBoundsException("Queue is Empty");
      }
      
      Object value = front();
      array[front] = null;
      front++;
      countElements--;
      
      return value;
   }
   
   // Supplementary Operations
   
   public static int front() {
      return front;
   }
   
   public static boolean isEmpty() {
      return countElements == 0;
   }
   
   public static boolean isFull() {
      return countElements == arraySize;
   }
   
   public static int size() {
      return countElements;
   }
   
   public void print() {
      for (int i = 0; i < arraySize; i++) {
         System.out.print(array[i] + " ");
      }
   }
}