public class BankingAccount {
    private double balance;

    public BankingAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("The amount you deposited: Rs." + amount);
        } else {
            System.out.println("Your deposit amount is invalid.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: Rs." + amount);
        } else if (amount > balance) {
            System.out.println("Insufficient balance.");
        } else {
            System.out.println("Your withdrawl amount is invalid.");
        }
    }

    public void checkBalance() {
        System.out.println("Your Current Balance is : Rs." + balance);
    }
}