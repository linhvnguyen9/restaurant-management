package com.ptit.restaurantmanagement.dao;

import com.ptit.restaurantmanagement.database.RestaurantManagementDatabase;
import com.ptit.restaurantmanagement.domain.model.Customer;
import com.ptit.restaurantmanagement.domain.model.CustomerType;
import com.ptit.restaurantmanagement.domain.model.Employee;
import com.ptit.restaurantmanagement.domain.model.EmployeeType;


import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class CustomerDao {
    private Statement statement;
    private Connection stament = RestaurantManagementDatabase.getConnection();
    ArrayList<Customer> listCustomer = new ArrayList<>();

    public CustomerDao() throws SQLException {
        RestaurantManagementDatabase.createDatabase(stament);
        RestaurantManagementDatabase.getConnection();
    }

    public int insertCustomer(Customer customer) throws SQLException {
        String createPerson = "INSERT INTO person VALUES (0, ?, ?, ?)";

        PreparedStatement preparedStatement = stament.prepareStatement(createPerson, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, customer.getName());

        Date utilDate = customer.getDob().getTime();
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

        preparedStatement.setDate(2, sqlDate);
        preparedStatement.setString(3, customer.getAddress());

        int personId = preparedStatement.executeUpdate();
        if (personId != -1) {
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                personId = resultSet.getInt(1);
            }
        } else {
            throw new SQLException();
        }

        String createCustomer = "INSERT INTO customer VALUES(?, ?)";

        preparedStatement = stament.prepareStatement(createCustomer);
        preparedStatement.setInt(1, personId);
        preparedStatement.setString(2, customer.getCustomerType().toString());

        preparedStatement.executeUpdate();

        return personId;
    }

    public ArrayList<Customer> getListCustomer() {
        String sql = "SELECT * FROM person,customer WHERE id_person = id_customer;";

        try {
            PreparedStatement ps = stament.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id_customer");
                String name = (rs.getString("name"));

                Calendar dob = Calendar.getInstance();
                dob.setTime(rs.getDate("dob"));


                String address = (rs.getString("addr"));
                CustomerType type;
                if (rs.getString("type").equals("NORMAL"))
                    type = CustomerType.NORMAL;
                else
                    type = CustomerType.VIP;
                Customer s = new Customer(id, name, dob, address, type);
                listCustomer.add(s);

                for (int i = 0; i < listCustomer.size(); i++)
                    System.out.println(listCustomer.get(i).toString());

                return listCustomer;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //print out listEmployee
        return new ArrayList<>();
    }

    public void updateEmployee(Employee employee, int id) throws SQLException {
        //update employee

        String updateEmployees = "UPDATE employee SET type=?,salary=? WHERE id_employee=?;";
        PreparedStatement pstmt = stament.prepareStatement(updateEmployees);

        pstmt.setString(1, employee.getEmployeeType().toString());

        //pstmt.setInt(2, employee.getManagerId());
        pstmt.setDouble(2, employee.getBaseSalary());
        pstmt.setInt(3, id);
        System.out.println(pstmt.toString());
        pstmt.executeUpdate();

        //update person
        String updatePerson = "UPDATE person SET name=?, dob=?, addr=? WHERE id_person=?;";
        PreparedStatement pstmt2 = stament.prepareStatement(updatePerson);

        pstmt2.setString(1, employee.getName());

        Date utilDate = employee.getDob().getTime();
        java.sql.Date date = new java.sql.Date(utilDate.getTime());

        pstmt2.setDate(2, date);
        pstmt2.setString(3, employee.getAddress());
        pstmt2.setInt(4, id);

        System.out.println(pstmt2.toString());
        pstmt2.executeUpdate();


        boolean autoCommit = stament.getAutoCommit();
        try {
            stament.setAutoCommit(false);

            stament.commit();
        } catch (SQLException exc) {
            stament.rollback();
        } finally {
            stament.setAutoCommit(autoCommit);
        }
    }

    public void deleteEmployee(int id) throws SQLException {
        String deleteEmployee = "delete from employee where id_employee=?;";
        PreparedStatement pstmEmployee = stament.prepareStatement(deleteEmployee);
        pstmEmployee.setInt(1, id);
        pstmEmployee.executeUpdate();

        String deletePerson = "delete from person where id_person=?;";
        PreparedStatement pstmtPerson = stament.prepareStatement(deletePerson);
        pstmtPerson.setInt(1, id);
        pstmtPerson.executeUpdate();


    }

    public void searchListEmployee(String name) {
        for (int i = 0; i < listCustomer.size(); i++)
            if (listCustomer.get(i).getName().equals(name))
                System.out.println(listCustomer.get(i).toString());
    }
}
