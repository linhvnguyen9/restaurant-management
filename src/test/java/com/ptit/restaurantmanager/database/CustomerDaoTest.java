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
    public void searchCustomer() {
        try {
            System.out.println(customerDao.getCustomerById(3));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void searchEmployeeByName() {
        try {
            for (Customer customer : customerDao.getCustomerByName("Nguyen Van")) {
                System.out.println(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void updateEmployee() {
        Customer customer = new Customer("Update22", Calendar.getInstance(), "Hanoi34234Update", "19001299", CustomerType.VIP);
        try {
            customerDao.updateCustomer(customer,3);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    @Test
    public void deleteCustomer(){
        try {
            customerDao.deleteCustomer(1);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Test
    void displayReport() {
        try {
            customerDao.displayCustomerTotalAmountPurchased();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
