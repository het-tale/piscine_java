package module03.ex00;

public class Program {

    public static void firstMethod(int count) throws Exception {
        ExtendThread thread1 = new ExtendThread(count, "Hen");
        ExtendThread thread2 = new ExtendThread(count, "Egg");
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        for (int i = 0; i < count; i++) {
            System.out.println("Human");
        }
    }
    public static void secondMethod(int count) throws Exception {
        ImplmentThread thread1 = new ImplmentThread(count, "Hen");
        ImplmentThread thread2 = new ImplmentThread(count, "Egg");
        Thread t1 = new Thread(thread1);
        Thread t2 = new Thread(thread2);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        for (int i = 0; i < count; i++) {
            System.out.println("Human");
        }
    }

    public static void main(String[] args) {
        try {
            if (args.length != 1) {
                throw new IllegalArgumentNumberException();
            }
            String[] arguments = args[0].split("=");
            if (arguments.length != 2) {
                throw new IllegalArgumentNumberException();
            }
            int count = Integer.parseInt(arguments[1]);
            // firstMethod(count);
            secondMethod(count);

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
