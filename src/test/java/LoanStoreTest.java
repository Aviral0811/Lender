import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class LoanStoreTest {
    private LoanStore loanStore;

    @Before
    public void setUp() {
        loanStore = new LoanStore();
    }

    @Test
    public void testAddLoan() {
        try {
            Loan loan = new Loan("L1", "C1", "LEN1", 10000, 10000, "05/06/2023", 1, "05/07/2023", 0.01);
            loanStore.addLoan(loan);
            List<Loan> loans = loanStore.getAllLoans();
            assertEquals(1, loans.size());
            assertEquals(loan, loans.get(0));
        } catch (Exception e) {
            System.err.println("Exception caught: " + e.getMessage());
            fail("Exception should not be thrown");
        }
    }
}
