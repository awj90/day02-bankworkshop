package myapp;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Random;

public class BankAccount {

    // Members
    private String name;
    private String accountNumber;
    private float accountBalance;
    private ArrayList<String> transactions = new ArrayList<>();
    private boolean closed;
    private String openDate;
    private String closeDate;
    
    // Constructors
    public BankAccount(String name) {
        this(name, 0f);
    }

    public BankAccount(String name, float accountBalance) {
        this.name = name;

        Random random = new Random();
        this.accountNumber = Integer.toString(random.nextInt(1_000_000_000));

        this.accountBalance = accountBalance;

        this.closed = false;

        this.openDate = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());

        transactions.add("Account created at " + openDate + " with initial balance of $" + accountBalance);
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public float getAccountBalance() {
        return accountBalance;
    }

    public ArrayList<String> getTransactions() {
        return transactions;
    }

    public boolean isClosed() {
        return closed;
    }

    public String getOpenDate() {
        return openDate;
    }

    public String getCloseDate() {
        return closeDate;
    }

    // Setters
    public void setClosed(boolean closed) {
        this.closed = closed;
    }

    public void setCloseDate(String closeDate) {
        this.closeDate = closeDate;
    }

    // Methods

    public String getTimeStamp() {
        return new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
    }

    public void deposit(float amount) {
        if (amount <= 0) {
            System.out.println("You may only make a deposit amount that is more than 0.");
        } else {
            accountBalance += amount;
            transactions.add("Deposited $" + amount + " at " + getTimeStamp());
            System.out.println(transactions.get(transactions.size() - 1));
            System.out.printf("Account Balance: $%.2f\n", accountBalance);
        }
    }
    
    public void withdraw(float amount) {
        if (amount <= 0) {
            System.out.println("You may only make a withdrawal amount that is more than 0.");
        } else if (accountBalance < amount) {
            System.out.println("Insufficient funds for withdrawal.");
            System.out.printf("Your available balance: $%.2f\n", accountBalance);
        } else {
            accountBalance -= amount;
            transactions.add("Withdrew $" + amount + " at " + getTimeStamp());
            System.out.println(transactions.get(transactions.size() - 1));
            System.out.printf("Account Balance: $%.2f\n", accountBalance);
        }
    }

    @Override
    public String toString() {
        return "BankAccount [name=" + name + ", accountNumber=" + accountNumber + ", accountBalance=" + accountBalance
                + ", transactions=" + transactions + ", closed=" + closed + ", openDate=" + openDate + ", closeDate="
                + closeDate + "]";
    }
}