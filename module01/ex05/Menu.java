package module01.ex05;

import java.util.Scanner;

/**
 * Menu
 */
public class Menu {

    TransactionsService transactionsService = new TransactionsService();
    Scanner scanner = new Scanner(System.in);

    public void showMenu(boolean isDevMode) {
        while (true) {
            System.out.println("1. Add a user");
            System.out.println("2. View user balances");
            System.out.println("3. Perform a transfer");
            System.out.println("4. View all transactions for a specific user");
            if (isDevMode) {
                System.out.println("5. remove a transfer by ID");
                System.out.println("6. check transfer validity");
                System.out.println("7. Finish execution");
            } else {
                System.out.println("5. Finish execution");
            }
            int option = scanner.nextInt();
            executeOption(option, isDevMode);
            System.out.println("---------------------------------------------------------");
        }
    }

    public void executeOption(int option, boolean isDevMode) {
        switch (option) {
            case 1:
                this.addUser();
                break;
            case 2:
                this.viewBalances();
                break;
            case 3:
                this.performTransfer();
                break;
            case 4:
                this.viewAllTransactions();
                break;
            case 5:
                if (isDevMode) {
                    this.removeTransaction();
                } else {
                    this.finishExecution();
                }
                break;
            case 6:
                if (isDevMode) {
                    this.checkTransferValidity();
                } else {
                    this.finishExecution();
                }
                break;
            case 7:
                if (isDevMode) {
                    this.finishExecution();
                }
                break;
            default:
                System.out.println("Invalid option");
                break;
        }
    }

    public void addUser() {
        System.out.println("Enter a user name and a balance");
        String name = scanner.next();
        int balance = scanner.nextInt();
        User user = new User(name, balance);
        this.transactionsService.addUser(user);
        System.out.println("User with id = " + user.getIdentifier() + " is added");
    }

    public void viewBalances() {
        System.out.println("Enter a user ID");
        int id = scanner.nextInt();
        System.out.println(this.transactionsService.getUserById(id) + " - "
                + this.transactionsService.getUserBalance(id));
    }

    public void performTransfer() {
        System.out.println("Enter a sender ID, a recipient ID, and a transfer amount");
        int senderId = scanner.nextInt();
        int receiverId = scanner.nextInt();
        int transferAmount = scanner.nextInt();
        this.transactionsService.transferTransaction(senderId, receiverId, transferAmount);
        System.out.println("The transfer is completed");
    }

    public void viewAllTransactions() {
        System.out.println("Enter a user ID");
        int id = scanner.nextInt();
        Transaction[] transactions = this.transactionsService.getUserTransactions(id);
        for (Transaction transaction : transactions) {
            System.out.println(
                    "To " + transaction.getReceiver().getName() + "(" + transaction.getReceiver().getIdentifier()
                            + ")" + -transaction.getTransferAmount() + "with id = " + transaction.getIdentifier());
        }
    }

    public void removeTransaction() {
        System.out.println("Enter a user ID and a transfer ID");
        String transactionId = scanner.next();
        int userId = scanner.nextInt();
        this.transactionsService.removeUserTransaction(transactionId, userId);
        // Transfer To Mike(id = 2) 150 removed
        System.out.println("Transfer To " + this.transactionsService.getUserById(userId).getName() + "(id = "
                + this.transactionsService.getUserById(userId).getIdentifier() + ") "
                + this.transactionsService.getTransaction(transactionId, userId).getTransferAmount() + " removed");
    }

    public void checkTransferValidity() {
        // Check results: Mike(id = 2) has an unacknowledged transfer id =
        // 1fc852e7-914f-4bfd-913d-0313aab1ed99 from John(id =1) for 150
        Transaction[] transactions = this.transactionsService.checkValidity();
        System.out.println("Check results: ");
        for (Transaction transaction : transactions) {
            System.out.println(transaction.getReceiver().getName() + "(id = "
                    + transaction.getReceiver().getIdentifier() + ")" + " has an unacknowledged transfer id = "
                    + transaction.getIdentifier() + " from " + transaction.getSender().getName() + "(id = "
                    + transaction.getSender().getIdentifier() + ") for " + transaction.getTransferAmount());
        }
    }
    public void finishExecution() {
        System.exit(0);
    }
}