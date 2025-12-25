import java.util.Scanner;

public class ATMOperations {
    private User user;
    private Account account;
    private Scanner sc = new Scanner(System.in);

    public ATMOperations(User user, Account account) {
        this.user = user;
        this.account = account;
    }

    public boolean authenticate(String userId, String pin) {
        return user.getUserId().equals(userId) && user.getPin().equals(pin);
    }

    public void showMenu() {
        int choice;
        do {
            System.out.println("\n----- ATM MENU -----");
            System.out.println("1. Transaction History");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Quit");
            System.out.print("Choose option: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    showTransactions();
                    break;
                case 2:
                    withdraw();
                    break;
                case 3:
                    deposit();
                    break;
                case 4:
                    transfer();
                    break;
                case 5:
                    System.out.println("Thank you for using ATM.");
                    break;
                default:
                    System.out.println("Invalid Choice!");
            }
        } while (choice != 5);
    }

    private void showTransactions() {
        if (account.getTransactions().isEmpty()) {
            System.out.println("No transactions yet.");
        } else {
            for (Transaction t : account.getTransactions()) {
                System.out.println(t);
            }
        }
    }

    private void withdraw() {
        System.out.print("Enter amount to withdraw: ");
        double amt = sc.nextDouble();
        if (account.withdraw(amt)) {
            System.out.println("Withdraw successful.");
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    private void deposit() {
        System.out.print("Enter amount to deposit: ");
        double amt = sc.nextDouble();
        account.deposit(amt);
        System.out.println("Deposit successful.");
    }

    private void transfer() {
        System.out.print("Enter amount to transfer: ");
        double amt = sc.nextDouble();
        if (amt <= account.getBalance()) {
            account.transfer(amt);
            System.out.println("Transfer successful.");
        } else {
            System.out.println("Insufficient balance.");
        }
    }
}
