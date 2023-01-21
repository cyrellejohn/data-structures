// Author: Cyrelle John A. Domingo
// Date Written: December 10, 2021

// Purpose: AVL Tree Implementation Testing

public class StartHere {
   public static void main(String[] args) {
      AVLTree tree = new AVLTree();
      
      tree.insert(9);
      tree.insert(5);
      tree.insert(10);
      tree.insert(0);
      tree.insert(6);
      tree.insert(11);
      tree.insert(-1);
      tree.insert(1);
      tree.insert(2);
      
      System.out.print("Preorder Traversal: ");
      tree.preorder();
      
      System.out.println("\n\nDeleting 10 in the AVL Tree\n");
      tree.delete(10);
      
      System.out.print("Preorder Traversal: ");
      tree.preorder();
      
      System.out.println("\n\nFinding 11 in the AVL Tree\n");
      
      System.out.print("Is 11 exist on AVL Tree: " + tree.search(11));
   }
}