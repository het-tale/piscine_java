package module01.ex00;

public class User {
    private int identifier;
    private String name;
    private int balance;

    public User(int identifier, String name, int balance) {
        this.identifier = identifier;
        this.name = name;
        if (balance < 0) {
            throw new IllegalArgumentException("Balance can't be negative.");
        }
        this.balance = balance;
    }

    public int getIdentifier() {
        return identifier;
    }

    public String getName() {
        return name;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        if (balance < 0) {
            throw new IllegalArgumentException("Balance can't be negative.");
        }
        this.balance = balance;
    }

    public void setIdentifier(int identifier) {
        this.identifier = identifier;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User: " + this.name + " with identifier: " + this.identifier + " has balance: " + this.balance;
    }

}