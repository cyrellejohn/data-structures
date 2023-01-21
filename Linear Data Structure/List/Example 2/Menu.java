import java.util.Scanner;

// Main Menu
public class Menu {
   private static final String N = System.getProperty("line.separator"); // Print a new line like using an \n 
   Covid19F0Tracker person = new Covid19F0Tracker();
   LinkedList list = new LinkedList();
   private String name;
   
   public void mainMenu() {
      Scanner input = new Scanner(System.in);
      String option = "";
      
      // Displaying Main Menu
      System.out.println(N + N + String.format("%78s", "COVID-19 POSITIVE TRACKER") + N + N + N);
      list.printThreeAtATime();
      System.out.println(N + N + String.format("%39s %34s %30s", "[1]ADD PERSON", "[2]DELETE PERSON", "[3]SEARCH PERSON") + N);
      System.out.println(String.format("%70s", "[4]EXIT") + N + N);
      
      // Selecting an option
      while(option.equals("")) {
         System.out.print("Select: ");
         option = input.nextLine();
         
         if(option.equals("1")) {
            addPersonMenu();
         }
         
         else if(option.equals("2")) {
            deletePersonMenu();
         }
         
         else if(option.equals("3")) {
            findPersonMenu();
         }
         
         else if(option.equals("4")) {
            System.exit(0);
         }
         
         else {
            option = "";
         }
      }
   }
   
   // Menu for adding an F0 person
   public void addPersonMenu() {
      Scanner input = new Scanner(System.in);
      String number = "";
      String status = "";
      
      System.out.print("Name: ");
      name = input.nextLine();
      
      while(number.equals("")) {
        System.out.print("Number: ");
        number = person.checkNumber(input.nextLine()); // Formatting the phone number
      }
       
      System.out.println(N + String.format("%45s %45s", "[1]RECOVERED", "[2]QUARANTINED") + N); // Status of the F0 Person
      while(status.equals("")) {
         System.out.print("Status: ");
         status = input.nextLine();
         
         if(status.equals("1")) {
            status = "Recovered";
         }
         
         else if(status.equals("2")) {
            status = "Quarantined";
         }
         
         else {
            status = "";
         }
      }
      person.addContact(name, number, status); // Adding contact info to the list
      mainMenu();
   }
   
   // Menu for deleting F0 person info
   public void deletePersonMenu() {
      Scanner input = new Scanner(System.in);
      
      System.out.print("Name: ");
      name = input.nextLine();
      person.deleteContact(name); // Deleting contact info to the list
      mainMenu();
   }
   
   // Menu for searching F0 person using name or number
   public void findPersonMenu() {
      Scanner input = new Scanner(System.in);
      String nameOrNum;
      String option = "";
      
      System.out.print("Name or Number: ");
      nameOrNum = input.nextLine();
      
      // If nameOrNum contains a plus sign and digits format the nameOrNum
      if(nameOrNum.matches("\\+[0-9]+$")) {
         nameOrNum = person.checkNumber(nameOrNum);
      }

      System.out.println(N + N);
      person.findContact(nameOrNum); // Finding contact info on the list
      System.out.println(N + N + N);
      
      // Try searching again or go to Main Menu
      while(option.equals("")) {
         System.out.println(N + String.format("%45s %45s", "[1]SEARCH AGAIN", "[2]EXIT") + N);
         
         System.out.print("Select: ");
         option = input.nextLine();
         
         if(option.equals("1")) {
            findPersonMenu();
         }
         
         else if(option.equals("2")) {
            mainMenu();
         }
            
         else {
            option = "";
         }
      }
   }
}