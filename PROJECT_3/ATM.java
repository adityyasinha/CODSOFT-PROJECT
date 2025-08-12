import java.util.Scanner;

public class ATM {
    private BankingAccount account;

    public ATM(BankingAccount account) {
        this.account = account;
    }

    public void start() {
     Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n ATM'S MENU ");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdrawl");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    account.checkBalance();
                    break;
                case 2:
                    System.out.print("Enter the amount you want to deposit: Rs.");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 3:
                    System.out.print("Enter the amount you want to withdraw: Rs.");
                    double withdrawAmount = scanner.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;
                case 4:
                    System.out.println("Thankyou for using the ATM.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 4);
        scanner.close();
    }
}
