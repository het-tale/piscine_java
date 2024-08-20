package module01.ex05;

public class Program {
    public static void main(String[] args) {
        try {
            Menu menu = new Menu();
            if (args.length > 0) {
                menu.showMenu(true);
            } else {
                menu.showMenu(false);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
