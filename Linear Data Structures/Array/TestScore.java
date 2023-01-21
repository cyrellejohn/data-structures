// Filename: TestScore.java
// Author: Cyrelle John A. Domingo
// Date Written: September 18, 2021

/* Purpose: Calculate lowest, highest, average of the test score 
   and the number of student that their score is above average */

abstract class Grade {
   public abstract void calculate(int classTestScores[], int totalStud);
   public abstract int findLargest();
   public abstract int findSmallest();
   public abstract double getAverage();
   public abstract int getNumStud();
}

class GradeCalculator extends Grade {
   private double average;
   private int largest;
   private int smallest;
   private int studAboveAverage;
   
   @Override
   public void calculate(int classTestScores[], int totalStud) {
      int sum = 0;
      
      // smallest and largest is initialized with the value of the first element of the array classTestScores
      smallest = classTestScores[0];
      largest = classTestScores[0];
      
      for(int i = 0; i < totalStud; i++) {
         sum = sum + classTestScores[i];
         
         // If the score is smaller than the compared value, assign score as the new smallest value and skip the next condition
         if(classTestScores[i] < smallest) {
            smallest = classTestScores[i];
         }
         
         // This condition is executed if the first condition is false. If the score is larger than the compared value, assign score as the new largest value
         else if(classTestScores[i] > largest) {
            largest = classTestScores[i];
         }
      }
      average = (double) sum / totalStud;
      
      for(int i = 0; i < totalStud; i++) {
         // If the score is above the average, add one to the studAboveAverage variable
         if(classTestScores[i] > average) {
            studAboveAverage++;
         }
      }
   }

   @Override
   public int findLargest() {
      return largest;
   }
   
   @Override
   public int findSmallest() {
      return smallest;
   }
   
   @Override
   public double getAverage() {
      return average;
   }
   
   @Override
   public int getNumStud() {
      return studAboveAverage;
   }
}

public class TestScore {
   public static void main(String[] args) {
      GradeCalculator grade = new GradeCalculator();
      int totalStud;
      
      totalStud = 8;
      int[] classTestScores = {83, 7, 70, 86, 93, 94, 19, 17};
      
      grade.calculate(classTestScores, totalStud);
      
      System.out.println("Largest Test Score: " + grade.findLargest());
      System.out.println("Smallest Test Score: " + grade.findSmallest());
      System.out.println("Test Score Average: " + grade.getAverage());
      System.out.print("Number of Student Above Average: " + grade.getNumStud());
   }
}