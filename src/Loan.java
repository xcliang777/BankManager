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
    public boolean setLoan(int dayforLoan, double loan) {
        if (this.collateral >= loan) {
            this.loan = loan;
            transaction.addTransaction(dayforLoan, "Loan", "USD", loan, "loan");
            return true;
        }
        return false;

    }

    /**
    * @Description:  Customer pay off his loan including interest.
    * @Param: [dayForLoan, dayForRepayment]
    * @return: void
    */
    public void repayment(int dayForLoan, int dayForRepayment) {
        this.arrears = loan * Math.pow(loanRate, dayForRepayment - dayForLoan);
        transaction.addTransaction(dayForRepayment, "Pay off", "USD", arrears, "loan");
        this.loan = 0;
        this.arrears = 0;
    }


}
