public class ConvertInfex {
   // Returns the precedence of operators. Higher value means higher precedence
   public static int precedence(char infix) {
      if (infix == '+' || infix == '-') {
         return 1;
      }
      
      else if (infix == '*' || infix == '/') {
         return 2;
      }
      
      else if (infix == '^') {
         return 3;
      }
      
      return 0; // Parenthesis is an example that returns 0
   }
   
   // Converts Infix to Postfix using Array
   public String toPostfixArray(String infix) {
      infix = infix.replaceAll("\\s", "");
      String postfix = "";
      ArrayStack stack = new ArrayStack(infix.length());

      for (int i = 0; i < infix.length(); i++) {
         char symbol = infix.charAt(i);
         
         if (Character.isLetterOrDigit(symbol)) {
            postfix = postfix + symbol;
         }
         
         else if (symbol == '(') {
            stack.push(symbol);
         }
         
         else if (symbol == ')') {
            while (!stack.peek().equals('(')) {
               postfix = postfix + stack.pop();
            }
            stack.pop();
         }
         
         else {
            while (!stack.isEmpty() && precedence(symbol) <= precedence((char) stack.peek())) {
               postfix = postfix + stack.pop();   
            }
            stack.push(symbol);
         }
      }
       
      while (!stack.isEmpty()) {
         postfix = postfix + stack.pop();
      }
      
      return postfix;
   }
   
   // Converts Infix to Postfix using Singly Linked List
   public String toPostfixLL(String infix) {
      infix = infix.replaceAll("\\s", ""); // Remove spaces to lessen the space use
      String postfix = "";
      DynamicStack stack = new DynamicStack();

      for (int i = 0; i < infix.length(); i++) {
         char symbol = infix.charAt(i);
         
         if (Character.isLetterOrDigit(symbol)) {
            postfix = postfix + symbol;
         }
         
         else if (symbol == '(') {
            stack.push(symbol);
         }
         
         else if (symbol == ')') {
            while (!stack.peek().equals('(')) {
               postfix = postfix + stack.pop();
            }
            stack.pop();
         }
         
         else {
            while (!stack.isEmpty() && precedence(symbol) <= precedence((char) stack.peek())) {
               postfix = postfix + stack.pop();   
            }
            stack.push(symbol);
         }
      }
       
      while (!stack.isEmpty()) {
         postfix = postfix + stack.pop();
      }
      
      return postfix;
   }
}