// Circular Queue implementation using Array 
public class CircularQueueArray {
   private static Object[] array;
   private static int back;
   private static int arraySize;
   private static int countElements;
   private static int front;
   
   public CircularQueueArray() {
      arraySize = 8;
      array = new Object[arraySize];
      
      back = -1;
      front = 0;
   }
   
   // Option to change the size of the Array
   public CircularQueueArray(int newSize) {
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
      
      /* back variable reset the count of the back depending on
         the size of the array as long as the array is not full 
         yet */
         
      back = (back + 1) % arraySize; 
      array[back] = item;
      countElements++;     
   }
   
   public void dequeue() {
      if (isEmpty() == true) {
         throw new IndexOutOfBoundsException("Queue is Empty");
      }
      
      array[front] = null;
      front++;
      countElements--;
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