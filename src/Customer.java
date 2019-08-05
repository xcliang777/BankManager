import java.util.HashMap;
import java.util.Map;

/**
 * @program: BankManager
 * @description:
 * @author: Xiaocheng Liang
 * @create: 2019-07-25 12:26
 **/
public class Customer extends Person {

    public static Map<String, Customer> customers = new HashMap<>();

    private SavingAccount savingAccount;
    private CheckingAccount checkingAccount;
    private Loan loan;
    private Transaction transaction;

    public Customer(String id, String passWord) {
        super(id, passWord);
        this.loan = new Loan();
        this.transaction = new Transaction();
    }

    public SavingAccount getSavingAccount() {
        return savingAccount;
    }

    public void setSavingAccount(SavingAccount savingAccount) {
        this.savingAccount = savingAccount;
    }

    public CheckingAccount getCheckingAccount() {
        return checkingAccount;
    }

    public void setCheckingAccount(CheckingAccount checkingAccount) {
        this.checkingAccount = checkingAccount;
    }

    public Loan getLoan() {
        return loan;
    }

    public void setLoan(Loan loan) {
        this.loan = loan;
    }

    public String getReport(boolean all) {
        //return getId() + "\n" + loan.getTransaction().generateReportWithReset(all) + "\n" + checkingAccount != null ? getCheckingAccount().getTransaction().generateReportWithReset(all) : "" + (savingAccount != null ? getSavingAccount().getTransaction().generateReportWithReset(all) : "");
        String s1 = checkingAccount != null ? getCheckingAccount().getTransaction().generateReportWithReset(all) : "" + (savingAccount != null ? getSavingAccount().getTransaction().generateReportWithReset(all) : "");
        String s2 = "Id: " + getId() + "\n" + getLoan().getTransaction().generateReportWithReset(all) + "\n";
        return s2 + s1;
    }

}
