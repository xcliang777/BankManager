/**
 * @program: BankManager
 * @description:
 * @author: Xiaocheng Liang
 * @create: 2019-07-25 12:26
 **/
public class Manager extends Person{

    public Manager(String id, String passWord) {
        super(id, passWord);
    }

    /**
    * @Description:  When manager wants to see all the transactions
    * @Param: []
    * @return: java.lang.String
    * @Author: Xiaocheng Liang
    */
    public String seeAllTransaction(Customer customer, int day) {
        String s = customer.getSavingAccount().getTransaction().getCustomerTransaction(day);
        return s;
    }

}
