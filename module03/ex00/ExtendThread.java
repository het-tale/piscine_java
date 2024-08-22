package module03.ex00;

public class ExtendThread extends Thread {
    private int count;
    private String name;

    public ExtendThread(int count, String name) {
        this.count = count;
        this.name = name;
    }

    @Override
    public void run() {
        while (count > 0) {
            System.out.println(name);
            count--;
        }
    }

}
