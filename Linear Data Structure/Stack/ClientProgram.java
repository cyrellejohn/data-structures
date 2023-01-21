// Filename: ClientProgram.java
// Author: Cyrelle John A. Domingo
// Date Written: October 9, 2021

// Purpose: Convert Infix to Postfix

public class ClientProgram {
   public static void main(String[] args) {
      ConvertInfex convert = new ConvertInfex();
      
      String infix = "((a + (c - d)) / e)";
      String toPostfixArray = convert.toPostfixArray(infix);
      String toPostfixLL = convert.toPostfixLL(infix);
      
      System.out.println("Input Infix: " + infix);
      System.out.println("\nInfix to Postfix Using Array: " + toPostfixArray);
      System.out.println("\nInfix to Postfix Using Singly Linked List: " + toPostfixLL);
   }
}