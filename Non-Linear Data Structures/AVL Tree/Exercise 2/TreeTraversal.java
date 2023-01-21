public class TreeTraversal {
   // TREE TRAVERSAL
      
   public void inorder(Node node) {
      if (node == null) {
         return;
      }
      
      inorder(node.getLeftChild());
      System.out.print(node.getData() + " ");
      inorder(node.getRightChild());
   }
   
   public void preorder(Node node) {
      if (node == null) {
         return;
      }
      
      System.out.print(node.getData() + " ");
      preorder(node.getLeftChild());
      preorder(node.getRightChild());
   }
   
   public void postorder(Node node) {
      if (node == null) {
         return;
      }
      
      postorder(node.getLeftChild());
      postorder(node.getRightChild());
      System.out.print(node.getData() + " ");
   }
   
   // Breadth-first traversal or level order traversal
   public void levelOrder(Node node) {
      DynamicQueue<Node> tempQueue = new DynamicQueue<Node>();
      
      tempQueue.enqueue(node);
      
      while(!tempQueue.isEmpty()) {
         Node temp = tempQueue.dequeue();
         System.out.print(temp.getData() + " ");
         
         if (temp.getLeftChild() != null) {
            tempQueue.enqueue(temp.getLeftChild());
         }
         
         if (temp.getRightChild() != null) {
            tempQueue.enqueue(temp.getRightChild());
         }
      }
   }
}