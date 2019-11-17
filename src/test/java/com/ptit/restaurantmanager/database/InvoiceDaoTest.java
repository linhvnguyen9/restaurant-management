package com.ptit.restaurantmanager.database;

import com.ptit.restaurantmanagement.dao.InvoiceDao;
import com.ptit.restaurantmanagement.domain.model.Invoice;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

public class InvoiceDaoTest {
    private static InvoiceDao dao;

    @BeforeAll
    public static void init() {
        try {
            dao = new InvoiceDao();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void insertInvoice() {
        Invoice invoice = new Invoice(3, 1, null);
        try {
            dao.insertInvoice(invoice);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getInvoices() {
        try {
            for (Invoice invoice : dao.getInvoices()) {
                System.out.println(invoice.toString());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getInvoiceById() {
        try {
            System.out.println(dao.getInvoiceByInvoiceId(1).toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void deleteInvoice() {
        try {
            dao.deleteInvoice(2);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
