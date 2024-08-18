import java.util.Scanner;

public class Program {
    static Scanner sc = new Scanner(System.in);
    static String text;
    static int length;
    static char[] textChars;
    static int[] occurences = new int[65535];
    static char[] letters = new char[65535];

    public static void bubbleSortDescending(int[] arr, char[] arr1) {
        int n = arr.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] < arr[j + 1]) {

                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    char temp2 = arr1[j];
                    arr1[j] = arr1[j + 1];
                    arr1[j + 1] = temp2;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }

    public static void initializeArray(int[] occurences) {
        for (int i = 0; i < occurences.length; i++) {
            occurences[i] = 0;
        }
    }

    public static void fillArray(int[] occurences, char[] letters, int length) {
        for (int i = 0; i < length; i++) {
            occurences[textChars[i]] += 1;
            letters[textChars[i]] = textChars[i];
        }
    }

    public static void printResult(int[] occurences, char[] letters, int[] hashCounts) {
        int k = 0;
        
        for (int j = 0; j < 11; j++) {
            for (int i = 0; i < 10; i++) {
                if (j > (10 - hashCounts[i])) {
                    System.out.print("# ");
                }
                if (j == 10 - hashCounts[i]) {
                    System.out.print(occurences[i] + " ");
                }
            }
            System.out.println("");
        }
        for (int i = 0; i < 10; i++) {
            System.out.print(letters[i] + " ");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        text = sc.nextLine();
        length = text.length();
        if (length == 0) {
            System.err.println("You should enter a non empty text");
            System.exit(-1);
        }
        textChars = text.toCharArray();
        initializeArray(occurences);
        fillArray(occurences, letters, length);
        bubbleSortDescending(occurences, letters);
        if (occurences[0] > 999) {
            System.err.println("You exceeded the number of occurences allowed");
            System.exit(-1);
        }
        int max = occurences[0];

        int[] hashCounts = new int[10];
        for (int i = 0; i < 10; i++) {
            int hashCount = (occurences[i] * 10) / max;
            hashCounts[i] = hashCount;
        }
        printResult(occurences, letters, hashCounts);
    }
}

// AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAASSSSSSSSSSSSSSSSSSSSSSSSDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDWEWWKFKKDKKDSKAKLSLDKSKALLLLLLLLLLRTRTETWTWWWWWWWWWWOOOOOOO42
// AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAASSSSSSSSSSSSSSSSSSSSSSSSDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDWEWWKFKKDKKDSKAKLSLDKSKALLLLLLLLLLRTRTETWTWWWWWWWWWWOOOOOOO42漢漢漢漢
