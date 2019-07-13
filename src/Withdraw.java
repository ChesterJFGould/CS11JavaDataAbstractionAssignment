import java.util.Date;

public class Withdraw {
    private double amount;
    private Date date;
    private String account;

    // Requires: double, Date, Checking/Saving String
    // Modifies: this
    // Effects: creates new Withdraw
    public Withdraw(double amount, Date date, String account){
        this.amount = amount;
        this.date = date;
        this.account = account;
    }

    // Requires: none
    // Modifies: none
    // Effects: returns string form of Withdraw
    public String toString(){
        //your code here
        return "Withdraw of: $" + amount + " Date: " + date + " into account: " + account;
    }
}
