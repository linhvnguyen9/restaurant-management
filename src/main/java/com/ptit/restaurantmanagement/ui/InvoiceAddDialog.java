/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ptit.restaurantmanagement.ui;

import com.ptit.restaurantmanagement.dao.InvoiceDao;
import com.ptit.restaurantmanagement.dao.LineDao;
import com.ptit.restaurantmanagement.dao.MenuEntryDao;
import com.ptit.restaurantmanagement.domain.model.Invoice;
import com.ptit.restaurantmanagement.domain.model.Line;
import com.ptit.restaurantmanagement.domain.model.MenuEntry;

import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Viet
 */
public class InvoiceAddDialog extends javax.swing.JDialog {

    private Invoice invoice = null;

    MainJFrame mainJFrame;
    DefaultTableModel dtmInvoiceMenu;

    public InvoiceAddDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        mainJFrame = (MainJFrame) parent;
        initComponents();
        // set middle screen middle
        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width / 2 - getWidth() / 2, size.height / 2 - getHeight() / 2);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        TextFieldInvoiceCustomerID = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        TextFieldInvoiceEmployeeID = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableInvoiceMenu = new javax.swing.JTable();
        btInvoiceCreate = new javax.swing.JButton();
        btAddInvoice = new javax.swing.JButton();
        btEditInvoice = new javax.swing.JButton();
        btDeleteInvoice = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        TextFieldQuantity = new javax.swing.JTextField();
        TextFieldIDMenuEntry = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Customer ID:");

        jLabel2.setText("Employee ID:");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Menu");

        TableInvoiceMenu.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{

                },
                new String[]{
                        "ID", "Name", "Price", "Quantity"
                }
        ));
        TableInvoiceMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableInvoiceMenuMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TableInvoiceMenu);

        btInvoiceCreate.setText("Create Invoice");

        btAddInvoice.setText("Add");
        btAddInvoice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAddInvoiceActionPerformed(evt);
            }
        });

        btEditInvoice.setText("Edit");

        btDeleteInvoice.setText("Delete");

        jLabel4.setText("ID Menu Entry: ");

        jLabel5.setText("Quantity:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btInvoiceCreate)
                                .addGap(207, 207, 207))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(18, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(18, 18, 18)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addComponent(btAddInvoice)
                                                                                .addGap(18, 18, 18)
                                                                                .addComponent(btEditInvoice))
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addGap(28, 28, 28)
                                                                                .addComponent(jLabel5))
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addGap(21, 21, 21)
                                                                                .addComponent(jLabel4))
                                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                .addComponent(TextFieldIDMenuEntry, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(TextFieldQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(47, 47, 47)
                                                                .addComponent(btDeleteInvoice)))))
                                .addGap(26, 26, 26))
                        .addGroup(layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(jLabel1)
                                .addGap(22, 22, 22)
                                .addComponent(TextFieldInvoiceCustomerID, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(TextFieldInvoiceEmployeeID, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(TextFieldInvoiceCustomerID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2)
                                        .addComponent(TextFieldInvoiceEmployeeID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(69, 69, 69)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel4)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(TextFieldIDMenuEntry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                                                .addComponent(jLabel5)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(TextFieldQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(27, 27, 27)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(btAddInvoice)
                                                        .addComponent(btEditInvoice))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btDeleteInvoice)
                                                .addGap(82, 82, 82))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                                .addComponent(btInvoiceCreate)
                                .addGap(15, 15, 15))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TableInvoiceMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableInvoiceMenuMouseClicked
        dtmInvoiceMenu = (DefaultTableModel) TableInvoiceMenu.getModel();
        int row = TableInvoiceMenu.getSelectedRow();
        int quantity = Integer.parseInt(TableInvoiceMenu.getValueAt(row, 3).toString());
        int idMenuEntry = Integer.parseInt(TableInvoiceMenu.getValueAt(row, 0).toString());
        TextFieldIDMenuEntry.setText(String.valueOf(idMenuEntry));
        TextFieldQuantity.setText(String.valueOf(quantity));
    }//GEN-LAST:event_TableInvoiceMenuMouseClicked

    private void btAddInvoiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAddInvoiceActionPerformed
        dtmInvoiceMenu = (DefaultTableModel) TableInvoiceMenu.getModel();

        int customerID = Integer.parseInt(TextFieldInvoiceCustomerID.getText());
        int employeeID = Integer.parseInt(TextFieldInvoiceEmployeeID.getText());
        int IDMenuEntry = Integer.parseInt(TextFieldIDMenuEntry.getText());
        int quantity = Integer.parseInt(TextFieldQuantity.getText());

        int invoiceId = 0;

        if (this.invoice == null) {
            System.out.println("customerId" + customerID);
            System.out.println("employeeID" + employeeID);
            Invoice newInvoice = new Invoice(customerID, employeeID, Calendar.getInstance());
            this.invoice = newInvoice;

            try {
                InvoiceDao invoiceDao = new InvoiceDao();
                invoiceId = invoiceDao.insertInvoice(newInvoice);
                this.invoice.setInvoiceId(invoiceId);
            } catch (SQLException ex) {
                Logger.getLogger(InvoiceAddDialog.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            invoiceId = this.invoice.getInvoiceId();
        }

        MenuEntryDao menuEntryDao;
        MenuEntry menuEntry = null;
        try {
            menuEntryDao = new MenuEntryDao();
            menuEntry = menuEntryDao.searchListMenuEntry(IDMenuEntry);
        } catch (SQLException ex) {
            Logger.getLogger(InvoiceAddDialog.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println(invoiceId);

        Line line = new Line(invoiceId, menuEntry.getEntryId(), quantity);
        LineDao lineDao;

        try {
            lineDao = new LineDao();
            lineDao.insertLine(line);
            dtmInvoiceMenu.addRow(new Object[]{
                    menuEntry.getEntryId(), menuEntry.getName(), menuEntry.getPrice(), line.getQuantity()
            });
        } catch (SQLException ex) {
            Logger.getLogger(InvoiceAddDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btAddInvoiceActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(InvoiceAddDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InvoiceAddDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InvoiceAddDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InvoiceAddDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                InvoiceAddDialog dialog = new InvoiceAddDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TableInvoiceMenu;
    private javax.swing.JTextField TextFieldIDMenuEntry;
    private javax.swing.JTextField TextFieldInvoiceCustomerID;
    private javax.swing.JTextField TextFieldInvoiceEmployeeID;
    private javax.swing.JTextField TextFieldQuantity;
    private javax.swing.JButton btAddInvoice;
    private javax.swing.JButton btDeleteInvoice;
    private javax.swing.JButton btEditInvoice;
    private javax.swing.JButton btInvoiceCreate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
