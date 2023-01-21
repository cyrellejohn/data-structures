import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.charset.Charset;

public class ClientProgram {
   private AVLTree tree = new AVLTree();
   
   public ClientProgram() {
      setAVLTree();
   }

   // Converting file input to AVLTree
   private void setAVLTree() {
      CheckPath check = new CheckPath();
           
      check.setFilePath("inputNum.txt"); // File input
      
      BufferedReader reader = null;
      FileReader fileReader = null;
      String currentLine;
      
      try {
         // Uses FileReader with explicit character enconding to avoid problems in the future
         fileReader = new FileReader(check.getFilePath(), Charset.forName("UTF-8"));
         reader = new BufferedReader(fileReader);
         
         // Assign each line in the file to currentLine
         while ((currentLine = reader.readLine()) != null) {
            // Separate text when encountered with ','
            String[] stringArr = currentLine.split(",");
            
            for (String key : stringArr) {
               tree.insert(Integer.parseInt(key));
            } 
         }
      }
      
      catch (Exception e) {
         System.out.println("Please contact the programmer.");
         e.printStackTrace();
      }
   }
   
   public int findMax() {
      return tree.getMax().getData();
   }
   
   public int findMin() {
      return tree.getMin().getData();
   }
}