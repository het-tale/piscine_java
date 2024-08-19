package module01.ex04;

public class UserIdsGenerator {
    private static UserIdsGenerator instance;
    private int id = 1;

    private UserIdsGenerator() {
    }

    public static UserIdsGenerator getInstance() {
        if (instance == null) {
            synchronized (UserIdsGenerator.class) {
                if (instance == null) {
                    instance = new UserIdsGenerator();
                }
            }
        }
        return instance;
    }

    public int generateId() {
        return id++;
    }
}