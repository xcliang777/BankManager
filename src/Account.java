/**
 * @program: BankManager
 * @description: Saving Account and Checking Account
 * @author: Xiaocheng Liang
 * @create: 2019-07-25 12:28
 **/
public class Account {

    private double USDBalance;
    private double CADBalance;
    private double EURBalance;
    private Transaction transaction;

    private final double payForWithdraw = 0.02;



    public Account() {
        this.USDBalance = 0;
        this.CADBalance = 0;
        this.EURBalance = 0;
        this.transaction = new Transaction();

    }

    public Account(double USDBalance, double CADBalance, double EURBalance) {
        this.USDBalance = USDBalance;
        this.CADBalance = CADBalance;
        this.EURBalance = EURBalance;
        this.transaction = new Transaction();
    }

    public double getUSDBalance() {
        return USDBalance;
    }

    public void setUSDBalance(double USDBalance) {
        this.USDBalance = USDBalance;
    }

    public double getCADBalance() {
        return CADBalance;
    }

    public void setCADBalance(double CADBalance) {
        this.CADBalance = CADBalance;
    }

    public double getEURBalance() {
        return EURBalance;
    }

    public void setEURBalance(double EURBalance) {
        this.EURBalance = EURBalance;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    /**
    * @Description:  Deposit money(need to know the currency)
     *              return true if deposit successfully.
     *              add this to transaction.
    * @Param: [day, currency, money]
    * @return: boolean
    */
    public boolean deposit(int day, String currency, double money) {
        if (currency.equals("USD")) {
            USDBalance += money;
        }

        else if (currency.equals("CAD")) {
            CADBalance += money;
        }

        else if (currency.equals("EUR")) {
            EURBalance += money;
        }
        String accountType = savingOrChecking();
        transaction.addTransaction(day, "Deposit", currency, money, accountType);
        return true;
    }

    /**
    * @Description:  Withdraw money, banker will charge 2% for each withdraw.
     *               Return false if (balance < withdraw money + charge fee for withdraw).
     *               add this to transantion.
    * @Param: [day, currency, money]
    * @return: boolean
    */
    public boolean withdraw(int day, String currency, double money) {
        double withdrawFee = money * payForWithdraw;
        if (currency.equals("USD")) {
            if (money > USDBalance + withdrawFee) return false;
            USDBalance -= (money + withdrawFee);
        }
        if (currency.equals("CAD")) {
            if (money > CADBalance + withdrawFee) return false;
            CADBalance -= (money + withdrawFee);
        }
        if (currency.equals("EUR")) {
            if (money > USDBalance + withdrawFee) return false;
            EURBalance -= (money + withdrawFee);
        }
        String accountType = savingOrChecking();
        transaction.addTransaction(day, "Withdraw", currency, money, accountType);
        return true;
    }

    /**
     * @Description:  charge a fee for every time open and close the account.
     *                  charge $1 each time, if balance for USD is not enough, charge CAD 1.
     * @Param: []
     * @return: void
     * @Author: Xiaocheng Liang
     */
    public void chargeOpenAndClose() {
        if (this.getUSDBalance() > 1) {
            this.setUSDBalance(getUSDBalance() - 1);
        }
        else if (this.getCADBalance() > 1) {
            this.setCADBalance(getCADBalance() - 1);
        }
        else if (this.getEURBalance() > 1) {
            this.setEURBalance(getEURBalance() - 1);
        }
    }

    /**
    * @Description:  For deposit and withdraw method to check the acount type
    * @Param: []
    * @return: java.lang.String
    * @Author: Xiaocheng Liang
    */
    private String savingOrChecking(){
        boolean res;
        res = this instanceof SavingAccount;
        String accountType = res? "saving account" : "checking account";
        return accountType;
    }



}
