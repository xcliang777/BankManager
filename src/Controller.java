import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;

public class Controller {

    public static void showStartLogin(StartLoginFrame frame) {
        frame.getStartLoginPanel1().getjPasswordField1().setText("");
        frame.getStartLoginPanel1().getUserIdTextFiled().setText("");
        showWindow(frame);
    }

    public static void showStartChoose(StartChooseFrame frame) {
        showWindow(frame);
    }

    public static void showManager(ManagerFrame managerFrame) {
        Set<String> items = Customer.customers.keySet();
        managerFrame.getManagerPanel1().getCustomerComboBox().setModel(new javax.swing.DefaultComboBoxModel(items.toArray()));
        managerFrame.getManagerPanel1().getAllUserToggleButton().setSelected(false);
        managerFrame.getManagerPanel1().getUpdateCheckBox().setSelected(false);
        managerFrame.getManagerPanel1().getReportTextArea().setText("");
        showWindow(managerFrame);
    }

    public static void showCustomerOverview(CustomerOverviewFrame customerOverviewFrame, Customer customer) {
        ArrayList<String> types = new ArrayList<>();
        if (customer.getSavingAccount() != null) types.add("Saving Account");
        if (customer.getCheckingAccount() != null) types.add("Checking Account");
        customerOverviewFrame.getCustomerOverviewPanel1().getTypeComboBox().setModel(new javax.swing.DefaultComboBoxModel(Account.CURRENCIES));
        customerOverviewFrame.getCustomerOverviewPanel1().getAccountComboBox().setModel(new javax.swing.DefaultComboBoxModel(types.toArray()));
        customerOverviewFrame.getCustomerOverviewPanel1().getAccountArea().setText("");
        customerOverviewFrame.getCustomerOverviewPanel1().getLoanArea().setText("");
        customerOverviewFrame.getCustomerOverviewPanel1().getActionArea().setText("");
        customerOverviewFrame.getCustomerOverviewPanel1().getUpdateCheckBox().setSelected(false);
        showWindow(customerOverviewFrame);
        refreshOverviewAccount(customerOverviewFrame, customer);
        refreshOverviewLoan(customerOverviewFrame, customer);
        refreshOverviewTransaction(customerOverviewFrame, customer);
    }

    public static void showCustomerAction(CustomerActionFrame customerActionFrame, Customer customer) {
        ArrayList<String> types = new ArrayList<>();
        if (customer.getSavingAccount() != null) types.add("Saving Account");
        if (customer.getCheckingAccount() != null) types.add("Checking Account");
        customerActionFrame.getCustomerActionPanel1().getTypeComboBox().setModel(new javax.swing.DefaultComboBoxModel(types.toArray()));
        customerActionFrame.getCustomerActionPanel1().getActionComboBox().setModel(new javax.swing.DefaultComboBoxModel(Account.ACTIONS));
        customerActionFrame.getCustomerActionPanel1().getActionComboBox1().setModel(new javax.swing.DefaultComboBoxModel(Account.CURRENCIES));
        customerActionFrame.getCustomerActionPanel1().getjTextField3().setText("");
        refreshAction(customerActionFrame, customer);
        showWindow(customerActionFrame);
    }

    public static void showCustomerCreate(CustomerCreateFrame customerCreateFrame, Customer customer) {
        ArrayList<String> types = new ArrayList<>();
        if (customer.getSavingAccount() == null) types.add("Saving Account");
        if (customer.getCheckingAccount() == null) types.add("Checking Account");
        customerCreateFrame.getCustomerCreatePanel1().getTypeComboBox().setModel(new javax.swing.DefaultComboBoxModel(types.toArray()));
        customerCreateFrame.getCustomerCreatePanel1().getPassWordField().setText("");
        showWindow(customerCreateFrame);
    }

    public static void showCustomerLoan(CustomerLoadFrame customerLoadFrame, Customer customer) {
        customerLoadFrame.getCustomerLoanPanel1().getTypeComboBox().setModel(new javax.swing.DefaultComboBoxModel(Account.LOAN));
        customerLoadFrame.getCustomerLoanPanel1().getAmountField().setText("");
        customerLoadFrame.getCustomerLoanPanel1().getInfoField().setText("");
        refreshLoan(customerLoadFrame, customer);
        showWindow(customerLoadFrame);
    }

    public static Customer customerLogin(String id, String password, JFrame parent, CustomerOverviewFrame customerOverviewFrame) {
        if (!Tools.checkString(id, parent) || !Tools.checkString(password, parent)) return null;
        if (Customer.customers.containsKey(id) && !Customer.customers.get(id).getPassWord().equals(password)) {
            Tools.errorPanel("Invalid Input", Tools.ERROR_DUPLICATE_STRING, parent);
            return null;
        } else if (Customer.customers.containsKey(id) && Customer.customers.get(id).getPassWord().equals(password)) {
            Tools.errorPanel("Success", "Login Success", parent);
            //parent.setVisible(false);
            return Customer.customers.get(id);
        } else {
            Customer customer = new Customer(id, password);
            Customer.customers.put(id, customer);
            Tools.errorPanel("Success", "New Customer Created", parent);
            return Customer.customers.get(id);
        }
    }

