import java.time.Instant;
import java.util.Date;
import org.junit.Before;
import org.junit.Test;

import java.time.Instant;

import static org.junit.Assert.assertEquals;

public class DepositTest {
    private Deposit deposit;

    @Test
    public void TestToString() {
        Date now = Date.from(Instant.now());

        // Tests Checking deposit
        deposit = new Deposit(3.14, now, Customer.CHECKING);

        assertEquals("Deposit of: $" + 3.14 + " Date: " + now + " into account: Checking", deposit.toString());

        // Tests Saving deposit
        deposit = new Deposit(3.14, now, Customer.SAVING);

        assertEquals("Deposit of: $" + 3.14 + " Date: " + now + " into account: Saving", deposit.toString());
    }
}
