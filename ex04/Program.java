import java.util.Scanner;

public class Program {
    /**
     * 
     * @param args
     * The goal of this project is to count character occurences in a text
     */
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
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        int length = text.length();
        char[] textChars = text.toCharArray();
        int[] occurences = new int[65535];
        char[] letters = new char[65535];
        for (int i = 0; i < occurences.length; i++) {
            occurences[i] = 0;
        }
        for (int i = 0; i < length; i++) {
            occurences[textChars[i]] += 1;
            letters[textChars[i]] = textChars[i];
        }
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
        boolean printed = false;
        
        int k = 0;
        for (int j = 0; j < 12; j++) {
            if (j == 11) {
                for (int i = 0; i < 10; i++) {
                    System.out.print(letters[i] + " ");
                }
                System.out.println("");
                break ;
            }
            for (int i = 0; i < 10; i++) {
                if (hashCounts[i] > (10 - j)) {
                    System.out.print("# ");
                }
            }
            while (k < 10 && j == 10 - hashCounts[k]) {
                System.out.print(occurences[k] + " ");
                k++;
            }
            System.out.println("");
    }
    }
}
