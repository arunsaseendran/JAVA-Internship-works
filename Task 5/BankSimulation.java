import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// Account class
class Account {
    private String accountHolder;
    private double balance;
    private List<String> transactionHistory;

    // Constructor
    public Account(String accountHolder, double initialBalance) {
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
        this.transactionHistory = new ArrayList<>();
        transactionHistory.add("Account created with balance: " + initialBalance);
    }

    // Deposit method
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactionHistory.add(new Date() + " - Deposited: " + amount + " | Balance: " + balance);
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Deposit amount must be positive!");
        }
    }

    // Withdraw method
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            transactionHistory.add(new Date() + " - Withdrawn: " + amount + " | Balance: " + balance);
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Invalid withdrawal amount or insufficient funds!");
        }
    }

    // Get balance
    public double getBalance() {
        return balance;
    }

    // Print transaction history
    public void printTransactionHistory() {
        System.out.println("\nTransaction History for " + accountHolder + ":");
        for (String transaction : transactionHistory) {
            System.out.println(transaction);
        }
    }
}

// Main class
public class BankSimulation {
    public static void main(String[] args) {
        
        // Create an account
        Account myAccount = new Account("Arun", 500);

        // Perform transactions
        myAccount.deposit(200);
        myAccount.withdraw(100);
        myAccount.withdraw(800); // should fail

        // Show balance
        System.out.println("\nFinal Balance: " + myAccount.getBalance());

        // Print all transactions
        myAccount.printTransactionHistory();
    }
}
