import java.util.ArrayList;

public class Account {
    private double balance;
    private ArrayList<Transaction> transactions;

    public Account(double balance) {
        this.balance = balance;
        transactions = new ArrayList<>();
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
        transactions.add(new Transaction("Deposit", amount));
    }

    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            transactions.add(new Transaction("Withdraw", amount));
            return true;
        }
        return false;
    }

    public void transfer(double amount) {
        balance -= amount;
        transactions.add(new Transaction("Transfer", amount));
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }
}
