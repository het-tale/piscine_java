package module03.ex01;

public class Program {

    public static void secondMethod(int count) throws Exception {
        ImplmentThread thread1 = new ImplmentThread(count, "Egg");
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                thread1.printEgg();
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                thread1.printHen();
            }
        });
        t1.start();
        t2.start();
    }

    public static void main(String[] args) {
        try {
            if (args.length != 1) {
                throw new IllegalArgumentNumberException();
            }
            String[] arguments = args[0].split("=");
            int count = Integer.parseInt(arguments[1]);
            secondMethod(count);

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
