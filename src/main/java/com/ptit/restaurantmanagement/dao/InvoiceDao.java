package com.ptit.restaurantmanagement.dao;

import com.ptit.restaurantmanagement.database.RestaurantManagementDatabase;
import com.ptit.restaurantmanagement.domain.model.Invoice;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;

public class InvoiceDao {
    private Connection connection = RestaurantManagementDatabase.getConnection();

    public InvoiceDao() throws SQLException {
        RestaurantManagementDatabase.createDatabase(connection);
        RestaurantManagementDatabase.getConnection();
    }

    public int insertInvoice(Invoice invoice) throws SQLException {
        String insertInvoiceQuery = "INSERT INTO invoice VALUES (0, ?, ?, null)";
        PreparedStatement preparedStatement = connection.prepareStatement(insertInvoiceQuery, Statement.RETURN_GENERATED_KEYS);

        int customerId = invoice.getCustomerId();
        int employeeId = invoice.getEmployeeId();

        preparedStatement.setInt(1, customerId);
        preparedStatement.setInt(2, employeeId);

        int invoiceId = preparedStatement.executeUpdate();
        if (invoiceId == 1) {
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                invoiceId = resultSet.getInt(1);
            }
        } else {
            throw new SQLException();
        }

        return invoiceId;
    }

    public ArrayList<Invoice> getInvoices() throws SQLException {
        String getInvoices = "SELECT * FROM invoice";
        Statement statement = connection.createStatement();

        ResultSet rs = statement.executeQuery(getInvoices);
        ArrayList<Invoice> invoices = new ArrayList<>();
        while (rs.next()) {
            invoices.add(invoiceFromResultSet(rs));
        }

        return invoices;
    }

    public Invoice getInvoiceByInvoiceId(int id) throws SQLException {
        String getInvoices = "SELECT * FROM invoice WHERE id_invoice=?";
        PreparedStatement preparedStatement = connection.prepareStatement(getInvoices);

        preparedStatement.setInt(1, id);

        ResultSet rs = preparedStatement.executeQuery();
        rs.next();

        return invoiceFromResultSet(rs);
    }

    private Invoice invoiceFromResultSet(ResultSet rs) throws SQLException {
        int invoiceId = rs.getInt("id_invoice");
        int customerId = rs.getInt("id_customer");
        int employeeId = rs.getInt("id_employee");
        Timestamp timestamp = rs.getTimestamp("time");

        Calendar time = Calendar.getInstance();
        time.setTimeInMillis(timestamp.getTime());

        return new Invoice(invoiceId, customerId, employeeId, time);
    }

    public void deleteInvoice(int id) throws SQLException {
        String delete = "DELETE FROM invoice WHERE id_invoice=?";
        PreparedStatement preparedStatement = connection.prepareStatement(delete);
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
    }

    public int calculateInvoiceSum(int invoiceId) throws SQLException {
        String query = "SELECT SUM(price*quantity) " +
                "FROM line, invoice, menu_entry " +
                "WHERE (line.id_invoice = invoice.id_invoice " +
                    "AND menu_entry.id_menu_entry = line.id_menu_entry " +
                "AND line.id_invoice = ?)";

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, invoiceId);

        System.out.println(preparedStatement.toString());

        ResultSet result = preparedStatement.executeQuery();
        result.next();

        return result.getInt(1);
    }
}
