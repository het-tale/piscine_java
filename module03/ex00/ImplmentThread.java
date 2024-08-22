package module03.ex00;

public class ImplmentThread implements Runnable {
    private int count;
    private String name;

    public ImplmentThread(int count, String name) {
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
