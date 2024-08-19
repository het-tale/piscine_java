package module01.ex02;

public class Program {
    public static void main(String[] args) {
        try {
            /* ======================= User tests ================== */
            // User errUser = new User("errUser", -1000);
            User TestUser = new User("test", 2000);
            User Hasnaa = new User("Hasnaa", 1000);
            User Trevor = new User("trevor", 2000);

            /* ======================= Array List tests ================== */

            UsersArrayList usersList = new UsersArrayList();
            System.out.println("================== Add users ===================");
            usersList.addUser(Hasnaa);
            usersList.addUser(Trevor);
            usersList.addUser(TestUser);
            for (int i = 3; i < 10; i++) {
                usersList.addUser(new User("User" + i, 1000 * i));
            }
            System.out.println("Length before: " + usersList.getUsers().length);
            usersList.addUser(new User("User" + 10, 1000 * 10));
            System.out.println("Length after: " + usersList.getUsers().length);
            System.out.println("================== Get List of users ===================");
            User[] users = usersList.getUsers();
            for (int i = 0; i < usersList.getUsersCount(); i++) {
                System.out.println(users[i].toString());
            }
            System.out.println("================== Get List of users By Index ===================");
            for (int i = 0; i < usersList.getUsersCount(); i++) {
                System.out.println(usersList.getUserByIndex(i).toString());
            }
            // System.out.println(usersList.getUserByIndex(usersList.getUsersCount()).toString());
            System.out.println("================== Get List of users By ID ===================");
            System.out.println(usersList.getUserById(1).toString());
            // System.out.println(usersList.getUserById(100).toString());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
