public class HashTable<K, V> {
   private int size;
   Entry<K, V>[] hashTable;
   
   public HashTable(int setSize) {
      size = setSize;
      hashTable = new Entry[size];
   }
   
   public void insert(K key, V value) {
      int index = hashFunction(key);
      
      if (hashTable[index] == null) {
         hashTable[index] = new Entry(key, value);
         
         return;
      }
      
      Entry<K, V> focusEntry = hashTable[index];
      while (focusEntry.next != null) {
         if (focusEntry.getKey().equals(key)) {
            focusEntry.setValue(value);
            return;
         }
         focusEntry = focusEntry.next;
      }
      focusEntry.next = new Entry(key, value);
   }
   
   public void remove(K key) {
      int index = hashFunction(key);
      
      Entry<K, V> focusEntry = hashTable[index];
      
      if (focusEntry == null) {
         return;
      }
      
      if (focusEntry.getKey().equals(key)) {
         hashTable[index] = focusEntry.next;
         return;
      }
      
      while (focusEntry.next != null) {
         if (focusEntry.next.getKey().equals(key)) {
            focusEntry.next = focusEntry.next.next;
            return;
         }
         
         focusEntry = focusEntry.next;
      }
   }
   
   public V search(K key) {
      V value = null;
      
      int index = hashFunction(key);
      
      Entry<K, V> focusEntry = hashTable[index];
      while (focusEntry != null) {
         if (focusEntry.getKey().equals(key)) {
            value = focusEntry.getValue();
         }
         
         focusEntry = focusEntry.next;
      }
      
      return value;
   }
   
   public int hashFunction(K key) {
      return (key.hashCode() % size) & (size + (key.hashCode() % size));
   }
}