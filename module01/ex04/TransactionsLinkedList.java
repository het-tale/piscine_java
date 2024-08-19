package module01.ex04;

public class TransactionsLinkedList implements TransactionsList {
    private Node head;
    private int size;

    private class Node {
        private Transaction transaction;
        private Node next;

        public Node(Transaction transaction) {
            this.transaction = transaction;
        }
    }

    public TransactionsLinkedList() {
        head = null;
        size = 0;
    }

    @Override
    public void addTransaction(Transaction transaction) {
        Node newNode = new Node(transaction);
        newNode.next = head;
        head = newNode;
        size++;
    }

    @Override
    public void removeTransactionById(String transactionId) {
        if (head == null) {
            return;
        }
        if (head.transaction.getIdentifier().equals(transactionId)) {
            head = head.next;
            size--;
            return;
        }
        Node current = head;
        while (current.next != null) {
            if (current.next.transaction.getIdentifier().equals(transactionId)) {
                current.next = current.next.next;
                size--;
                return;
            }
            current = current.next;
        }
        throw new TransactionNotFoundException("Transaction with id " + transactionId + " not found.");
    }

    @Override
    public Transaction[] toArray() {
        Transaction[] transactions = new Transaction[size];
        Node current = head;
        for (int i = 0; i < size; i++) {
            transactions[i] = current.transaction;
            current = current.next;
        }
        return transactions;
    }

    public int size() {
        return size;
    }
}