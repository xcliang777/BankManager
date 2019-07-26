import java.util.ArrayList;
import java.util.List;

/**
 * @program: BankManager
 * @description:
 * @author: Xiaocheng Liang
 * @create: 2019-07-25 12:29
 **/
public class Transaction {
    private List<Integer> dayList;
    private List<String> transactionTypeList;
    private List<String> currencyList;
    private List<Double> moneyList;
    private List<String> accountTypeList;
    
    public Transaction() {
        this.dayList = new ArrayList<Integer>();
        this.transactionTypeList = new ArrayList<String>();
        this.currencyList = new ArrayList<String>();
        this.moneyList = new ArrayList<Double>();
        this.accountTypeList = new ArrayList<String>();
    }

    /**
    * @Description:
    * @Param: [day, transactionType, currency, money]
    * @return: void
    */
    public void addTransaction(int day, String transactionType, String currency, Double money, String accountType) {
        dayList.add(day);
        transactionTypeList.add(transactionType);
        currencyList.add(currency);
        moneyList.add(money);
        accountTypeList.add(accountType);
    }

    /**
    * @Description:  print a customer's transaction in one day
    * @Param: [day]
    * @return: java.lang.String
    */
    public String getCustomerTransaction(int day) {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < moneyList.size(); i++) {
            if (day == dayList.get(i)) {
                s.append("Day: " + dayList.get(i) +". The customer " + transactionTypeList.get(i)
                            + " " + currencyList.get(i) + " " + moneyList.get(i));
                if (accountTypeList.get(i).equals("saving account") || accountTypeList.get(i).equals("checking account"))
                    s.append(" in " + accountTypeList.get(i) + ".\n");
                else
                    s.append(".\n");
            }
        }
        return s.toString();
    }


}
