import java.util.Date;

public class Deposit {
    private double amount;
    private Date date;
    private String account;

    // Requires: double, Date, Checking/Saving String
    // Modifies: this
    // Effects: creates new Deposit
    public Deposit(double amount, Date date, String account){
        this.amount = amount;
        this.date = date;
        this.account = account;
    }

    // Requires: none
    // Modifies: none
    // Effects: returns string form of Deposit
    public String toString(){
        //your code here
        return "Deposit of: $" + amount + " Date: " + date + " into account: " + account;
    }
}
