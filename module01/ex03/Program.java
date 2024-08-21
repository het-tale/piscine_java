package module01.ex03;

import module01.ex03.Transaction.TransferCategory;

public class Program {
    public static void main(String[] args) {
        try {
            /* ======================= User tests ================== */
            // User errUser = new User("errUser", -1000);
            // User TestUser = new User("test", 2000);
            User Hasnaa = new User("Hasnaa", 1000);
            User Trevor = new User("trevor", 2000);

            /* ======================= Transaction list tests ================== */
            TransactionsLinkedList transactionsList = new TransactionsLinkedList();
            System.out.println("================== Add transactions ===================");
            transactionsList.addTransaction(new Transaction(Hasnaa, Trevor, 1000, TransferCategory.DEBITS));
            transactionsList.addTransaction(new Transaction(Trevor, Hasnaa, -1000, TransferCategory.CREDITS));

            System.out.println("================== Get List of transactions ===================");
            Transaction[] transactions = transactionsList.toArray();
            for (int i = 0; i < transactionsList.size(); i++) {
                System.out.println(transactions[i].toString());
            }

            System.out.println("================== Remove transactions ===================");
            transactionsList.removeTransactionById(transactions[0].getIdentifier());
            transactions = transactionsList.toArray();
            for (int i = 0; i < transactionsList.size(); i++) {
                System.out.println(transactions[i].toString());
            }

            System.out.println("================== Remove transactions by non existant ID ===================");
            transactionsList.removeTransactionById("123456-7890-1234-5678");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
