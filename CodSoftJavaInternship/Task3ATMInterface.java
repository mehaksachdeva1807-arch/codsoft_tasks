import java.util.Scanner;

class BankAccount {
    private double balance = 10000;

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Money deposited successfully!");
        } else {
            System.out.println("Invalid amount!");
        }
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount!");
        } else if (amount > balance) {
            System.out.println("Insufficient balance!");
        } else {
            balance -= amount;
            System.out.println("Please collect your money.");
        }
    }

    public void checkBalance() {
        System.out.println("Current Balance: Rs. " + balance);
    }
}

public class Task3ATMInterface {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankAccount account = new BankAccount();
        int choice = 0;

        do {
            System.out.println("\n===== ATM MENU =====");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            if (!sc.hasNextInt()) {
                System.out.println("Please enter a valid number.");
                sc.next();
                continue;
            }

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    account.checkBalance();
                    break;

                case 2:
                    System.out.print("Enter deposit amount: ");
                    if (sc.hasNextDouble()) {
                        account.deposit(sc.nextDouble());
                    } else {
                        System.out.println("Invalid amount!");
                        sc.next();
                    }
                    break;

                case 3:
                    System.out.print("Enter withdrawal amount: ");
                    if (sc.hasNextDouble()) {
                        account.withdraw(sc.nextDouble());
                    } else {
                        System.out.println("Invalid amount!");
                        sc.next();
                    }
                    break;

                case 4:
                    System.out.println("Thank you for using ATM!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 4);

        sc.close();
    }
}
