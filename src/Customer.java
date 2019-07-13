import java.util.ArrayList;
import java.util.Date;

public class Customer {
    private int accountNumber;
    private ArrayList<Deposit> deposits;
    private ArrayList<Withdraw> withdraws;
    private double checkBalance;
    private double savingBalance;
    private double savingRate;
    private String name;
    public static final String CHECKING = "Checking";
    public static final String SAVING = "Saving";
    private final int OVERDRAFT = -100;
    private static int accountCount = 0;

    public Customer(){
        this.name = "N/A";
        this.accountNumber = -1;
        this.savingBalance = 0;
        this.checkBalance = 0;
        deposits = new ArrayList<Deposit>();
        withdraws = new ArrayList<Withdraw>();
    }

    // Requires: String, unique int, double, double
    // Modifies: this
    // Effects: Creates a new Customer
    public Customer(String name, int accountNumber, double checkDeposit, double savingDeposit){
        this.name = name;
        this.accountNumber = accountNumber;
        this.checkBalance = checkDeposit;
        this.savingBalance = savingDeposit;
        deposits = new ArrayList<Deposit>();
        withdraws = new ArrayList<Withdraw>();
    }

    // Requires: double, Date, Checking/Saving String
    // Modifies: deposits
    // Effects: adds amount to balance
    public double deposit(double amt, Date date, String account){
        switch (account) {
            case CHECKING:
                deposits.add(new Deposit(amt, date, account));
                checkBalance += amt;

                return checkBalance;
            case SAVING:
                deposits.add(new Deposit(amt, date, account));
                savingBalance += amt;

                return savingBalance;
            default:
                System.out.println("Error: invalid account specified for deposit");
                return 0;
        }
    }

    // Requires: double, Date, Checking/Saving String
    // Modifies: withdraws
    // Effects: negates amount from balance
    public double withdraw(double amt, Date date, String account){
        switch (account) {
            case CHECKING:
                if (checkOverdraft(amt, account)) {
                    System.out.println("OVERDRAFT: accountNumber:" + accountNumber + " account: " + account);
                    return checkBalance;
                }

                withdraws.add(new Withdraw(amt, date, account));
                checkBalance -= amt;

                return checkBalance;
            case SAVING:
                if (checkOverdraft(amt, account)) {
                    System.out.println("OVERDRAFT: accountNumber:" + accountNumber + " account: " + account);
                    return checkBalance;
                }

                withdraws.add(new Withdraw(amt, date, account));
                savingBalance -= amt;

                return savingBalance;
            default:
                System.out.println("Error: invalid account specified for withdraw");
                return -1;
        }
    }

    // Requires: double, Checking/Saaving String
    // Modifies: none
    // Effects: returns true if withdrawn amount will put balance over overdraft limit
    private boolean checkOverdraft(double amt, String account){
        switch (account) {
            case CHECKING:
                return (-amt + checkBalance) < OVERDRAFT;
            case SAVING:
                return (-amt + savingBalance) < OVERDRAFT;
            default:
                System.out.println("Error: invalid account specified for overdraft check");
                return true;
        }
    }
    // Requires: none
    // Modifies: none
    // Effects: prints all deposits for customer
    //do not modify
    public void displayDeposits(){
        for(Deposit d : deposits){
            System.out.println(d);
        }
    }
    // Requires: none
    // Modifies: none
    // Effects: prints all withdraws for customer
    //do not modify
    public void displayWithdraws(){
        for(Withdraw w : withdraws){
            System.out.println(w);
        }
    }

}
