import java.util.ArrayList;
import java.util.List;

public class LoanStore {
    private List<Loan> loans;

    public LoanStore() {
        loans = new ArrayList<>();
    }

    public void addLoan(Loan loan) {
        loans.add(loan);
    }

    public List<Loan> getAllLoans() {
        return loans;
    }

    public List<Loan> getLoansByLender(String lenderId) {
        List<Loan> lenderLoans = new ArrayList<>();
        for (Loan loan : loans) {
            if (loan.getLenderId().equals(lenderId)) {
                lenderLoans.add(loan);
            }
        }
        return lenderLoans;
    }

    public List<Loan> getLoansByInterest(double interestRate) {
        List<Loan> interestLoans = new ArrayList<>();
        for (Loan loan : loans) {
            if (loan.getInterestPerDay() == interestRate) {
                interestLoans.add(loan);
            }
        }
        return interestLoans;
    }

    public List<Loan> getLoansByCustomer(String customerId) {
        List<Loan> customerLoans = new ArrayList<>();
        for (Loan loan : loans) {
            if (loan.getCustomerId().equals(customerId)) {
                customerLoans.add(loan);
            }
        }
        return customerLoans;
    }
}
