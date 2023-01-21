// Author: Cyrelle John A. Domingo
// Date Written: November 20, 2021

// Purpose: Implementation Testing of Binary Search Tree

public class StartHere {
   public static void main(String[] args) {
      StartHere run = new StartHere();
      BinarySearchTree tree = new BinarySearchTree();
      
      tree.insert(50);
      tree.insert(30);
      tree.insert(20);
      tree.insert(40);
      tree.insert(70);
      tree.insert(60);
      tree.insert(80);
      tree.insert(65);
      tree.insert(55);
      tree.insert(85);
      tree.insert(90);
      
      System.out.print("Level Order Traversal or BFS: ");
      tree.levelOrder();
      
      tree.delete(90); // Deleting Leaf
      System.out.print("\nLevel Order Traversal or BFS: ");
      tree.levelOrder();
      
      tree.delete(80); // Deleting node with 1 child
      System.out.print("\nLevel Order Traversal or BFS: ");
      tree.levelOrder();
      
      tree.delete(50); // Deleting node with 2 children
      System.out.print("\nLevel Order Traversal or BFS: ");
      tree.levelOrder();
      
      System.out.println("\n\nSearch 50: " + tree.search(50));
      System.out.println("\nSearch 55: " + tree.search(55));
      
      tree.create();
      System.out.print("\n\nTree: ");
      tree.inorder();
      
      run.testTwo();
   }
   
   public void testTwo() {
      BinarySearchTree tree = new BinarySearchTree();
      
      tree.root(50);
      tree.insert(30);
      tree.insert(20);
      tree.insert(40);
      tree.insert(70);
      tree.insert(60);
      tree.insert(80);
      tree.insert(65);
      tree.insert(55);
      tree.insert(85);
      tree.insert(90);
      
      System.out.println("\n\nBinary Tree Traversal");
      System.out.print("\nInorder Traversal: ");
      tree.inorder();
      
      System.out.print("\nPreorder Traversal: ");
      tree.preorder();
      
      System.out.print("\nPostorder Traversal: ");
      tree.postorder();
      
      // Finding the minimum and maximum keys
      
      System.out.print("\n\nMinimum key: " + tree.getMin().getData());
      System.out.print("\nMaximum key: " + tree.getMax().getData());
   }
}