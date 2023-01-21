public class BinaryTree {
   private int nextPosition;
   private Node parent;
   private Node root;
   private Node recentLeaf;
   
   class Node {
      private Object data;
      private Node left;
      private Node right;
      
      public Node(Object key) {
         data = key;
      }
      
      public Object getData() {
         return data;
      }
   }
   
   // PRIMARY FUNCTIONS OF BINARY TREE
   
   // Create an empty tree or reset the tree
   public Node create() {
      nextPosition = 0;
      parent = null;
      recentLeaf = null;
      
      return root = null;
   }
   
   public void root(Object key) {
      root = new Node(key);
      
      if (nextPosition == 0) {
         parent = root;
         
         nextPosition++;
      }
   }
   
   // Insert a node in level order
   public void insert(Object key) {
      if (root == null) {
         root(key);
         
         return;
      }
      
      Node newNode = new Node(key);
      nextPosition++;
      
      /* Set the next position available to insert the key by 
         converting the nextPosition to an annotation of 
         left or right child using getEdge method */
      setParent(getEdge(nextPosition));
      
      if (parent.left == null) {
         parent.left = newNode;
         
         recentLeaf = parent.left;
      }
      
      else {
         parent.right = newNode;
         
         recentLeaf = parent.right; 
      }
   }
   
   public void delete(Object key) {
      nullError(root); // Return error if root is null 
      
      Node nodeToDelete = findNode(root, key);
      Node nodeToReplace = recentLeaf;
      
      if (nodeToDelete == null) {
         System.out.println("Key Not Found");
         return; 
      }
      
      if (nodeToDelete == nodeToReplace) {
         deleteRecentLeaf(getEdge(nextPosition));
      }
      
      else {
         nodeToDelete.data = nodeToReplace.data;
         
         deleteRecentLeaf(getEdge(nextPosition));
      }
      nextPosition--;
   }
   
   // SEARCH NODE ON BINARY TREE
   
   // findNode in Pre-Order Traversal
   public Node findNode(Node tree, Object key) {
      if (tree == null) {
         return null;
      }
      
      if (tree.data == key) {
         return tree;
      }
      
      Node foundNode = findNode(tree.left, key);
      
      if (foundNode != null) {
         return foundNode;
      }
      
      return findNode(tree.right, key);
   }
   
   public boolean search(Object key) {
      if (root == null) {
         return false;
      }
      
      Node foundNode = findNode(root, key);
      if (foundNode != null) {
         return true;
      }
      
      return false;
   }

   // REQUIRED FUNCTIONS
   
   public void deleteRecentLeaf(String edge) {
      setParent(edge); // Set the parent node
      
      if (parent.left == recentLeaf) {
         parent.left = null;
         
         // Set next parent and recentLeaf
         setParent(getEdge(nextPosition - 1));
         recentLeaf = parent.right;
      }
      
      else if (parent.right == recentLeaf) {
         parent.right = null;
         
         // Set recentLeaf
         recentLeaf = parent.left;
      }
   }
   
   /* Convert number of nodes in decimal to next position 
      available by traversing left and right child represented 
      in binary without the first and last number */  
   public String getEdge(int num) {
      String result = "";
      num = num / 2; // Remove first number in binary
      
      // num != 1 means removing the last number in binary
      while (num != 1) { 
         // remainder 0 means left and 1 means right
         String remainder = "" + num % 2; 
         result = remainder + result;
         
         num = num / 2;
      }
      
      return result;
   }
   
   public void setParent(String edge) {
      parent = root;
             
      for (int i = 0; i < edge.length(); i++) {   
         char bit = edge.charAt(i);
                                 
         if (bit == '0') { // 0 means left
            parent = parent.left;
         }
                                 
         else { // else or 1 means right
            parent = parent.right;
         } 
      }
   }
   
   // TREE TRAVERSAL

   public void inorder() {
      inorder(root);
   }
   
   public void inorder(Node tree) {
      if (tree == null) {
         return;
      }
      
      inorder(tree.left);
      System.out.print(tree.data + " ");
      inorder(tree.right);
   }
   
   public void preorder() {
      preorder(root);
   }
   
   public void preorder(Node tree) {
      if (tree == null) {
         return;
      }
      
      System.out.print(tree.data + " ");
      preorder(tree.left);
      preorder(tree.right);
   }
   
   public void postorder() {
      postorder(root);
   }
   
   public void postorder(Node tree) {
      if (tree == null) {
         return;
      }
      
      postorder(tree.left);
      postorder(tree.right);
      System.out.print(tree.data + " ");
   }
   
   // Breadth-first traversal or level order traversal
   public void levelOrder() {
      levelOrder(root);
   }
   
   public void levelOrder(Node tree) {
      DynamicQueue<Node> tempQueue = new DynamicQueue<Node>();
      
      tempQueue.enqueue(tree);
      
      while(!tempQueue.isEmpty()) {
         Node temp = tempQueue.dequeue();
         System.out.print(temp.data + " ");
         
         if (temp.left != null) {
            tempQueue.enqueue(temp.left);
         }
         
         if (temp.right != null) {
            tempQueue.enqueue(temp.right);
         }
      }
   }
   
   // OTHERS
   
   public int countNodes() {
      return nextPosition;
   }

   public Object data(Node tree) {
      nullError(tree);
      
      return tree.getData();
   }
   
   public boolean isEmpty(Node tree) {
      if (tree == null) {
         return true;
      }
      
      return false;
   }
   
   public Node lChild(Node tree) {
      nullError(tree);
      
      return tree.left;
   }
   
   // Generate error when given tree is null
   public void nullError(Node tree) {
      if (isEmpty(tree) == true) {
         tree.getData();
      }
   }
   
   public Node rChild(Node tree) {
      nullError(tree);
      
      return tree.right;
   }
   
   public Node getRoot() {
      return root;
   }
}