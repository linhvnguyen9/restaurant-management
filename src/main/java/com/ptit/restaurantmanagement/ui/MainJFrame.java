/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ptit.restaurantmanagement.ui;

import com.ptit.restaurantmanagement.domain.model.Customer;
import com.ptit.restaurantmanagement.domain.model.CustomerType;
import com.ptit.restaurantmanagement.domain.model.Employee;
import com.ptit.restaurantmanagement.domain.model.EmployeeType;

import javax.swing.table.DefaultTableModel;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Viet
 */
public class MainJFrame extends javax.swing.JFrame {


    public MainJFrame() {
        initComponents();
    }


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainJFrame().setVisible(true);
            }
        });
    }
     DefaultTableModel dtmEmployee;
     DefaultTableModel dtmCustomer;
    public void addRowEmployee(String name, String DOB, String address, String employeeTypeString,
                               String phone, Integer managerId, double baseSalary) {
        Date dobDate;
        Calendar calendar = Calendar.getInstance();
        try {
            dobDate = new SimpleDateFormat("dd-MM-yyyy").parse(DOB);
            calendar.setTime(dobDate);
        } catch (ParseException ex) {
            Logger.getLogger(MainJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

        EmployeeType employeeType = EmployeeType.valueOf(employeeTypeString.toUpperCase());

        Employee employee = new Employee(name, calendar, address, employeeType, managerId, baseSalary);
        employee.addPhoneNumber(phone);

       
       
        dtmEmployee = (DefaultTableModel) TableEmployee.getModel();
        dtmEmployee.addRow(employee.toObject());
    }
    
     public void addRowCustomer(String name, String DOB, String address, 
                                String customerTypeString,String phone) {
        Date dobDate;
        Calendar calendar = Calendar.getInstance();
        try {
            dobDate = new SimpleDateFormat("dd-MM-yyyy").parse(DOB);
            calendar.setTime(dobDate);
        } catch (ParseException ex) {
            Logger.getLogger(MainJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        CustomerType customerType = CustomerType.valueOf(customerTypeString.toUpperCase());
         Customer customer = new Customer(name, calendar, address, customerType);

        customer.addPhoneNumber(phone);

       
        
        dtmCustomer = (DefaultTableModel) TableCustomer.getModel();
        dtmCustomer.addRow(customer.toObjects());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        PanelEmployee = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        TableEmployee = new javax.swing.JTable();
        btEmployeeView = new javax.swing.JButton();
        btEmployeeSearch = new javax.swing.JButton();
        btEmployeeAdd = new javax.swing.JButton();
        btEmployeeEdit = new javax.swing.JButton();
        btEmployeeRemove = new javax.swing.JButton();
        PanelCustomer = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        TableCustomer = new javax.swing.JTable();
        btCustomerAdd = new javax.swing.JButton();
        btCustomerEdit = new javax.swing.JButton();
        btCustomerSearch = new javax.swing.JButton();
        btCustomerRemove = new javax.swing.JButton();
        PanelInvoice = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        InvoiceTable = new javax.swing.JTable();
        jButton5 = new javax.swing.JButton();
        btInvoicerSearch = new javax.swing.JButton();
        btInvoicerView = new javax.swing.JButton();
        btInvoicerUpdate = new javax.swing.JButton();
        btInvoicerDelete = new javax.swing.JButton();
        btInvoicerViewReport = new javax.swing.JButton();
        PanelMenu = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        MenuTable = new javax.swing.JTable();
        btMenuAdd = new javax.swing.JButton();
        btMenuEdit = new javax.swing.JButton();
        btMenuRemove = new javax.swing.JButton();
        btMenuSearch = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        TableEmployee.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "DOB", "Address", "Type", "Phone number", "Manager ID", "Salary"
            }
        ));
        jScrollPane4.setViewportView(TableEmployee);

        btEmployeeView.setText("View time table");

        btEmployeeSearch.setText("Search");

        btEmployeeAdd.setText("Add");
        btEmployeeAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEmployeeAddActionPerformed(evt);
            }
        });

        btEmployeeEdit.setText("Edit");
        btEmployeeEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEmployeeEditActionPerformed(evt);
            }
        });

        btEmployeeRemove.setText("Remove");
        btEmployeeRemove.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btEmployeeRemoveMouseClicked(evt);
            }
        });
        btEmployeeRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEmployeeRemoveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelEmployeeLayout = new javax.swing.GroupLayout(PanelEmployee);
        PanelEmployee.setLayout(PanelEmployeeLayout);
        PanelEmployeeLayout.setHorizontalGroup(
            PanelEmployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelEmployeeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 543, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(PanelEmployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelEmployeeLayout.createSequentialGroup()
                        .addComponent(btEmployeeView, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelEmployeeLayout.createSequentialGroup()
                        .addGroup(PanelEmployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btEmployeeSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btEmployeeAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btEmployeeEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btEmployeeRemove))
                        .addGap(61, 61, 61))))
        );
        PanelEmployeeLayout.setVerticalGroup(
            PanelEmployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelEmployeeLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btEmployeeView)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btEmployeeAdd)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btEmployeeSearch)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btEmployeeEdit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btEmployeeRemove)
                .addGap(184, 184, 184))
            .addGroup(PanelEmployeeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(58, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Employee", PanelEmployee);

        TableCustomer.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Type", "DOB", "Address", "Phone number"
            }
        ));
        jScrollPane3.setViewportView(TableCustomer);

        btCustomerAdd.setText("Add");
        btCustomerAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCustomerAddActionPerformed(evt);
            }
        });

        btCustomerEdit.setText("Edit");

        btCustomerSearch.setText("Search");

        btCustomerRemove.setText("Remove");
        btCustomerRemove.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btCustomerRemoveMouseClicked(evt);
            }
        });
        btCustomerRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCustomerRemoveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelCustomerLayout = new javax.swing.GroupLayout(PanelCustomer);
        PanelCustomer.setLayout(PanelCustomerLayout);
        PanelCustomerLayout.setHorizontalGroup(
            PanelCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelCustomerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btCustomerEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PanelCustomerLayout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 523, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(PanelCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelCustomerLayout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addComponent(btCustomerAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelCustomerLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(PanelCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btCustomerSearch, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btCustomerRemove, javax.swing.GroupLayout.Alignment.TRAILING))))))
                .addGap(80, 80, 80))
        );
        PanelCustomerLayout.setVerticalGroup(
            PanelCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCustomerLayout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 80, Short.MAX_VALUE))
            .addGroup(PanelCustomerLayout.createSequentialGroup()
                .addGap(140, 140, 140)
                .addComponent(btCustomerAdd)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btCustomerEdit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btCustomerSearch)
                .addGap(18, 18, 18)
                .addComponent(btCustomerRemove)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Customer", PanelCustomer);

        InvoiceTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Invoice", "Customer ID", "Employee ID", "Time", "Total price"
            }
        ));
        jScrollPane2.setViewportView(InvoiceTable);

        jButton5.setText("Add");

        btInvoicerSearch.setText("Search");

        btInvoicerView.setText("View");

        btInvoicerUpdate.setText("Update");

        btInvoicerDelete.setText("Delete");

        btInvoicerViewReport.setText("View report");
        btInvoicerViewReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btInvoicerViewReportActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelInvoiceLayout = new javax.swing.GroupLayout(PanelInvoice);
        PanelInvoice.setLayout(PanelInvoiceLayout);
        PanelInvoiceLayout.setHorizontalGroup(
            PanelInvoiceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelInvoiceLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(PanelInvoiceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelInvoiceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btInvoicerView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btInvoicerSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btInvoicerUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                        .addComponent(btInvoicerDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(btInvoicerViewReport))
                .addContainerGap(248, Short.MAX_VALUE))
        );
        PanelInvoiceLayout.setVerticalGroup(
            PanelInvoiceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelInvoiceLayout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 477, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(PanelInvoiceLayout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(btInvoicerView)
                .addGap(18, 18, 18)
                .addComponent(jButton5)
                .addGap(18, 18, 18)
                .addComponent(btInvoicerSearch)
                .addGap(18, 18, 18)
                .addComponent(btInvoicerUpdate)
                .addGap(18, 18, 18)
                .addComponent(btInvoicerDelete)
                .addGap(18, 18, 18)
                .addComponent(btInvoicerViewReport)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Invoice", PanelInvoice);

        MenuTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Price"
            }
        ));
        jScrollPane1.setViewportView(MenuTable);

        btMenuAdd.setText("Add menu entry");

        btMenuEdit.setText("Edit");

        btMenuRemove.setText("Remove");

        btMenuSearch.setText("Search");

        javax.swing.GroupLayout PanelMenuLayout = new javax.swing.GroupLayout(PanelMenu);
        PanelMenu.setLayout(PanelMenuLayout);
        PanelMenuLayout.setHorizontalGroup(
            PanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(PanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btMenuAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btMenuEdit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btMenuRemove, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btMenuSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(247, Short.MAX_VALUE))
        );
        PanelMenuLayout.setVerticalGroup(
            PanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelMenuLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 477, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(PanelMenuLayout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(btMenuAdd)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btMenuEdit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btMenuRemove)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btMenuSearch)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Menu", PanelMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btEmployeeEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEmployeeEditActionPerformed
      EmployeeAddDialog employeeAddDialog = new EmployeeAddDialog(this, true);
      employeeAddDialog.setVisible(true);
      
      
    }//GEN-LAST:event_btEmployeeEditActionPerformed

    private void btEmployeeRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEmployeeRemoveActionPerformed
        
        // TODO add your handling code here:
    }//GEN-LAST:event_btEmployeeRemoveActionPerformed

    private void btInvoicerViewReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btInvoicerViewReportActionPerformed
        //

