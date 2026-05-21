import java.util.Scanner;

class BankAccount {

  
    private double balance;

    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }

   
    public void deposit(double amount) {

        if (amount > 0) {
            balance += amount;

            System.out.println("₹" + amount + " deposited successfully.");
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }

    
    public void withdraw(double amount) {

        
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount!");
        }

        
        else if (amount > balance) {
            System.out.println("Insufficient balance!");
        }

       
        else {
            balance -= amount;

            System.out.println("₹" + amount + " withdrawn successfully.");
        }
    }

    
    public void checkBalance() {
        System.out.println("Current Balance: ₹" + balance);
    }
}


class ATM {

    private BankAccount account;

    
    public ATM(BankAccount account) {
        this.account = account;
    }

    
    public void start() {

        Scanner sc = new Scanner(System.in);

        int choice;

        do {

            
            System.out.println("\n========== ATM MENU ==========");
            System.out.println("1. Deposit Money");
            System.out.println("2. Withdraw Money");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.println("==============================");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                
                case 1:

                    System.out.print("Enter deposit amount: $");
                    double depositAmount = sc.nextDouble();

                    account.deposit(depositAmount);

                    break;

                
                case 2:

                    System.out.print("Enter withdrawal amount: $");
                    double withdrawAmount = sc.nextDouble();

                    account.withdraw(withdrawAmount);

                    break;

               
                case 3:

                    account.checkBalance();

                    break;

               
                case 4:

                    System.out.println("Thank you for using the ATM!");

                    break;

                
                default:

                    System.out.println("Invalid choice! Please try again.");
            }

        } while (choice != 4);

        sc.close();
    }
}

public class AtmInterface {

    public static void main(String[] args) {

        
        BankAccount userAccount = new BankAccount(10000);

       
        ATM atm = new ATM(userAccount);

        
        atm.start();
    }
}
