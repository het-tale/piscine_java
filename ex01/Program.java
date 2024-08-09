import java.util.Scanner;

public class Program {
    public static double sqrt(int number) {
        double sqrt = number / 2;
        double t;
        if (number < 2)
            sqrt = number;
        do {
            t = sqrt;
            sqrt = (t + (number / t)) / 2;
        } while ((t - sqrt) != 0);
        return sqrt;
    }
    public static void main(String[] args) {
        int iterationCounter = 1;
        boolean isPrime = true;
        Scanner scan = new Scanner(System.in);
        int number = scan.nextInt();
        if (number <= 0 || number == 1) {
            System.err.println("IllegalArgument");
            System.exit(-1);
        }
        for (int i = 2; i <= sqrt(number); i++) {
            if (number % i == 0) {
                isPrime = false;
                break ;
            }
            iterationCounter++;
        }
        
        System.out.print(isPrime+" ");
        System.out.println(iterationCounter);
    }
}