// TODO add your handling code here:
    }//GEN-LAST:event_btInvoicerViewReportActionPerformed

    private void btEmployeeAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEmployeeAddActionPerformed
        EmployeeAddDialog employeeAddDialog = new EmployeeAddDialog(this, true);
        employeeAddDialog.setVisible(true);

    }//GEN-LAST:event_btEmployeeAddActionPerformed

    private void btEmployeeRemoveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btEmployeeRemoveMouseClicked
        int row = TableEmployee.getSelectedRow();
        dtmEmployee.removeRow(row);
        
        // TODO add your handling code here:
    }//GEN-LAST:event_btEmployeeRemoveMouseClicked

    private void btCustomerAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCustomerAddActionPerformed
        CustomerAddDialog customerAddDialog = new CustomerAddDialog(this, true);
        customerAddDialog.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_btCustomerAddActionPerformed

    private void btCustomerRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCustomerRemoveActionPerformed
        
        
        // TODO add your handling code here:
    }//GEN-LAST:event_btCustomerRemoveActionPerformed

    private void btCustomerRemoveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btCustomerRemoveMouseClicked
        int row = TableCustomer.getSelectedRow();
        dtmCustomer.removeRow(row);
        // TODO add your handling code here:
    }//GEN-LAST:event_btCustomerRemoveMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable InvoiceTable;
    private javax.swing.JTable MenuTable;
    private javax.swing.JPanel PanelCustomer;
    private javax.swing.JPanel PanelEmployee;
    private javax.swing.JPanel PanelInvoice;
    private javax.swing.JPanel PanelMenu;
    private javax.swing.JTable TableCustomer;
    private javax.swing.JTable TableEmployee;
    private javax.swing.JButton btCustomerAdd;
    private javax.swing.JButton btCustomerEdit;
    private javax.swing.JButton btCustomerRemove;
    private javax.swing.JButton btCustomerSearch;
    private javax.swing.JButton btEmployeeAdd;
    private javax.swing.JButton btEmployeeEdit;
    private javax.swing.JButton btEmployeeRemove;
    private javax.swing.JButton btEmployeeSearch;
    private javax.swing.JButton btEmployeeView;
    private javax.swing.JButton btInvoicerDelete;
    private javax.swing.JButton btInvoicerSearch;
    private javax.swing.JButton btInvoicerUpdate;
    private javax.swing.JButton btInvoicerView;
    private javax.swing.JButton btInvoicerViewReport;
    private javax.swing.JButton btMenuAdd;
    private javax.swing.JButton btMenuEdit;
    private javax.swing.JButton btMenuRemove;
    private javax.swing.JButton btMenuSearch;
    private javax.swing.JButton jButton5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
}
