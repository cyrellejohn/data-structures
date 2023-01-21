// Filename: ClientProgram.java
// Author: Cyrelle John A. Domingo
// Date Written: September 24, 2021

// Purpose: Testing Linked List

public class ClientProgram {
   LinkedList list = new LinkedList();
   
   public static void main(String[] args) {
      ClientProgram program = new ClientProgram();
      
      System.out.println("Undo the comment below");
      // program.testOne();
      // program.testTwo();
      // program.testThree();
      // program.testFour();
   }
   
   public void testOne() {
      LinkedList list = new LinkedList();
      
      System.out.println("\nTest 4");
      
      System.out.println("\nAdding first element");
      list.addFirst(10);
      list.print();
      
      System.out.println("\nDeleting Index: " + 0);
      list.deleteIndex(0);
      System.out.println("Refreshing");
      list.print();
      
      System.out.println("\nAdding and Deleting Elements");
      list.addLast(1);
      list.addLast(70);
      list.addIndex(0, 77);
      list.deleteIndex(1);
      list.print();
      
      System.out.println("\nSearch: " + 90);
      list.search(90);
      
      System.out.println("\nDelete: " + 99);
      list.deleteItem(99);
   }
   
   public void testTwo() {
      LinkedList list = new LinkedList();
      
      System.out.println("\nTest 3");
      
      System.out.println("\nAdding element");
      list.addLast(1);
      list.addLast(70);
      list.print();
      
      System.out.println("\nAdding element on index 0");
      list.addIndex(0, 77);
      list.print();
      
      System.out.println("\nExecuting deleteLast 5 times");
      list.deleteLast();
      list.deleteLast();
      list.deleteLast();
      list.deleteLast();
      list.deleteLast();
      list.print();
   }
   
   public void testThree() {
      System.out.println("\nTest d");
      
      list.addFirst(10);
      list.addFirst(20);
      System.out.println("\nNumber of Nodes: " + list.getSize());
      list.print();
      
      System.out.println("Searching: " + 10);
      list.search(10);
      
      System.out.print("\n\nDeleting the first occurence of search item: " + 10);
      list.deleteItem(10);
      System.out.println("\nRefreshing");
      list.print();
      System.out.println("Number of Nodes: " + list.getSize());
   }
   
   public void testFour() {
      System.out.println("\nTest 2");
      
      list.addFirst(10);
      list.addFirst(20);
      list.print();
      System.out.println("\nFinding element: " + 77);
      list.search(77);
      list.print();
      
      System.out.println("\n\nExecuting deleteFirst 3 times");
      list.deleteFirst();
      list.deleteFirst();
      list.deleteFirst();
      list.print();
      
      
      System.out.println("\nTrying to delete elements again even empty");
      list.deleteFirst();
      list.print();
   }
}