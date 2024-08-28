package module03.ex01;

public class ImplmentThread {
    private int count;
    private String name;

    public ImplmentThread(int count, String name) {
        this.count = count;
        this.name = name;
    }

    public synchronized void printEgg() {
        while (count > 0) {
            if (name.equals("Egg")) {
                System.out.println("Egg");
                this.setName("Hen");
                count--;
                notifyAll();
            } else {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public synchronized void printHen() {
        while (count > 0) {
            if (name.equals("Hen")) {
                System.out.println("Hen");
                this.setName("Egg");
                count--;
                notifyAll();
            } else {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public void setName(String name) {
        this.name = name;
    }

}
