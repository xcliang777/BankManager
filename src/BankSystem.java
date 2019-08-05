/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Controller | Templates
 * and open the template in the editor.
 */


import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author zhuyu
 */
public class BankSystem {

    private StartChooseFrame startChoosingFrame;
    private StartLoginFrame startLoginFrame;

    private ManagerFrame managerFrame;

    private CustomerOverviewFrame customerOverviewFrame;
    private CustomerCreateFrame customerCreateFrame;

    private Customer customer;
    public StartChooseFrame getStartChoosingFrame() {
        return startChoosingFrame;
    }

    public StartLoginFrame getStartLoginFrame() {
        return startLoginFrame;
    }

    public ManagerFrame getManagerFrame() {
        return managerFrame;
    }

    public CustomerOverviewFrame getCustomerOverviewFrame() {
        return customerOverviewFrame;
    }

    public CustomerCreateFrame getCustomerCreateFrame() {
        return customerCreateFrame;
    }

    public CustomerActionFrame getCustomerActionFrame() {
        return customerActionFrame;
    }

    private CustomerActionFrame customerActionFrame;
    private CustomerLoadFrame customerLoanFrame;


    public JFrame getCustomerLoanFrame() {
        return customerLoanFrame;
    }

    public BankSystem() {
        startChoosingFrame = new StartChooseFrame();
        startLoginFrame = new StartLoginFrame();
        managerFrame = new ManagerFrame();
        customerActionFrame = new CustomerActionFrame();
        customerCreateFrame = new CustomerCreateFrame();
        customerLoanFrame = new CustomerLoadFrame();
        customerOverviewFrame = new CustomerOverviewFrame();

        startChoosingFrame.getStartChoosePanel1().getCustomerButton().addActionListener(e -> {startChoosingFrame.setVisible(false); Controller.showStartLogin(startLoginFrame);});
        startChoosingFrame.getStartChoosePanel1().getExitButton().addActionListener(e -> {System.exit(0);});
        startChoosingFrame.getStartChoosePanel1().getManagerButton().addActionListener(e -> {startChoosingFrame.setVisible(false); Controller.showManager(managerFrame);});

        startLoginFrame.getStartLoginPanel1().getLoginButton1().addActionListener(e -> {startLoginFrame.setVisible(false); Controller.showStartChoose(startChoosingFrame);});
        startLoginFrame.getStartLoginPanel1().getLoginButton().addActionListener(e -> {
            customer = Controller.customerLogin(startLoginFrame.getStartLoginPanel1().getUserIdTextFiled().getText(),
                startLoginFrame.getStartLoginPanel1().getjPasswordField1().getText(), startLoginFrame, customerOverviewFrame);
            if (customer != null) {
                startLoginFrame.setVisible(false);
                Controller.showCustomerOverview(customerOverviewFrame, customer);
            }
        });
        managerFrame.getManagerPanel1().getBackButton().addActionListener(e -> {managerFrame.setVisible(false); Controller.showStartChoose(startChoosingFrame);});
        managerFrame.getManagerPanel1().getGenerateButton().addActionListener(e -> {
            StringBuilder stringBuilder = new StringBuilder();
            if (managerFrame.getManagerPanel1().getAllUserToggleButton().isSelected()) {
                if (managerFrame.getManagerPanel1().getUpdateCheckBox().isSelected()){
                    for (Customer customer : Customer.customers.values()) {
                        stringBuilder.append(customer.getReport(false) + "\n\n\n");
                    }
                } else {
                    for (Customer customer : Customer.customers.values()) {
                        stringBuilder.append(customer.getReport(true) + "\n\n\n");
                    }
                }
            } else {
                if (managerFrame.getManagerPanel1().getUpdateCheckBox().isSelected()){
                    stringBuilder.append(Customer.customers.get(managerFrame.getManagerPanel1().getCustomerComboBox().getSelectedItem()).getReport(false));
                } else {
                    stringBuilder.append(Customer.customers.get(managerFrame.getManagerPanel1().getCustomerComboBox().getSelectedItem()).getReport(true));
                }
            }
            managerFrame.getManagerPanel1().getReportTextArea().setText(stringBuilder.toString());
        });

        //======================================================================
        customerActionFrame.getjMenu5().addMenuListener(new MenuListener() {
            @Override
            public void menuSelected(MenuEvent e) {
                customerActionFrame.setVisible(false);
                Controller.showStartChoose(startChoosingFrame);
            }

            @Override
            public void menuDeselected(MenuEvent e) {

            }

            @Override
            public void menuCanceled(MenuEvent e) {

            }
        });
        customerActionFrame.getjMenu1().addMenuListener(new MenuListener() {
            @Override
            public void menuSelected(MenuEvent e) {
                customerActionFrame.setVisible(false);
                Controller.showCustomerOverview(customerOverviewFrame, customer);
            }

            @Override
            public void menuDeselected(MenuEvent e) {

            }

            @Override
            public void menuCanceled(MenuEvent e) {

            }
        });
        customerActionFrame.getjMenu2().addMenuListener(new MenuListener() {
            @Override
            public void menuSelected(MenuEvent e) {
                customerActionFrame.setVisible(false);
                Controller.showCustomerCreate(customerCreateFrame, customer);
            }

            @Override
            public void menuDeselected(MenuEvent e) {

            }

            @Override
            public void menuCanceled(MenuEvent e) {

            }
        });
        customerActionFrame.getjMenu3().addMenuListener(new MenuListener() {
            @Override
            public void menuSelected(MenuEvent e) {
                customerActionFrame.setVisible(false);
                Controller.showCustomerLoan(customerLoanFrame, customer);
            }

            @Override
            public void menuDeselected(MenuEvent e) {

            }

            @Override
            public void menuCanceled(MenuEvent e) {

            }
        });
        customerActionFrame.getjMenu4().addMenuListener(new MenuListener() {
            @Override
            public void menuSelected(MenuEvent e) {
            }

            @Override
            public void menuDeselected(MenuEvent e) {

            }

            @Override
            public void menuCanceled(MenuEvent e) {

            }
        });
        customerActionFrame.getCustomerActionPanel1().getButtonCreate().addActionListener(e -> Controller.actionAction(customerActionFrame, customer));
        customerActionFrame.getCustomerActionPanel1().getActionComboBox1().addActionListener(e -> Controller.refreshAction(customerActionFrame, customer));
        customerActionFrame.getCustomerActionPanel1().getActionComboBox().addActionListener(e -> Controller.refreshAction(customerActionFrame, customer));
        customerActionFrame.getCustomerActionPanel1().getTypeComboBox().addActionListener(e -> Controller.refreshAction(customerActionFrame, customer));

        //======================================================================
        customerCreateFrame.getjMenu5().addMenuListener(new MenuListener() {
            @Override
            public void menuSelected(MenuEvent e) {
                customerCreateFrame.setVisible(false);
                Controller.showStartChoose(startChoosingFrame);
            }

            @Override
            public void menuDeselected(MenuEvent e) {

            }

            @Override
            public void menuCanceled(MenuEvent e) {

            }
        });
        customerCreateFrame.getjMenu1().addMenuListener(new MenuListener() {
            @Override
            public void menuSelected(MenuEvent e) {
                customerCreateFrame.setVisible(false);
                Controller.showCustomerOverview(customerOverviewFrame, customer);
            }

            @Override
            public void menuDeselected(MenuEvent e) {

            }

            @Override
            public void menuCanceled(MenuEvent e) {

            }
        });
        customerCreateFrame.getjMenu3().addMenuListener(new MenuListener() {
            @Override
            public void menuSelected(MenuEvent e) {
                customerCreateFrame.setVisible(false);
                Controller.showCustomerLoan(customerLoanFrame, customer);
            }

            @Override
            public void menuDeselected(MenuEvent e) {

            }

            @Override
            public void menuCanceled(MenuEvent e) {

            }
        });
        customerCreateFrame.getjMenu4().addMenuListener(new MenuListener() {
            @Override
            public void menuSelected(MenuEvent e) {
                customerCreateFrame.setVisible(false);
                Controller.showCustomerAction(customerActionFrame, customer);
            }

            @Override
            public void menuDeselected(MenuEvent e) {

            }

            @Override
            public void menuCanceled(MenuEvent e) {

            }
        });
        customerCreateFrame.getjMenu2().addMenuListener(new MenuListener() {
            @Override
            public void menuSelected(MenuEvent e) {

            }

            @Override
            public void menuDeselected(MenuEvent e) {

            }

            @Override
            public void menuCanceled(MenuEvent e) {

            }
        });
        customerCreateFrame.getCustomerCreatePanel1().getCreateButton().addActionListener(e -> Controller.actionCreate(customerCreateFrame, customer));

        //======================================================================
        customerOverviewFrame.getjMenu5().addMenuListener(new MenuListener() {
            @Override
            public void menuSelected(MenuEvent e) {
                customerOverviewFrame.setVisible(false);
                Controller.showStartChoose(startChoosingFrame);
            }

            @Override
            public void menuDeselected(MenuEvent e) {

            }

            @Override
            public void menuCanceled(MenuEvent e) {

            }
        });
        customerOverviewFrame.getjMenu2().addMenuListener(new MenuListener() {
            @Override
            public void menuSelected(MenuEvent e) {
                customerOverviewFrame.setVisible(false);
                Controller.showCustomerCreate(customerCreateFrame, customer);
            }

            @Override
            public void menuDeselected(MenuEvent e) {

            }

            @Override
            public void menuCanceled(MenuEvent e) {

            }
        });
        customerOverviewFrame.getjMenu3().addMenuListener(new MenuListener() {
            @Override
            public void menuSelected(MenuEvent e) {
                customerOverviewFrame.setVisible(false);
                Controller.showCustomerLoan(customerLoanFrame, customer);
            }

            @Override
            public void menuDeselected(MenuEvent e) {

            }

            @Override
            public void menuCanceled(MenuEvent e) {

            }
        });
        customerOverviewFrame.getjMenu4().addMenuListener(new MenuListener() {
            @Override
            public void menuSelected(MenuEvent e) {
                customerOverviewFrame.setVisible(false);
                Controller.showCustomerAction(customerActionFrame, customer);
            }

            @Override
            public void menuDeselected(MenuEvent e) {

            }

            @Override
            public void menuCanceled(MenuEvent e) {

            }
        });
        customerOverviewFrame.getjMenu1().addMenuListener(new MenuListener() {
            @Override
            public void menuSelected(MenuEvent e) {

            }

            @Override
            public void menuDeselected(MenuEvent e) {

            }

            @Override
            public void menuCanceled(MenuEvent e) {

            }
        });
        customerOverviewFrame.getCustomerOverviewPanel1().getTypeComboBox().addActionListener(e ->  Controller.refreshOverviewAccount(customerOverviewFrame, customer));
        customerOverviewFrame.getCustomerOverviewPanel1().getAccountComboBox().addActionListener(e ->  Controller.refreshOverviewAccount(customerOverviewFrame, customer));
        customerOverviewFrame.getCustomerOverviewPanel1().getjButton1().addActionListener(e ->  Controller.refreshOverviewTransaction(customerOverviewFrame, customer));

        //======================================================================
        customerLoanFrame.getjMenu5().addMenuListener(new MenuListener() {
            @Override
            public void menuSelected(MenuEvent e) {
                customerLoanFrame.setVisible(false);
                Controller.showStartChoose(startChoosingFrame);
            }

            @Override
            public void menuDeselected(MenuEvent e) {

            }

            @Override
            public void menuCanceled(MenuEvent e) {

            }
        });
        customerLoanFrame.getjMenu1().addMenuListener(new MenuListener() {
            @Override
            public void menuSelected(MenuEvent e) {
                customerLoanFrame.setVisible(false);
                Controller.showCustomerOverview(customerOverviewFrame, customer);
            }

            @Override
            public void menuDeselected(MenuEvent e) {

            }

            @Override
            public void menuCanceled(MenuEvent e) {

            }
        });
        customerLoanFrame.getjMenu2().addMenuListener(new MenuListener() {
            @Override
            public void menuSelected(MenuEvent e) {
                customerLoanFrame.setVisible(false);
                Controller.showCustomerCreate(customerCreateFrame, customer);
            }

            @Override
            public void menuDeselected(MenuEvent e) {

            }

            @Override
            public void menuCanceled(MenuEvent e) {

            }
        });
        customerLoanFrame.getjMenu4().addMenuListener(new MenuListener() {
            @Override
            public void menuSelected(MenuEvent e) {
                customerLoanFrame.setVisible(false);
                Controller.showCustomerAction(customerActionFrame, customer);
            }

            @Override
            public void menuDeselected(MenuEvent e) {

            }

            @Override
            public void menuCanceled(MenuEvent e) {

            }
        });
        customerLoanFrame.getCustomerLoanPanel1().getCreateButton().addActionListener(e -> Controller.actionLoan(customerLoanFrame, customer));
    }



    public static void main(String[] args) {
        BankSystem bankSystem = new BankSystem();
        Controller.showStartChoose(bankSystem.getStartChoosingFrame());
    }
}
