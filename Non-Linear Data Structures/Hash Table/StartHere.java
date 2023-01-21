// Author: Cyrelle John A. Domingo
// Date Written: December 24, 2021

public class StartHere {
   public static void main(String[] args) {
      HashTable<String, Integer> map = new HashTable<>(10);
      
      map.insert("coder", 1);
      map.insert("codering", 2);
      
      System.out.println(map.search("coder"));
      map.remove("coder");
      System.out.println(map.search("coder"));
   }
}  