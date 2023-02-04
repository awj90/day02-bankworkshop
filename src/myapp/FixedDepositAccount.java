package myapp;

public class FixedDepositAccount extends BankAccount {
    
    // Members
    private float interest;
    private int duration;
    private boolean canChangeInterest = true;
    private boolean canChangeDuration = true;

    // Constructors
    public FixedDepositAccount(String name, float balance) {
        this(name, balance, 3f, 6);
    }

    public FixedDepositAccount(String name, float balance, float interest) {
        this(name, balance, interest, 6);
    }

    public FixedDepositAccount(String name, float balance, float interest, int duration) {
        super(name, balance);
        this.interest = interest;
        this.duration = duration;
    }

    // Getters
    public float getInterest() {
        return interest;
    }

    public int getDuration() {
        return duration;
    }

    public void setInterest(float interest) {
        if (canChangeInterest) {
            canChangeInterest = false;
            this.interest = interest;
            System.out.printf("Your Fixed Deposit interest rate is now %.2f%.", interest);
        } else {
            System.out.println("You may not change the Fixed Deposit interest rate again.");
            System.out.printf("Your Fixed Deposit interest rate is still %.2f%", interest);
        }
    }

    public void setDuration(int duration) {
        if (canChangeDuration) {
            canChangeDuration = false;
            this.duration = duration;
            System.out.printf("Your Fixed Deposit duration is now %d months.", duration);
        } else {
            System.out.println("You may not change the Fixed Deposit duration again.");
            System.out.printf("Your Fixed Deposit duration is still %d months.", duration);
        }
    }

    public float getBalance() {
        return this.getAccountBalance() + (interest/100)*this.getAccountBalance()*((float) (duration))/12;
    }

    @Override
    public String toString() {
        return "FixedDepositAccount [interest=" + interest + ", duration=" + duration + "]";
    }

    @Override
    public void deposit(float amount) {
        System.out.println("Cannot perform this operation on a Fixed Deposit Account.");
    }

    @Override
    public void withdraw(float amount) {
        System.out.println("Cannot perform this operation on a Fixed Deposit Account.");
    }

    

}
