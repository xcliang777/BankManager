/**
 * @program: BankManager
 * @description:
 * @author: Xiaocheng Liang
 * @create: 2019-07-25 12:29
 **/
public class CheckingAccount extends Account{

    public CheckingAccount() {
    }

    public CheckingAccount(double USDBalance, double CADBalance, double EURBalance) {
        super(USDBalance, CADBalance, EURBalance);
    }
}
