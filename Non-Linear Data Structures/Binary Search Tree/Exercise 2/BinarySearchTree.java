public class BinarySearchTree {
   private Node root;
   
   class Node {
      private int data;
      private Node left;
      private Node right;
      
      public Node(int key) {
         data = key;
      }
      
      public int getData() {
         return data;
      }
   }
   
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
      }
      
      else {
         insert(root, key);
      }
   }

   public Node insert(Node tree, int key) {
      if (tree == null) {
         tree = new Node(key);
         
         return tree;
      }
      
      if (key < tree.data) {
         tree.left = insert(tree.left, key);
      }
      
      else if (key > tree.data) {
         tree.right = insert(tree.right, key);
      }
      
      return tree;
   }
   
   public void delete(int key) {
      // Execute statement if key does not match on the data of the root
      if (key != root.data) {
         delete(root, key);
         
         return;
      }
      
      // Otherwise delete root by creating temporary root
      Node tempRoot = getTempRoot();
      delete(tempRoot, key);
               
      root = tempRoot.right;  
   }
   
   public void delete(Node tree, int key) {
      int child = 0;
      Node nodeToDelete = null;
      Node parent = getParent(tree, key);
      
      if (parent == null) {
         return;
      }
      
      // If left child data of parent matches the key 
      if (parent.left != null && parent.left.data == key) {
         nodeToDelete = parent.left; // Store matching node on nodeToDelete
         
         child = 1; // 1 means left 
      }
      
      // If right child data of parent matches the key 
      else if (parent.right != null && parent.right.data == key) {
         nodeToDelete = parent.right; // Store matching node on nodeToDelete
         child = 2; // 2 means right
      }
      
      // Deleting leaf node
      
      if (nodeToDelete.left == null && nodeToDelete.right == null) {
         deleteChild(parent, child); // Delete nodeToDelete thru the parent
      }
      
      // Deleting node with 1 child
      
      else if (nodeToDelete.left == null || nodeToDelete.right == null) {
         if (nodeToDelete.left != null) {
            Node nodeToReplace = nodeToDelete.left;
            
            replaceChild(parent, nodeToReplace, child); 
         }
         
         else {
            Node nodeToReplace = nodeToDelete.right;
            
            replaceChild(parent, nodeToReplace, child);
         }
      }
      
      // Deleting node with 2 children
      
      else {
         int inorderSuccessor = getMin(nodeToDelete.right).data;
         nodeToDelete.data = inorderSuccessor;
         
         delete(nodeToDelete.right, inorderSuccessor);
      }
   }
   
   public boolean search(int key) {
      if (root.data == key) {
         return true;
      }
      
      Node search = getParent(root, key);
      
      if (search == null) {
         return false;
      }
      
      return true;
   }
   
   // REQUIRED FUNCTIONS
   
   // Delete child node
   public void deleteChild(Node parent, int child) {
      // Run replaceChild method with the argument null on the nodeToReplace
      replaceChild(parent, null, child);
   }
   
   // Get the parent of the given key
   public Node getParent(Node tree, int key) {
      if (tree == null) {
         return null;
      }
      
      if (tree.left == null && tree.right == null) {
         return null;
      }
      
      // If left or right child data matches the key return the tree
      if (tree.left != null && tree.left.data == key || tree.right != null && tree.right.data == key) {
         return tree;
      }
      
      if (key < tree.data) {
         return getParent(tree.left, key);
      }
      
      else if (key > tree.data) {
         return getParent(tree.right, key);
      }
      
      return null; // Return null if key is not found
   }
   
   // Replace child node
   public void replaceChild(Node parent, Node nodeToReplace, int child) {
      // 1 means left
      if (child == 1) {
         parent.left = nodeToReplace;
      }
      
      // 2 means right
      else if (child == 2) {
         parent.right = nodeToReplace;
      }
   }
   
   // Create temporary root
   public Node getTempRoot() {
      Node tempRoot = new Node(0);
      tempRoot.right = root;
      
      return tempRoot;
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
   
   // Delete all children on the given node
   public void deleteDescendant(int ancestor) {
      Node parent = null;
      
      boolean search = search(ancestor);
      
      if (search == false) {
         System.out.println("Ancestor Does Not Exist");
         return;
      }
      
      if (root.data == ancestor) {
         Node tempRoot = getTempRoot();
         
         parent = tempRoot;
      }
      
      else {
         parent = getParent(root, ancestor);
      }
      
      // If left child matches the ancestor delete all the children
      if (parent.left != null && parent.left.data == ancestor) {
         deleteChild(parent.left, 1); // Delete left child
         deleteChild(parent.left, 2); // Delete right child
      }
      
      // Else delete all children on the right child of the parent
      else if (parent.right != null && parent.right.data == ancestor) {
         deleteChild(parent.right, 1);
         deleteChild(parent.right, 2);
      } 
   }
   
   // Get the max key of the root
   public Node getMax() {
      return getMax(root);
   }
   
   // Get the min key depending on the given tree
   public Node getMax(Node tree) {
      while (tree.right != null) {
         tree = tree.right;
      }
      
      return tree;
   }
   
   // Get the min key of the root
   public Node getMin() {
      return getMin(root);
   }
   
   // Get the min key depending on the given tree
   public Node getMin(Node tree) {
      while (tree.left != null) {
         tree = tree.left;
      }
      
      return tree;
   }
}