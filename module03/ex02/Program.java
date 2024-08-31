package module03.ex02;

import java.util.*;

public class Program {
    public static int sum(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        return sum;
    }

    public static void initializeArray(int[] array) {
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(1000);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        try {
            if (args.length != 2) {
                throw new IllegalArgumentNumberException();
            }
            int arraySize = Integer.parseInt(args[0].split("=")[1]);
            int threadsCount = Integer.parseInt(args[1].split("=")[1]);
            int[] array = new int[arraySize];
            initializeArray(array);
            int sumThreads = 0;
            System.out.println("Sum: " + sum(array));
            for (int i = 0; i < threadsCount; i++) {
                int size;
                SummingThread summingThread;
                if (i == threadsCount - 1) {
                    size = arraySize / threadsCount + arraySize % threadsCount;
                    summingThread = new SummingThread(size, i * (size - arraySize % threadsCount),
                            i * (size - arraySize % threadsCount) + size - 1, i + 1, array);
                } else {
                    size = arraySize / threadsCount;
                    summingThread = new SummingThread(size, i * size, i * size + size - 1, i + 1, array);
                }
                Thread thread = new Thread(summingThread);
                thread.start();
                thread.join();
                sumThreads += summingThread.getSum();
            }
            System.out.println("Sum by threads: " + sumThreads);

        } catch (IllegalArgumentNumberException e) {
            System.out.println(e.getMessage());
            return;
        }
    }
}