    public static void refreshOverviewAccount(CustomerOverviewFrame customerOverviewFrame, Customer customer) {

        if (customerOverviewFrame.getCustomerOverviewPanel1().getAccountComboBox().getSelectedItem() == null) {
            customerOverviewFrame.getCustomerOverviewPanel1().getAccountArea().setText("No info to show");
        } else {
            customerOverviewFrame.getCustomerOverviewPanel1().getAccountArea().setText(accountInfoGenerate(customerOverviewFrame.getCustomerOverviewPanel1().getAccountComboBox().getSelectedItem().toString(),
                    customerOverviewFrame.getCustomerOverviewPanel1().getTypeComboBox().getSelectedItem().toString(), customer));
        }
    }

    public static void refreshOverviewLoan(CustomerOverviewFrame customerOverviewFrame, Customer customer) {
        customerOverviewFrame.getCustomerOverviewPanel1().getLoanArea().setText(
                "Current Collateral Value: " + customer.getLoan().getCollateral() + "$\n" +
                        "Current Loan Value: " + customer.getLoan().getLoan() + "$\n"
        );
    }

    public static void refreshOverviewTransaction(CustomerOverviewFrame customerOverviewFrame, Customer customer) {
        customerOverviewFrame.getCustomerOverviewPanel1().getActionArea().setText(customer.getReport(!customerOverviewFrame.getCustomerOverviewPanel1().getUpdateCheckBox().isSelected()));
    }

    public static void actionCreate(CustomerCreateFrame customerCreateFrame, Customer customer) {

        if (customerCreateFrame.getCustomerCreatePanel1().getTypeComboBox().getSelectedItem() == null) {
            Tools.errorPanel("Error", "You can't have additional account", customerCreateFrame);
        }
        else if (Tools.checkString(customerCreateFrame.getCustomerCreatePanel1().getPassWordField().getText(), customerCreateFrame)) {
            if (customerCreateFrame.getCustomerCreatePanel1().getTypeComboBox().getSelectedItem().equals("Checking Account")) {
                Tools.errorPanel("Success", "Checking Account created", customerCreateFrame);
                customer.setCheckingAccount(new CheckingAccount());
                System.out.println(customer.getCheckingAccount());
            } else {
                Tools.errorPanel("Success", "Saving Account created", customerCreateFrame);
                customer.setSavingAccount(new SavingAccount());
            }
        }
        refreshCreate(customerCreateFrame, customer);
    }

    public static void refreshCreate(CustomerCreateFrame customerCreateFrame, Customer customer) {
        ArrayList<String> types = new ArrayList<>();
        if (customer.getSavingAccount() == null) types.add("Saving Account");
        if (customer.getCheckingAccount() == null) types.add("Checking Account");
        customerCreateFrame.getCustomerCreatePanel1().getTypeComboBox().setModel(new javax.swing.DefaultComboBoxModel(types.toArray()));
        customerCreateFrame.getCustomerCreatePanel1().getPassWordField().setText("");
    }

    public static void refreshLoan(CustomerLoadFrame customerLoadFrame, Customer customer) {
        double coVal = customer.getLoan().getCollateral();
        double loanVal = customer.getLoan().getLoan();
        double repayVal = customer.getLoan().getArrears();
        customerLoadFrame.getCustomerLoanPanel1().getInfoField().setText("Collateral value: " + coVal +
                "\nLoan value" + loanVal + "\nValue need to repay: " + (customer.getLoan().getArrears() == 0 ? "Cleared" : customer.getLoan().getArrears()));
    }

    public static void actionLoan(CustomerLoadFrame customerLoadFrame, Customer customer) {
        String type = customerLoadFrame.getCustomerLoanPanel1().getTypeComboBox().getSelectedItem().toString();
        if (type.equals("Add Collateral")) {
            System.out.println("loan collateral");
            if (!Tools.checkStringIsNumberWithRange(customerLoadFrame.getCustomerLoanPanel1().getAmountField().getText(), 0, 10000, customerLoadFrame)) {
                return;
            }
            customer.getLoan().setCollateral(customer.getLoan().getCollateral() + Integer.parseInt(customerLoadFrame.getCustomerLoanPanel1().getAmountField().getText()));
            Tools.errorPanel("Success", "Transaction finished", customerLoadFrame);
        } else if (type.equals("Get Loan")) {
            if (!Tools.checkStringIsNumberWithRange(customerLoadFrame.getCustomerLoanPanel1().getAmountField().getText(), 0, (int)(customer.getLoan().getCollateral() - customer.getLoan().getLoan()), customerLoadFrame)) return;
            if (!customer.getLoan().setLoan(Integer.parseInt(customerLoadFrame.getCustomerLoanPanel1().getAmountField().getText()))) Tools.errorPanel("Failed", "Not enough money", customerLoadFrame);
            else Tools.errorPanel("Success", "Transaction finished", customerLoadFrame);
        } else {
            customer.getLoan().repayment();
            Tools.errorPanel("Success", "Transaction finished", customerLoadFrame);
        }
        refreshLoan(customerLoadFrame, customer);
    }

