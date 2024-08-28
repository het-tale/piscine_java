package module03.ex02;

public class SummingThread implements Runnable {
    private int sum = 0;
    private int size;
    private int start;
    private int end;
    private int number;
    private int[] array;

    SummingThread(int size, int start, int end, int number, int[] array) {
        this.size = size;
        this.start = start;
        this.end = end;
        this.number = number;
        this.array = array;
    }

    public synchronized void printResult() {
        for (int i = 0; i < this.size; i++) {
            sum += array[start + i];
        }
        System.out.println("Thread " + this.number + ": from " + this.start + " to " + this.end
                + " sum is " + this.sum);
    }

    @Override
    public void run() {
        printResult();
    }

    public synchronized int getSum() {
        return sum;
    }

}
