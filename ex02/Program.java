import java.util.Scanner;

public class Program {
    public static int sumOfDigits(int number) {
        int result = 0;
        while (number > 0) {
            result += number % 10;
            number /= 10;
        }
        return result;
    }
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
    public static boolean isPrime(int number) {
        boolean isPrime = true;
        for (int i = 2; i <= sqrt(number); i++) {
            if (number % i == 0) {
                isPrime = false;
                break ;
            }
        }
        return isPrime;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int number;
        int count = 0;
        while (true) {
            number = scan.nextInt();
            if (number == 42) {
                break ;
            }
            else if (isPrime(sumOfDigits(number))) {
                count++;
            }
        }
        System.out.println("Count of coffee-request : " + count);
    }
}
