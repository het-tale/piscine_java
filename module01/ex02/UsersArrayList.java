package module01.ex02;

public class UsersArrayList implements UsersList {
    private User[] users;
    private int usersCount;

    public UsersArrayList() {
        users = new User[10];
        usersCount = 0;
    }

    public void addUser(User user) {
        if (usersCount >= users.length) {
            User[] newUsers = new User[users.length + (users.length / 2)];
            System.arraycopy(users, 0, newUsers, 0, users.length);
            users = newUsers;
        }
        users[usersCount] = user;
        usersCount++;
    }

    public User getUserById(int id) {
        for (int i = 0; i < usersCount; i++) {
            if (users[i].getIdentifier() == id) {
                return users[i];
            }
        }
        throw new UserNotFoundException("User not found");
    }

    public User getUserByIndex(int index) {
        if (index < 0 || index >= usersCount) {
            throw new UserNotFoundException("User not found");
        }
        return users[index];
    }

    public int getUsersCount() {
        return usersCount;
    }

    public User[] getUsers() {
        return users;
    }
}