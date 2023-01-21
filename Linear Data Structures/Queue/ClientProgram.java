// Filename: ClientProgram.java
// Author: Cyrelle John A. Domingo
// Date Written: October 9, 2021

// Purpose: Test multiple implmentation of Queue

public class ClientProgram {
   public static void main(String[] args) {
      ArrayQueue queue = new ArrayQueue();
      ClientProgram run = new ClientProgram();
      
      System.out.println("Uncomment the code below");
      // run.arrayQueue();
      // run.circularQueueArray();
      // run.dynamicQueue();
   }
   
   public void arrayQueue() {
      ArrayQueue queue = new ArrayQueue();
      
      queue.enqueue(4);
      queue.enqueue(8);
      queue.enqueue(9);
      queue.enqueue(7);
      queue.enqueue(5);
      queue.enqueue(3);
      queue.enqueue(2);
      queue.enqueue(6);
      
      queue.dequeue();
      queue.dequeue();
      
      // queue.enqueue(26); // Throws an error 
      
      queue.print();
   }
   
   public void circularQueueArray() {
      CircularQueueArray queue = new CircularQueueArray();
      
      queue.enqueue(4);
      queue.enqueue(8);
      queue.enqueue(9);
      queue.enqueue(7);
      queue.enqueue(5);
      queue.enqueue(3);
      queue.enqueue(2);
      queue.enqueue(6);
      
      queue.dequeue();
      queue.dequeue();
      
      queue.enqueue(26);
      queue.enqueue(82);
      
      queue.dequeue();
      System.out.println("Front: " + queue.front());
      
      queue.print();
   }
   
   public void dynamicQueue() {
      DynamicQueue queue = new DynamicQueue();
      
      queue.enqueue(4);
      queue.enqueue(8);
      queue.enqueue(9);
      queue.enqueue(7);
      queue.enqueue(5);
      queue.enqueue(3);
      queue.enqueue(2);
      queue.enqueue(6);
      
      queue.dequeue();
      queue.dequeue();
      
      queue.enqueue(26);
      queue.enqueue(82);
      
      queue.dequeue();
      System.out.println("Front: " + queue.front());
      
      queue.print();
   }
}