    public static void refreshAction(CustomerActionFrame customerActionFrame, Customer customer) {
        System.out.println(customerActionFrame.getCustomerActionPanel1().getTypeComboBox().getSelectedItem());
        if (customer.getSavingAccount() == null && customer.getCheckingAccount() == null) return;
        Account temp = customerActionFrame.getCustomerActionPanel1().getTypeComboBox().getSelectedItem().equals("Checking Account") ? customer.getCheckingAccount() : customer.getSavingAccount();
        String currency = customerActionFrame.getCustomerActionPanel1().getActionComboBox1().getSelectedItem().toString();
        if (currency.equals("USD")) customerActionFrame.getCustomerActionPanel1().getInfo().setText("Current Balance: " + temp.getUSDBalance());
        else if (currency.equals("EUR")) customerActionFrame.getCustomerActionPanel1().getInfo().setText("Current Balance: " + temp.getEURBalance());
        else customerActionFrame.getCustomerActionPanel1().getInfo().setText("Current Balance: " + temp.getCADBalance());

    }


    public static void actionAction(CustomerActionFrame customerActionFrame, Customer customer) {
        if (!Tools.checkStringIsNumberWithRange(customerActionFrame.getCustomerActionPanel1().getjTextField3().getText(), 0, 10000, customerActionFrame)) {
            System.out.println("action failed");
            return;
        }
        int amount = Integer.parseInt(customerActionFrame.getCustomerActionPanel1().getjTextField3().getText());
        Account temp = customerActionFrame.getCustomerActionPanel1().getTypeComboBox().getSelectedItem().equals("Checking Account") ? customer.getCheckingAccount() : customer.getSavingAccount();
        String currency = customerActionFrame.getCustomerActionPanel1().getActionComboBox1().getSelectedItem().toString();
        if (currency.equals("USD")) {
            if (customerActionFrame.getCustomerActionPanel1().getActionComboBox().getSelectedItem().equals("Deposit")) {

                temp.deposit("USD",amount);
            } else {
                if (!temp.withdraw("USD", amount)) Tools.errorPanel("Failed", "Not enough Money", customerActionFrame);
                else Tools.errorPanel("Success", "Transaction finished", customerActionFrame);
            }
        }
        else if (currency.equals("EUR")) {
            if (customerActionFrame.getCustomerActionPanel1().getActionComboBox().getSelectedItem().equals("Deposit")) {
                temp.deposit("EUR",amount);
            } else {
                if (!temp.withdraw("EUR", amount)) Tools.errorPanel("Failed", "Not enough Money", customerActionFrame);
                else Tools.errorPanel("Success", "Transaction finished", customerActionFrame);
            }
        }
        else {
            if (customerActionFrame.getCustomerActionPanel1().getActionComboBox().getSelectedItem().equals("Deposit")) {
                temp.deposit("CAD",amount);
            } else {
                if (!temp.withdraw("CAD", amount)) Tools.errorPanel("Failed", "Not enough Money", customerActionFrame);
                else Tools.errorPanel("Success", "Transaction finished", customerActionFrame);
            }
        }
        refreshAction(customerActionFrame, customer);
    }



    private static <T extends JFrame> void showWindow(T frame) {
        int windowWidth = frame.getWidth();
        int windowHeight = frame.getHeight();
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;
        frame.setLocation(screenWidth/2-windowWidth/2, screenHeight/2-windowHeight/2);
        frame.setVisible(true);
    }

    private static String accountInfoGenerate(String type, String currency, Customer customer) {
        Account account;
        if (type.equals("Checking Account")) {
            account = customer.getCheckingAccount();
        } else {
            account = customer.getSavingAccount();
        }
        if (currency.equals("CAD")) {
            return "Your balance:\n" + account.getCADBalance() + "CAD";
        } else if (currency.equals("EUR")) {
            return "Your balance:\n" + account.getEURBalance() + "EUR";
        } else {
            return "Your balance:\n" + account.getUSDBalance() + "USD";
        }
    }

}
