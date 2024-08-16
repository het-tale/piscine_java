import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        int iterationCounter = 1;
        boolean isPrime = true;
        Scanner scan = new Scanner(System.in);
        int number = scan.nextInt();
        if (number < 2) {
            System.err.println("IllegalArgument");
            scan.close();
            System.exit(-1);
        }
        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                isPrime = false;
                break ;
            }
            iterationCounter++;
        }
        scan.close();
        System.out.print(isPrime+" ");
        System.out.println(iterationCounter);
    }
}