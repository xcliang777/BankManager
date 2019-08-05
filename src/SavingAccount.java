/**
 * @program: BankManager
 * @description:
 * @author: Xiaocheng Liang
 * @create: 2019-07-25 12:29
 **/
public class SavingAccount extends Account{

    private double interestRate = 1.1;

    public SavingAccount() {
        super();
    }

    public SavingAccount(double USDBalance, double CADBalance, double EURBalance) {
        super(USDBalance, CADBalance, EURBalance);
    }
    
    /** 
    * @Description:  pay interest on savings accounts
    * @Param: [] 
    * @return: void
    */ 
    public void payInterest() {
        this.setCADBalance(getCADBalance() * interestRate);
        this.setUSDBalance(getUSDBalance() * interestRate);
        this.setEURBalance(getEURBalance() * interestRate);
    }

}
