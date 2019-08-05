/**
 * @program: BankManager
 * @description:
 * @author: Xiaocheng Liang
 * @create: 2019-07-26 09:31
 **/
public class Loan {
    private double collateral;
    private double loan;
    private double arrears;
    private Transaction transaction;

    public Transaction getTransaction() {
        return transaction;
    }

    private double loanRate = 1.1;

    public Loan() {
        this.collateral = 0;
        this.loan = 0;
        this.arrears = 0;
        this.transaction = new Transaction();
    }

    public double getCollateral() {
        return collateral;
    }

    public void setCollateral(double collateral) {
        this.collateral = collateral;
    }

    public double getLoan() {
        return loan;
    }


    /**
    * @Description:  Request a loan. We only offer USD loans
     *               Return true if they have collateral, then add this to transaction.
     *               Return false if they don't have enough collateral.
     *
    * @Param: [dayForLoan, loan]
    * @return: boolean
    */
    public boolean setLoan(double loan) {
        if (this.collateral >= (loan + this.loan)) {
            this.loan += loan;
            this.arrears = loan * Math.pow(loanRate, 5);
            transaction.addTransaction("Loan: " + loan + "USD");
            return true;
        }
        return false;

    }

    /**
    * @Description:  Customer pay off his loan including interest.
    * @Param: [dayForLoan, dayForRepayment]
    * @return: void
    */
    public void repayment() {
        this.arrears = loan * Math.pow(loanRate, 5);
        transaction.addTransaction("Pay off: " + loan + "USD");
        this.loan = 0;
        this.arrears = 0;
    }

    public double getArrears() {
        return arrears;
    }

    public void setArrears(double arrears) {
        this.arrears = arrears;
    }
}
