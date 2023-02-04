package myapp;

public class Main {

    public static void main(String[] args) {
        
        // Bank Account
        // create accounts
        BankAccount myAccount = new BankAccount("Dennis");
        System.out.println(myAccount);

        BankAccount mySecondAccount = new BankAccount("Ang Wei Jun", 100f);
        System.out.println(mySecondAccount);

        // deposit
        myAccount.deposit(-1);

        mySecondAccount.deposit(50);

        for (String s : mySecondAccount.getTransactions()) {
            System.out.println(s);
        }

        // withdraw

        myAccount.withdraw(-1);

        mySecondAccount.withdraw(20);

        for (String s : mySecondAccount.getTransactions()) {
            System.out.println(s);
        }

        mySecondAccount.withdraw(220);


        // Fixed Deposits
        FixedDepositAccount myFD = new FixedDepositAccount("Tim", 1000);
        System.out.println(myFD);
        System.out.println("MyFD's maturity balance: $" + myFD.getBalance());
        myFD.deposit(1);
        myFD.withdraw(1);

        FixedDepositAccount mySecondFD = new FixedDepositAccount("Fred", 1000,5f);
        System.out.println(mySecondFD);
        System.out.println("MySecondFD's maturity balance: $" + myFD.getBalance());
        mySecondFD.deposit(1);
        mySecondFD.withdraw(1);

        FixedDepositAccount myThirdFD = new FixedDepositAccount("Tom", 10000,1f,12);
        System.out.println(myThirdFD);
        System.out.println("MyThirdFD's maturity balance: $" + myFD.getBalance());
        myThirdFD.deposit(1);
        myThirdFD.withdraw(1);

    }
    
}
