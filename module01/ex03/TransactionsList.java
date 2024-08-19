package module01.ex03;

/**
 * TransactionsList
 */
public interface TransactionsList {

    void addTransaction(Transaction transaction);

    void removeTransactionById(String transactionId);

    Transaction[] toArray();

}