public class Main {
    public static void main(String[] args) {
        BankingAccount userAccount = new BankingAccount(1000.00); // THE INITIAL BALANCE SHOULD BE MINIMUM 1000 RUPEES
        ATM atm = new ATM(userAccount);
        atm.start();
    }
}
