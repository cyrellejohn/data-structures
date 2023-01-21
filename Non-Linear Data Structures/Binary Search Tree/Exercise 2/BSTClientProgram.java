import java.util.Scanner;

public class BSTClientProgram extends BinarySearchTree {
   public void menu() {
      deleteDescendantMenu();
   }
   
   public void deleteDescendantMenu() {
      Scanner input = new Scanner(System.in);
      int ancestor;
      String stop = "";
      
      System.out.println("Binary Search Tree Delete Descendant Menu\n");
      
      while (stop.equals("")) {
         System.out.print("\nIn-Order Traversal: ");
         inorder();
      
         System.out.print("\n\nType Ancestor Node: ");
         while(!input.hasNextInt()) {
            System.out.print("Type Ancestor Node: ");
            input.next();
         }
         ancestor = input.nextInt();
         deleteDescendant(ancestor);
         
         System.out.print("\nOutput: ");
         inorder();
         
         System.out.print("\n\nStop (Y/N) : " );
         stop = input.next();
         
         if (stop.equals("y") || stop.equals("Y")) {
            stop = "y";
         }
         
         else {
            stop = "";
         }
      }
   }
}