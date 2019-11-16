/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ptit.restaurantmanagement.ui;

import com.ptit.restaurantmanagement.dao.CustomerDao;
import com.ptit.restaurantmanagement.domain.model.*;
import com.ptit.restaurantmanagement.dao.EmployeesDao;
import com.ptit.restaurantmanagement.dao.InvoiceDao;
import com.ptit.restaurantmanagement.dao.MenuEntryDao;
import com.ptit.restaurantmanagement.domain.model.Customer;
import com.ptit.restaurantmanagement.domain.model.CustomerType;
import com.ptit.restaurantmanagement.domain.model.Employee;
import com.ptit.restaurantmanagement.domain.model.EmployeeType;
import com.ptit.restaurantmanagement.domain.model.MenuEntry;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.SQLException;

import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;

/**
 * @author Viet
 */
public class MainJFrame extends javax.swing.JFrame {

    DefaultTableModel dtmEmployee;
    DefaultTableModel dtmCustomer;
    DefaultTableModel dtmMenuEntry;
    DefaultTableModel dtmInvoice;

    public MainJFrame() {
        initComponents();
        
        
       dataEmployee();
       dataCustomer();
       dataMenuEntry();
       dataInvoice();

        // set middle screen middle
        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width/2 - getWidth() /2 , size.height/2 - getHeight()/2 );
        
    }
    public void dataEmployee(){
         dtmEmployee = (DefaultTableModel) TableEmployee.getModel();
          EmployeesDao employeesDao;
        try {
            employeesDao = new EmployeesDao();
            
            for (Employee e : employeesDao.getListEmployee()) {
                dtmEmployee.addRow(e.toObject());
            }
                   
        } catch (SQLException ex) {
            Logger.getLogger(MainJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void dataCustomer(){
         dtmCustomer = (DefaultTableModel) TableCustomer.getModel();
         CustomerDao customerDao;
            
        try {
            customerDao = new CustomerDao();
            
            for (Customer c : customerDao.getListCustomer()) {
                dtmCustomer.addRow(c.toObjects());
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(MainJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void dataMenuEntry(){
        dtmMenuEntry = (DefaultTableModel) TableMenu.getModel();
        MenuEntryDao menuEntryDao;
        
        
        try {
            menuEntryDao = new MenuEntryDao();
            
            for(MenuEntry m : menuEntryDao.getListMenuEntry()){
                dtmMenuEntry.addRow(m.toObjects());
            }
        } catch (SQLException ex) {
            Logger.getLogger(MainJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void dataInvoice(){
        dtmInvoice =(DefaultTableModel) TableInvoice.getModel();
        InvoiceDao invoiceDao;
        
        try {
            invoiceDao = new InvoiceDao();
            for (Invoice i : invoiceDao.getInvoices()) {
                dtmMenuEntry.addRow(i.toObjects());
            }
        } catch (SQLException ex) {
            Logger.getLogger(MainJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
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
     
    public void addRowEmployee(String name, String DOB, String address, String employeeTypeString,
                               String phone, Integer managerId, double baseSalary) throws SQLException {
        Date dobDate;
        Calendar calendar = Calendar.getInstance();
        try {
            dobDate = new SimpleDateFormat("dd-MM-yyyy").parse(DOB);
            calendar.setTime(dobDate);
        } catch (ParseException ex) {
            Logger.getLogger(MainJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        EmployeeType employeeType = EmployeeType.valueOf(employeeTypeString.toUpperCase());

        Employee employee = new Employee(name, calendar, address, phone, employeeType, managerId, baseSalary);
        EmployeesDao employeesDao = new EmployeesDao();
        int id = employeesDao.insertEmployee(employee);
        employee.setId(id);
        
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
       
        Customer customer = new Customer(name, calendar, address, phone, customerType);
       
       
        try {
            CustomerDao customerDao = new CustomerDao();
            int id = customerDao.insertCustomer(customer);
             customer.setId(id);
        } catch (SQLException ex) {
            Logger.getLogger(MainJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        dtmCustomer = (DefaultTableModel) TableCustomer.getModel();
        dtmCustomer.addRow(customer.toObjects());
        
        
       
    }
     public void addRowMenu(String name, double price){
         MenuEntry menuEntry = new MenuEntry(name, price);
       
         
        try {
            MenuEntryDao menuEntryDao = new MenuEntryDao();
            int id = menuEntryDao.insertMenuEntry(menuEntry);
            menuEntry.setEntryId(id);
        } catch (SQLException ex) {
            Logger.getLogger(MainJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
          dtmMenuEntry = (DefaultTableModel) TableMenu.getModel();
         
         dtmMenuEntry.addRow(menuEntry.toObjects());
         
     }
     
     public void addInvoice(){
        
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
        jLabel5 = new javax.swing.JLabel();
        jTextFieldSearchEmployee = new javax.swing.JTextField();
        PanelCustomer = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        TableCustomer = new javax.swing.JTable();
        btCustomerAdd = new javax.swing.JButton();
        btCustomerEdit = new javax.swing.JButton();
        btCustomerSearch = new javax.swing.JButton();
        btCustomerRemove = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        TextFieldCustomerSearch = new javax.swing.JTextField();
        PanelInvoice = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TableInvoice = new javax.swing.JTable();
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
        jLabel8 = new javax.swing.JLabel();
        TextFieldSearchMenu = new javax.swing.JTextField();

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

        jLabel5.setText("Search by name:");

        jTextFieldSearchEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldSearchEmployeeActionPerformed(evt);
            }
        });
        jTextFieldSearchEmployee.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldSearchEmployeeKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout PanelEmployeeLayout = new javax.swing.GroupLayout(PanelEmployee);
        PanelEmployee.setLayout(PanelEmployeeLayout);
        PanelEmployeeLayout.setHorizontalGroup(
            PanelEmployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelEmployeeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 586, Short.MAX_VALUE)
                .addGap(18, 18, 18)
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
            .addGroup(PanelEmployeeLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldSearchEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelEmployeeLayout.setVerticalGroup(
            PanelEmployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelEmployeeLayout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
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
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(PanelEmployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextFieldSearchEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
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
        btCustomerEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCustomerEditActionPerformed(evt);
            }
        });

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

        jLabel7.setText("Search:");

        TextFieldCustomerSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TextFieldCustomerSearchKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout PanelCustomerLayout = new javax.swing.GroupLayout(PanelCustomer);
        PanelCustomer.setLayout(PanelCustomerLayout);
        PanelCustomerLayout.setHorizontalGroup(
            PanelCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCustomerLayout.createSequentialGroup()
                .addGroup(PanelCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelCustomerLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 577, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(PanelCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelCustomerLayout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(btCustomerSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btCustomerRemove))
                            .addGroup(PanelCustomerLayout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(btCustomerAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btCustomerEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PanelCustomerLayout.createSequentialGroup()
                                .addGap(59, 59, 59)
                                .addComponent(jLabel4))))
                    .addGroup(PanelCustomerLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TextFieldCustomerSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(14, Short.MAX_VALUE))
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
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(PanelCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(TextFieldCustomerSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
            .addGroup(PanelCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(PanelCustomerLayout.createSequentialGroup()
                    .addGap(233, 233, 233)
                    .addComponent(jLabel3)
                    .addContainerGap(215, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Customer", PanelCustomer);

        TableInvoice.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Invoice", "Customer ID", "Employee ID", "Time", "Total price"
            }
        ));
        jScrollPane2.setViewportView(TableInvoice);

        jButton5.setText("Add");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

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
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 464, Short.MAX_VALUE)
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
        btMenuEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btMenuEditActionPerformed(evt);
            }
        });

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

        jLabel8.setText("Search:");

        TextFieldSearchMenu.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TextFieldSearchMenuKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout PanelMenuLayout = new javax.swing.GroupLayout(PanelMenu);
        PanelMenu.setLayout(PanelMenuLayout);
        PanelMenuLayout.setHorizontalGroup(
            PanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 516, Short.MAX_VALUE)
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
            .addGroup(PanelMenuLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(TextFieldSearchMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        PanelMenuLayout.setVerticalGroup(
            PanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                .addContainerGap(315, Short.MAX_VALUE))
            .addGroup(PanelMenuLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(TextFieldSearchMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
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
        int id = Integer.parseInt(TableEmployee.getValueAt(row,0).toString());
        
        dtmEmployee.removeRow(row);
        
           try {
            EmployeesDao employeesDao = new EmployeesDao();
            employeesDao.deleteEmployee(id);
            
        } catch (SQLException ex) {
            Logger.getLogger(MainJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
          
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
        
 
    }//GEN-LAST:event_btCustomerAddActionPerformed

    private void btCustomerRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCustomerRemoveActionPerformed
        int row = TableCustomer.getSelectedRow();
        int id = Integer.parseInt(TableCustomer.getValueAt(row,0).toString()); 
        dtmCustomer.removeRow(row);
        
           try {
            CustomerDao customerDao = new CustomerDao();
            customerDao.deleteCustomer(id);
            
        } catch (SQLException ex) {
            Logger.getLogger(MainJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
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
          int id = Integer.parseInt(TableMenu.getValueAt(row,0).toString()); 
        dtmMenuEntry.removeRow(row);
        
           try {
            MenuEntryDao menuEntryDao = new MenuEntryDao();
            menuEntryDao.deleteMenuEntry(id);
            
        } catch (SQLException ex) {
            Logger.getLogger(MainJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
          
          
    }//GEN-LAST:event_btMenuRemoveActionPerformed

    private void btCustomerEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCustomerEditActionPerformed
        CustomerAddDialog customerAddDialog = new CustomerAddDialog(this, true);
        customerAddDialog.setVisible(true);
        
        // TODO add your handling code here:
    }//GEN-LAST:event_btCustomerEditActionPerformed

    private void btMenuEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btMenuEditActionPerformed
        MenuAddDialog menuAddDialog = new  MenuAddDialog(this,true);
        menuAddDialog.setVisible(true);
   
    }//GEN-LAST:event_btMenuEditActionPerformed
     public void filterEmployee(String querry){
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(dtmEmployee);
        TableEmployee.setRowSorter(tr);
        
        tr.setRowFilter(RowFilter.regexFilter(querry));
    }
    private void jTextFieldSearchEmployeeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldSearchEmployeeKeyReleased
        String query = jTextFieldSearchEmployee.getText().toLowerCase();
        filterEmployee(query);
    }//GEN-LAST:event_jTextFieldSearchEmployeeKeyReleased

    private void jTextFieldSearchEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldSearchEmployeeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldSearchEmployeeActionPerformed
      public void filterCustomer(String querry){
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(dtmCustomer);
        TableCustomer.setRowSorter(tr);
        
        tr.setRowFilter(RowFilter.regexFilter(querry));
    }
    private void TextFieldCustomerSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TextFieldCustomerSearchKeyReleased
         String query = TextFieldCustomerSearch.getText().toLowerCase();
        filterCustomer(query);
    }//GEN-LAST:event_TextFieldCustomerSearchKeyReleased
     public void filterMenuEntry(String querry){
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(dtmMenuEntry);
        TableMenu.setRowSorter(tr);
        
        tr.setRowFilter(RowFilter.regexFilter(querry));
    }
    private void TextFieldSearchMenuKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TextFieldSearchMenuKeyReleased
         String query = TextFieldSearchMenu.getText().toLowerCase();
         filterMenuEntry(query);
    }//GEN-LAST:event_TextFieldSearchMenuKeyReleased

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
      InvoiceAddDialog invoiceAddDialog = new InvoiceAddDialog(this, true);
      invoiceAddDialog.setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelCustomer;
    private javax.swing.JPanel PanelEmployee;
    private javax.swing.JPanel PanelInvoice;
    private javax.swing.JPanel PanelMenu;
    public javax.swing.JTable TableCustomer;
    public javax.swing.JTable TableEmployee;
    public javax.swing.JTable TableInvoice;
    public javax.swing.JTable TableMenu;
    private javax.swing.JTextField TextFieldCustomerSearch;
    private javax.swing.JTextField TextFieldSearchMenu;
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
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextFieldSearchEmployee;
    // End of variables declaration//GEN-END:variables
}
