public class AVLTree extends BinarySearchTree {
   
   // PRIMARY FUNCTIONS OF AVL TREE
   
   @Override
   public void insert(int key) {
      if (getRoot() == null) {
         root(key);
         
         return;
      }
      
      setRoot(insert(getRoot(), key));
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
      
      // If key matches the value of the node, return node
      else {
         return node; 
      }
      
      updateHeight(node);
      return applyRotation(node);
   }
   
   @Override
   public void delete(int key) {
      setRoot(delete(getRoot(), key));
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
      
      updateHeight(node);
      return applyRotation(node);
   }


   // REQUIRED FUNCTIONS
   
   // Apply rotation if tree is not balance
   private Node applyRotation(Node node) {
      int balance = updateBalance(node);
      
      // Left Right Rotation 
      if (balance > 1) {
         if (updateBalance(node.getLeftChild()) < 0) {
            node.setLeftChild(rotateLeft(node.getLeftChild()));
         }
         
         // If tree is left skewed apply only right rotation 
         return rotateRight(node);
      }
      
      // Right Left Rotation
      if (balance < -1) {
         if (updateBalance(node.getRightChild()) > 0) {
            node.setRightChild(rotateRight(node.getRightChild()));
         }
         
         // If tree is right skewed apply only left rotation
         return rotateLeft(node);
      } 
      
      // Return node if no rotation happens
      return node;
   }
   
   // Get the balance factor of the given node
   private int updateBalance(Node node) {
      if (node == null) {
         return 0;
      }
      
      return getHeight(node.getLeftChild()) - getHeight(node.getRightChild());
   }
   
   // Get the height of the node
   private int getHeight(Node node) {
      if (node == null) {
         return 0;
      }
      
      return node.getHeight();
   }
   
   // Get max value of two integers
   private int getMaxHeight(int left, int right) {
      if (left > right) {
         return left;
      }
      
      return right;
   }
   
   private Node rotateLeft(Node node) {
      // Initialization
      Node newRoot = node.getRightChild();
      Node centerNode = newRoot.getLeftChild();
      
      // Perform rotation
      newRoot.setLeftChild(node);
      node.setRightChild(centerNode);
      
      // Update height
      updateHeight(node);
      updateHeight(newRoot);
      
      return newRoot;
   }
   
   private Node rotateRight(Node node) {
      // Initialization
      Node newRoot = node.getLeftChild();
      Node centerNode = newRoot.getRightChild();
      
      // Perform rotation
      newRoot.setRightChild(node);
      node.setLeftChild(centerNode);
      
      // Update height
      updateHeight(node);
      updateHeight(newRoot);
      
      return newRoot;
   }
   
   // Update the height of the node
   private void updateHeight(Node node) {
      node.setHeight(1 + getMaxHeight(getHeight(node.getLeftChild()), getHeight(node.getRightChild())));
   }
}
