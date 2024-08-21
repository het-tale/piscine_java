package module01.ex05;

/**
 * TransactionsService
 */
public class TransactionsService {
    private UsersList interactions;

    public TransactionsService() {
        this.interactions = new UsersArrayList();
    }

    public void addUser(User user) {
        interactions.addUser(user);
    }

    public int getUserBalance(int id) {
        User user = interactions.getUserById(id);
        return user.getBalance();
    }

    public void transferTransaction(int senderId, int receiverId, int transferAmount) {
        if (interactions.getUserById(senderId).getBalance() < transferAmount) {
            throw new IllegalTransactionException("Not enough balance to transfer.");
        }
        Transaction transaction = new Transaction(interactions.getUserById(senderId),
                interactions.getUserById(receiverId), transferAmount, Transaction.TransferCategory.DEBITS);
        Transaction transaction2 = new Transaction(interactions.getUserById(senderId),
                interactions.getUserById(receiverId), -transferAmount, Transaction.TransferCategory.CREDITS);
        transaction2.setIdentifier(transaction.getIdentifier());
        interactions.getUserById(senderId).getTransactions().addTransaction(transaction2);
        interactions.getUserById(receiverId).getTransactions().addTransaction(transaction);
        interactions.getUserById(senderId).setBalance(interactions.getUserById(senderId).getBalance() - transferAmount);
        interactions.getUserById(receiverId)
                .setBalance(interactions.getUserById(receiverId).getBalance() + transferAmount);
    }

    public Transaction[] getUserTransactions(int id) {
        return interactions.getUserById(id).getTransactions().toArray();
    }

    public void removeUserTransaction(String transactionId, int userId) {
        interactions.getUserById(userId).getTransactions().removeTransactionById(transactionId);
    }

    public Transaction[] checkValidity() {
        TransactionsList transactions = new TransactionsLinkedList();
        for (int i = 0; i < interactions.getUsersCount(); i++) {
            Transaction[] userTransactions = interactions.getUserByIndex(i).getTransactions().toArray();
            for (int j = 0; j < userTransactions.length; j++) {
                transactions.addTransaction(userTransactions[j]);
            }
        }
        Transaction[] transactionsArray = transactions.toArray();// get all transactions of all users
        TransactionsList unpairedTransactions = new TransactionsLinkedList();
        boolean isPaired = false;
        for (int i = 0; i < transactionsArray.length; i++) {
            for (int j = i + 1; j < transactionsArray.length; j++) {
                if (transactionsArray[i].getIdentifier().equals(transactionsArray[j].getIdentifier())) {
                    isPaired = true;
                    break;
                }
            }
            if (!isPaired) {
                unpairedTransactions.addTransaction(transactionsArray[i]);
            }
        }
        return unpairedTransactions.toArray();
    }

    public User getUserById(int id) {
        return interactions.getUserById(id);
    }

    public Transaction getTransaction(String transactionId, int id) {
        Transaction[] transactions = interactions.getUserById(id).getTransactions().toArray();
        for (int i = 0; i < transactions.length; i++) {
            if (transactions[i].getIdentifier().equals(transactionId)) {
                return transactions[i];
            }
        }
        throw new TransactionNotFoundException("Transaction not found");
    }
}