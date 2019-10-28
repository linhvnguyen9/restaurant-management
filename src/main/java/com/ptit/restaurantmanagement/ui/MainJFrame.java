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
import com.ptit.restaurantmanagement.domain.model.MenuEntry;
import java.awt.Dimension;
import java.awt.Toolkit;

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
        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width/2 - getWidth() /2 , size.height/2 - getHeight()/2 );
        
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
     DefaultTableModel dtmMenuEntry;
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
     public void addRowMenu(int id, String name, double price){
         MenuEntry menuEntry = new MenuEntry(id, name, price);
         dtmMenuEntry = (DefaultTableModel) TableMenu.getModel();
         
         dtmMenuEntry.addRow(menuEntry.toObjects());
         
     }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        PanelEmployee = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        TableEmployee = new javax.swing.JTable();
        btEmployeeView = new javax.swing.JButton();
        btEmployeeSearch = new javax.swing.JButton();
        btEmployeeAdd = new javax.swing.JButton();
        btEmployeeEdit = new javax.swing.JButton();
        btEmployeeRemove = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        PanelCustomer = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        TableCustomer = new javax.swing.JTable();
        btCustomerAdd = new javax.swing.JButton();
        btCustomerEdit = new javax.swing.JButton();
        btCustomerSearch = new javax.swing.JButton();
        btCustomerRemove = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        PanelInvoice = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        InvoiceTable = new javax.swing.JTable();
        jButton5 = new javax.swing.JButton();
        btInvoicerSearch = new javax.swing.JButton();
        btInvoicerView = new javax.swing.JButton();
        btInvoicerUpdate = new javax.swing.JButton();
        btInvoicerDelete = new javax.swing.JButton();
        btInvoicerViewReport = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        PanelMenu = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableMenu = new javax.swing.JTable();
        btMenuAdd = new javax.swing.JButton();
        btMenuEdit = new javax.swing.JButton();
        btMenuRemove = new javax.swing.JButton();
        btMenuSearch = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

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
        btEmployeeView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEmployeeViewActionPerformed(evt);
            }
        });

        btEmployeeSearch.setText("Search");
        btEmployeeSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEmployeeSearchActionPerformed(evt);
            }
        });

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

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Options");

        javax.swing.GroupLayout PanelEmployeeLayout = new javax.swing.GroupLayout(PanelEmployee);
        PanelEmployee.setLayout(PanelEmployeeLayout);
        PanelEmployeeLayout.setHorizontalGroup(
            PanelEmployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelEmployeeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 590, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelEmployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelEmployeeLayout.createSequentialGroup()
                        .addGroup(PanelEmployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelEmployeeLayout.createSequentialGroup()
                                .addComponent(btEmployeeEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btEmployeeRemove))
                            .addGroup(PanelEmployeeLayout.createSequentialGroup()
                                .addComponent(btEmployeeAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btEmployeeSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(11, 11, 11))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelEmployeeLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(52, 52, 52))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelEmployeeLayout.createSequentialGroup()
                        .addComponent(btEmployeeView, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23))))
        );
        PanelEmployeeLayout.setVerticalGroup(
            PanelEmployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelEmployeeLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(25, 25, 25)
                .addComponent(btEmployeeView)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelEmployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btEmployeeAdd)
                    .addComponent(btEmployeeSearch))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelEmployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btEmployeeEdit)
                    .addComponent(btEmployeeRemove))
                .addGap(280, 280, 280))
            .addGroup(PanelEmployeeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
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
        btCustomerSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCustomerSearchActionPerformed(evt);
            }
        });

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

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Options");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Options");

        javax.swing.GroupLayout PanelCustomerLayout = new javax.swing.GroupLayout(PanelCustomer);
        PanelCustomer.setLayout(PanelCustomerLayout);
        PanelCustomerLayout.setHorizontalGroup(
            PanelCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCustomerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 577, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(PanelCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelCustomerLayout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(jLabel4))
                    .addGroup(PanelCustomerLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(PanelCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelCustomerLayout.createSequentialGroup()
                                .addComponent(btCustomerSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btCustomerRemove))
                            .addGroup(PanelCustomerLayout.createSequentialGroup()
                                .addComponent(btCustomerAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btCustomerEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(24, Short.MAX_VALUE))
            .addGroup(PanelCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(PanelCustomerLayout.createSequentialGroup()
                    .addGap(350, 350, 350)
                    .addComponent(jLabel3)
                    .addContainerGap(350, Short.MAX_VALUE)))
        );
        PanelCustomerLayout.setVerticalGroup(
            PanelCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCustomerLayout.createSequentialGroup()
                .addGroup(PanelCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelCustomerLayout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(PanelCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btCustomerAdd)
                            .addComponent(btCustomerEdit))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(PanelCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btCustomerSearch)
                            .addComponent(btCustomerRemove)))
                    .addGroup(PanelCustomerLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(25, Short.MAX_VALUE))
            .addGroup(PanelCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(PanelCustomerLayout.createSequentialGroup()
                    .addGap(233, 233, 233)
                    .addComponent(jLabel3)
                    .addContainerGap(233, Short.MAX_VALUE)))
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
        btInvoicerSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btInvoicerSearchActionPerformed(evt);
            }
        });

        btInvoicerView.setText("View");

        btInvoicerUpdate.setText("Update");

        btInvoicerDelete.setText("Delete");

        btInvoicerViewReport.setText("View report");
        btInvoicerViewReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btInvoicerViewReportActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Options");

        javax.swing.GroupLayout PanelInvoiceLayout = new javax.swing.GroupLayout(PanelInvoice);
        PanelInvoice.setLayout(PanelInvoiceLayout);
        PanelInvoiceLayout.setHorizontalGroup(
            PanelInvoiceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelInvoiceLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 569, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelInvoiceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelInvoiceLayout.createSequentialGroup()
                        .addGroup(PanelInvoiceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btInvoicerViewReport, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btInvoicerSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(PanelInvoiceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelInvoiceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btInvoicerView, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btInvoicerUpdate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btInvoicerDelete, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelInvoiceLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(61, 61, 61))))
        );
        PanelInvoiceLayout.setVerticalGroup(
            PanelInvoiceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelInvoiceLayout.createSequentialGroup()
                .addGroup(PanelInvoiceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 477, Short.MAX_VALUE)
                    .addGroup(PanelInvoiceLayout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(PanelInvoiceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btInvoicerViewReport)
                            .addComponent(btInvoicerDelete))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelInvoiceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btInvoicerView)
                            .addComponent(jButton5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelInvoiceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btInvoicerSearch)
                            .addComponent(btInvoicerUpdate))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Invoice", PanelInvoice);

        TableMenu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Price"
            }
        ));
        jScrollPane1.setViewportView(TableMenu);

        btMenuAdd.setText("Add menu entry");
        btMenuAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btMenuAddActionPerformed(evt);
            }
        });

        btMenuEdit.setText("Edit");

        btMenuRemove.setText("Remove");
        btMenuRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btMenuRemoveActionPerformed(evt);
            }
        });

        btMenuSearch.setText("Search");
        btMenuSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btMenuSearchActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Options");

        javax.swing.GroupLayout PanelMenuLayout = new javax.swing.GroupLayout(PanelMenu);
        PanelMenu.setLayout(PanelMenuLayout);
        PanelMenuLayout.setHorizontalGroup(
            PanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 515, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelMenuLayout.createSequentialGroup()
                        .addGroup(PanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelMenuLayout.createSequentialGroup()
                                .addComponent(btMenuSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btMenuRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelMenuLayout.createSequentialGroup()
                                .addComponent(btMenuAdd)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btMenuEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelMenuLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(88, 88, 88))))
        );
        PanelMenuLayout.setVerticalGroup(
            PanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelMenuLayout.createSequentialGroup()
                .addGroup(PanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 477, Short.MAX_VALUE)
                    .addGroup(PanelMenuLayout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addGroup(PanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btMenuEdit)
                            .addComponent(btMenuAdd))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btMenuRemove)
                            .addComponent(btMenuSearch))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
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
           int row = TableEmployee.getSelectedRow();
        dtmEmployee.removeRow(row);
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

    private void btEmployeeViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEmployeeViewActionPerformed
