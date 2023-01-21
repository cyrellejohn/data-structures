// Stack implmentation using Array
public class ArrayStack {
   private static Object[] array;
   private static int arraySize;
   private static int countElements;
   private static int top;
   
   public ArrayStack() {
      arraySize = 70;
      array = new Object[arraySize];
      
      top = -1; // Top is the last element being added
   }
   
   // Option to change the size of the Array
   public ArrayStack(int newSize) {
      arraySize = newSize;
      array = new Object[arraySize];
      
      top = -1;
   }
   
   // Basic Operations
   
   public void push(Object item) {
      if (isFull() == true) {
         throw new IndexOutOfBoundsException("Stack is Full");
      }
      
      top++;
      array[top] = item;
      countElements++;
   }
   
   public Object pop() {
      if (isEmpty() == true) {
         throw new IndexOutOfBoundsException("Stack is Empty");
      }
      
      Object tempElement = array[top];
      array[top] = null;
      top--;
      countElements--;
      
      return tempElement;
   }
   
   // Supplementary Operations
   
   public static boolean isEmpty() {
      return countElements == 0;
   }
   
   public static boolean isFull() {
      return countElements == arraySize;
   }
   
   public static Object peek() {
      return array[top];
   }
   
   public static int size() {
      return countElements;
   }
}