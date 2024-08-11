import java.util.Scanner;


public class Program {
   public static void printResult(int counter, long totalMinGrades) {
      for (int i = 1; i <= counter; i++) {
         System.out.print("Week " + i + " ");
         for (int j = 1; j <= totalMinGrades % 10; j++) {
            System.out.print("=");
         }
         System.out.println(">");
         totalMinGrades /= 10;
      }
   }
   public static long storeMinGrades(int minGrade, long totalMinGrades, int counter) {
      if (counter == 0) {
         totalMinGrades += minGrade;
      }
      else {
         long multiplier = 1;
         for (int i = 0; i < counter ; i++) {
            multiplier *= 10;  
         }
         totalMinGrades += (minGrade * multiplier);
      }
      return totalMinGrades;
   }
   public static void main(String[] args) {
   Scanner scan = new Scanner(System.in);
   String weekNumber = "";
   String testResults = "";
   int counter = 0;
   int minGrade = 0;
   int testGrade;
   long totalMinGrades = 0;
   while (true) {
      weekNumber = scan.nextLine();
      if (weekNumber.equals("42")) {
         break;
      }
      if (!weekNumber.equals("Week " + (counter + 1)))
      {
         System.out.println("IllegalArgument");
         System.exit(-1);
      }
      testResults = scan.nextLine();
      Scanner numberScanner = new Scanner(testResults);
      minGrade = 0;
      while(numberScanner.hasNextInt()) {
         testGrade = numberScanner.nextInt();
         if (minGrade == 0 || minGrade > testGrade) {
            minGrade = testGrade;
         }
      }
      totalMinGrades = storeMinGrades(minGrade, totalMinGrades, counter);
      counter++;
   }
   printResult(counter, totalMinGrades);
   }
}
