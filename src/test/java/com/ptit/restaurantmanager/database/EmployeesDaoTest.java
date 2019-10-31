package com.ptit.restaurantmanager.database;

import com.ptit.restaurantmanagement.dao.CustomerDao;
import com.ptit.restaurantmanagement.dao.EmployeesDao;
import com.ptit.restaurantmanagement.domain.model.Customer;
import com.ptit.restaurantmanagement.domain.model.CustomerType;
import com.ptit.restaurantmanagement.domain.model.Employee;
import com.ptit.restaurantmanagement.domain.model.EmployeeType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.Calendar;

public class EmployeesDaoTest {
    private static EmployeesDao dao;
    private static CustomerDao  customerDao;

    @BeforeAll
    public static void init() {
        try {
            dao = new EmployeesDao();
            customerDao=new CustomerDao();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public int insertEmployeeWithNullManagerId() {
        Employee employee = new Employee("Linh", Calendar.getInstance(), "Hanoi", EmployeeType.NORMAL, null, 30.2);
        try {
            return dao.insertEmployee(employee);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 1;
    }

    @Test
    public void insertEmployee() {
        int managerId = insertEmployeeWithNullManagerId();

        Employee employee = new Employee("Long", Calendar.getInstance(), "Ha Noi", EmployeeType.NORMAL, managerId, 90.0);
        try {
            dao.insertEmployee(employee);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getListEmployee() {
        dao.getListEmployee();
    }

    @Test
    public void searchEmployee() {
        try {
            System.out.println(dao.searchListEmployee(3));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void updateEmployee() {
        Employee employee = new Employee("Update22eewwwe22", Calendar.getInstance(), "Hanoi34234Update", EmployeeType.NORMAL, null, 99956459.9);
        try {
            dao.updateEmployee(employee,3);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Test
    public void deleteEmployee() {
        try {
            dao.deleteEmployee(6);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
