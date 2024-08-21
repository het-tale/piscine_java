package module01.ex04;

/**
 * We need to add transactions field of TransactionsList type to User class so that
each user can store the list of their transactions.
 */
public class User {
    private int identifier;
    private String name;
    private int balance;
    private TransactionsList transactions;

    public User(String name, int balance) {
        this.identifier = UserIdsGenerator.getInstance().generateId();
        this.name = name;
        if (balance < 0) {
            throw new IllegalArgumentException("Balance can't be negative.");
        }
        this.balance = balance;
        this.transactions = new TransactionsLinkedList();
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

    public void setName(String name) {
        this.name = name;
    }

    public TransactionsList getTransactions() {
        return transactions;
    }

    @Override
    public String toString() {
        return "User: " + this.name + " with identifier: " + this.identifier + " has balance: " + this.balance;
    }

}