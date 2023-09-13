import java.text.SimpleDateFormat;
import java.util.Date;

public class Loan {
    private String loanId;
    private String customerId;
    private String lenderId;
    private double amount;
    private double remainingAmount;
    private Date paymentDate;
    private double interestPerDay;
    private Date dueDate;
    private double penaltyPerDay;
    private boolean isCancelled;

    public Loan(String loanId, String customerId, String lenderId, double amount, double remainingAmount,
                String paymentDate, double interestPerDay, String dueDate, double penaltyPerDay) throws Exception {
        this.loanId = loanId;
        this.customerId = customerId;
        this.lenderId = lenderId;
        this.amount = amount;
        this.remainingAmount = remainingAmount;
        this.paymentDate = new SimpleDateFormat("dd/MM/yyyy").parse(paymentDate);
        this.interestPerDay = interestPerDay;
        this.dueDate = new SimpleDateFormat("dd/MM/yyyy").parse(dueDate);
        this.penaltyPerDay = penaltyPerDay;
        this.isCancelled = false;
        validatePaymentDate();
    }

    public String getLoanId() {
        return loanId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getLenderId() {
        return lenderId;
    }

    public double getAmount() {
        return amount;
    }

    public double getRemainingAmount() {
        return remainingAmount;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public double getInterestPerDay() {
        return interestPerDay;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public double getPenaltyPerDay() {
        return penaltyPerDay;
    }

    public boolean isCancelled() {
        return isCancelled;
    }

    public void makePayment(double paymentAmount) {
        if (paymentAmount > 0 && !isCancelled) {

            //assume the payment made
            double totalAmountPaid = amount - remainingAmount;

            //interest accrued by Lender
            double interestAccrued = totalAmountPaid * interestPerDay;

            //remaining amount
            remainingAmount -= paymentAmount;

            //Calculate new interest accrued after the payment on the assumed payment done
            double newInterestAccrued = paymentAmount * interestPerDay;

            interestAccrued = newInterestAccrued - interestAccrued;
            if (remainingAmount <= 0) {
                remainingAmount = 0;
                dueDate = new Date();
            }
            // Log interest accrued here
            if (interestAccrued > 0) {
                System.out.println("Interest accrued for Loan " + loanId + ": " + interestAccrued);
            }
        }
    }

    public void cancelLoan() {
        isCancelled = true;
    }

    private void validatePaymentDate() throws Exception {
        if (paymentDate.compareTo(dueDate) > 0) {
            throw new IllegalArgumentException("Payment date cannot be greater than due date for Loan " + loanId);
        }
    }
}
