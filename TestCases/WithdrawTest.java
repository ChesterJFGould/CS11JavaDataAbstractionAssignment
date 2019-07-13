import java.time.Instant;
import java.util.Date;
import org.junit.Before;
import org.junit.Test;

import java.time.Instant;

import static org.junit.Assert.assertEquals;

public class WithdrawTest {
    private Withdraw withdraw;

    @Test
    public void TestToString() {
        Date now = Date.from(Instant.now());

        // Tests Checking withdraw
        withdraw = new Withdraw(2.71, now, Customer.CHECKING);

        assertEquals("Withdraw of: $" + 2.71 + " Date: " + now + " into account: Checking", withdraw.toString());

        // Tests Saving withdraw
        withdraw = new Withdraw(2.71, now, Customer.SAVING);

        assertEquals("Withdraw of: $" + 2.71 + " Date: " + now + " into account: Saving", withdraw.toString());
    }
}
