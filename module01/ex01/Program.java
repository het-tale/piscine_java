package module01.ex01;

public class Program {
    public static void main(String[] args) {
        try {
            // User errUser = new User("errUser", -1000);
            User TestUser = new User("test", 2000);
            User Hasnaa = new User("Hasnaa", 1000);
            User Trevor = new User("trevor", 2000);

            System.out.println(Hasnaa.toString());
            System.out.println(Trevor.toString());
            System.out.println(TestUser.toString());

            Hasnaa.setBalance(2000);
            Trevor.setName("Mohamed");

            System.out.println(Hasnaa.toString());
            System.out.println(Trevor.toString());

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
