import java.util.Scanner;

public class Covid19F0Tracker {
   LinkedList list = new LinkedList();
   private String contactInfo;
   
   public void addContact(String name, String number, String status) {
      list.addLast(name);
      list.addLast(number);
      list.addLast(status);
   }
   
   public void deleteContact(String name) {
      int index = list.indexOf(name);
      list.deleteNextThree(index);
   }
   
   // findContact() method accepts name or number as parameter
   public void findContact(String nameOrNum) {
      int index = list.indexOf(nameOrNum); // Returns the index of element if found otherwise return -1
      
      if(index == -1) {
         System.out.println(String.format("%79s", "NAME OR NUMBER DOES NOT EXIST"));
      }
      
      // Execute this statements if nameOrNum are all numbers
      else if(nameOrNum.matches("[0-9]+")) { 
         list.printThreeNode(index - 1); // Print name, contact and status using phone number
      }
      
      else {
         list.printThreeNode(index); // Print name, contact and status using name
      }
   }
   
   // Formatting the phone number
   public String checkNumber(String number) {
      if(number.startsWith("09") && number.length() == 11) {
         number = number;
      }
      
      else if(number.startsWith("+639") && number.length() == 13) {
         number = number.replaceFirst("\\+639", "09");
      }
      
      else if(number.startsWith("9") && number.length() == 10) {
         number = number.replaceFirst("9", "09");
      }
      
      else if(number.startsWith("639") && number.length() == 12) {
         number = number.replaceFirst("639", "09");
      }
      
      else {
         number = "";
      }
      
      if(!number.matches("[0-9]+")) {
         number = "";
      }
      
      return number;
   }
}