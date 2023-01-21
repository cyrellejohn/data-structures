public interface BinarySearchTreeADT {
   // Create an empty tree or reset the tree
   public Node create();
   
   // Insert node in AVL Tree without duplicate values
   public void insert(int key);
   public void delete(int key);
   public boolean search(int key);
   
   // Tree Traversal
   public void inorder();
   public void preorder();
   public void postorder();
   
   // Breadth-first traversal or level order traversal
   public void levelOrder();
   
   // Get the max key of the root
   public Node getMax();
   
   // Get the min key of the root
   public Node getMin();
} 