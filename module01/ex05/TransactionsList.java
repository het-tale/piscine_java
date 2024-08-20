package module01.ex05;

/**
 * TransactionsList
 */
public interface TransactionsList {

    void addTransaction(Transaction transaction);

    void removeTransactionById(String transactionId);

    Transaction[] toArray();

}