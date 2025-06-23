public interface BankOperations {
    void deposit(double amount);
    void withdraw(double amount);import java.util.*;

class Account {
    private String name;
    private String accountNumber;
    private String pin;
    private double balance;

    public Account(String name, String accountNumber, String pin) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.pin = pin;
        this.balance = 0.0;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getPin() {
        return pin;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amt) {
        if (amt > 0) {
            balance += amt;
            System.out.println("₹" + amt + " deposited successfully.");
        } else {
            System.out.println("Invalid amount.");
        }
    }

    public void withdraw(double amt) {
        if (amt > 0 && amt <= balance) {
            balance -= amt;
            System.out.println("₹" + amt + " withdrawn successfully.");
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }
}

public class BankSystem {
    static Scanner sc = new Scanner(System.in);
    static Map<String, Account> accounts = new HashMap<>();

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n===== MINI BANKING SYSTEM =====");
            System.out.println("1. Create Account");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1 -> createAccount();
                case 2 -> login();
                case 3 -> System.out.println("Thank you for using Mini Bank!");
                default -> System.out.println("Invalid choice.");
            }
        } while (choice != 3);
    }

    public static void createAccount() {
        System.out.print("Enter your name: ");
        String name = sc.nextLine();
        String accNum;
        do {
            System.out.print("Enter a 6-digit Account Number: ");
            accNum = sc.nextLine();
        } while (accounts.containsKey(accNum));

        System.out.print("Set a 4-digit PIN: ");
        String pin = sc.nextLine();

        accounts.put(accNum, new Account(name, accNum, pin));
        System.out.println("✅ Account created successfully!");
    }

    public static void login() {
        System.out.print("Enter Account Number: ");
        String accNum = sc.nextLine();
        System.out.print("Enter PIN: ");
        String pin = sc.nextLine();

        Account acc = accounts.get(accNum);
        if (acc != null && acc.getPin().equals(pin)) {
            System.out.println("✅ Welcome, " + acc.getName() + "!");
            userMenu(acc);
        } else {
            System.out.println("❌ Invalid credentials.");
        }
    }

    public static void userMenu(Account acc) {
        int ch;
        do {
            System.out.println("\n--- Banking Menu ---");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Logout");
            System.out.print("Enter choice: ");
            ch = sc.nextInt();

            switch (ch) {
                case 1 -> System.out.println("💰 Balance: ₹" + acc.getBalance());
                case 2 -> {
                    System.out.print("Enter amount to deposit: ₹");
                    double amt = sc.nextDouble();
                    acc.deposit(amt);
                }
                case 3 -> {
                    System.out.print("Enter amount to withdraw: ₹");
                    double amt = sc.nextDouble();
                    acc.withdraw(amt);
                }
                case 4 -> System.out.println("Logging out...");
                default -> System.out.println("Invalid option.");
            }
        } while (ch != 4);
    }
}

    double getBalance();
}
