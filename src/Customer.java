/**
 * @program: BankManager
 * @description:
 * @author: Xiaocheng Liang
 * @create: 2019-07-25 12:26
 **/
public class Customer extends Person {
    private SavingAccount savingAccount;
    private CheckingAccount checkingAccount;
    private Loan loan;

    public Customer(String id, String passWord) {
        super(id, passWord);
        this.savingAccount = new SavingAccount();
        this.checkingAccount = new CheckingAccount();
        this.loan = new Loan();
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

}
