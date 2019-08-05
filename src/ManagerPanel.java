/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Controller | Templates
 * and open the template in the editor.
 */

import javax.swing.*;

/**
 *
 * @author zhuyu
 */
public class ManagerPanel extends javax.swing.JPanel {

    /**
     * Creates new form ManagerPanel
     */
    public ManagerPanel() {
        initComponents();
    }

    public JToggleButton getAllUserToggleButton() {
        return allUserToggleButton;
    }

    public JButton getBackButton() {
        return backButton;
    }

    public JComboBox getCustomerComboBox() {
        return customerComboBox;
    }

    public JLabel getFilterLabel() {
        return filterLabel;
    }

    public JButton getGenerateButton() {
        return generateButton;
    }

    public JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    public JTextArea getReportTextArea() {
        return reportTextArea;
    }

    public JLabel getResultLabel() {
        return resultLabel;
    }

    public JCheckBox getUpdateCheckBox() {
        return updateCheckBox;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        filterLabel = new javax.swing.JLabel();
        updateCheckBox = new javax.swing.JCheckBox();
        resultLabel = new javax.swing.JLabel();
        generateButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        reportTextArea = new javax.swing.JTextArea();
        customerComboBox = new javax.swing.JComboBox();
        allUserToggleButton = new javax.swing.JToggleButton();
        backButton = new javax.swing.JButton();

        filterLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        filterLabel.setText("Report Filter");

        updateCheckBox.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        updateCheckBox.setText("Only Update Info");
        updateCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateCheckBoxActionPerformed(evt);
            }
        });

        resultLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        resultLabel.setText("Report Result");

        generateButton.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        generateButton.setText("Generate");
        generateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generateButtonActionPerformed(evt);
            }
        });

        reportTextArea.setColumns(20);
        reportTextArea.setRows(5);
        reportTextArea.setEditable(false);
        jScrollPane1.setViewportView(reportTextArea);

        customerComboBox.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        customerComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        allUserToggleButton.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        allUserToggleButton.setText("Show All users info");

        backButton.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addComponent(filterLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(resultLabel)
                .addGap(100, 100, 100))
            .addGroup(layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(customerComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(updateCheckBox)
                    .addComponent(allUserToggleButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 151, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
            .addGroup(layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addComponent(generateButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(backButton)
                .addGap(117, 117, 117))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(filterLabel)
                    .addComponent(resultLabel))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(updateCheckBox)
                        .addGap(67, 67, 67)
                        .addComponent(allUserToggleButton)
                        .addGap(65, 65, 65)
                        .addComponent(customerComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(generateButton)
                    .addComponent(backButton))
                .addGap(90, 90, 90))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void updateCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateCheckBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_updateCheckBoxActionPerformed

    private void generateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generateButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_generateButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_backButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton allUserToggleButton;
    private javax.swing.JButton backButton;
    private javax.swing.JComboBox customerComboBox;
    private javax.swing.JLabel filterLabel;
    private javax.swing.JButton generateButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea reportTextArea;
    private javax.swing.JLabel resultLabel;
    private javax.swing.JCheckBox updateCheckBox;
    // End of variables declaration//GEN-END:variables
}
