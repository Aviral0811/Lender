import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            // Create a LoanStore instance
            LoanStore loanStore = new LoanStore();

            // Add loans to the store
            Loan loan1 = new Loan("L1", "C1", "LEN1", 10000, 10000, "05/06/2023", 1, "05/07/2023", 0.01);
            Loan loan2 = new Loan("L2", "C1", "LEN1", 20000, 5000, "01/06/2023", 1, "05/08/2023", 0.01);
            Loan loan3 = new Loan("L3", "C2", "LEN2", 50000, 30000, "04/04/2023", 2, "04/05/2023", 0.02);
            Loan loan4 = new Loan("L4", "C3", "LEN2", 50000, 30000, "04/04/2023", 2, "04/05/2023", 0.02);

            loanStore.addLoan(loan1);
            loanStore.addLoan(loan2);
            loanStore.addLoan(loan3);
            loanStore.addLoan(loan4);

            // Make payments on loans
            loan1.makePayment(5000);
            loan2.makePayment(2000);
            loan3.makePayment(20000);
            loan4.makePayment(15000);

            // Retrieve loans by criteria
            List<Loan> lenderLoans = loanStore.getLoansByLender("LEN1");
            List<Loan> interestLoans = loanStore.getLoansByInterest(0.02);
            List<Loan> customerLoans = loanStore.getLoansByCustomer("C1");

            // Print loan details
            System.out.println("Loans for Lender LEN1:");
            for (Loan loan : lenderLoans) {
                System.out.println(loan.getLoanId() + ": Remaining Amount = " + loan.getRemainingAmount());
            }

            System.out.println("\nLoans with 0.02% Interest:");
            for (Loan loan : interestLoans) {
                System.out.println(loan.getLoanId() + ": Remaining Amount = " + loan.getRemainingAmount());
            }

            System.out.println("\nLoans for Customer C1:");
            for (Loan loan : customerLoans) {
                System.out.println(loan.getLoanId() + ": Remaining Amount = " + loan.getRemainingAmount());
            }
        } catch (Exception e) {
            System.err.println("Error parsing date in loan creation: " + e.getMessage());
        }
    }
}
