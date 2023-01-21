public class Node {
   private int data;
   private int height;
   private Node left;
   private Node right;
         
   public Node(int key) {
      data = key;
      height = 1;
   }
   
   public int getData() {
      return data;
   }
   
   public void setData(int key) {
      data = key;
   }
   
   public int getHeight() {
      return height;
   }
   
   public void setHeight(int newHeight) {
      height = newHeight;
   }
   
   public Node getLeftChild() {
      return left;
   }
   
   public void setLeftChild(Node node) {
      left = node;
   }
   
   public Node getRightChild() {
      return right;
   }

   public void setRightChild(Node node) {
      right = node;
   }
}