//        int row = TableEmployee.getSelectedRow();

        //TODO: Get the selected row number
        //TODO: Get the selected Employee from EmployeeRepository
        //TODO: Pass the Employee object to the dialog

//        EmployeeViewTimeTableDialog dialog = new EmployeeViewTimeTableDialog(this, true, selectedEmployee);
        EmployeeViewTimeTableDialog dialog = new EmployeeViewTimeTableDialog(this, true);
        dialog.setVisible(true);
    }//GEN-LAST:event_btEmployeeViewActionPerformed
  
    private void btEmployeeRemoveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btEmployeeRemoveMouseClicked
     
        
        // TODO add your handling code here:
    }//GEN-LAST:event_btEmployeeRemoveMouseClicked

    private void btCustomerAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCustomerAddActionPerformed
        CustomerAddDialog customerAddDialog = new CustomerAddDialog(this, true);
        customerAddDialog.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_btCustomerAddActionPerformed

    private void btCustomerRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCustomerRemoveActionPerformed
          int row = TableCustomer.getSelectedRow();
            dtmCustomer.removeRow(row);
        
        // TODO add your handling code here:
    }//GEN-LAST:event_btCustomerRemoveActionPerformed

    private void btCustomerRemoveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btCustomerRemoveMouseClicked
      
        //TODO: Delete customer entry in database
    }//GEN-LAST:event_btCustomerRemoveMouseClicked

    private void btEmployeeSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEmployeeSearchActionPerformed
        CustomerSearchDialog dialog = new CustomerSearchDialog(this, true);
        dialog.setVisible(true);
    }//GEN-LAST:event_btEmployeeSearchActionPerformed

    private void btCustomerSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCustomerSearchActionPerformed
        CustomerSearchDialog dialog = new CustomerSearchDialog(this, true);
        dialog.setVisible(true);
    }//GEN-LAST:event_btCustomerSearchActionPerformed

    private void btMenuSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btMenuSearchActionPerformed
        MenuSearchDialog dialog = new MenuSearchDialog(this, true);
        dialog.setVisible(true);
    }//GEN-LAST:event_btMenuSearchActionPerformed

    private void btInvoicerSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btInvoicerSearchActionPerformed
        InvoiceSearchDialog dialog = new InvoiceSearchDialog(this, true);
        dialog.setVisible(true);
    }//GEN-LAST:event_btInvoicerSearchActionPerformed

    private void btMenuAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btMenuAddActionPerformed
        MenuAddDialog menuAddDialog = new MenuAddDialog(this,true);
      
        menuAddDialog.setVisible(true);
        
        // TODO add your handling code here:
    }//GEN-LAST:event_btMenuAddActionPerformed

    private void btMenuRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btMenuRemoveActionPerformed
          int row = TableMenu.getSelectedRow();
          
          dtmMenuEntry.removeRow(row);
          
          
    }//GEN-LAST:event_btMenuRemoveActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable InvoiceTable;
    private javax.swing.JPanel PanelCustomer;
    private javax.swing.JPanel PanelEmployee;
    private javax.swing.JPanel PanelInvoice;
    private javax.swing.JPanel PanelMenu;
    private javax.swing.JTable TableCustomer;
    public javax.swing.JTable TableEmployee;
    private javax.swing.JTable TableMenu;
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
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
}
