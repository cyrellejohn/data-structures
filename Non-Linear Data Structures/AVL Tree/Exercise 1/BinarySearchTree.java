public class BinarySearchTree extends TreeTraversal implements BinarySearchTreeADT {
   private Node root;
   
   // PRIMARY FUNCTIONS OF BINARY SEARCH TREE
   
   // Create an empty tree or reset the tree
   public Node create() {
      return root = null;
   }
   
   public void root(int key) {
      root = new Node(key);
   }
   
   public void insert(int key) {
      if (root == null) {
         root(key);
         
         return;
      }
      
      root = insert(root, key);
   }

   // Insert node in AVL Tree without duplicate values
   private Node insert(Node node, int key) {
      if (node == null) {
         node = new Node(key);
         
         return node;
      }
      
      if (key < node.getData()) {
         node.setLeftChild(insert(node.getLeftChild(), key));
      }
      
      else if (key > node.getData()) {
         node.setRightChild(insert(node.getRightChild(), key));
      }
      
      return node;
   }
   
   public void delete(int key) {
      root = delete(root, key);
   }
   
   private Node delete(Node node, int key) {
      if (node == null) {
         return node;
      }

      if (key < node.getData()) {
         node.setLeftChild(delete(node.getLeftChild(), key));
      }
      
      else if (key > node.getData()) {
         node.setRightChild(delete(node.getRightChild(), key));
      }
      
      else {
         // Deleting leaf node or node with 1 child 
         if (node.getLeftChild() == null) {
            return node.getRightChild();
         }
         
         else if (node.getRightChild() == null) {
            return node.getLeftChild();
         }
         
         // Deleting node with 2 children
         node.setData(getMin(node.getRightChild()).getData());
         node.setRightChild(delete(node.getRightChild(), node.getData()));
      }
      
      return node;
   }
   
   public boolean search(int key) {
      return search(root, key);
   }
   
   private boolean search(Node node, int key) {
      if (node == null) {
         return false;
      }
      
      if (key == node.getData()) {
         return true;
      }
      
      else if (key < node.getData()) {
         return search(node.getLeftChild(), key);
      }
      
      return search(node.getRightChild(), key);
   }
   
   // TREE TRAVERSAL
   
   public void inorder() {
      inorder(root);
   }
   
   public void preorder() {
      preorder(root);
   }
   
   public void postorder() {
      postorder(root);
   }
   
   // Breadth-first traversal or level order traversal
   public void levelOrder() {
      levelOrder(root);
   }
   
   // OTHERS
   
   public Node getRoot() {
      return root;
   }
   
   public void setRoot(Node node) {
      root = node;
   }

   // Get the max key of the root
   public Node getMax() {
      return getMax(root);
   }
   
   // Get max key depending on the given tree
   private Node getMax(Node node) {
      while (node.getRightChild() != null) {
         node = node.getRightChild();
      }
      
      return node;
   }
   
   // Get the min key of the root
   public Node getMin() {
      return getMin(root);
   }
   
   // Get the min key depending on the given tree
   public Node getMin(Node node) {
      while (node.getLeftChild() != null) {
         node = node.getLeftChild();
      }
      
      return node;
   }
}