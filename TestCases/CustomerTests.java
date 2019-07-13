import java.time.Instant;
import java.util.Date;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CustomerTests {
    private Customer customer;

    @Before
    public void setup() {
        customer = new Customer("John Smith", 1, 0, 0);
    }

    @Test
    public void TestDeposit() {
        Date now = Date.from(Instant.now());
        // Tests basic deposit on both accounts
        assertEquals(100, customer.deposit(100, now, Customer.CHECKING), 0);
        assertEquals(100, customer.deposit(100, now, Customer.SAVING), 0);
        // Tests additional deposit and non integer deposit on both accounts
        assertEquals(110.01, customer.deposit(10.01, now, Customer.CHECKING), 0.01);
        assertEquals(110.01, customer.deposit(10.01, now, Customer.SAVING), 0.01);
    }

    @Test
    public void TestWithdraw() {
        Date now = Date.from(Instant.now());
        // Gives customer initial balance on both accounts
        customer.deposit(20.01, now, Customer.CHECKING);
        customer.deposit(20.01, now, customer.SAVING);

        // Tests basic withdraw on both accounts
        assertEquals(10, customer.withdraw(10.01, now, Customer.CHECKING), 0.01);
        assertEquals(10, customer.withdraw(10.01, now, Customer.SAVING), 0.01);
        // Tests withdraw that will cause balance to be negative but above withdraw limit on both accounts
        assertEquals(-50, customer.withdraw(60, now, Customer.CHECKING), 0.01);
        assertEquals(-50, customer.withdraw(60, now, Customer.SAVING), 0.01);
        // Tests withdraw that will overdraft account on both accounts
        assertEquals(-50, customer.withdraw(60, now, Customer.CHECKING), 0.01);
        assertEquals(-50, customer.withdraw(60, now, Customer.SAVING), 0.01);
    }
}