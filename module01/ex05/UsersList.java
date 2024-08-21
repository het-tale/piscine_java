package module01.ex05;

interface UsersList {
    public void addUser(User user);

    public User getUserById(int id);

    public User getUserByIndex(int index);

    public int getUsersCount();
}