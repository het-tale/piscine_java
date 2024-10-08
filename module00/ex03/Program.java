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

      long multiplier = 1;
      for (int i = 0; i < counter; i++) {
         multiplier *= 10;
      }
      totalMinGrades += (minGrade * multiplier);

      return totalMinGrades;
   }

   public static void main(String[] args) {
      Scanner scan = new Scanner(System.in);
      String weekNumber = "";
      int counter = 0;
      int minGrade = 0;
      int testGrade;
      long totalMinGrades = 0;
      while (true) {
         if (counter == 18) {
            break;
         }
         weekNumber = scan.nextLine();
         if (weekNumber.equals("42")) {
            break;
         }
         if (!weekNumber.equals("Week " + (counter + 1))) {
            System.err.println("IllegalArgument");
            System.exit(-1);
         }
         minGrade = 0;
         int j = 0;
         while (j < 5) {
            testGrade = scan.nextInt();
            if (minGrade == 0 || minGrade > testGrade) {
               minGrade = testGrade;
            }
            j++;
         }
         weekNumber = scan.nextLine();
         totalMinGrades = storeMinGrades(minGrade, totalMinGrades, counter);
         counter++;
      }
      printResult(counter, totalMinGrades);
      scan.close();
   }
}
