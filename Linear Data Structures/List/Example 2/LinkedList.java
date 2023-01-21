public class LinkedList {
   private static Node head;
   private static int countNodes; // countNodes being added or deleted. Starts with the count of 1
   
   public LinkedList() {
   
   }
   
   class Node {
      private Node next;
      private Object data;
      
      public Node(Object item) {
         data = item;
         
      }
      
      public Object getData() {
         return data;
      }
   }
   
   // ADDING NODE TO LL STARTS HERE
   
   public void addFirst(Object item) {
      Node newNode = new Node(item);
      
      // If there is no head execute the statement
      if(head == null) {
         head = newNode;
         countNodes++;
      }
      
      else {
         Node temp = head;
         head = new Node(item);
         head.next = temp;
         
         countNodes++;
      }   
   }
   
   public void addLast(Object item) {
      // If there is no existing node execute the statement
      if(countNodes == 0) {
         addFirst(item);
      }
      
      else {
         Node temp = head;
         while(temp.next != null) {
            temp = temp.next;
         }
         temp.next = new Node(item);
         countNodes++;
      }
   }
   
   public void addIndex(int index, Object item) {
      // If index is greater than the number of nodes throw an error
      if(index > countNodes) {
         throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + countNodes);
      }
      
      else if(index == 0) {
         addFirst(item);
      } 
      
      else {
         Node temp = head;
         Node holder;
         
         for(int i = 0; i < index - 1 && temp.next != null; i++) {
            temp = temp.next;
         }
         
         holder = temp.next;
         temp.next = new Node(item);
         temp.next.next = holder;
         countNodes++;
      }
   }
   
   // DELETE NODE ON LL STARTS HERE
   
   public void deleteFirst() {
      if(countNodes == 0) {
         System.out.println("No Elements Detected");
      }
      
      else if(countNodes == 1) {
         head = null;
         countNodes--;
      }
      
      else {
         head = head.next;
         countNodes--;
      }
   }
   
   public void deleteLast() {
      if(countNodes == 0) {
         System.out.println("No Elements Detected");
      }
      else if(countNodes == 1) {
         deleteFirst();
      }
      
      else {
         Node temp = head;
         while(temp.next.next != null) { 
            temp = temp.next;
         }
         
         temp.next = null;
         countNodes--;
      }
   }
   
   public void deleteIndex(int index) {
      if(index >= countNodes) {
         throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + countNodes);
      }
      
      else if(index == 0) {
         deleteFirst();
      }
      
      else {
         Node temp = head;
         for(int i = 0; i < index - 1 && temp.next != null; i++) {
            temp = temp.next;
         }
         temp.next = temp.next.next;
         countNodes--;
      } 
   }
   
   // Deleting specific element
   public void deleteItem(Object item) {
      Node temp = head;
      int index = indexOf(item); // Searching the index of the element
      
      if(index == -1) {
         System.out.println("Element Not Found");
      }
      
      else {
         deleteIndex(index);
      }
   }
   
   // Deleting next three nodes that starts on the specific element
   public void deleteNextThree(int index) {
      Node temp = head;
      
      // If index is greater than the number of nodes or there is no existing nodes throw an error
      if(index >= countNodes || countNodes == 0) {
         throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + countNodes);
      }
      
      // If index or item found on index 0 make the new head after 3 nodes
      else if(index == 0) {
         head = temp.next.next.next; 
         countNodes = countNodes - 3;
      }
      
      // Assign new head after 3 nodes
      else {
         for(int i = 0; i < index - 1 && temp.next != null; i++) {
            temp = temp.next;
         }
         temp.next = temp.next.next.next.next;
         countNodes = countNodes - 3;
      }
   }
   
   // PRINT NODE ON LL
   
   public static void print() {
      Node temp = head;
      
      while(temp != null) {
         System.out.println(temp.data);
         temp = temp.next;
      }
   }
   
   // Print three nodes at a time
   public void printThreeAtATime() {
      Node temp = head;
      
      while(temp != null) {
         System.out.print(String.format("%39s %32s %32s", temp.data, temp.next.data, temp.next.next.data));
         temp = temp.next.next.next;
         System.out.println();
      }
   }
   
   // Print only 3 nodes that starts on the specified index
   public void printThreeNode(int index) {
      Node temp = head;
   
      if(index >= countNodes) {
         throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + countNodes);
      }
      
      // Print if specified index is on index 0
      else if(index == 0) {
         System.out.println("inside 1: " + index);
         System.out.print(String.format("%39s %32s %32s", temp.data, temp.next.data, temp.next.next.data));
      }
      
      else {
         // Print after locating the index
         System.out.println("inside 2: " + index);
         for(int i = 0; i < index - 1 && temp.next != null; i++) {
            temp = temp.next;
            System.out.println("inside 2.5: " + temp.data);
         }
         System.out.println("inside 3: " + index);
         System.out.println("inside 4: " + temp.data);
         System.out.print(String.format("%39s %32s %32s", temp.next.data, temp.next.next.data, temp.next.next.next.data));
      }
   }
   
   // SEARCH NODE ON LL
   
   public void search(Object item) {
      int index = indexOf(item);
      
      if(index == -1) {
         System.out.println("Element Not Found"); 
      }
      
      else {
         System.out.println("Element Found On Index " + index);
      }
   }
   
   // OTHERS
   
   // Returns the index of the element being search otherwise return -1
   public int indexOf(Object item) {
      Node temp = head;
      boolean elementExist = false;
      int index = -1;
      
      while(temp != null) {
         /* If element is equals to the item break while loop then return index. 
            Otherwise increment index. .equals is use to accomodate String datatype */
         if(temp.data.equals(item)) {
            elementExist = true;
            index++;
            break; 
         }
         index++;
         temp = temp.next;
      }
      
      if(elementExist == false) {
         index = -1;
      }
      return index;
   }
   
   public static int getSize() {
      return countNodes;
   }
}