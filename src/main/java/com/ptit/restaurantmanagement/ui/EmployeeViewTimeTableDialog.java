/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ptit.restaurantmanagement.ui;

import com.ptit.restaurantmanagement.domain.model.Employee;

/**
 *
 * @author Viet
 */
public class EmployeeViewTimeTableDialog extends javax.swing.JDialog {

    Employee currentEmployee;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonEmployeeViewTimeTableAddEntry;
    private javax.swing.JButton ButtonEmployeeViewTimeTableDeleteEntry;
    private javax.swing.JButton ButtonEmployeeViewTimeTableEditEntry;
    private javax.swing.JLabel LabelEmployeeViewTimeTableEmployeeId;
    private javax.swing.JLabel LabelEmployeeViewTimeTableEmployeeName;
    private javax.swing.JLabel LabelEmployeeViewTimeTableId;
    private javax.swing.JLabel LabelEmployeeViewTimeTableName;
    private javax.swing.JLabel LabelEmployeeViewTimeTableTitle;
    private javax.swing.JTable TableEmployeeTimeTable;
    private javax.swing.JScrollPane jScrollPane1;

    public EmployeeViewTimeTableDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    public EmployeeViewTimeTableDialog(java.awt.Frame parent, boolean modal, Employee employee) {
        super(parent, modal);
        initComponents();
        currentEmployee = employee;
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
            java.util.logging.Logger.getLogger(EmployeeViewTimeTableDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EmployeeViewTimeTableDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EmployeeViewTimeTableDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EmployeeViewTimeTableDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                EmployeeViewTimeTableDialog dialog = new EmployeeViewTimeTableDialog(new javax.swing.JFrame(), true);
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TableEmployeeTimeTable = new javax.swing.JTable();
        LabelEmployeeViewTimeTableTitle = new javax.swing.JLabel();
        LabelEmployeeViewTimeTableId = new javax.swing.JLabel();
        LabelEmployeeViewTimeTableName = new javax.swing.JLabel();
        LabelEmployeeViewTimeTableEmployeeId = new javax.swing.JLabel();
        LabelEmployeeViewTimeTableEmployeeName = new javax.swing.JLabel();
        ButtonEmployeeViewTimeTableAddEntry = new javax.swing.JButton();
        ButtonEmployeeViewTimeTableEditEntry = new javax.swing.JButton();
        ButtonEmployeeViewTimeTableDeleteEntry = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        TableEmployeeTimeTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{

                },
                new String[]{
                        "Month", "Year", "Workdays", "Salary"
                }
        ) {
            boolean[] canEdit = new boolean[]{
                    true, true, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        jScrollPane1.setViewportView(TableEmployeeTimeTable);

        LabelEmployeeViewTimeTableTitle.setText("Timesheet for Employee: ");

        LabelEmployeeViewTimeTableId.setText("ID: ");

        LabelEmployeeViewTimeTableName.setText("Name:");

        LabelEmployeeViewTimeTableEmployeeId.setText("jLabel4");

        LabelEmployeeViewTimeTableEmployeeName.setText("jLabel5");

        ButtonEmployeeViewTimeTableAddEntry.setText("Add");

        ButtonEmployeeViewTimeTableEditEntry.setText("Edit");

        ButtonEmployeeViewTimeTableDeleteEntry.setText("Delete");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                            .addComponent(LabelEmployeeViewTimeTableId)
                                            .addGap(18, 18, 18)
                                            .addComponent(LabelEmployeeViewTimeTableEmployeeId, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(LabelEmployeeViewTimeTableName)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(LabelEmployeeViewTimeTableEmployeeName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                            .addComponent(LabelEmployeeViewTimeTableTitle)
                                            .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 606, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(ButtonEmployeeViewTimeTableAddEntry, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(ButtonEmployeeViewTimeTableEditEntry, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(ButtonEmployeeViewTimeTableDeleteEntry, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE))))
                            .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(LabelEmployeeViewTimeTableTitle)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(LabelEmployeeViewTimeTableId)
                                    .addComponent(LabelEmployeeViewTimeTableName)
                                    .addComponent(LabelEmployeeViewTimeTableEmployeeId)
                                    .addComponent(LabelEmployeeViewTimeTableEmployeeName))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                            .addComponent(ButtonEmployeeViewTimeTableAddEntry)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(ButtonEmployeeViewTimeTableEditEntry)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(ButtonEmployeeViewTimeTableDeleteEntry)))
                            .addContainerGap(41, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // End of variables declaration//GEN-END:variables
}
