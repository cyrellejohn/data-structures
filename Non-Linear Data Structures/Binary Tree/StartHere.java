// Author: Cyrelle John A. Domingo
// Date Written: November 20, 2021

// Purpose: Implementation Testing of Binary Tree

public class StartHere {
   public static void main(String[] args) {
      StartHere run = new StartHere();
      BinaryTree tree = new BinaryTree();
      int numOfNodes;
      String parent;
      
      tree.insert(10);
      tree.insert(11);
      tree.insert(9); 
      tree.insert(7); 
      tree.insert(17); 
      tree.insert(13);
      tree.insert(8);
      tree.insert(99);
      
      tree.delete(99);
      tree.delete(8);
      
      System.out.print("Level Order Traversal or BFS: ");
      tree.levelOrder();
      
      System.out.println("\n\nIs 99 in the Binary Tree: " + tree.search(99));
      System.out.println("Is 13 in the Binary Tree: " + tree.search(13));
      
      numOfNodes = tree.countNodes();
      
      System.out.println("\nNumber of Nodes: " + numOfNodes);
      tree.deleteRecentLeaf(tree.getEdge(numOfNodes));
      System.out.print("Deleting Recent Leaf: ");
      tree.levelOrder();
      
      System.out.println("\n\nBinary Tree Traversal");
      System.out.print("\nInorder Traversal: ");
      tree.inorder();
      
      System.out.print("\nPreorder Traversal: ");
      tree.preorder();
      
      System.out.print("\nPostorder Traversal: ");
      tree.postorder();
      
      tree.create();
      System.out.print("\n\nTree: ");
      tree.inorder();
      
      run.testTwo();
   }
   
   public void testTwo() {
      BinaryTree tree = new BinaryTree();
      
      tree.root(77);
      tree.insert(11);
      tree.insert(9); 
      tree.insert(7); 
      tree.insert(17); 
      tree.insert(13);
      tree.insert(8);
      tree.insert(99);
      tree.insert(27);
      
      System.out.println("\n\nRoot: " + tree.getRoot().getData());
      
      System.out.print("Level Order Traversal on Left Subtree: ");
      tree.levelOrder(tree.lChild(tree.getRoot()));
      
      System.out.print("\nLevel Order Traversal on Right Subtree: ");
      tree.levelOrder(tree.rChild(tree.getRoot()));
   }
}