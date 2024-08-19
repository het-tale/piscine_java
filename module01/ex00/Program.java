package module01.ex00;

public class Program {
    public static void main(String[] args) {
        try {
            // User errUser = new User(2, "errUser", -1000);
            User Hasnaa = new User(1, "Hasnaa", 1000);
            User Trevor = new User(3, "trevor", 2000);

            System.out.println(Hasnaa.toString());
            System.out.println(Trevor.toString());

            Hasnaa.setBalance(2000);
            Trevor.setName("Mohamed");

            System.out.println(Hasnaa.toString());
            System.out.println(Trevor.toString());

            Transaction transaction = new Transaction(Hasnaa, Trevor, 100, Transaction.TransferCategory.DEBITS);
            // Transaction transaction1 = new Transaction(Hasnaa, Trevor, 100, Transaction.TransferCategory.CREDITS);
            
            System.out.println(transaction.toString());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
