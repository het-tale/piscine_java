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
    
    public static boolean isPrime(int number) {
        boolean isPrime = true;
        for (int i = 2; i * i <= number; i++) {
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
        scan.close();
        System.out.println("Count of coffee-request : " + count);
    }
}
