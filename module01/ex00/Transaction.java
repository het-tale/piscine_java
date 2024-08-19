package module01.ex00;

import java.util.UUID;

public class Transaction {

    private String identifier;
    private User sender;
    private User receiver;
    private int transferAmount;
    private TransferCategory transferCategory;

    enum TransferCategory {
        DEBITS,
        CREDITS
    }

    public Transaction(User sender, User receiver, int transferAmount, TransferCategory transferCategory) {
        this.identifier = UUID.randomUUID().toString();
        this.sender = sender;
        this.receiver = receiver;
        this.transferCategory = transferCategory;
        if (this.transferCategory == TransferCategory.DEBITS && transferAmount < 0) {
            throw new IllegalArgumentException("Debits can't be negative.");
        } else if (this.transferCategory == TransferCategory.CREDITS && transferAmount > 0) {
            throw new IllegalArgumentException("Credits can't be positive.");
        }
        this.transferAmount = transferAmount;
    }

    public String getIdentifier() {
        return identifier;
    }

    public User getSender() {
        return sender;
    }

    public User getReceiver() {
        return receiver;
    }

    public int getTransferAmount() {
        return transferAmount;
    }

    public TransferCategory getTransferCategory() {
        return transferCategory;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public void setReceiver(User receiver) {
        this.receiver = receiver;
    }

    public void setTransferAmount(int transferAmount) {
        if (this.transferCategory == TransferCategory.DEBITS && transferAmount < 0) {
            throw new IllegalArgumentException("Debits can't be negative.");
        } else if (this.transferCategory == TransferCategory.CREDITS && transferAmount > 0) {
            throw new IllegalArgumentException("Credits can't be positive.");
        }
        this.transferAmount = transferAmount;
    }

    public void setTransferCategory(TransferCategory transferCategory) {
        this.transferCategory = transferCategory;
    }

    @Override
    public String toString() {
        return "Transaction: " + this.identifier + " from " + this.sender.getName() + " to " + this.receiver.getName()
                + " with amount: " + this.transferAmount + " and category: " + this.transferCategory;
    }

}
