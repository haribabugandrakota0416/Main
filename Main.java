package codesoft;
import java.util.Scanner;

class UserBankAccount {
    private double balance;

    public UserBankAccount(double initialBalance) {
        balance = initialBalance;
    }

    public boolean deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            return true;
        }
        return false;
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }

    public double checkBalance() {
        return balance;
    }
}

class ATMS {
    private UserBankAccount userAccount;

    public ATMS(UserBankAccount account) {
        userAccount = account;
    }

    public String deposit(double amount) {
        if (userAccount.deposit(amount)) {
            return "Deposited RS" + amount + ". New balance: RS" + userAccount.checkBalance();
        } else {
            return "Invalid deposit amount.";
        }
    }

    public String withdraw(double amount) {
        if (userAccount.withdraw(amount)) {
            return "Withdrew RS" + amount + ". New balance: RS" + userAccount.checkBalance();
        } else {
            return "Invalid withdrawal amount or insufficient balance.";
        }
    }

    public String checkBalance() {
        return "Your account balance is RS" + userAccount.checkBalance();
    }
}

public class Main {
    public static void main(String[] args) {
        double initialBalance = 1000;
        UserBankAccount userAccount = new UserBankAccount(initialBalance);
        ATMS atm = new ATMS(userAccount);

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Select option in which you want :");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");

            System.out.print("Enter option: ");
            String choice = scanner.nextLine();

            if (choice.equals("1")) {
                System.out.print("Enter the deposit amount: ");
                double amount = Double.parseDouble(scanner.nextLine());
                String message = atm.deposit(amount);
                System.out.println(message);
            } else if (choice.equals("2")) {
                System.out.print("Enter the withdrawal amount: ");
                double amount = Double.parseDouble(scanner.nextLine());
                String message = atm.withdraw(amount);
                System.out.println(message);
            } else if (choice.equals("3")) {
                String message = atm.checkBalance();
                System.out.println(message);
            } else if (choice.equals("4")) {
                System.out.println("Thank you for using the ATM");
                break;
            } else {
                System.out.println("Invalid option. Please choose a valid option 1-4");
            }
        }
    }
}
