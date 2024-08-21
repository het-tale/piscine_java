package module01.ex04;

public class Program {
    public static void main(String[] args) {
        try {
            /* ======================= User tests ================== */
            // User errUser = new User("errUser", -1000);
            User TestUser = new User("test", 2000);
            User Hasnaa = new User("Hasnaa", 1000);
            User Trevor = new User("trevor", 2000);

            /* ======================= Transaction Service tests ================== */
            TransactionsService transactionsService = new TransactionsService();

            System.out.println("==========> Adding users to the service <==========");
            transactionsService.addUser(Hasnaa);
            transactionsService.addUser(Trevor);
            transactionsService.addUser(TestUser);

            System.out.println("==========> Getting user balance before transaction <==========");
            System.out.println("Hasnaa balance: " + transactionsService.getUserBalance(Hasnaa.getIdentifier()));
            System.out.println("Trevor balance: " + transactionsService.getUserBalance(Trevor.getIdentifier()));

            System.out.println("==========> Transfering transactions <==========");
            transactionsService.transferTransaction(Hasnaa.getIdentifier(), Trevor.getIdentifier(), 500);
            transactionsService.transferTransaction(Hasnaa.getIdentifier(), TestUser.getIdentifier(), 300);
            // transactionsService.transferTransaction(Hasnaa.getIdentifier(), Trevor.getIdentifier(), 4000);

            System.out.println("==========> Getting user balance after transaction <==========");
            System.out.println("Hasnaa balance: " + transactionsService.getUserBalance(Hasnaa.getIdentifier()));
            System.out.println("Trevor balance: " + transactionsService.getUserBalance(Trevor.getIdentifier()));

            System.out.println("==========> Getting user1 transactions <==========");
            Transaction[] HasnaaTransactions = transactionsService.getUserTransactions(Hasnaa.getIdentifier());
            for (Transaction transaction : HasnaaTransactions) {
                System.out.println(transaction);
            }
            System.out.println("==========> Getting user2 transactions <==========");
            Transaction[] TrevorTransactions = transactionsService.getUserTransactions(Trevor.getIdentifier());
            for (Transaction transaction : TrevorTransactions) {
                System.out.println(transaction);
            }

            System.out.println("==========> Removing user transaction <==========");
            transactionsService.removeUserTransaction(HasnaaTransactions[0].getIdentifier(), Hasnaa.getIdentifier());
            Transaction[] HasnaaTransactionsAfterRemove = transactionsService.getUserTransactions(Hasnaa.getIdentifier());
            for (Transaction transaction : HasnaaTransactionsAfterRemove) {
                System.out.println(transaction);
            }

            System.out.println("==========> Checking transactions validity <==========");
            Transaction[] transactions = transactionsService.checkValidity();
            for (Transaction transaction : transactions) {
                System.out.println(transaction);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
