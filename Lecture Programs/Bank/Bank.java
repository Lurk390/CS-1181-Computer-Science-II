package Bank;
import java.util.*;

public class Bank {
    private static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        ArrayList<BankAccount> accountList = new ArrayList<>();
        
        while (true) {
            int choice = getMenuOption();

            switch (choice) {
                case 1: newCustomer();
                        break;
                // case 2: getBalance;
                //         break;
                // case 3: deposit();
                //         break;
                // case 4: withdraw();
                //         break;
                // case 5: applyInterest();
                //         break;
                case 6: displayAccounts(accountList);
                        break;
                case 7: return; // Quit
            }
        }

       
    }


    public static void displayAccounts(ArrayList<BankAccount> accounts) {
        Collections.sort(accounts);
        for (BankAccount a: accounts) {
            System.out.println(a);
        }
    }


    public static BankAccount newCustomer() {
        System.out.print("Name: ");
        String firstName = input.next();
        String lastName = input.next();
        System.out.print("Account Number: ");
        String accountNumber = input.next();
        System.out.print("Balance: ");
        double balance = input.nextDouble();
        double interestRate = 0.0012;
        BankAccount c = new BankAccount (firstName, lastName, accountNumber, 
                                         balance, interestRate);
        return c;
    }


    public static int getMenuOption() {
        System.out.println("1. New Customer");
        System.out.println("2. Get Balance");
        System.out.println("3. Deposit");
        System.out.println("4. Withdraw");
        System.out.println("5. Apply Interest");
        System.out.println("6. List Accounts");
        System.out.println("7. Quit");
        System.out.print("What do you want to do? ");
        return input.nextInt();
    }
}
