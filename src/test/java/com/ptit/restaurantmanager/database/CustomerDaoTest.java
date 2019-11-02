package com.ptit.restaurantmanager.database;

import com.ptit.restaurantmanagement.dao.CustomerDao;
import com.ptit.restaurantmanagement.domain.model.Customer;
import com.ptit.restaurantmanagement.domain.model.CustomerType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.Calendar;

public class CustomerDaoTest {
    private static CustomerDao customerDao;

    @BeforeAll
    public static void init() {
        try {
            customerDao=new CustomerDao();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void insertCustomer() {
        Customer customer = new Customer("Nguyen Van lInh", Calendar.getInstance(), "Ha Noi", "19001296", CustomerType.NORMAL);
        try {
            customerDao.insertCustomer(customer);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void getListCustomer(){
        customerDao.getListCustomer();
    }
    @Test
    public void deleteCustomer(){
        try {
            customerDao.deleteCustomer(7);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
